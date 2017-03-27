<%@ page import="java.net.URL" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <title>糖老师知道</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/res/weui/style/weui.min.css"/>
    <script src="<%=request.getContextPath()%>/resources/res/jquery/jquery-3.1.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/index.js"></script>
</head>
<body>
<div class="weui-tab">
    <div class="weui-tab__panel" id="main_panel"></div>

    <div class="weui-tabbar">
      <a href="javascript:changeToMain();" class="weui-tabbar__item weui-bar__item_on" id="first_menu">
        <img src="<%=request.getContextPath()%>/resources/res/images/mall54.png" alt="" class="weui-tabbar__icon">
        <p class="weui-tabbar__label">首页</p>
      </a>
      <a href="javascript:changeToOrder();" class="weui-tabbar__item" id="order_menu">
        <img src="<%=request.getContextPath()%>/resources/res/images/order54.png" alt="" class="weui-tabbar__icon">
        <p class="weui-tabbar__label">订单</p>
      </a>
      <a href="javascript:changeToMine();" class="weui-tabbar__item" id="mine_menu">
        <img src="<%=request.getContextPath()%>/resources/res/images/mine54.png" alt="" class="weui-tabbar__icon">
        <p class="weui-tabbar__label">我</p>
      </a>
    </div>
  </div>

  </body>
</html>
