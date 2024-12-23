<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    <style>
        .active-page {
            background-color: #007bff;
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 管理员信息</strong></div>

    <table class="table table-hover text-center">
        <tr>
            <td>姓名</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="admin" varStatus="vs">
            <c:choose>
                <c:when test="${(vs.index+1)%2==0}">
                    <tr style="background-color: rgb(255, 175, 175)">
                        <td>${admin.name}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main"  href="/admin/admintoedit?adminId=${admin.adminId}">
                                    <span class="icon-edit"></span> 修改密码
                                </a>

                            </div>
                        </td>

                    </tr>
                </c:when>
                <c:otherwise>
                    <tr style="background-color: rgb(255, 175, 175)">
                        <td>${admin.name}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main"  href="/admin/admintoedit?adminId=${admin.adminId}">
                                    <span class="icon-edit"></span> 修改密码
                                </a>

                            </div>
                        </td>

                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>

    </table>
</div>
</body>
</html>