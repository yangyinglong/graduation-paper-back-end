package cn.hdu.fragmentTax.model.view;

import cn.hdu.fragmentTax.dao.entity.GOrderEntity;
import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dao.mapper.IGOrderMapper;
import cn.hdu.fragmentTax.dao.mapper.IGUserMapper;
import cn.hdu.fragmentTax.dto.request.AddOrderRestDto;
import cn.hdu.fragmentTax.dto.request.EditOrderRestDto;
import cn.hdu.fragmentTax.dto.request.SendEmailRestDto;
import cn.hdu.fragmentTax.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import java.text.ParseException;
import java.util.Properties;

import static cn.hdu.fragmentTax.util.DateUtil.getChinaDateTime;
import static cn.hdu.fragmentTax.util.DateUtil.getCurrentDatetime;
import static cn.hdu.fragmentTax.util.StringUtil.getRandomString;

@Service
public class OrderHallView implements IOrderHallView {

    @Autowired
    private IGUserMapper userMapper;
    @Autowired
    private IGOrderMapper orderMapper;

    @Override
    public GOrderEntity getOrderEntity(AddOrderRestDto addOrderRestDto) throws ParseException {
        GOrderEntity orderEntity = new GOrderEntity();
        orderEntity.setId(getRandomString(18));
        orderEntity.setUserId(addOrderRestDto.getLabBeSpeakId());
        orderEntity.setUserName(addOrderRestDto.getLabBeSpeakName());
        orderEntity.setLaboratoryId(addOrderRestDto.getLabId());
        orderEntity.setLaboratoryName(addOrderRestDto.getLabName());
        orderEntity.setLaboratoryAddress(addOrderRestDto.getLabAddress());
        orderEntity.setBespeakStartTime(getChinaDateTime(addOrderRestDto.getTime().get(0)));
        orderEntity.setBespeakEndTime(getChinaDateTime(addOrderRestDto.getTime().get(1)));
        orderEntity.setUsedTo(addOrderRestDto.getUsedTo());
        orderEntity.setStatus(1);
        orderEntity.setAdminRemarks(null);
        if (!FormatUtil.isEmpty(addOrderRestDto.getRemarks())){
            orderEntity.setRemarks(addOrderRestDto.getRemarks());
        }
        orderEntity.setCreatedTime(getCurrentDatetime());
        return orderEntity;
    }

    @Override
    public Session createSession() {
        Properties prop = new Properties();
        Session session = Session.getInstance(prop);
        try {
            prop.setProperty("mail.host", "smtp.163.com");
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.setProperty("mail.smtp.auth", "true");
            //使用JavaMail发送邮件的5个步骤
            //1、创建session
            //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
            session.setDebug(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return session;
    }

    @Override
    public SendEmailRestDto createEmailDtoToAdminForAddOrder(AddOrderRestDto addOrderRestDto) throws ParseException {
        SendEmailRestDto sendEmailRestDto = new SendEmailRestDto();
        GUserEntity userEntity = userMapper.queryByKey(addOrderRestDto.getLabAdminId());
        sendEmailRestDto.setTo(userEntity.getEmail());
        sendEmailRestDto.setSubject("实验室预约通知");
        String content = "您好，您管理的" + addOrderRestDto.getLabName() + "已被" + addOrderRestDto.getLabBeSpeakName() + "预约做" + addOrderRestDto.getUsedTo() + ", 预约时间为：" + getChinaDateTime(addOrderRestDto.getTime().get(1)) + " - " + getChinaDateTime(addOrderRestDto.getTime().get(0)) + "，请您及时登录实验室预约系统进行审核!";
        sendEmailRestDto.setContent(content);
        return sendEmailRestDto;
    }

    @Override
    public SendEmailRestDto createEmailDtoToAdminForEditOrder(EditOrderRestDto editOrderRestDto) throws ParseException {
        GOrderEntity orderEntity = orderMapper.queryByKey(editOrderRestDto.getOrderId());
        SendEmailRestDto sendEmailRestDto = new SendEmailRestDto();
        GUserEntity userEntity = userMapper.queryByKey(orderMapper.queryByKey(editOrderRestDto.getOrderId()).getUserId()); sendEmailRestDto.setTo(userEntity.getEmail());
        sendEmailRestDto.setTo(userEntity.getEmail());
        sendEmailRestDto.setSubject("实验室预约通知");
        String content = "您好，您管理的" + orderEntity.getLaboratoryName() + "已被" + editOrderRestDto.getLabBeSpeakName() + "预约做" + editOrderRestDto.getUsedTo() + ", 预约时间为：" + getChinaDateTime(editOrderRestDto.getTime().get(0)) + " - " + getChinaDateTime(editOrderRestDto.getTime().get(1)) + "，请您及时登录实验室预约系统进行审核!";
        sendEmailRestDto.setContent(content);
        return sendEmailRestDto;
    }
}
