package cn.adibio.service;

import cn.adibio.entity.User;

/**
 * Created by wjq on 2017/3/14.
 */
public interface UserService {

    /**
     * query by openid
     */
    User queryByOpenid(String openId);

    /**
     * update a record
     */
    Integer updateReceiveinfoIds(String receinfoIds, String openId);

    /**
     * insert a record into the user table
     * @param user
     * @return
     */
    Integer insertUser(User user);

}
