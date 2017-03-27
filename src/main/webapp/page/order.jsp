<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <title>我的订单</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/res/weui/style/weui.min.css"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/receive_info.css"/>
        <script src="<%=request.getContextPath()%>/resources/res/jquery/jquery-3.1.1.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/res/weui/js/weui.min.js"></script>
    </head>
    <body ontouchstart>
        <c:if test="${orderList == null}">
            <div class="weui-loadmore weui-loadmore_line">
                <span class="weui-loadmore__tips">暂无订单</span>
            </div>
        </c:if>
        <c:if test="${orderList != null}">
            <c:forEach items="${orderList}" var="item">
                <!-- 表单预览 -->
                <div class="weui-form-preview">
                    <!-- head 部分 -->
                    <div class="weui-form-preview__hd">
                        <div class="weui-form-preview__item">
                            <label class="weui-form-preview__label">订单状态</label>
                            <em class="weui-form-preview__value">
                                <c:set var="st" scope="page" value="${item.state}"></c:set>
                                <c:choose>
                                    <c:when test="${st=='wait1'}">已下单，待发货</c:when>
                                    <c:when test="${st=='wait2'}">已发货</c:when>
                                    <c:when test="${st=='wait3'}">到货，未返回</c:when>
                                    <c:when test="${st=='wait4'}">已返回，等待监测结果</c:when>
                                    <c:when test="${st=='finished'}">检测完成</c:when>
                                </c:choose>
                            </em>

                        </div>
                    </div>
                    <!-- body 部分 -->
                    <div class="weui-form-preview__bd">
                        <div class="weui-form-preview__item">
                            <label class="weui-form-preview__label">下单时间</label>
                            <span class="weui-form-preview__value">${item.createTime}</span>
                        </div>
                        <div class="weui-form-preview__item">
                            <label class="weui-form-preview__label">联系电话</label>
                            <span class="weui-form-preview__value">${item.phone}</span>
                        </div>
                        <div class="weui-form-preview__item">
                            <label class="weui-form-preview__label">送货地址</label>
                            <span class="weui-form-preview__value">${item.address}</span>
                        </div>
                        <div class="weui-form-preview__item">
                            <label class="weui-form-preview__label">订单号</label>
                            <span class="weui-form-preview__value">${item.orderId}</span>
                        </div>
                    </div>
                    <!-- foot 部分 -->
                    <div class="weui-form-preview__ft">
                        <a href="<%=request.getContextPath()%>/order/${item.id}/detail"
                           class="weui-form-preview__btn weui-form-preview__btn_default">
                            订单详情
                        </a>
                    </div>
                </div>
                <br>
            </c:forEach>
        </c:if>


    </body>

</html>
