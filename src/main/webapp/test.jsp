<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .divClass {
            /*float: left;*/
        }

        .swiper-container {
            height: 500px;
        }
    </style>

    <script src="<%=basePath%>static/js/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.1.6/css/swiper.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.1.6/js/swiper.js"></script>
</head>

<body>
<div id="bar" style="width: 400px;height: 10px;position: absolute;">

</div>
<div class="swiper-container">
    <div class="swiper-wrapper">
        <div style="background: #2aabd2" class="divClass swiper-slide"></div>
        <div style="background: #d28c54" class="divClass swiper-slide"></div>
        <div style="background: #41d25f" class="divClass swiper-slide"></div>
        <div style="background: #071e25" class="divClass swiper-slide"></div>
        <div style="background: #2aabd2" class="divClass swiper-slide"></div>
        <div style="background: #d28c54" class="divClass swiper-slide"></div>
        <div style="background: #41d25f" class="divClass swiper-slide"></div>
        <div style="background: #071e25" class="divClass swiper-slide"></div>
        <%--<div class="">Slide 1</div>--%>
        <%--<div class="swiper-slide">Slide 2</div>--%>
        <%--<div class="swiper-slide">Slide 3</div>--%>
    </div>
</div>
</body>
<%--<script language="javascript">--%>
<%--var mySwiper = new Swiper('.swiper-container',{--%>
<%--slidesPerView : 3,--%>
<%--spaceBetween : 20,--%>
<%--//spaceBetween : '10%',按container的百分比--%>
<%--})--%>
<%--</script>--%>

<script language="javascript">
    var mySwiper = new Swiper('.swiper-container', {
            effect: 'flip',
            flipEffect: {
            width: window.innerWidth,
            height: window.innerHeight,
            slideShadows: true,
            limitRotation: true,
        }
    })
</script>
</html>