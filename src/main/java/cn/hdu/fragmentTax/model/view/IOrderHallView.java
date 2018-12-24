package cn.hdu.fragmentTax.model.view;

import cn.hdu.fragmentTax.dao.entity.GOrderEntity;
import cn.hdu.fragmentTax.dto.request.AddOrderRestDto;
import cn.hdu.fragmentTax.dto.request.EditOrderRestDto;
import cn.hdu.fragmentTax.dto.request.SendEmailRestDto;

import javax.mail.Session;
import java.text.ParseException;

public interface IOrderHallView {
    GOrderEntity getOrderEntity(AddOrderRestDto addOrderRestDto) throws ParseException;

    Session createSession();

    SendEmailRestDto createEmailDtoToAdminForAddOrder(AddOrderRestDto addOrderRestDto) throws ParseException;

    SendEmailRestDto createEmailDtoToAdminForEditOrder(EditOrderRestDto editOrderRestDto) throws ParseException;
}
