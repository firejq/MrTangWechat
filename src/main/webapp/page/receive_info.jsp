<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <title>收货信息</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/res/weui/style/weui.min.css"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/receive_info.css"/>
        <script src="<%=request.getContextPath()%>/resources/res/jquery/jquery-3.1.1.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/res/weui/js/weui.min.js"></script>
        <script language="javascript" type="text/javascript">
            function submit()
            {
                document.getElementById('hiddenForm').submit();
                <%--window.location.href("<%=request.getContextPath()%>/page/receinfo_add.jsp");--%>

            }
        </script>
    </head>
    <body ontouchstart>

        <%--查询收货信息为空--%>
        <c:if test="${receiveInfoList == null}">
            <div class="weui-loadmore weui-loadmore_line">
                <span class="weui-loadmore__tips">暂无收货信息</span>
            </div>
        </c:if>
        <%--查询收货信息不为空--%>
        <c:if test="${receiveInfoList != null}">
            <c:forEach items="${receiveInfoList}" var="item">
                <!-- 表单预览 -->
                <div class="weui-form-preview">
                    <!-- head 部分 -->
                    <div class="weui-form-preview__hd">
                        <div class="weui-form-preview__item">
                            <label class="weui-form-preview__label">
                                <c:out value="${item.name}"/>
                            </label>
                            <em class="weui-form-preview__value">
                                <c:out value="${item.phone}"/>
                            </em>
                        </div>
                    </div>
                    <!-- body 部分 -->
                    <div class="weui-form-preview__bd">
                        <div class="weui-form-preview__item">
                            <label class="weui-form-preview__label">
                                <c:out value="${item.address}"/>
                            </label>
                        </div>

                        <!-- foot 部分 -->
                        <div class="weui-form-preview__ft">
                            <a href="<%=request.getContextPath()%>/receive_info/${item.id}/edit"
                               class="weui-form-preview__btn weui-form-preview__btn_default">编辑</a>
                            <a href="<%=request.getContextPath()%>/receive_info/${item.id}/delete"
                               class="weui-form-preview__btn weui-form-preview__btn_primary">删除</a>
                        </div>
                    </div>
                </div>
                <br>
            </c:forEach>

        </c:if>

        <form id="hiddenForm" action="<%=request.getContextPath()%>/page/receinfo_add.jsp" method="post">
            <input type="text" name="openId" value="${sessionScope.userInfo.openid}" hidden/>
        </form>
        <a href="javaScript:submit();"
           class="weui-btn weui-footer_fixed-bottom_jq weui-btn_primary">添加新地址</a>
    </body>
</html>