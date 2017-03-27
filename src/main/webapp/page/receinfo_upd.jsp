<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
        <title>修改信息</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/res/weui/style/weui.min.css"/>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/receive_info.css"/>
        <script src="<%=request.getContextPath()%>/resources/res/jquery/jquery-3.1.1.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/res/weui/js/weui.min.js"></script>
        <script type="text/javascript">
            function formSubmit() {
                document.getElementById('receinfoForm').submit();
            }

        </script>
    </head>

    <body ontouchstart>
    <form id="receinfoForm" action="<%=request.getContextPath()%>/receive_info/${receiveInfo.id}/update" method="post">
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">收货人</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="text" placeholder="" name="name" value="${receiveInfo.name}">
                </div>
            </div>

            <div class="weui-cell weui-cell_select weui-cell_select-after">
                <div class="weui-cell__hd">
                    <label for="" class="weui-label">性别</label>
                </div>
                <div class="weui-cell__bd">
                    <select class="weui-select" name="gender">
                        <c:if test="${receiveInfo.gender == '男'}">
                            <option value="男" selected="selected">男</option>
                            <option value="女">女</option>
                        </c:if>
                        <c:if test="${receiveInfo.gender == '女'}">
                            <option value="男">男</option>
                            <option value="女" selected="selected">女</option>
                        </c:if>
                    </select>
                </div>
            </div>


            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">年龄</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="text" placeholder="" name="age" value="${receiveInfo.age}">
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">联系电话</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="text" placeholder="" name="phone" value="${receiveInfo.phone}">
                </div>
            </div>

            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">收货地址</label></div>
                <div class="weui-cell__bd">
                    <textarea class="weui-textarea" rows="3" name="address">${receiveInfo.address}</textarea>
                </div>
            </div>
        </div>
    </form>

    <a href="javascript:formSubmit();" class="weui-btn weui-footer_fixed-bottom_jq weui-btn_primary">确定修改</a>

    </body>
</html>