<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>课程</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <base href="<%=basePath%>">

    <%--Swiper--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.1.6/js/swiper.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.1.6/css/swiper.min.css">

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="<%=basePath%>static/css/bootstrap.min.css" rel="stylesheet">

    <script src="<%=basePath%>static/js/jquery.min.js"></script>
    <script src="<%=basePath%>static/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>static/js/handlebars-v4.0.11.js"></script>

    <script src="<%=basePath%>static/js/course.js" type="text/javascript"></script>
    <link href="<%=basePath%>static/css/course.css" rel="stylesheet">

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
                <div>
                    <a class="nav-style" href="javascript:void(0);">第<big id="week-num">几</big>周</a>
                </div>
                <%--<div class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></div>--%>
            </div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<%=basePath%>home">主页</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<%--周列表--%>
<div id="week-list" class="swiper-container swiper-container-style">
    <div class="swiper-wrapper">
        <c:forEach begin="1" end="20" var="v">
            <div id="week${v}" class="swiper-slide center-block text-center" onclick="chooseWeek(${v});">
                <a href="javascript:void(0);" onclick="getCourse('<%=basePath%>course',${v})">
                    <label>第<big>${v}</big>周</label>
                    <img src="<%=basePath%>static/img/courseIcon.png" width="38px" height="38px"/>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
<%--课程表--%>
<div>
    <table class="table table-bordered table-hover text-muted center-block text-center">
        <col width="2%"/>
        <col width="14%"/>
        <col width="14%"/>
        <col width="14%"/>
        <col width="14%"/>
        <col width="14%"/>
        <col width="14%"/>
        <col width="14%"/>

        <thead class="course-table-head">
        <tr class="warning">
            <td id="00"></td>
            <td>
                <label>周日</label>
                <label id="70"></label>
            </td>
            <td>
                <label>周一</label>
                <label id="10"></label>
            </td>
            <td>
                <label>周二</label>
                <label id="20"></label>
            </td>
            <td>
                <label>周三</label>
                <label id="30"></label>
            </td>
            <td>
                <label>周四</label>
                <label id="40"></label>
            </td>
            <td>
                <label>周五</label>
                <label id="50"></label>
            </td>
            <td>
                <label>周六</label>
                <label id="60"></label>
            </td>
        </tr>
        </thead>
        <tbody id="course-body" class="table-cell-font">
        <tr>
            <td class="warning">1</td>
            <td id="71"></td>
            <td id="11"></td>
            <td id="21"></td>
            <td id="31"></td>
            <td id="41"></td>
            <td id="51"></td>
            <td id="61"></td>
        </tr>
        <tr>
            <td class="warning">2</td>
            <td id="72"></td>
            <td id="12"></td>
            <td id="22"></td>
            <td id="32"></td>
            <td id="42"></td>
            <td id="52"></td>
            <td id="62"></td>
        </tr>
        <tr>
            <td class="warning">3</td>
            <td id="73"></td>
            <td id="13"></td>
            <td id="23"></td>
            <td id="33"></td>
            <td id="43"></td>
            <td id="53"></td>
            <td id="63"></td>
        </tr>
        <tr>
            <td class="warning">4</td>
            <td id="74"></td>
            <td id="14"></td>
            <td id="24"></td>
            <td id="34"></td>
            <td id="44"></td>
            <td id="54"></td>
            <td id="64"></td>
        </tr>
        <tr>
            <td class="warning">5</td>
            <td id="75"></td>
            <td class="table-cell-size" id="15"></td>
            <td id="25"></td>
            <td id="35"></td>
            <td id="45"></td>
            <td id="55"></td>
            <td id="65"></td>
        </tr>
        <tr>
            <td class="warning">6</td>
            <td id="76"></td>
            <td id="16"></td>
            <td id="26"></td>
            <td id="36"></td>
            <td id="46"></td>
            <td id="56"></td>
            <td id="66"></td>
        </tr>
        </tbody>
    </table>
</div>

</body>

