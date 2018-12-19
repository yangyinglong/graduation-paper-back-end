package cn.hdu.fragmentTax.model.view;

import cn.hdu.fragmentTax.dao.entity.GLaboratoryEntity;
import cn.hdu.fragmentTax.dto.request.AddLabRestDto;

public interface ILaboratoryHallView {
    GLaboratoryEntity getLaboratoryEntity(AddLabRestDto addLabRestDto);
}
