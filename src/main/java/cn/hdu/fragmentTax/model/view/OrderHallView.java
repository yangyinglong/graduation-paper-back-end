package cn.hdu.fragmentTax.model.view;

import cn.hdu.fragmentTax.dao.entity.GOrderEntity;
import cn.hdu.fragmentTax.dto.request.AddOrderRestDto;
import cn.hdu.fragmentTax.util.FormatUtil;
import org.springframework.stereotype.Service;

import java.text.ParseException;

import static cn.hdu.fragmentTax.util.DateUtil.getChinaDateTime;
import static cn.hdu.fragmentTax.util.DateUtil.getCurrentDatetime;
import static cn.hdu.fragmentTax.util.StringUtil.getRandomString;

@Service
public class OrderHallView implements IOrderHallView {
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
}
