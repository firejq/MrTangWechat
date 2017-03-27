package cn.adibio.wechatApiEntity.Authorization;

public class AccessToken {
    private String access_token;

    private String expires_in;

    public AccessToken(String access_token, String expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "AccessToken{" + "access_token='" + access_token + '\'' + ", expires_in='" + expires_in + '\'' + '}';
    }
}
