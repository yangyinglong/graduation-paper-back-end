package cn.hdu.fragmentTax.model.logical;

import cn.hdu.fragmentTax.dao.entity.GOrderEntity;
import cn.hdu.fragmentTax.dto.request.*;
import cn.hdu.fragmentTax.dto.response.OrderBespeakRespDto;
import cn.hdu.fragmentTax.dto.response.OrderRespDto;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.text.ParseException;
import java.util.List;

public interface IOrderHallLogical {
    void addOrder(GOrderEntity orderEntity);

    List<OrderRespDto> getOrderRespDtos(ShowOrderRestDto showOrderRestDto);

    int getOrderEntitiesNum(ShowOrderRestDto showOrderRestDto);

    void editOrder(EditOrderRestDto editOrderRestDto) throws ParseException;

    List<OrderBespeakRespDto> getOrderBespeakRespDtos(ShowOrderBespeakRestDto showOrderBespeakRestDto) throws ParseException;

    void cancelOrder(String orderId);

    void sendEmail(Session session, SendEmailRestDto sendEmailRestDto) throws Exception;

    List<OrderRespDto> getAdminOrderDtos(ShowOrderRestDto showOrderRestDto);

    int getAdminOrderEntitiesNum(ShowOrderRestDto showOrderRestDto);

    void reviewOrder(ReviewOrderRestDto reviewOrderRestDto);
}
