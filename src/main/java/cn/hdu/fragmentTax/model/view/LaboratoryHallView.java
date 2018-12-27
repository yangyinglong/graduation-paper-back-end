package cn.hdu.fragmentTax.model.view;

import cn.hdu.fragmentTax.dao.entity.GLaboratoryEntity;
import cn.hdu.fragmentTax.dao.mapper.IGLaboratoryMapper;
import cn.hdu.fragmentTax.dto.request.AddLabRestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static cn.hdu.fragmentTax.util.DateUtil.getCurrentDatetime;
import static cn.hdu.fragmentTax.util.StringUtil.getRandomString;

@Service
public class LaboratoryHallView implements ILaboratoryHallView {

    @Autowired
    private IGLaboratoryMapper laboratoryMapper;

    @Override
    public GLaboratoryEntity getLaboratoryEntity(AddLabRestDto addLabRestDto) {
        GLaboratoryEntity laboratoryEntity = new GLaboratoryEntity();
        laboratoryEntity.setId(getRandomString(18));
        laboratoryEntity.setName(addLabRestDto.getName());
        laboratoryEntity.setAdress(addLabRestDto.getAddress());
        laboratoryEntity.setAdminId(addLabRestDto.getAdminId());
        laboratoryEntity.setIntr(addLabRestDto.getDesc());
        laboratoryEntity.setOpenTim(addLabRestDto.getOpenTime());
        laboratoryEntity.setStatus(1);
        laboratoryEntity.setCreatedTime(getCurrentDatetime());
        return laboratoryEntity;
    }
}
