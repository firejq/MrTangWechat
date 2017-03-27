<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/res/weui/style/weui.min.css"/>
</head>

<c:set var="openId" value="${sessionScope.userInfo.openid}"/>
<c:set var="headImgUrl" value="${sessionScope.userInfo.headimgurl}"/>
<c:set var="nickName" value="${sessionScope.userInfo.nickname}"/>

<body>
<div class="weui-cells__title">用户信息</div>
<div class="weui-cells">
    <div class="weui-cell">
        <div class="weui-cell__hd"><img src="${headImgUrl}" alt="用户头像" style="width:60px;margin:5px;display:block">
        </div>
        <div class="weui-cell__bd">
            <p></p>
        </div>
        <div class="weui-cell__ft"><p>用户名</p>
            <p>${nickName}</p></div>
    </div>
</div>
<div class="weui-cells__title"></div>
<div class="weui-cells">
    <a class="weui-cell weui-cell_access"
       href="<%=request.getContextPath()%>/receive_info/${openId}/show">
        <div class="weui-cell__bd">
            <p>收货信息</p>
        </div>
        <div class="weui-cell__ft"></div>
    </a>
    <a class="weui-cell weui-cell_access" href="javascript:;">
        <div class="weui-cell__bd">
            <p>用户反馈</p>
        </div>
        <div class="weui-cell__ft"></div>
    </a>
    <a class="weui-cell weui-cell_access" href="javascript:;">
        <div class="weui-cell__bd">
            <p>其他</p>
        </div>
        <div class="weui-cell__ft">下面可以放些别的什么的</div>
    </a>

</div>
</body>
</html>
