package cn.adibio.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class WechatUtilTest {
    @Test
    public void getUserInfo() throws Exception {
        String accessToken = "123";
        String openId = "456";
        String accessPath = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN ";
        accessPath = accessPath.replace("ACCESS_TOKEN", accessToken);
        accessPath = accessPath.replace("OPENID", openId);
        System.out.printf(accessPath);
    }

}