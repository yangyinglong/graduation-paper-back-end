package cn.hdu.fragmentTax.model.logical;

import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dto.request.EditUserRestDto;
import cn.hdu.fragmentTax.dto.request.ForgotPassRestDto;
import cn.hdu.fragmentTax.dto.request.LoginRestDto;
import cn.hdu.fragmentTax.dto.request.RegisterRestDto;
import cn.hdu.fragmentTax.dto.response.UserRespDto;

public interface IAuthorizeLogical {
    GUserEntity getUserEntity(RegisterRestDto registerRestDto);

    void addUser(GUserEntity userEntityRegister);

    GUserEntity getUserEntity(LoginRestDto loginRestDto);

    GUserEntity getUserEntity(ForgotPassRestDto forgotPassRestDto);

    UserRespDto updatePassword(GUserEntity userEntity, ForgotPassRestDto forgotPassRestDto);

    void editUser(EditUserRestDto editUserRestDto);
}
