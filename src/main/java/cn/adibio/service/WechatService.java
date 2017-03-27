package cn.adibio.service;

import cn.adibio.wechatApiEntity.Authorization.AccessToken;

import java.io.IOException;

public interface WechatService {

    /**
     * 获取accesstoken
     * @return
     */
    AccessToken getAccessToken() throws IOException;

}
