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
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <table class="table table-hover text-center">
        <tr>
            <td>编号</td>
            <td>醫生姓名</td>
            <td>醫生頭像路徑/圖片名</td>
            <td>醫生電話號碼</td>
            <td>醫生電子郵箱</td>
            <td>醫生簡介</td>
            <td>挂號費</td>
            <td>所屬科室標識符</td>
            <td>職稱標識符</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="doc" varStatus="vs">
            <c:choose>
                <c:when test="${(vs.index+1)%2==0}">
                    <tr style="background-color: rgb(175, 175, 175)">
                        <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />${vs.index+1}</td>
                        <td>${doc.doctorName}</td>
                        <td><img width="70" height="50" src="/doctor/${doc.doctorAvatar}"/></td>
                        <td>${doc.doctorPhone}</td>
                        <td>${doc.doctorEmail}</td>
                        <td>${doc.doctorIntion}</td>
                        <td>${doc.doctorReFee}</td>
                        <td>${doc.doctorDeptId}</td>
                        <td>${doc.doctorProTitleId}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" href="/app/apptoapp?doctorId=${doc.doctorId}">
                                    <span class="icon-edit"></span> 预约
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr style="background-color: rgb(175, 175, 175)">
                        <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />${vs.index+1}</td>
                        <td>${doc.doctorName}</td>
                        <td><img width="70" height="50" src="/doctor/${doc.doctorAvatar}"/></td>
                        <td>${doc.doctorPhone}</td>
                        <td>${doc.doctorEmail}</td>
                        <td>${doc.doctorIntion}</td>
                        <td>${doc.doctorReFee}</td>
                        <td>${doc.doctorDeptId}</td>
                        <td>${doc.doctorProTitleId}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" href="/app/apptoapp?doctorId=${doc.doctorId}">
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
                        <a href="/app/apppat?pageNum=${pageInfo.prePage}">上一页</a>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                        <c:choose>
                            <c:when test="${i == pageInfo.pageNum}">
                                <a class="active-page" href="/app/apppat?pageNum=${i}">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/app/apppat?pageNum=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageInfo.isLastPage}">
                        <a href="javascript:alert('已经是最后一页了')" >下一页</a>
                    </c:if>
                    <c:if test="${not pageInfo.isLastPage}">
                        <a href="/app/apppat?pageNum=${pageInfo.nextPage}">下一页</a>
                    </c:if>
                    <a href="/app/apppat?pageNum=${pageInfo.pages}">尾页</a>
                </div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>