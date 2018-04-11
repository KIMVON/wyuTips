<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">


    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>static/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="<%=basePath%>static/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<%=basePath%>static/css/signin.css" rel="stylesheet">
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="<%=basePath%>static/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="<%=basePath%>static/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="<%=basePath%>static/js/html5shiv.min.js"></script>
    <script src="<%=basePath%>static/js/respond.min.js"></script>
    <![endif]-->
    <script src="<%=basePath%>static/js/jquery.min.js"></script>
    <script src="<%=basePath%>static/js/bootstrap.min.js"></script>

    <script src="<%=basePath%>static/js/course.js" type="text/javascript"></script>
    <link href="<%=basePath%>static/css/course.css" rel="stylesheet">
</head>

<body>

<div class="container">
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
                    <a href="javascript:void(0);" class="nav-style">登录</a>
                </div>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="javascript:void(0);">想干嘛～</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>


    <form action="login" method="post" class="form-signin">
        <h2 class="form-signin-heading">Bang Bang Bang</h2>
        <label for="inputStuNum" class="sr-only">学号</label>
        <input name="studentNum" type="text" id="inputStuNum" class="form-control" placeholder="学号" required autofocus>

        <label for="inputPassword" class="sr-only">密码</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>


        <div class="row">
            <div class="col-lg-6">
                <div class="input-group">
                    <label for="inputVerifyCode" class="sr-only">验证码</label>
                    <input name="verifyCode" type="text" id="inputVerifyCode" class="form-control" placeholder="验证码"
                           required>
                    <span class="input-group-btn">
                        <img id="verifyCode" width="120px" height="44px" src="<%=basePath%>showVerifyImage?spec=2"
                             onclick="reflushVerify()"/>
                    </span>
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div><!-- /.row -->


        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="<%=basePath%>static/js/ie10-viewport-bug-workaround.js"></script>
</body>
<script>
    function reflushVerify() {
        var date = new Date();
        $("#verifyCode").attr("src", "<%=basePath%>showVerifyImage?spec=" + date.getTime())
    }

</script>

</html>
