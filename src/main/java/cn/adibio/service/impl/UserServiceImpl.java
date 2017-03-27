package cn.adibio.service.impl;

import cn.adibio.dao.UserDao;
import cn.adibio.entity.User;
import cn.adibio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wjq on 2017/3/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User queryByOpenid(String openId) {
        return this.userDao.queryByOpenid(openId);
    }

    @Override
    public Integer updateReceiveinfoIds(String receinfoIds, String openId) {
        return this.userDao.updateReceiveinfoIds(receinfoIds, openId);
    }

    @Override
    public Integer insertUser(User user) {
        return this.userDao.insertUser(user);
    }
}
