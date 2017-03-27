package cn.adibio.dao;

import cn.adibio.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wjq on 2017/3/13.
 */
@Repository
public interface OrderDao {
    /**
     * query all records by openid
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
