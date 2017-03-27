package cn.adibio.service.impl;

import cn.adibio.dao.ReceiveInfoDao;
import cn.adibio.entity.ReceiveInfo;
import cn.adibio.entity.User;
import cn.adibio.service.ReceiveInfoService;
import cn.adibio.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wjq on 2017/3/14.
 */
@Service
public class ReceiveInfoServiceImpl implements ReceiveInfoService {

    @Autowired
    ReceiveInfoDao receiveInfoDao;

    @Autowired
    UserService userService;

    @Override
    public ReceiveInfo queryById(Long id) {
        return this.receiveInfoDao.queryById(id);
    }

    @Override
    public List<ReceiveInfo> queryAllByOpenid(String openId) {
        return this.receiveInfoDao.queryAllByOpenid(openId);
    }

    @Override
    @Transactional
    public Integer insertReceiveInfo(ReceiveInfo receiveInfo) {
        String token = new Date().getTime() + receiveInfo.getOpenId() + RandomStringUtils.randomAlphanumeric(4);
        receiveInfo.setToken(token);
        //插入新的收货信息
        Integer res = this.receiveInfoDao.insertReceiveInfo(receiveInfo);
        if (res <= 0) {
            return res;
        } else {
            String openId = receiveInfo.getOpenId();
            User user = this.userService.queryByOpenid(openId);
            //获取刚刚添加的收货信息的自增id值
            ReceiveInfo receiveInfo1 = this.receiveInfoDao.queryByToken(token);
            if (receiveInfo1 != null) {
                String newId = receiveInfo1.getId().toString();
                //查询user表是否有当前微信用户的数据
                if (user == null) {//若没有，则添加
                    user = new User(openId, "", newId + ":");
                    res = this.userService.insertUser(user);
                } else {//若有，则更新receinfo_ids字段，添加新的id
                    String receinfoIds = user.getReceinfoIds();
                    receinfoIds = receinfoIds + newId + ":";
                    res = this.userService.updateReceiveinfoIds(receinfoIds, openId);
                }
                return res;
            } else {
                return -1;
            }
        }
    }

    @Override
    @Transactional
    public Integer deleteById(Long id) {
        //取出要删除的记录数据，用于更新user表中的对应用户的receinfo_ids字段
        ReceiveInfo receiveInfo = this.receiveInfoDao.queryById(id);
        if (receiveInfo == null) {
            return -1;
        } else {
            //删除receive_info表的对应记录
            Integer res = this.receiveInfoDao.deleteById(id);
            if (res > 0) {
                //更新user表中的对应用户的receinfo_ids字段
                String openId =  receiveInfo.getOpenId();
                User user = this.userService.queryByOpenid(openId);
                String receinfoIds = user.getReceinfoIds();
                String newReceinfoIds = receinfoIds.replace(id + ":", "");
                res = this.userService.updateReceiveinfoIds(newReceinfoIds, openId);
            }
            return res;
        }
    }

    @Override
    public Integer updateById(Long id, ReceiveInfo receiveInfo) {
        return this.receiveInfoDao.updateById(id, receiveInfo);
    }
}
