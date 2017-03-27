package cn.adibio.service.impl;

import cn.adibio.entity.ReceiveInfo;
import cn.adibio.service.ReceiveInfoService;
import org.junit.Test;
import cn.adibio.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.SortedMap;

import static org.junit.Assert.*;


/**
 * Created by wjq on 2017/3/14.
 */
public class ReceiveInfoServiceImplTest extends BaseTest {

    @Autowired
    ReceiveInfoService receiveInfoService;

    @Test
    public void queryById() throws Exception {
        ReceiveInfo receiveInfo = this.receiveInfoService.queryById(16L);
        System.out.printf(receiveInfo.toString() + "\n");




    }


    @Test
    @Rollback(false)
    public void insertReceiveInfo() throws Exception {
        ReceiveInfo receiveInfo = new ReceiveInfo(null, "qqwweerr", "saasd阿三", "男", 34,
                "啊实打实大大", "13223223333", null);
        Integer res = this.receiveInfoService.insertReceiveInfo(receiveInfo);
        System.out.printf(res > 0 ? "成功！！！" : "失败！！！");
    }

    @Test
    public void timeTest() throws Exception {
        String time1 = String.valueOf(new Date().getTime());
        System.out.printf(time1);
        Date date = new Date(Long.parseLong(time1));
        System.out.printf(date.toString());
    }

    @Test
    //@Rollback(false)
    public void deleteById() throws Exception {
        Integer res = this.receiveInfoService.deleteById(34L);
        System.out.printf(res > 0 ? "成功！！！" : "失败！！！");
    }


}