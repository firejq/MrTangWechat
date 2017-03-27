package cn.adibio.service.impl;

import cn.adibio.BaseTest;
import cn.adibio.entity.User;
import cn.adibio.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wjq on 2017/3/14.
 */
public class UserServiceImplTest extends BaseTest {
    @Autowired
    UserService userService;

    @Test
    public void queryByOpenid() throws Exception {
        User user = this.userService.queryByOpenid("aaabbbccc");
        System.out.printf(user.toString());
    }


}