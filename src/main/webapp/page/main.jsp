<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--这里的所有路径都应该设置成和index.jsp一样-->
<html>
<head>
    <meta name="viewport" content="initial-scale=1, user-scalable=0" charset="UTF-8">
    <title>首页</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/res/weui/style/weui.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/res/carousel/css/swiper.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css">
</head>
<body>

<!-- Swiper -->
<div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide"><a href="//www.baidu.com/"><img src="http://d10.yihaodianimg.com/V00/M03/4D/41/CgQDsVQG4d6AISZPAAFa7N3KyPY18100.jpg" width="100%"></a> </div>
        <div class="swiper-slide"><a href="//www.qq.com/"><img src="http://d10.yihaodianimg.com/V00/M04/32/59/CgQDsVQDEtaAVv4BAAEFc6n3fws75000.jpg" width="100%"></a> </div>
        <div class="swiper-slide">Slide 3</div>
        <div class="swiper-slide">Slide 4</div>
        <div class="swiper-slide">Slide 5</div>
        <div class="swiper-slide">Slide 6</div>
        <div class="swiper-slide">Slide 7</div>
        <div class="swiper-slide">Slide 8</div>
        <div class="swiper-slide">Slide 9</div>
        <div class="swiper-slide">Slide 10</div>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
    <!-- Add Arrows -->
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
</div>

<!-- Swiper JS -->
<script src="<%=request.getContextPath()%>/resources/res/carousel/js/swiper.min.js"></script>

<!-- Initialize Swiper -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js" charset="UTF-8"></script>

<div class="weui-grids">
    <a href="page/buy_diabetes_service.jsp" class="weui-grid">
        <div class="weui-grid__icon">
            <img src="<%=request.getContextPath()%>/resources/res/weui/images/icon_nav_button.png" alt="">
        </div>
        <p class="weui-grid__label">
            糖尿病检测
        </p>
    </a>
    <a href="javascript:;" class="weui-grid">
        <div class="weui-grid__icon">
            <img src="<%=request.getContextPath()%>/resources/res/weui/images/icon_nav_cell.png" alt="">
        </div>
        <p class="weui-grid__label">
            糖尿病预防
        </p>
    </a>
    <a href="javascript:;" class="weui-grid">
        <div class="weui-grid__icon">
            <img src="<%=request.getContextPath()%>/resources/res/weui/images/icon_nav_button.png" alt="">
        </div>
        <p class="weui-grid__label">
            治疗建议
        </p>
    </a>
    <a href="javascript:;" class="weui-grid">
        <div class="weui-grid__icon">
            <img src="<%=request.getContextPath()%>/resources/res/weui/images/icon_nav_button.png" alt="">
        </div>
        <p class="weui-grid__label">
            售后服务
        </p>
    </a>
    <a href="javascript:;" class="weui-grid">
        <div class="weui-grid__icon">
            <img src="<%=request.getContextPath()%>/resources/res/weui/images/icon_nav_cell.png" alt="">
        </div>
        <p class="weui-grid__label">
            信息查询
        </p>
    </a>
    <a href="javascript:;" class="weui-grid">
        <div class="weui-grid__icon">
            <img src="<%=request.getContextPath()%>/resources/res/weui/images/icon_nav_button.png" alt="">
        </div>
        <p class="weui-grid__label">
            服务介绍
        </p>
    </a>
</div>
</body>
</html>
