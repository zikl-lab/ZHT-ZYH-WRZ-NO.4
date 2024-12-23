<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>管理员页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />管理员管理中心</h1>
    </div>
    <div class="head-l">
        <span class="welcome-msgs">
            欢迎您，<b>${loginName}</b>&nbsp;管理员&nbsp;
            <i class="el-icon-caret-bottom"></i>
        </span>
        <a class="button button-little bg-red" href="login.jsp">
            <span class="icon-power-off">

            </span> 退出登录
        </a>
    </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>基本设置</h2>
    <ul style="display:block">
        <li><a href="/info.jsp" target="right"><span class="icon-caret-right"></span>统计报表</a></li>
        <li><a href="/admin/adminlist" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>公告管理</h2>
    <ul>
        <li><a href="/anct/anctlist" target="right"><span class="icon-caret-right"></span>公告表格分类管理</a></li>
        <li><a href="/anct/first" target="right"><span class="icon-caret-right"></span>添加公告</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>科室管理</h2>
    <ul>
        <li><a href="/dept/deptlist" target="right"><span class="icon-caret-right"></span>科室表格分类管理</a></li>
        <li><a href="/dept/first" target="right"><span class="icon-caret-right"></span>添加科室</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>職稱管理</h2>
    <ul>
        <li><a href="/prot/protlist" target="right"><span class="icon-caret-right"></span>職稱表格分类管理</a></li>
        <li><a href="/prot/protadd" target="right"><span class="icon-caret-right"></span>添加職稱</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>预约管理</h2>
    <ul>
        <li><a href="/schedule/schedulelist" target="right"><span class="icon-caret-right"></span>预约表格分类管理</a></li>
        <li><a href="/schedule/scheadd" target="right"><span class="icon-caret-right"></span>添加预约信息</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>醫生管理</h2>
    <ul>
<%--        <li><a href="/doc/doctocate" target="right"><span class="icon-caret-right"></span>醫生表格管理</a></li>--%>
        <li><a href="/doc/doclist" target="right"><span class="icon-caret-right"></span>醫生表格分类管理</a></li>
        <li><a href="/doc/docadd" target="right"><span class="icon-caret-right"></span>添加醫生</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>医生排班管理</h2>
    <ul>
        <li><a href="/schedule/schedulelist" target="right"><span class="icon-caret-right"></span>排班表格分类管理</a></li>
        <li><a href="/schedule/scheadd" target="right"><span class="icon-caret-right"></span>添加排班</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>患者管理</h2>
    <ul>
        <li><a href="/pat/patlist" target="right"><span class="icon-caret-right"></span>患者表格分类管理</a></li>
        <li><a href="/pat/patadd" target="right"><span class="icon-caret-right"></span>添加患者</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>就诊记录</h2>
    <ul>
        <li><a href="/con/conlist" target="right"><span class="icon-caret-right"></span>就诊表格分类管理</a></li>
        <li><a href="/con/consave" target="right"><span class="icon-caret-right"></span>添加诊断记录</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>住院管理</h2>
    <ul>
        <li><a href="/hos/hoslist" target="right"><span class="icon-caret-right"></span>住院表格分类管理</a></li>
        <li><a href="/hos/first" target="right"><span class="icon-caret-right"></span>添加住院信息</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="info.jsp" target="right" class="icon-home"> 首页</a></li>
    <li><a href="##" id="a_leader_txt">网站信息</a></li>
    <li><b>当前语言：</b><span style="color:red;">中文</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
    <iframe scrolling="auto" frameborder="0" src="/info.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
    <p>来源:<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
</div>
</body>
</html>