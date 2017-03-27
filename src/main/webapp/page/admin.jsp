<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>订单页</title>
    </head>
    <body>
        <table>
            <tr>
                <td>订单流水号</td>
                <td>创建时间</td>
                <td>状态</td>
                <td>联系地址</td>
                <td>联系电话</td>
                <td>收货人姓名</td>
                <td>收货人年龄</td>
                <td>收货人性别</td>
            </tr>
            <c:forEach items="${orderList}" var="item">
            <tr>
                <td>${item.orderId}</td>
                <td>${item.createTime}</td>
                <td>
                    <c:set var="st" scope="page" value="${item.state}"></c:set>
                    <c:choose>
                        <c:when test="${st=='wait1'}">已下单，待发货</c:when>
                        <c:when test="${st=='wait2'}">已发货</c:when>
                        <c:when test="${st=='wait3'}">到货，未返回</c:when>
                        <c:when test="${st=='wait4'}">已返回，等待监测结果</c:when>
                        <c:when test="${st=='finished'}">检测完成</c:when>
                    </c:choose>
                </td>
                <td>${item.address}</td>
                <td>${item.phone}</td>
                <td>${item.name}</td>
                <td>${item.age}</td>
                <td>${item.gender}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
