<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>糖老师知道</title>
    <meta name="viewport" content="initial-scale=1, user-scalable=0" charset="UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/res/weui/style/weui.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/receive_info.css"/>
</head>
<body>
<c:set var="openId" value="${sessionScope.userInfo.openid}"/>
<article class="weui-article">
    <h1>糖尿病检测服务</h1>
    <section>
        <h2 class="title">我们的服务很好</h2>
        <section>
            <h3>超级好</h3>
            <p>
                这里是一堆服务介绍，介绍一堆东西。
            </p>
            <p>
                <img src="<%=request.getContextPath()%>/resources/res/weui/images/pic_article.png" alt="">
                <img src="<%=request.getContextPath()%>/resources/res/weui/images/pic_article.png" alt="">
            </p>
        </section>
        <section>
            <h3>非常好</h3>
            <p>
                这里可以介绍一堆东西，或者干脆删掉。
            </p>
        </section>
    </section>
</article>
<a href="<%= request.getContextPath()%>/receive_info/${openId}/purchase_detail" class="weui-btn weui-footer_fixed-bottom_jq weui-btn_primary">立即购买</a>

</body>
</html>
