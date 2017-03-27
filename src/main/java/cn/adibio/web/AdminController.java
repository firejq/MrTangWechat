package cn.adibio.web;

import cn.adibio.entity.Order;
import cn.adibio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/admin/nimda", method = RequestMethod.GET)
    public ModelAndView admin() {
        List<Order> orderList = this.orderService.queryAllOrder();
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("orderList", orderList);
        return modelAndView;
    }
}
