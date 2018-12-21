package cn.hdu.fragmentTax.model.logical;

import cn.hdu.fragmentTax.dao.entity.GOrderEntity;
import cn.hdu.fragmentTax.dto.request.AddOrderRestDto;
import cn.hdu.fragmentTax.dto.request.EditOrderRestDto;
import cn.hdu.fragmentTax.dto.request.ShowOrderBespeakRestDto;
import cn.hdu.fragmentTax.dto.request.ShowOrderRestDto;
import cn.hdu.fragmentTax.dto.response.OrderBespeakRespDto;
import cn.hdu.fragmentTax.dto.response.OrderRespDto;

import java.text.ParseException;
import java.util.List;

public interface IOrderHallLogical {
    void addOrder(GOrderEntity orderEntity);

    List<OrderRespDto> getOrderRespDtos(ShowOrderRestDto showOrderRestDto);

    int getOrderEntitiesNum(ShowOrderRestDto showOrderRestDto);

    void editOrder(EditOrderRestDto editOrderRestDto) throws ParseException;

    List<OrderBespeakRespDto> getOrderBespeakRespDtos(ShowOrderBespeakRestDto showOrderBespeakRestDto) throws ParseException;

    void cancelOrder(String orderId);
}
