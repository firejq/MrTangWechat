<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: will
  Date: 2017/3/16
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="openId" value="${sessionScope.userInfo.openid}"/>
<html>
<head>
    <title>确认订单</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/res/weui/style/weui.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/receive_info.css"/>
</head>
<body>
<%--查询收货信息为空--%>

<div class="weui-cells__title">收货信息</div>
<div class="weui-cells">
    <a class="weui-cell weui-cell_access"
       href="<%=request.getContextPath()%>/receive_info/${openId}/choose">
        <div class="weui-cell__bd">
            <c:if test="${receiveInfo == null}">
                <p>暂无收货信息</p>
            </c:if>
            <c:if test="${receiveInfo != null}">
                <p>${receiveInfo.name}</p>
                <p>${receiveInfo.address}</p>
            </c:if>
        </div>
        <div class="weui-cell__ft"></div>
    </a>
</div>
<div class="weui-cells__title">商品信息</div>
<div class="weui-cells">
    <a class="weui-cell weui-cell_access"
       href="<%=request.getContextPath()%>/page/buy_diabetes_service.jsp">
        <div class="weui-cell__bd">
            <p>糖尿病检测服务</p>
        </div>
        <div class="weui-cell__ft"></div>
    </a>
</div>
<c:if test="${receiveInfo == null}">
    <a class="weui-btn weui-footer_fixed-bottom_jq weui-btn_primary weui-btn_disabled">确认支付（请填写收货信息）</a>
</c:if>
<c:if test="${receiveInfo != null}">
    <%--/order/{openId}/{address}/{phone}/{name}/{age}/{gender}/insert--%>
    <a href="<%= request.getContextPath()%>/order/${openId}/${receiveInfo.address}/${receiveInfo.phone}/${receiveInfo.name}/${receiveInfo.age}/${receiveInfo.gender}/insert"
       class="weui-btn weui-footer_fixed-bottom_jq weui-btn_primary" target="_blank">确认支付</a>
</c:if>

</body>
</html>
