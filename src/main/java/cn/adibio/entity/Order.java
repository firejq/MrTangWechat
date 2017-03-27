package cn.adibio.entity;

import org.springframework.stereotype.Repository;

/**
 * Created by wjq on 2017/3/13.
 */
public class Order {

    private Long id;

    private String orderId;

    private String openId;

    private String createTime;

    private String state;

    private String address;

    private String phone;

    private String name;

    private Integer age;

    private String gender;

    public Order() {
    }

    public Order(String openId, String createTime, String address, String phone, String name, Integer age, String gender) {
        this.openId = openId;
        this.createTime = createTime;
        this.address = address;
        this.phone = phone;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Order(Long id, String orderId, String openId, String createTime, String state, String address, String phone, String name, Integer age, String gender) {
        this.id = id;
        this.orderId = orderId;
        this.openId = openId;
        this.createTime = createTime;
        this.state = state;
        this.address = address;
        this.phone = phone;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", orderId='" + orderId + '\'' + ", openId='" + openId + '\'' + ", createTime='" + createTime + '\'' + ", state='" + state + '\'' + ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + '}';
    }
}
