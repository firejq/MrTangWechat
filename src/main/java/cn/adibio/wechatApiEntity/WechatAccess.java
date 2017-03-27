package cn.adibio.wechatApiEntity;

/**
 * 接入微信服务器的消息体
 */
public class WechatAccess {
//    private String token;
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;

//    public void init() throws IOException {
//        token = new String();
//        Properties properties = new Properties();
//        properties.load(WechatAccess.class.getClassLoader().getResourceAsStream("wechat/wechat.properties"));
//        this.token = properties.getProperty("wechat.token");
//    }

    public WechatAccess() {
    }

    public WechatAccess(String signature, String timestamp, String nonce, String echostr) {
        this.signature = signature;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.echostr = echostr;

    }

//    public String getToken() {
//        return token;
//    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    @Override
    public String toString() {
        return "WechatAccess{" + "signature='" + signature + '\'' + ", timestamp='" + timestamp + '\'' + ", nonce='" + nonce + '\'' + ", echostr='" + echostr + '\'' + '}';
    }
}
