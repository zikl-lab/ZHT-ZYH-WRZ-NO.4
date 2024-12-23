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
    <div class="panel-head"><strong class="icon-reorder"> ${doctors.doctorName} 的预约列表${patient.patientId}</strong></div>
    <table class="table table-hover text-center">
        <tr>
            <td>科室编号</td>
            <td>预约日期</td>
            <td>预约时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageInfos.list}" var="apps" varStatus="vs">
            <c:choose>
                <c:when test="${(vs.index+1)%2==0}">
                    <tr style="background-color: rgb(230,250,255)">
                        <td>${apps.departmentId}</td>
                        <td>${apps.date}</td>
                        <td>${apps.shiftTime}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" href=
                                        "/appoint/appapp?doctorId=${doctors.doctorId}&appointDate=${apps.date}&appointTime=${apps.shiftTime}">
                                    <span class="icon-edit"></span> 预约
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr style="background-color: rgb(230,250,255)">
                            <%--<td style="text-align:center; padding-left:20px;">${vs.index+1}</td>--%>
                        <td>${apps.departmentId}</td>
                                <td>${apps.date}</td>
                                <td>${apps.shiftTime}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" href=
                                        "/appoint/appapp?doctorId=${doctors.doctorId}&appointDate=${apps.date}&appointTime=${apps.shiftTime}">
                                    <span class="icon-edit"></span> 预约
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <tr>
            <td colspan="8">
                <div class="pagelist">
                    <c:if test="${pageInfo.isFirstPage}">
                        <a href="javascript:alert('已经是第一页了')" >上一页</a>
                    </c:if>
                    <c:if test="${not pageInfo.isFirstPage}">
                        <a href="/app/apptoapp?pageNum=${pageInfo.prePage}">上一页</a>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                        <c:choose>
                            <c:when test="${i == pageInfo.pageNum}">
                                <a class="active-page" href="/app/apptoapp?pageNum=${i}">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/app/apptoapp?pageNum=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageInfo.isLastPage}">
                        <a href="javascript:alert('已经是最后一页了')" >下一页</a>
                    </c:if>
                    <c:if test="${not pageInfo.isLastPage}">
                        <a href="/app/apptoapp?pageNum=${pageInfo.nextPage}">下一页</a>
                    </c:if>
                    <a href="/app/apptoapp?pageNum=${pageInfo.pages}">尾页</a>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>