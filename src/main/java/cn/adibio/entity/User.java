package cn.adibio.entity;

import org.springframework.stereotype.Repository;

/**
 * Created by wjq on 2017/3/13.
 */
public class User {

    private String openId;

    private String orderIds;

    private String receinfoIds;

    public User() {
    }

    public User(String openId, String orderIds, String receinfoIds) {
        this.openId = openId;
        this.orderIds = orderIds;
        this.receinfoIds = receinfoIds;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(String orderIds) {
        this.orderIds = orderIds;
    }

    public String getReceinfoIds() {
        return receinfoIds;
    }

    public void setReceinfoIds(String receinfoIds) {
        this.receinfoIds = receinfoIds;
    }

    @Override
    public String toString() {
        return "User{" + "openId='" + openId + '\''
                + ", orderIds='" + orderIds + '\''
                + ", receinfoIds='" + receinfoIds + '\''
                + '}';
    }
}
