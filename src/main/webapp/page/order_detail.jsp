<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>订单详情</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.1/style/weui.min.css"/>
</head>
<body>
<!-- 表单预览 -->
<div class="weui-form-preview">
    <!-- head 部分 -->
    <div class="weui-form-preview__hd">
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">订单详情</label>
            <em class="weui-form-preview__value">
            </em>
        </div>
    </div>
    <!-- body 部分 -->
    <div class="weui-form-preview__bd">
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">订单编号</label>
            <span class="weui-form-preview__value">
                ${order.orderId}
            </span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">下单时间</label>
            <span class="weui-form-preview__value">
                ${order.createTime}
            </span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">收件人</label>
            <span class="weui-form-preview__value">
                ${order.name}
            </span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">性别</label>
            <span class="weui-form-preview__value">
                ${order.gender}
            </span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">年龄</label>
            <span class="weui-form-preview__value">
                ${order.age}
            </span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">联系电话</label>
            <span class="weui-form-preview__value">
                ${order.phone}
            </span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">送货地址</label>
            <span class="weui-form-preview__value">
                ${order.address}
            </span>
        </div>
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">订单状态</label>
            <span class="weui-form-preview__value">
                <c:set var="st" scope="page" value="${order.state}"></c:set>
                <c:choose>
                    <c:when test="${st=='wait1'}">已下单，待发货</c:when>
                    <c:when test="${st=='wait2'}">已发货</c:when>
                    <c:when test="${st=='wait3'}">到货，未返回</c:when>
                    <c:when test="${st=='wait4'}">已返回，等待监测结果</c:when>
                    <c:when test="${st=='finished'}">检测完成</c:when>
                </c:choose>
            </span>
        </div>
    </div>
</div>
</body>
</html>