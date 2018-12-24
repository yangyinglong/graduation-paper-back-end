package cn.hdu.fragmentTax.model.logical;

import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dto.request.*;
import cn.hdu.fragmentTax.dto.response.UserRespDto;

import javax.mail.Session;

public interface IAuthorizeLogical {
    GUserEntity getUserEntity(RegisterRestDto registerRestDto);

    void addUser(GUserEntity userEntityRegister);

    GUserEntity getUserEntity(LoginRestDto loginRestDto);

    GUserEntity getUserEntity(ForgotPassRestDto forgotPassRestDto);

    UserRespDto updatePassword(GUserEntity userEntity, ForgotPassRestDto forgotPassRestDto);

    void editUser(EditUserRestDto editUserRestDto);
    void sendEmail(Session session, SendEmailRestDto sendEmailRestDto) throws Exception;
}
