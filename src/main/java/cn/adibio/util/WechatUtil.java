package cn.adibio.util;

import cn.adibio.wechatApiEntity.Authorization.AccessFeedback;
import cn.adibio.wechatApiEntity.Authorization.UserInfo;
import cn.adibio.wechatApiEntity.message.TextMessage;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WechatUtil {
    /**
     * 获取sha1
     * @param str
     * @return
     */
    public static String getSha1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将微信服务器发过来的request请求（xml格式）转换为Map
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        SAXReader saxReader = new SAXReader();
        InputStream inputStreams = request.getInputStream();
        Document document = saxReader.read(inputStreams);
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();
        Map<String, String> map = new HashMap<>();
        for (Element element : elementList) {
            map.put(element.getName(), element.getText());
        }
        inputStreams.close();
        return map;
    }

    /**
     * 将文本消息类型转换为xml格式的字符串，以回复微信服务器
     * @param textMessage
     * @return
     */
    public static String textMessageToXml(TextMessage textMessage) {
        XStream xstream = new XStream();
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 使用微信服务器传回的code，结合appid和appsecret获取网页授权accesstoken
     * @param code
     * @param appId
     * @param appSecret
     * @return
     * @throws IOException
     */
    public static AccessFeedback getWebAccessToken(String code, String appId, String appSecret) throws IOException {
        if (code == null){
            return null;
        }else{
            String accessToken;
            String accessPath = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
            accessPath = accessPath.replace("APPID", appId);
            accessPath = accessPath.replace("SECRET", appSecret);
            accessPath = accessPath.replace("CODE", code);

            URL url = new URL(accessPath);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
            System.setProperty("sun.net.client.defaultReadTimeout", "30000");
            httpURLConnection.connect();

            InputStream is=httpURLConnection.getInputStream();
            int size=is.available();
            byte[] jsonBytes=new byte[size];
            is.read(jsonBytes);
            accessToken = new String(jsonBytes,"UTF-8");

            Gson gson = new Gson();
            AccessFeedback accessFeedback = gson.fromJson(accessToken, AccessFeedback.class);

            return accessFeedback;
        }
    }

    /**
     * 使用网页授权accesstoken和openid，拉取用户信息
     * @param accessToken
     * @param openId
     * @return
     * @throws IOException
     */
    public static UserInfo getUserInfo(String accessToken, String openId) throws IOException {
        if (accessToken == null) {
            return null;
        } else {
            String accessPath = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN ";
            accessPath = accessPath.replace("ACCESS_TOKEN", accessToken);
            accessPath = accessPath.replace("OPENID", openId);

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
            String userInfoString = new String(jsonBytes,"UTF-8");

            Gson gson = new Gson();
            UserInfo userInfo = gson.fromJson(userInfoString, UserInfo.class);
            return userInfo;
        }
    }

}
