package cn.adibio.entity;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;
import org.springframework.stereotype.Repository;

/**
 * Created by wjq on 2017/3/13.
 */
public class ReceiveInfo {

    private Long id;

    private String openId;

    private String name;

    private String gender;

    private Integer age;

    private String address;

    private String phone;

    private String token;

    public ReceiveInfo() {
    }

    public ReceiveInfo(Long id, String openId, String name, String gender, Integer age, String address, String phone, String token) {
        this.id = id;
        this.openId = openId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.token = token;
    }

    public ReceiveInfo(String name, String gender, Integer age, String address, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ReceiveInfo{" + "id=" + id + ", openId='" + openId + '\'' + ", name='" + name + '\'' + ", gender='" + gender + '\'' + ", age=" + age + ", address='" + address + '\'' + ", phone='" + phone + '\'' + ", token='" + token + '\'' + '}';
    }
}
