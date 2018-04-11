<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>主页</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="apple-mobile-web-app-capable" content="yes">

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>static/css/bootstrap.min.css" rel="stylesheet">

    <script src="<%=basePath%>static/js/jquery.min.js"></script>
    <script src="<%=basePath%>static/js/bootstrap.min.js"></script>
    <link href="<%=basePath%>static/css/course.css" rel="stylesheet">
    <style type="text/css">
        body {
            overflow: hidden;
            font-family: Georgia, Helvetica, Arial, sans-serif;
            color: #333333;
            font-size: 11px;
        }

        #panel {
            position: absolute;
            left: 14%;
            padding-top: 70px;
            z-index: 99;
        }
    </style>
</head>
<body style="padding-top: 0;">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="center-block text-center">
                <a href="javascript:void(0);" class="nav-style">主页</a>
            </div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<%=basePath%>home">主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div id="panel" class="container-fluid center-block text-center">
    <div id="into-course-div">
        <a id="into-course-btn" href="<%=basePath%>course" class="btn btn-info">课程</a>
    </div>
    <div id="into-achievement-div">
        <a id="into-achievement-btn" href="<%=basePath%>achievement" class="btn btn-success">成绩</a>
    </div>
</div>

<a id="keyboardUp" href="#"></a>
<a id="keyboardDown" href="#"></a>
<a id="keyboardLeft" href="#"></a>
<a id="keyboardRight" href="#"></a>

<canvas id="world">
    <a href="http://www.google.com/chrome"> </a>
</canvas>
</body>
<script src="<%=basePath%>static/js/blob.min.js"></script>
<script>
    $(function () {
        for (var i = 0; i < Math.floor(Math.random() * 7 + 1); i++) {
            document.getElementById("keyboardRight").click();
        }
        for (var j = 0; j < 4 + Math.floor(Math.random() * 4 + 1); j++) {
            document.getElementById("keyboardDown").click();
        }
    });
</script>
</html>
