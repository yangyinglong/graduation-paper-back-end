package cn.hdu.fragmentTax.controller.endpoint;


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

    @Path("/login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> login(){
        Map<String, Object> resp = new HashMap<>();
        resp.put("c", 200);
        resp.put("r", "登录成功");
        return resp;
    }

}
