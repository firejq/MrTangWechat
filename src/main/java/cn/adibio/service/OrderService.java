package cn.adibio.service;

import cn.adibio.entity.Order;

import java.util.List;

/**
 * Created by wjq on 2017/3/14.
 */
public interface OrderService {
    /**
     * query all records by openId
     */
    List<Order> queryAllByOpenid(String openId);

    /**
     * query a record by id
     */
    Order queryById(Long id);

    /**
     * insert a record into order
     */
    Integer insertOrder(Order order);

    /**
     * query all records in the order table
     * @return
     */
    List<Order> queryAllOrder();
}
