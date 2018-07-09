<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>成绩</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>static/css/bootstrap.min.css" rel="stylesheet">


    <script src="<%=basePath%>static/js/jquery.min.js"></script>
    <script src="<%=basePath%>static/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>static/js/handlebars-v4.0.11.js"></script>

    <link href="<%=basePath%>static/css/course.css" rel="stylesheet">
    <script src="<%=basePath%>static/js/course.js" type="text/javascript"></script>

    <%--Swiper--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.1.6/js/swiper.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.1.6/css/swiper.min.css">

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
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

            <div id="select" class="center-block text-center">
                <div><a class="nav-style" href="javascript:void(0);">成绩</a></div>
            </div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<%=basePath%>home">主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<c:set var="init_term" value="2015"></c:set>
<%--学期列表--%>
<div id="term-list" class="swiper-container swiper-container-style">
    <div class="swiper-wrapper">
        <c:forEach begin="0" end="7" var="v">
            <div id="term${init_term+v}01" class="swiper-slide center-block text-center">
                <a href="javascript:void(0);" onclick="getAchievement('<%=basePath%>achievement',${init_term+v}+'01')">
                    <label>${init_term+v}-${init_term+v+1}</label>
                    <label>第一学期</label>
                    <img src="<%=basePath%>static/img/achievementIcon.png" width="38px" height="38px"/>
                </a>
            </div>
            <div id="term${init_term+v}02" class="swiper-slide center-block text-center">
                <a href="javascript:void(0);" onclick="getAchievement('<%=basePath%>achievement',${init_term+v}+'02')">
                    <label>${init_term+v}-${init_term+v+1}</label>
                    <label>第二学期</label>
                    <img src="<%=basePath%>static/img/achievementIcon.png" width="38px" height="38px"/>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
<%--成绩--%>
<table class="table table-bordered table-hover center-block text-center table-striped ">
    <col width="2%"/>
    <col width="62%"/>
    <col width="20%"/>
    <col width="16%"/>

    <thead id="achievement-thead">
    <tr class="warning">
        <td>编号</td>
        <td>课程</td>
        <td>分数</td>
        <td>学分</td>
    </tr>
    </thead>

    <tbody id="achievement-body">
    </tbody>
</table>
<div>
    <div>
        <div class="btn-group btn-group-justified" role="group" aria-label="...">
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myAllAchievement">大学绩点
                </button>
            </div>
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-default"
                        data-toggle="modal" data-target="#myModal">学期绩点
                </button>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">平均绩点</h4>
            </div>
            <%--主要内容--%>
            <div id="modalBody" class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<!-- myAllAchievement -->
<div class="modal fade" id="myAllAchievement" tabindex="-1" role="dialog" aria-labelledby="myAllAchievementLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myAllAchievementLabel">大学平均绩点</h4>
            </div>
            <%--主要内容--%>
            <div id="myAllAchievementBody" class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    $(function () {
        getAchievement('<%=basePath%>achievement', "201701");

        $("#term-list").slideUp(2000);

        $("#select").click(function () {
            $("#term-list").slideToggle();
        })
    });

    <%--Swiper框架--%>
    var mySwiper = new Swiper('.swiper-container', {
        slidesPerView: 4,
        spaceBetween: '2%',//spaceBetween : '10%',按container的百分比
        loop: false,
        observer: true,
        observeParents: true
    });

    <%--//"<%=basePath%>achievement"--%>

    function getAchievement(url, termCode) {
        //清空tbody的元素
        $("#achievement-body").empty();
        $("#modalBody").empty();
        //构造json
        var term = {term: termCode};

        //获取绩点
        showAchievement(url, term);

        //选中标识
        chooseTerm("term" + termCode);

        //轮播图滑到指定位置
        slideToTarget(termCode);
    }

    //term201701
    function chooseTerm(term) {
        //清除所有背景
        for (var i = 0; i <= 7; i++) {
            var termCode01 = "term" + (${init_term}+i) + "01";
            var termCode02 = "term" + (${init_term}+i) + "02";
            $("#" + termCode01).css("background", "");
            $("#" + termCode02).css("background", "");
        }
        //添加css
        $("#" + term).css("background", "#fff");
        $("#" + term).css("border-radius", "8px");
    }

    //获取绩点
    function showAchievement(url, term) {
        //加载课程
        $.post(url, term, function (data) {
            var json = eval("(" + data + ")");

            for (var i = 0; i < json.length; i++) {
                var id = i + 1;
                var course = json[i].courseName;
                var totalAchievement = json[i].totalAchievement;
                var credit = json[i].credit;
                //使用模板
                var templateData = {
                    id: id,
                    course: course,
                    achievement: totalAchievement,
                    credit: credit
                };

                var source = $("#achievement-cell-template").html();
                var template = Handlebars.compile(source);
                var achievement = template(templateData);
                $("#achievement-body").append(achievement);
            }

            //计算绩点
            getAverageAchievement("<%=basePath%>calculateAchievement", term);
        });

    }

    //获取平均绩点
    function getAverageAchievement(url, term) {
        $.post(url, term, function (data) {
            var json = eval("(" + data + ")");

            var averageAchievement = json["averageAchievement"];
            var originalAverageAchievement = json["originalAverageAchievement"];
            var termCode = term.term;

            var termCodeInteger = parseInt(termCode);
            var yearInteger = parseInt(termCodeInteger / 100);//向下取整
            var termInteger = termCodeInteger % 100;

            //使用模板
            var templateData = {
                startYear: yearInteger,
                endYear: yearInteger + 1,
                term: termInteger,
                achievement: averageAchievement,
                originalAverageAchievement: originalAverageAchievement,
            };
            var source = $("#average-achievement-template").html();
            var template = Handlebars.compile(source);
            var achievement = template(templateData);

            $("#modalBody").append(achievement);
        });
    }

    function slideToTarget(termCode) {
        var termCodeInteger = parseInt(termCode);
        var yearInteger = parseInt(termCodeInteger / 100);//向下取整
        var termInteger = termCodeInteger % 100;

        var betweenYear = yearInteger - parseInt(${init_term});
        var index = betweenYear * 2 + termInteger;

        mySwiper.slideTo(index - 2);
    }
</script>

<%--模板--%>
<script id="achievement-cell-template" type="text/x-handlebars-template">
    <tr>
        <th>{{id}}</th>
        <%--标号--%>
        <td>{{course}}</td>
        <%--课程--%>
        <td>{{achievement}}</td>
        <%--分数--%>
        <td>{{credit}}</td>
        <%--学分--%>
    </tr>
</script>

<%--显示绩点模板--%>
<script id="average-achievement-template" type="text/x-handlebars-template">
    <div>
        <label>{{startYear}}-{{endYear}}学年</label>
        <label>第{{term}}学期</label>
        <div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <label>这学期新平均绩点:{{achievement}}</label>
        </div>
        <div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <label>这学期原平均绩点:{{originalAverageAchievement}}</label>
        </div>
    </div>
</script>
<%--显示绩点模板--%>
<script id="all-average-achievement-template" type="text/x-handlebars-template">
    <div>
        <label>{{startYear}}-{{endYear}}学年</label>
        <label>第{{term}}学期</label>
        <div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <label>新平均绩点:{{achievement}}</label>
        </div>
        <div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <label>原平均绩点:{{originalAverageAchievement}}</label>
        </div>
    </div>
</script>
</html>
