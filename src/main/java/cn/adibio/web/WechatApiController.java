package cn.adibio.web;

import cn.adibio.util.WechatUtil;
import cn.adibio.wechatApiEntity.Authorization.AccessFeedback;
import cn.adibio.wechatApiEntity.Authorization.UserInfo;
import cn.adibio.wechatApiEntity.WechatAccess;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Controller
public class WechatApiController {

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.appsecret}")
    private String appSecret;

    @Value("${wechat.token}")
    private String token;

    /**
     * 接入微信接口：http://xxx.xxx.com/wechat/wechat_api
     * @param wechatAccess
     * @return
     */
    @RequestMapping(value = "/wechat_api", method = RequestMethod.GET)
    @ResponseBody
    public String wechatApiGet(WechatAccess wechatAccess) throws IOException {

//        System.out.printf(wechatAccess.getToken());
        String[] arr = new String[]{token, wechatAccess.getTimestamp(), wechatAccess.getNonce()};
        Arrays.sort(arr);
        StringBuffer content = new StringBuffer();
        for (String str : arr) {
            content.append(str);
        }
        String result = WechatUtil.getSha1(content.toString());
        if (result.equals(wechatAccess.getSignature())) {
            return wechatAccess.getEchostr();
        } else {
            return null;
        }
    }

    /**
     * 获取微信消息推送和回复
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    @RequestMapping(value = "/wechat_api", method = RequestMethod.POST)
    @ResponseBody
    public String wechatApiPost(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = WechatUtil.xmlToMap(request);

//        if (map.get("MsgType").equals("text")) {
//            String content = "i am test!@";
//            TextMessage textMessage = new TextMessage(map.get("fromUserName"), map.get("toUserName"),
//                    new Date().getTime(), map.get("msgType"), content);
//            String xmlMessage = WechatUtil.textMessageToXml(textMessage);
//            return xmlMessage;
//        }

        return "success";
    }

    /**
     * 微信网页授权SCOPE=snsapi_userinfo
     * 引导用户访问url：
     * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx86eb57fabace7bef&redirect_uri=http%3a%2f%2fjq.tunnel.qydev.com%2fwechat%2fwechat_authorization&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect
     * @param code
     * @param state
     * @param httpSession
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/wechat_authorization", method = RequestMethod.GET)
    public String wechatAuthorization(@RequestParam("code") String code, @RequestParam("state") String state, HttpSession httpSession)
            throws IOException {
        //使用微信服务器传回的code，结合appid和appsecret获取网页授权accesstoken
        AccessFeedback accessFeedback = WechatUtil.getWebAccessToken(code, this.appId, this.appSecret);
        String accessToken = accessFeedback.getAccess_token();

        //使用网页授权accesstoken和openid，拉取用户信息
        String openId = accessFeedback.getOpenid();
        UserInfo userInfo = WechatUtil.getUserInfo(accessToken, openId);

        httpSession.setAttribute("userInfo", userInfo);
        return "index";
    }
}
