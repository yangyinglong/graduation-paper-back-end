package cn.hdu.fragmentTax.controller.endpoint;

import cn.hdu.fragmentTax.dto.request.AddLabRestDto;
import cn.hdu.fragmentTax.dto.request.AdminShowLabRestDto;
import cn.hdu.fragmentTax.dto.request.EditLabRestDto;
import cn.hdu.fragmentTax.dto.request.ShowLabRestDto;
import cn.hdu.fragmentTax.dto.response.LabRespDto;
import cn.hdu.fragmentTax.model.logical.ILaboratoryHallLogical;
import cn.hdu.fragmentTax.model.view.ILaboratoryHallView;
import cn.hdu.fragmentTax.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/laboratory")
@CrossOrigin
public class LaboratoryHallController {

    @Autowired
    private ILaboratoryHallView laboratoryHallView;

    @Autowired
    private ILaboratoryHallLogical laboratoryHallLogical;

    @Path("/addLaboratory")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addLaboratory(AddLabRestDto addLabRestDto) {
        Map<String, Object> resp = new HashMap<>();
         if (!FormatUtil.isEmpty(laboratoryHallLogical.getUserEntity(addLabRestDto)))
         {
             try {
                 laboratoryHallLogical.addLaboratory(laboratoryHallView.getLaboratoryEntity(addLabRestDto));
                 resp.put("c", 200);
                 resp.put("r", "添加成功！");
                 return resp;
             }catch (Exception e) {
                e.printStackTrace();
             }
         }
        resp.put("c", 300);
        resp.put("r", "添加失败！");
        return  resp;
    }

    @Path("/editLaboratory")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editLaboratory(EditLabRestDto editLabRestDto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            laboratoryHallLogical.editLaboratory(editLabRestDto);
            resp.put("c", 200);
            resp.put("r", "修改成功！");
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "修改失败！");
        }
        return  resp;
    }

    @Path("/showLaboratory")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showLaboratory(ShowLabRestDto showLabRestDto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            resp.put("c", 200);
            resp.put("r", laboratoryHallLogical.getLaboratoryEntities(showLabRestDto));
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "查询失败！");
        }
        return resp;
    }

    @Path("/showLabNum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showLabNum(ShowLabRestDto showLabRestDto) {
        Map<String, Object> resp = new HashMap<>();
        int num = laboratoryHallLogical.getLaboratoryEntitiesNum(showLabRestDto);
        resp.put("c", 200);
        resp.put("r", num);
        return  resp;
    }

    @Path("/cancelLab")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> cancelLab(String labId) {
        Map<String, Object> resp = new HashMap<>();
        try {
            laboratoryHallLogical.cancelLab(labId);
            resp.put("c", 200);
            resp.put("r", "实验室删除成功！");
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "实验室删除失败！");
        }
        return resp;
    }

    @Path("/adminShowLaboratory")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> adminShowLaboratory(AdminShowLabRestDto adminShowLabRestDto) {
        Map<String, Object> resp = new HashMap<>();
        List<LabRespDto> labRespDtos = null;
        try {
            labRespDtos = laboratoryHallLogical.getAdminLaboratoryEntities(adminShowLabRestDto);
            resp.put("c", 200);
            resp.put("r", labRespDtos);
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "查询失败！");
        }
        return resp;
    }

    @Path("/adminShowLabNum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> adminShowLabNum(AdminShowLabRestDto adminShowLabRestDto) {
        Map<String, Object> resp = new HashMap<>();
        int num = laboratoryHallLogical.getAdminLaboratoryEntitiesNum(adminShowLabRestDto);
        resp.put("c", 200);
        resp.put("r", num);
        return  resp;
    }

}
