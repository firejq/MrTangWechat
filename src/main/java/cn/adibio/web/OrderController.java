package cn.adibio.web;

import cn.adibio.entity.Order;
import cn.adibio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order/{openId}/show", method = RequestMethod.GET)
    public ModelAndView orderShow(@PathVariable("openId") String openId) {
        List<Order> orderList = this.orderService.queryAllByOpenid(openId);
        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject(orderList);
        return modelAndView;
    }

    @RequestMapping(value = "/order/{id}/detail", method = RequestMethod.GET)
    public ModelAndView orderDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("order_detail");
        Order order = this.orderService.queryById(id);
        modelAndView.addObject(order);
        return modelAndView;
    }

    @RequestMapping(value = "/order/{openId}/create", method = RequestMethod.POST)//TODO
    public String orderCreate(@PathVariable("openId") String openId, HttpServletRequest request) {
        String createTime = String.valueOf(new Date().getTime());
        Order order = new Order(openId, createTime, request.getParameter("address"),
                request.getParameter("phone"), request.getParameter("name"),
                Integer.parseInt(request.getParameter("age")),
                request.getParameter("gender"));
        Integer res = this.orderService.insertOrder(order);
        return (res > 0 ? "success/add_receive_success" : "fail/error");
    }

    @RequestMapping(value = "/order/{openId}/{address}/{phone}/{name}/{age}/{gender}/insert", method = RequestMethod.GET)
    public ModelAndView insertOrder(@PathVariable("openId") String openId, @PathVariable("address") String address,
                                    @PathVariable("phone") String phone, @PathVariable("name") String name,
                                    @PathVariable("age") String age, @PathVariable("gender") String gender){
        String createTime = String.valueOf(new Date().getTime());
        Order order = new Order(openId, createTime, address, phone, name, Integer.valueOf(age), gender);
        int res = this.orderService.insertOrder(order);
        return (res > 0 ? new ModelAndView("success/purchase_success") : new ModelAndView("fail/error"));
    }

}
