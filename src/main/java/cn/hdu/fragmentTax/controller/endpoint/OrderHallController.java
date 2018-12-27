package cn.hdu.fragmentTax.controller.endpoint;

import cn.hdu.fragmentTax.dto.request.*;
import cn.hdu.fragmentTax.model.logical.IOrderHallLogical;
import cn.hdu.fragmentTax.model.view.IOrderHallView;
import cn.hdu.fragmentTax.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.mail.Session;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/order")
@CrossOrigin
public class OrderHallController {

    @Autowired
    private IOrderHallView orderHallView;

    @Autowired
    private IOrderHallLogical orderHallLogical;

    @Path("/addOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addOrder(AddOrderRestDto addOrderRestDto){
        Map<String, Object> resp = new HashMap<>();
        try {
            orderHallLogical.addOrder(orderHallView.getOrderEntity(addOrderRestDto));
            resp.put("c", 200);
            resp.put("r", "提交成功，请及时查看审核结果！");
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "提交预约单失败！");
        }
        // 发送邮件
        try {
            SendEmailRestDto sendEmailRestDto = orderHallView.createEmailDtoToAdminForAddOrder(addOrderRestDto);
            if (FormatUtil.isEmpty(sendEmailRestDto.getTo())) {
                return resp;
            }
            Session session = orderHallView.createSession();
            orderHallLogical.sendEmail(session, sendEmailRestDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  resp;
    }

    @Path("/editOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editOrder(EditOrderRestDto editOrderRestDto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            orderHallLogical.editOrder(editOrderRestDto);
            resp.put("c", 200);
            resp.put("r", "修改成功，请及时查看审核结果！");
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "提交失败！");
        }
        // 发送邮件
        try {
            SendEmailRestDto sendEmailRestDto = orderHallView.createEmailDtoToAdminForEditOrder(editOrderRestDto);
            if (FormatUtil.isEmpty(sendEmailRestDto.getTo())) {
                return resp;
            }
            Session session = orderHallView.createSession();
            orderHallLogical.sendEmail(session, sendEmailRestDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Path("/showOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showOrder(ShowOrderRestDto showOrderRestDto){
        Map<String, Object> resp = new HashMap<>();
        try {
            resp.put("c", 200);
            resp.put("r", orderHallLogical.getOrderRespDtos(showOrderRestDto));
        } catch ( Exception e) {
            resp.put("c", 300);
            resp.put("r", null);
        }
        return resp;
    }

    @Path("/showOrderNum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showOrderNum(ShowOrderRestDto showOrderRestDto) {
        Map<String, Object> resp = new HashMap<>();
        int num = orderHallLogical.getOrderEntitiesNum(showOrderRestDto);
        resp.put("c", 200);
        resp.put("r", num);
        return resp;
    }

    @Path("/showOrderBespeakTime")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showOrderBespeakTime(ShowOrderBespeakRestDto showOrderBespeakRestDto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            resp.put("c", 200);
            resp.put("r", orderHallLogical.getOrderBespeakRespDtos(showOrderBespeakRestDto));
        } catch (ParseException e) {
            resp.put("c", 300);
            resp.put("r", "查找失败！");
        }
        return resp;
    }

    @Path("/cancelOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> cancelOrder(String orderId) {
        Map<String, Object> resp = new HashMap<>();
        try {
            orderHallLogical.cancelOrder(orderId);
            resp.put("c", 200);
            resp.put("r", "已取消预约！");
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "取消预约失败！");
        }
        return resp;
    }

    @Path("/adminShowOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> adminShowOrder(ShowOrderRestDto showOrderRestDto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            resp.put("c", 200);
            resp.put("r", orderHallLogical.getAdminOrderDtos(showOrderRestDto));
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "查询失败！");
        }
        return resp;
    }

    @Path("/adminShowOrderNum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> adminShowOrderNum(ShowOrderRestDto showOrderRestDto) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("c", 200);
        resp.put("r", orderHallLogical.getAdminOrderEntitiesNum(showOrderRestDto));
        return resp;
    }

    @Path("/adminReviewOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> adminReviewOrder(ReviewOrderRestDto reviewOrderRestDto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            orderHallLogical.reviewOrder(reviewOrderRestDto);
            resp.put("c", 200);
            resp.put("r", "已审核！");
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "审核出错！");
        }
        return resp;
    }
}
