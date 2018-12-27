package cn.hdu.fragmentTax.model.view;

import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dto.request.RegisterRestDto;
import cn.hdu.fragmentTax.dto.response.UserRespDto;

import javax.mail.Session;

public interface IAuthorizeView {
    GUserEntity getUserEntity(RegisterRestDto registerRestDto);

    UserRespDto getUserRespDto(GUserEntity userEntityRegister);

    Session createSession();

    GUserEntity getAdminEntity(RegisterRestDto registerRestDto);

}
