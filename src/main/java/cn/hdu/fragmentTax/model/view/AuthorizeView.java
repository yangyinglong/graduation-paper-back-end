package cn.hdu.fragmentTax.model.view;

import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dto.request.RegisterRestDto;
import cn.hdu.fragmentTax.dto.response.UserRespDto;
import cn.hdu.fragmentTax.util.FormatUtil;
import org.springframework.stereotype.Service;

import static cn.hdu.fragmentTax.util.DateUtil.getCurrentDatetime;

@Service
public class AuthorizeView implements IAuthorizeView {
    @Override
    public GUserEntity getUserEntity(RegisterRestDto registerRestDto) {
        GUserEntity userEntity = new GUserEntity();
        userEntity.setId(registerRestDto.getId());
        userEntity.setName(registerRestDto.getName());
        userEntity.setPassword(registerRestDto.getPassword());
        userEntity.setPhone(registerRestDto.getPhone());
        userEntity.setStatus(1);
        userEntity.setCreatedTime(getCurrentDatetime());
        return userEntity;
    }

    @Override
    public UserRespDto getUserRespDto(GUserEntity userEntityRegister) {
        UserRespDto userRespDto = new UserRespDto();
        if (!FormatUtil.isEmpty(userEntityRegister)) {
            userRespDto.setId(userEntityRegister.getId());
            userRespDto.setName(userEntityRegister.getName());
            userRespDto.setPhone(userEntityRegister.getPhone());
            userRespDto.setStatus(userEntityRegister.getStatus());
            userRespDto.seteMail(userEntityRegister.getEmail());
            return userRespDto;
        }
        return null;

    }
}
