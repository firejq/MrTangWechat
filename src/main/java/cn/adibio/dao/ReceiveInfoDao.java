package cn.adibio.dao;

import cn.adibio.entity.ReceiveInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wjq on 2017/3/13.
 */
@Repository
public interface ReceiveInfoDao {

    /**
     * query all records by open_id
     */
    List<ReceiveInfo> queryAllByOpenid(String openId);

    /**
     * query by id
     * @param id
     */
    ReceiveInfo queryById(Long id);

    /**
     * insert a record into the table
     */
    Integer insertReceiveInfo(ReceiveInfo receiveInfo);

    /**
     * query a record by token
     */
    ReceiveInfo queryByToken(String token);

    /**
     * delete a record by id
     */
    Integer deleteById(Long id);

    /**
     * update a record by id
     */
    Integer updateById(@Param("id") Long id, @Param("receiveInfo") ReceiveInfo receiveInfo);


}
