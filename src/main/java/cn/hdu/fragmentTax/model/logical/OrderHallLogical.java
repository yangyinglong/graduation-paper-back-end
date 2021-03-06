package cn.hdu.fragmentTax.model.logical;

import cn.hdu.fragmentTax.dao.entity.GLaboratoryEntity;
import cn.hdu.fragmentTax.dao.entity.GOrderEntity;
import cn.hdu.fragmentTax.dao.mapper.IGLaboratoryMapper;
import cn.hdu.fragmentTax.dao.mapper.IGOrderMapper;
import cn.hdu.fragmentTax.dao.mapper.IGUserMapper;
import cn.hdu.fragmentTax.dto.request.*;
import cn.hdu.fragmentTax.dto.response.OrderBespeakRespDto;
import cn.hdu.fragmentTax.dto.response.OrderRespDto;
import cn.hdu.fragmentTax.util.FormatUtil;
import cn.hdu.fragmentTax.util.PropertiesUtil;
import cn.hdu.fragmentTax.util.SendMailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static cn.hdu.fragmentTax.util.DateUtil.getChinaDateTime;

@Service
public class OrderHallLogical implements IOrderHallLogical {

    @Autowired
    IGOrderMapper orderMapper;

    @Autowired
    IGUserMapper userMapper;

    @Autowired
    IGLaboratoryMapper laboratoryMapper;

    @Override
    public void addOrder(GOrderEntity orderEntity) {
        orderMapper.insert(orderEntity);
    }

    @Override
    public List<OrderRespDto> getOrderRespDtos(ShowOrderRestDto showOrderRestDto) {
        String status = FormatUtil.strings2String(getIntAuditStatus(showOrderRestDto.getStatus()));
        List<OrderRespDto> orderRespDtos = new ArrayList<OrderRespDto>();
        List<GOrderEntity> orderEntities = orderMapper.queryPartByUserId(showOrderRestDto.getUserId(), status, (showOrderRestDto.getPage()-1)*5);
        for (GOrderEntity orderEntity : orderEntities) {
            OrderRespDto orderRespDto = new OrderRespDto();
            GLaboratoryEntity laboratoryEntity = laboratoryMapper.queryByKey(orderEntity.getLaboratoryId());
            orderRespDto.setOrderId(orderEntity.getId());
            orderRespDto.setDate(orderEntity.getCreatedTime().split(" ")[0]);
            orderRespDto.setLabId(laboratoryEntity.getId());
            orderRespDto.setLabName(laboratoryEntity.getName());
            orderRespDto.setLabAddress(laboratoryEntity.getAdress());
            orderRespDto.setAdminId(laboratoryEntity.getAdminId());
            orderRespDto.setAdminName(userMapper.queryByKey(orderRespDto.getAdminId()).getName());
            orderRespDto.setUserId(orderEntity.getUserId());
            orderRespDto.setUserName(orderEntity.getUserName());
            orderRespDto.setTime(orderEntity.getBespeakStartTime() + " - " + orderEntity.getBespeakEndTime());
            orderRespDto.setUsedTo(orderEntity.getUsedTo());
            orderRespDto.setRemarks(orderEntity.getRemarks());
            orderRespDto.setStatus(getStrAuditStatus(orderEntity.getStatus()));
            orderRespDto.setAdminRemarks(orderEntity.getAdminRemarks());
            orderRespDtos.add(orderRespDto);
        }
        return orderRespDtos;
    }

    @Override
    public int getOrderEntitiesNum(ShowOrderRestDto showOrderRestDto) {
        int num = orderMapper.queryNum(showOrderRestDto.getUserId(), FormatUtil.strings2String(getIntAuditStatus(showOrderRestDto.getStatus())));
        return num;
    }

    @Override
    public void editOrder(EditOrderRestDto editOrderRestDto) throws ParseException {
        orderMapper.updateOrderById(editOrderRestDto.getOrderId(), getChinaDateTime(editOrderRestDto.getTime().get(0)),
                getChinaDateTime(editOrderRestDto.getTime().get(1)), editOrderRestDto.getLabBeSpeakName(),
                editOrderRestDto.getUsedTo(), editOrderRestDto.getRemarks());
    }

    @Override
    public  List<OrderBespeakRespDto> getOrderBespeakRespDtos(ShowOrderBespeakRestDto showOrderBespeakRestDto) throws ParseException {
        List<OrderBespeakRespDto> orderBespeakRespDtos = new ArrayList<OrderBespeakRespDto>();
        List<GOrderEntity> orderEntities = orderMapper.queryPartByBespeakTime(showOrderBespeakRestDto.getLabId(), getChinaDateTime(showOrderBespeakRestDto.getTime().get(0)), getChinaDateTime(showOrderBespeakRestDto.getTime().get(1)));
        for (GOrderEntity orderEntity : orderEntities) {
            OrderBespeakRespDto orderBespeakRespDto = new OrderBespeakRespDto();
            orderBespeakRespDto.setStartTime(orderEntity.getBespeakStartTime());
            orderBespeakRespDto.setEndTime(orderEntity.getBespeakEndTime());
            orderBespeakRespDto.setBespeakName(orderEntity.getUserName());
            orderBespeakRespDtos.add(orderBespeakRespDto);
        }
        return orderBespeakRespDtos;
    }

    @Override
    public void cancelOrder(String orderId) {
        orderMapper.cancelOrder(orderId);
    }

