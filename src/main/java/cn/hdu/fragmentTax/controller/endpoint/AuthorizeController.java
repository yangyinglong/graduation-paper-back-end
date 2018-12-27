package cn.hdu.fragmentTax.controller.endpoint;


import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dto.request.*;
import cn.hdu.fragmentTax.dto.response.UserRespDto;
import cn.hdu.fragmentTax.model.logical.IAuthorizeLogical;
import cn.hdu.fragmentTax.model.view.IAuthorizeView;
import cn.hdu.fragmentTax.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.mail.Session;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/authorize")
@CrossOrigin
public class AuthorizeController {

    @Autowired
    private IAuthorizeView authorizeView;

    @Autowired
    private IAuthorizeLogical authorizeLogical;

    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> login(LoginRestDto loginRestDto){
        Map<String, Object> resp = new HashMap<>();
        GUserEntity userEntity = authorizeLogical.getUserEntity(loginRestDto);
        if (FormatUtil.isEmpty(userEntity)) {
            resp.put("c", 400);
            resp.put("r", "没有此账号！");
            return resp;
        }
        if (userEntity.getPassword().equals(loginRestDto.getPassword())){
            resp.put("c", 200);
            resp.put("r", authorizeView.getUserRespDto(userEntity));
            return resp;
        }
        resp.put("c", 300);
        resp.put("r", "密码错误！");
        return resp;
    }

    @Path("/register")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> register(RegisterRestDto registerRestDto){
        Map<String, Object> resp = new HashMap<>();
        GUserEntity userEntity = authorizeLogical.getUserEntity(registerRestDto);
        if (!FormatUtil.isEmpty(userEntity)){
            resp.put("c", 201);
            resp.put("r", "账号已存在，请登录或者找回密码！");
            return resp;
        }
        GUserEntity userEntityRegister = authorizeView.getUserEntity(registerRestDto);
        //todo 异常捕捉
        authorizeLogical.addUser(userEntityRegister);
        resp.put("c", 200);
        resp.put("r", authorizeView.getUserRespDto(userEntityRegister));
        return resp;
    }

    @Path("/registerAdmin")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> registerAdmin(RegisterRestDto registerRestDto){
        Map<String, Object> resp = new HashMap<>();
        GUserEntity userEntity = authorizeLogical.getUserEntity(registerRestDto);
        if (!FormatUtil.isEmpty(userEntity)){
            authorizeLogical.updateToAdmin(userEntity);
            resp.put("c", 201);
            resp.put("r", authorizeView.getUserRespDto(authorizeView.getAdminEntity(registerRestDto)));
            return resp;
        }
        GUserEntity userEntityRegister = authorizeView.getAdminEntity(registerRestDto);
        //todo 异常捕捉
        authorizeLogical.addUser(userEntityRegister);
        resp.put("c", 200);
        resp.put("r", authorizeView.getUserRespDto(userEntityRegister));
        return resp;
    }

    @Path("/forgotPass")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> forgotPass(ForgotPassRestDto forgotPassRestDto){
        Map<String, Object> resp = new HashMap<>();
        GUserEntity userEntity = authorizeLogical.getUserEntity(forgotPassRestDto);
        if (FormatUtil.isEmpty(userEntity)) {
            resp.put("c", 400);
            resp.put("r", "该手机号未注册！");
            return resp;
        }
        UserRespDto userRespDto = authorizeLogical.updatePassword(userEntity, forgotPassRestDto);
        if (FormatUtil.isEmpty(userRespDto)) {
            resp.put("c", 300);
            resp.put("r", "密码修改失败！");
            return resp;
        }
        resp.put("c", 200);
        resp.put("r", userRespDto);
        return resp;
    }

    @Path("/editUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editUser(EditUserRestDto editUserRestDto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            authorizeLogical.editUser(editUserRestDto);
            resp.put("c", 200);
            resp.put("r", "修改成功！");
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "修改失败！");
        }
        return resp;
    }

    /**
     * 发送邮件
     * @param sendEmailRestDto
     * @return
     */
    @Path("sendEmail")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> sendEmail(SendEmailRestDto sendEmailRestDto){
        Map<String, Object> resp = new HashMap<>();
        try {
            Session session = authorizeView.createSession();
            authorizeLogical.sendEmail(session, sendEmailRestDto);
            resp.put("c", 200);
            resp.put("r", "邮件发送成功");
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.put("c", 201);
        resp.put("r", "邮件发送失败");
        return resp;
    }

}
