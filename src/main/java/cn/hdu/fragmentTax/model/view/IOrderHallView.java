package cn.hdu.fragmentTax.model.view;

import cn.hdu.fragmentTax.dao.entity.GOrderEntity;
import cn.hdu.fragmentTax.dto.request.AddOrderRestDto;

import java.text.ParseException;

public interface IOrderHallView {
    GOrderEntity getOrderEntity(AddOrderRestDto addOrderRestDto) throws ParseException;
}
