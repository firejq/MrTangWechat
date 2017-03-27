package cn.adibio.dao;

import cn.adibio.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by wjq on 2017/3/13.
 */
@Repository
public interface UserDao {

    /**
     * query by openid
     * @param openId
     * @return
     */
    User queryByOpenid(String openId);

    /**
     * update the receive_id of a record by open_id
     * @param receinfoIds
     * @param openId
     * @return
     */
    Integer updateReceiveinfoIds(@Param("receinfoIds") String receinfoIds, @Param("openId") String openId);

    /**
     * insert a record into the user table
     * @param user
     * @return
     */
    Integer insertUser(User user);
}