    @Override
    public void sendEmail(Session session, SendEmailRestDto sendEmailRestDto) throws Exception {
        Transport transport = session.getTransport();
        transport.connect("smtp.163.com", PropertiesUtil.prop("email_user_name"), PropertiesUtil.prop("email_password"));
        Message message = SendMailUtil.createSimpleMail(session, PropertiesUtil.prop("email_sender"), sendEmailRestDto.getTo(), sendEmailRestDto.getSubject(), sendEmailRestDto.getContent());
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    // 管理员管理预约自己实验室的订单
    @Override
    public List<OrderRespDto> getAdminOrderDtos(ShowOrderRestDto showOrderRestDto) {
        List<GLaboratoryEntity> laboratoryEntities = laboratoryMapper.queryByAdminId(showOrderRestDto.getUserId());
        if (FormatUtil.isEmpty(laboratoryEntities)) {
            return null;
        }
        String[] labIdArr = new String[laboratoryEntities.size()];
        int index = 0;
        for (GLaboratoryEntity laboratoryEntity : laboratoryEntities) {
            labIdArr[index] = laboratoryEntity.getId();
            index ++;
        }
        String labIds = FormatUtil.strings2String(labIdArr);
        String status = FormatUtil.strings2String(getIntAuditStatus(showOrderRestDto.getStatus()));
        List<OrderRespDto> orderRespDtos = new ArrayList<OrderRespDto>();
        List<GOrderEntity> orderEntities = orderMapper.queryPartByLabIds(labIds, status, (showOrderRestDto.getPage()-1)*5);
        for (GOrderEntity orderEntity : orderEntities) {
            OrderRespDto orderRespDto = new OrderRespDto();
            GLaboratoryEntity laboratoryEntity = laboratoryMapper.queryByKey(orderEntity.getLaboratoryId());
            orderRespDto.setOrderId(orderEntity.getId());
            orderRespDto.setDate(orderEntity.getCreatedTime().split(" ")[0]);
            orderRespDto.setLabId(laboratoryEntity.getId());
            orderRespDto.setLabName(laboratoryEntity.getName());
            orderRespDto.setLabAddress(laboratoryEntity.getAdress());
            orderRespDto.setAdminId(laboratoryEntity.getAdminId());
            orderRespDto.setAdminName(userMapper.queryByKey(orderRespDto.getAdminId()).getName());
            orderRespDto.setUserId(orderEntity.getUserId());
            orderRespDto.setUserName(orderEntity.getUserName());
            orderRespDto.setTime(orderEntity.getBespeakStartTime() + " - " + orderEntity.getBespeakEndTime());
            orderRespDto.setUsedTo(orderEntity.getUsedTo());
            orderRespDto.setRemarks(orderEntity.getRemarks());
            orderRespDto.setStatus(getStrAuditStatus(orderEntity.getStatus()));
            orderRespDto.setAdminRemarks(orderEntity.getAdminRemarks());
            orderRespDtos.add(orderRespDto);
        }
        return orderRespDtos;
    }

    @Override
    public int getAdminOrderEntitiesNum(ShowOrderRestDto showOrderRestDto) {
        List<GLaboratoryEntity> laboratoryEntities = laboratoryMapper.queryByAdminId(showOrderRestDto.getUserId());
        if (FormatUtil.isEmpty(laboratoryEntities)) {
            return 0;
        }
        String[] labIdArr = new String[laboratoryEntities.size()];
        int index = 0;
        for (GLaboratoryEntity laboratoryEntity : laboratoryEntities) {
            labIdArr[index] = laboratoryEntity.getId();
            index ++;
        }
        String labIds = FormatUtil.strings2String(labIdArr);
        String status = FormatUtil.strings2String(getIntAuditStatus(showOrderRestDto.getStatus()));
        int num = orderMapper.queryNumByLabIds(labIds, status);
        return num;
    }

    @Override
    public void reviewOrder(ReviewOrderRestDto reviewOrderRestDto) {
        int status = 2;
        if (reviewOrderRestDto.getReview().equals("驳回")) {
            status = 3;
        }
        orderMapper.adminReviewById(reviewOrderRestDto.getOrderId(), reviewOrderRestDto.getAdminRemarks(), status);
    }

    // todo 通过enum 改写
    //0-已删除 1-待审核  2-已通过  3-已驳回 4-已完成
    private String[] getIntAuditStatus(String[] auditStatus) {
        for (int i = 0; i < auditStatus.length; i++) {
            if (auditStatus[i].equals("已删除")) {
                auditStatus[i] = "0";
            } else if (auditStatus[i].equals("待审核")) {
                auditStatus[i] = "1";
            } else if (auditStatus[i].equals("已通过")) {
                auditStatus[i] = "2";
            } else if (auditStatus[i].equals("已驳回")) {
                auditStatus[i] = "3";
            } else if (auditStatus[i].equals("已完成")) {
                auditStatus[i] = "4";
            }
        }
        return auditStatus;
    }

    private String getStrAuditStatus(Integer auditStatus) {
        if (auditStatus == 0) {
            return "已删除";
        }
        if (auditStatus == 1) {
            return "待审核";
        }
        if (auditStatus == 2) {
            return "已通过";
        }
        if (auditStatus == 3) {
            return "已驳回";
        }
        if (auditStatus == 4) {
            return "已完成";
        }
        return "未知";
    }

}
