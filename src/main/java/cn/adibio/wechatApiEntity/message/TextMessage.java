package cn.adibio.wechatApiEntity.message;

public class TextMessage extends BaseMessage{
    private String Content;

    public TextMessage(String toUserName, String fromUserName, Long createTime, String msgType, String content) {
        super(toUserName, fromUserName, createTime, msgType);
        Content = content;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
