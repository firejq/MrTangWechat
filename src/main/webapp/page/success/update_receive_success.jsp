<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 2017/2/21
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改收货信息成功</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/res/weui/style/weui.min.css"/>
</head>
<body>
<div class="weui-msg">
    <div class="weui-msg__icon-area"><i class="weui-icon-success weui-icon_msg"></i></div>
    <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">成功修改</h2>
    </div>
    <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
            <a href="<%=request.getContextPath()%>" class="weui-btn weui-btn_primary">确认</a>
            <%--<a href="<%=request.getContextPath()%>/receive_info/${sessionScope.userInfo.openid}/show" class="weui-btn weui-btn_primary">确认</a>--%>
        </p>
    </div>
    <div class="weui-msg__extra-area">
        <div class="weui-footer">
            <p class="weui-footer__links">
                <a href="javascript:void(0);" class="weui-footer__link">公司链接</a>
            </p>
            <p class="weui-footer__text">Copyright &copy; 2008-2016 公司信息</p>
        </div>
    </div>
</div>
</body>
</html>
