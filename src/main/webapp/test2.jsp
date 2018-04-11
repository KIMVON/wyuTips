<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="viewport" content="width=device-width, initial-scale=1">

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


    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>static/css/course.css" rel="stylesheet">

    <script src="<%=basePath%>static/js/jquery.min.js"></script>
    <script src="<%=basePath%>static/js/bootstrap.min.js"></script>
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
        </div>
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


<canvas id="world" width="670" height="1192"><p class="noCanvas">You need a <a href="http://www.google.com/chrome">modern
    browser</a> to view this.</p></canvas>

<script src="<%=basePath%>static/js/blob.min.js"></script>
</body>
</html>
