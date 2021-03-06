package cn.hdu.fragmentTax.model.logical;

import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dao.mapper.IGUserMapper;
import cn.hdu.fragmentTax.dto.request.*;
import cn.hdu.fragmentTax.dto.response.UserRespDto;
import cn.hdu.fragmentTax.util.FormatUtil;
import cn.hdu.fragmentTax.util.PropertiesUtil;
import cn.hdu.fragmentTax.util.SendMailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

@Service
public class AuthorizeLogical implements IAuthorizeLogical{

    @Autowired
    private IGUserMapper userMapper;

    @Override
    public GUserEntity getUserEntity(RegisterRestDto registerRestDto) {
        GUserEntity userEntity = null;
        try {
            userEntity = userMapper.queryByKey(registerRestDto.getId());
            if (FormatUtil.isEmpty(userEntity)) {
                userEntity = userMapper.queryByPhone(registerRestDto.getPhone());
            }
            return userEntity;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void addUser(GUserEntity userEntityRegister) {
        userMapper.insert(userEntityRegister);
    }

    @Override
    public GUserEntity getUserEntity(LoginRestDto loginRestDto) {
        GUserEntity userEntity = null;
        try {
            userEntity = userMapper.queryByKey(loginRestDto.getId());
            if (FormatUtil.isEmpty(userEntity)) {
                userEntity = userMapper.queryByPhone(loginRestDto.getId());
            }
            return userEntity;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public GUserEntity getUserEntity(ForgotPassRestDto forgotPassRestDto) {
        try {
            GUserEntity userEntity = userMapper.queryByPhone(forgotPassRestDto.getPhone());
            return userEntity;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserRespDto updatePassword(GUserEntity userEntity, ForgotPassRestDto forgotPassRestDto) {
        try {
            userMapper.updatePasswordByPhone(forgotPassRestDto.getPhone(), forgotPassRestDto.getPassword());
        }catch (Exception e) {
            return null;
        }
        UserRespDto userRespDto = new UserRespDto();
        userRespDto.setId(userEntity.getId());
        userRespDto.setPhone(userEntity.getPhone());
        userRespDto.setName(userEntity.getName());
        userRespDto.setStatus(userEntity.getStatus());
        return userRespDto;
    }

    @Override
    public void editUser(EditUserRestDto editUserRestDto) {
        if (FormatUtil.isEmpty(editUserRestDto.getPassword())) {
            userMapper.updateById(editUserRestDto.getId(), editUserRestDto.getName(), editUserRestDto.getPhone(), editUserRestDto.geteMail());
            return;
        }
        userMapper.updatePasswordById(editUserRestDto.getId(), editUserRestDto.getName(), editUserRestDto.getPhone(), editUserRestDto.geteMail(), editUserRestDto.getPassword());
        return;
    }

    @Override
    public void sendEmail(Session session, SendEmailRestDto sendEmailRestDto) throws Exception {
        Transport transport = session.getTransport();
        transport.connect("smtp.163.com", PropertiesUtil.prop("email_user_name"), PropertiesUtil.prop("email_password"));
        Message message = SendMailUtil.createSimpleMail(session, PropertiesUtil.prop("email_sender"), sendEmailRestDto.getTo(), sendEmailRestDto.getSubject(), sendEmailRestDto.getContent());
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    @Override
    public void updateToAdmin(GUserEntity userEntity) {
        userMapper.updateToAdmin(userEntity.getId());
    }
}
