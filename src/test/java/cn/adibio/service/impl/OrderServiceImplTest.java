package cn.adibio.service.impl;

import cn.adibio.BaseTest;
import cn.adibio.entity.Order;
import cn.adibio.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceImplTest extends BaseTest{
    @Autowired
    OrderService orderService;

    @Test
    public void queryAllByOpenid() throws Exception {
        String openId = "aaabbbccc";
        List<Order> orderList = this.orderService.queryAllByOpenid(openId);

        for (Order order:orderList) {
            System.out.printf(order.toString() + "\n");
        }

    }

}