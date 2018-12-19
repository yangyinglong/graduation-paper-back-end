package cn.hdu.fragmentTax.model.logical;

import cn.hdu.fragmentTax.dao.entity.GLaboratoryEntity;
import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dao.mapper.IGLaboratoryMapper;
import cn.hdu.fragmentTax.dao.mapper.IGUserMapper;
import cn.hdu.fragmentTax.dto.request.AddLabRestDto;
import cn.hdu.fragmentTax.dto.request.ShowLabRestDto;
import cn.hdu.fragmentTax.dto.response.LabRespDto;
import cn.hdu.fragmentTax.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class LaboratoryHallLogical implements ILaboratoryHallLogical {

    @Autowired
    private IGUserMapper userMapper;

    @Autowired
    private IGLaboratoryMapper laboratoryMapper;

    @Override
    public GUserEntity getUserEntity(AddLabRestDto addLabRestDto) {
        try {
            GUserEntity userEntity = userMapper.queryByKey(addLabRestDto.getAdminId());
            if (userEntity.getStatus() == 2) {
                return userEntity;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void addLaboratory(GLaboratoryEntity laboratoryEntity) {
        laboratoryMapper.insert(laboratoryEntity);
    }

    @Override
    public List<LabRespDto> getLaboratoryEntities(ShowLabRestDto showLabRestDto) {
        List<GLaboratoryEntity> laboratoryEntities = null;
        List<LabRespDto> labRespDtos = new ArrayList<LabRespDto>();
        if (!FormatUtil.isEmpty(showLabRestDto.getLabName())){
            laboratoryEntities = laboratoryMapper.queryLikeByName(showLabRestDto.getLabName(), (showLabRestDto.getPage()-1)*5);
        } else {
            laboratoryEntities = laboratoryMapper.queryPart((showLabRestDto.getPage()-1)*5);
        }
        for (GLaboratoryEntity laboratoryEntity : laboratoryEntities) {
            LabRespDto labRespDto =  new LabRespDto();
            labRespDto.setId(laboratoryEntity.getId());
            labRespDto.setAddress(laboratoryEntity.getAdress());
            labRespDto.setName(laboratoryEntity.getName());
            labRespDto.setAdminId(laboratoryEntity.getAdminId());
            labRespDto.setAdminName(userMapper.queryByKey(laboratoryEntity.getAdminId()).getName());
            labRespDto.setOpenTime(laboratoryEntity.getOpenTim());
            labRespDto.setDesc(laboratoryEntity.getDesc());
            labRespDtos.add(labRespDto);
        }
        Collections.sort(labRespDtos, new SortLabByName());
        return labRespDtos;
    }

    @Override
    public int getLaboratoryEntitiesNum(ShowLabRestDto showLabRestDto) {
        if (!FormatUtil.isEmpty(showLabRestDto.getLabName())) {
            return laboratoryMapper.queryPartNum(showLabRestDto.getLabName());
        } else {
            return laboratoryMapper.queryAllNum();
        }
    }

    class SortLabByName implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            LabRespDto labRespDto1 = (LabRespDto)o1;
            LabRespDto labRespDto2 = (LabRespDto)o2;
            return labRespDto1.getName().compareTo(labRespDto2.getName());
        }
    }
}
