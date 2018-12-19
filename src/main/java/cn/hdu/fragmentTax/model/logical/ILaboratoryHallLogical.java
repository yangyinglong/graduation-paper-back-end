package cn.hdu.fragmentTax.model.logical;

import cn.hdu.fragmentTax.dao.entity.GLaboratoryEntity;
import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dto.request.AddLabRestDto;
import cn.hdu.fragmentTax.dto.request.ShowLabRestDto;
import cn.hdu.fragmentTax.dto.response.LabRespDto;

import java.util.List;

public interface ILaboratoryHallLogical {
    GUserEntity getUserEntity(AddLabRestDto addLabRestDto);

    void addLaboratory(GLaboratoryEntity laboratoryEntity);

    List<LabRespDto> getLaboratoryEntities(ShowLabRestDto showLabRestDto);

    int getLaboratoryEntitiesNum(ShowLabRestDto showLabRestDto);
}
