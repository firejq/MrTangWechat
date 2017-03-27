package cn.adibio.service.impl;

import cn.adibio.dao.OrderDao;
import cn.adibio.entity.Order;
import cn.adibio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wjq on 2017/3/14.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> queryAllByOpenid(String openId) {
        List<Order> orderList =  this.orderDao.queryAllByOpenid(openId);
        for (Order order : orderList) {
            Date createTime = new Date(Long.valueOf(order.getCreateTime()));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            order.setCreateTime(simpleDateFormat.format(createTime).toString());
        }
        return orderList;
    }

    @Override
    public Order queryById(Long id) {
        Order order = this.orderDao.queryById(id);
        Date createTime = new Date(Long.valueOf(order.getCreateTime()));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        order.setCreateTime(simpleDateFormat.format(createTime));
        return order;
    }

    @Override
    public Integer insertOrder(Order order) {
        //订单流水号
        String orderId = new Date().getTime() + order.getOpenId().substring(0, 6);
        order.setOrderId(orderId);
        order.setState("wait1");
        return this.orderDao.insertOrder(order);
    }

    @Override
    public List<Order> queryAllOrder() {
        List<Order> orderList =  this.orderDao.queryAllOrder();
        for (Order order : orderList) {
            Date createTime = new Date(Long.valueOf(order.getCreateTime()));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            order.setCreateTime(simpleDateFormat.format(createTime).toString());
        }
        return orderList;
    }
}
