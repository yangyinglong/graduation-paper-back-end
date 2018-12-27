package cn.hdu.fragmentTax.model.view;

import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dto.request.RegisterRestDto;
import cn.hdu.fragmentTax.dto.response.UserRespDto;
import cn.hdu.fragmentTax.util.FormatUtil;
import org.springframework.stereotype.Service;

import javax.mail.Session;

import java.util.Properties;

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
        userEntity.setEmail(registerRestDto.geteMail());
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

    @Override
    public Session createSession() {
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.163.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(false);
        return session;
    }

    @Override
    public GUserEntity getAdminEntity(RegisterRestDto registerRestDto) {
        GUserEntity userEntity = new GUserEntity();
        userEntity.setId(registerRestDto.getId());
        userEntity.setName(registerRestDto.getName());
        userEntity.setPassword(registerRestDto.getPassword());
        userEntity.setPhone(registerRestDto.getPhone());
        userEntity.setEmail(registerRestDto.geteMail());
        userEntity.setStatus(2);
        userEntity.setCreatedTime(getCurrentDatetime());
        return userEntity;
    }
}
