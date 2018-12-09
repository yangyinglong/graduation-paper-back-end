package cn.hdu.fragmentTax.controller.endpoint;


import cn.hdu.fragmentTax.dao.entity.GUserEntity;
import cn.hdu.fragmentTax.dto.request.LoginRestDto;
import cn.hdu.fragmentTax.dto.request.RegisterRestDto;
import cn.hdu.fragmentTax.model.logical.IAuthorizeLogical;
import cn.hdu.fragmentTax.model.view.IAuthorizeView;
import cn.hdu.fragmentTax.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

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
            resp.put("r", authorizeView.getUserResp(userEntity));
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
        authorizeLogical.addUser(userEntityRegister);
        resp.put("c", 200);
        resp.put("r", authorizeView.getUserResp(userEntityRegister));
        return resp;
    }

}
