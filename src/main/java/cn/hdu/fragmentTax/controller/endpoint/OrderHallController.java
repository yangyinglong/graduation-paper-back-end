package cn.hdu.fragmentTax.controller.endpoint;


import cn.hdu.fragmentTax.dto.request.AddOrderRestDto;
import cn.hdu.fragmentTax.dto.request.EditOrderRestDto;
import cn.hdu.fragmentTax.dto.request.ShowOrderBespeakRestDto;
import cn.hdu.fragmentTax.dto.request.ShowOrderRestDto;
import cn.hdu.fragmentTax.dto.response.OrderBespeakRespDto;
import cn.hdu.fragmentTax.dto.response.OrderRespDto;
import cn.hdu.fragmentTax.model.logical.IOrderHallLogical;
import cn.hdu.fragmentTax.model.view.IOrderHallView;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/order")
@CrossOrigin
public class OrderHallController {

    @Autowired
    private IOrderHallView orderHallView;

    @Autowired
    private IOrderHallLogical orderHallLogical;

    @Path("/addOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> addOrder(AddOrderRestDto addOrderRestDto){
        Map<String, Object> resp = new HashMap<>();
        try {
            orderHallLogical.addOrder(orderHallView.getOrderEntity(addOrderRestDto));
            resp.put("c", 200);
            resp.put("r", "提交成功，请及时查看审核结果！");
        } catch (Exception e) {
            resp.put("c", 300);
            resp.put("r", "提交预约单失败！");
        }
        return  resp;
    }

    @Path("/showOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showOrder(ShowOrderRestDto showOrderRestDto){
        Map<String, Object> resp = new HashMap<>();
        List<OrderRespDto> orderRespDtos = null;
        try {
            orderRespDtos = orderHallLogical.getOrderRespDtos(showOrderRestDto);
            resp.put("c", 200);
            resp.put("r", orderRespDtos);
        } catch ( Exception e) {
            resp.put("c", 300);
            resp.put("r", null);
        }
        return resp;
    }

    @Path("/showOrderNum")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showOrderNum(ShowOrderRestDto showOrderRestDto) {
        Map<String, Object> resp = new HashMap<>();
        int num = orderHallLogical.getOrderEntitiesNum(showOrderRestDto);
        resp.put("c", 200);
        resp.put("r", num);
        return resp;
    }

    @Path("/editOrder")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> editOrder(EditOrderRestDto editOrderRestDto) {
        Map<String, Object> resp = new HashMap<>();
       try {
           orderHallLogical.editOrder(editOrderRestDto);
           resp.put("c", 200);
           resp.put("r", "修改成功，请及时查看审核结果！");
       } catch (Exception e) {
           resp.put("c", 300);
           resp.put("r", "提交失败！");
       }
        return resp;
    }

    @Path("/showOrderBespeakTime")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> showOrderBespeakTime(ShowOrderBespeakRestDto showOrderBespeakRestDto) {
        Map<String, Object> resp = new HashMap<>();
        try {
            List<OrderBespeakRespDto> orderBespeakRespDtos = orderHallLogical.getOrderBespeakRespDtos(showOrderBespeakRestDto);
            resp.put("c", 200);
            resp.put("r", orderBespeakRespDtos);
        } catch (ParseException e) {
            resp.put("c", 300);
            resp.put("r", "查找失败！");
        }
        return resp;
    }

}
