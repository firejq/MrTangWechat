package cn.adibio.service.impl;

import cn.adibio.service.WechatService;
import cn.adibio.wechatApiEntity.Authorization.AccessToken;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class WechatServiceImpl implements WechatService {

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.appsecret}")
    private String appSecret;

    /**
     * 获取全局access_token
     * @return
     * @throws IOException
     */
    public AccessToken getAccessToken() throws IOException {
        String accessPath = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        accessPath = accessPath.replace("APPID", this.appId).replace("APPSECRET", this.appSecret);

        URL url = new URL(accessPath);
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
        System.setProperty("sun.net.client.defaultReadTimeout", "30000");
        httpURLConnection.connect();
        InputStream inputStream = httpURLConnection.getInputStream();

        int size = inputStream.available();
        byte[] jsonBytes=new byte[size];
        inputStream.read(jsonBytes);
        String accessTokenString = new String(jsonBytes,"UTF-8");

        Gson gson = new Gson();
        AccessToken accessToken = gson.fromJson(accessTokenString, AccessToken.class);

        //TODO 将accesstoken写到本地properties文件中以作缓存，expires_in时间过期后再重新请求
        return accessToken;
    }



}