<script>
    $(function () {
        getNowCourse("<%=basePath%>nowCourse");

        $("#week-list").slideUp(2000);

        $("#query").click(function () {
            var checkValue = $("#selectId").val();

            getCourse("<%=basePath%>course", checkValue);
        });

        $("#select").click(function () {
            $("#week-list").slideToggle();
        })
    });

    <%--Swiper框架--%>
    var mySwiper = new Swiper('.swiper-container', {
        slidesPerView: 5,
        spaceBetween: '2%',
        loop: false,
        observer: true,
        observeParents: true
        //spaceBetween : '10%',按container的百分比
    })
    <%--"<%=basePath%>course"--%>

    function getCourse(url, weekNum) {
        emptyTable();

        //构造json
        var week = {week: weekNum};

        //加载课程
        $.post(url, week, function (data) {
            var json = eval("(" + data + ")");

            showData(json);
        });

        //标题切换
        // $("#week-num").text(week.week);
    }

    function getNowCourse(url) {
        emptyTable();

        //加载课程
        $.post(url, null, function (data) {

            var json = eval("(" + data + ")");

            showData(json);
        });
    }

    function emptyTable() {
        for (var i = 1; i <= 7; i++) {
            for (var j = 1; j <= 6; j++) {
                $("#" + i + "" + j).empty();
            }
        }
    }

    function showData(json) {
        var courseInfo = json["courseInfo"];
        var courseDate = json["weekDate"];
        //显示日期
        var month = parseInt(courseDate.sunday.split("-")[1]);
        var sunday = parseInt(courseDate.sunday.split("-")[2]);

        var monday = parseInt(courseDate.monday.split("-")[2]);
        var mondayMonth = parseInt(courseDate.monday.split("-")[1]);

        var tuesday = parseInt(courseDate.tuesday.split("-")[2]);
        var tuesdayMonth = parseInt(courseDate.tuesday.split("-")[1]);

        var webnesday = parseInt(courseDate.webnesday.split("-")[2]);
        var webnesdayMonth = parseInt(courseDate.webnesday.split("-")[1]);

        var thursday = parseInt(courseDate.thursday.split("-")[2]);
        var thursdayMonth = parseInt(courseDate.thursday.split("-")[1]);

        var friday = parseInt(courseDate.friday.split("-")[2]);
        var fridayMonth = parseInt(courseDate.friday.split("-")[1]);

        var saturday = parseInt(courseDate.saturday.split("-")[2]);
        var saturdayMonth = parseInt(courseDate.saturday.split("-")[1]);

        $("#00").text(month + "月");
        $("#70").text(sunday + "日");
        $("#10").text((monday == 1 && mondayMonth != month) ? (mondayMonth + "月") : (monday + "日"));
        $("#20").text((tuesday == 1 && tuesdayMonth != month) ? (tuesdayMonth + "月") : (tuesday + "日"));
        $("#30").text((webnesday == 1 && webnesdayMonth != month) ? (webnesdayMonth + "月") : (webnesday + "日"));
        $("#40").text((thursday == 1 && thursdayMonth != month) ? (thursdayMonth + "月") : (thursday + "日"));
        $("#50").text((friday == 1 && fridayMonth != month) ? (fridayMonth + "月") : (friday + "日"));
        $("#60").text((saturday == 1 && saturdayMonth != month) ? (saturdayMonth + "月") : (saturday + "日"));

        //显示课程
        for (var i = 0; i < courseInfo.length; i++) {
            var weekday = courseInfo[i].weekday;
            var s = courseInfo[i].section;
            var section = parseInt(s.split(",")[1], 10) / 2;//获取第几节
            var id = weekday + section;

            //使用模板
            var data = {
                courseName: courseInfo[i].courseName,
                site: courseInfo[i].teachPlace
            };
            var source = $("#course-cell-template").html();
            var template = Handlebars.compile(source);
            var course = template(data);

            $("#" + id).append(course);
        }

        //标题切换
        $("#week-num").text(courseDate.week);
        //选中标识
        chooseWeek(courseDate.week);
        //轮播图滑到指定位置
        mySwiper.slideTo(parseInt(courseDate.week) - 3);
    }

    function chooseWeek(week) {
        for (var i = 1; i <= 20; i++) {
            $("#week" + i).css("background", "");
        }
        $("#week" + week).css("background", "#fff");
        $("#week" + week).css("border-radius", "8px");
    }

</script>

<%--模板--%>
<script id="course-cell-template" type="text/x-handlebars-template">
    <a href="javascript:void(0);">
        <div class="table-cell-background">
            <div>
                <span><b>{{courseName}}</b></span>
            </div>
            <div>@{{{site}}}</div>
        </div>
    </a>
</script>

</html>
