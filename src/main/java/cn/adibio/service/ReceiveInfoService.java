package cn.adibio.service;

import cn.adibio.entity.ReceiveInfo;

import java.util.List;

/**
 * Created by wjq on 2017/3/14.
 */
public interface ReceiveInfoService {

    /**
     * query by id
     */
    ReceiveInfo queryById(Long id);

    /**
     * query all receive information as a list by openid
     */
    List<ReceiveInfo> queryAllByOpenid(String openId);

    /**
     * insert a record into the table
     */
    Integer insertReceiveInfo(ReceiveInfo receiveInfo);

    /**
     * delete a record by id
     */
    Integer deleteById(Long id);

    /**
     * update a record by id
     */
    Integer updateById(Long id, ReceiveInfo receiveInfo);
}
