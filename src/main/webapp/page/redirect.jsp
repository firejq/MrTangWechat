<%@ page import="cn.adibio.wechatApiEntity.Authorization.UserInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String openId = ((UserInfo) session.getAttribute("userInfo")).getOpenid();
    //request.getRequestDispatcher("/order/" + openId + "/show").forward(request, response);
    response.sendRedirect(request.getContextPath() + "/order/" + openId + "/show");
%>