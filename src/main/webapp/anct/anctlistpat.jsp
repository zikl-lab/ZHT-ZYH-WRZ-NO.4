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
        .title-cell {
            text-align: center;
            font-weight: bold;
        }
        .content-cell {
            padding-top: 0;
        }
    </style>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <table class="table table-hover text-center">
        <tr>
        </tr>
        <c:forEach items="${pageInfo.list}" var="anct" varStatus="vs">
            <c:choose>
                <c:when test="${(vs.index+1)%2==0}">
                    <tr style="background-color: rgb(255,255,255)">
                            <%--                        <td rowspan="2" style="text-align:center; padding-left:20px;"><input type="checkbox" name="id[]" value="" />${vs.index+1}</td>--%>
                        <td colspan="4" class="title-cell">${anct.title}</td>
                    </tr>
                    <tr style="background-color: rgb(255,255,255)">
                        <td class="content-cell">${anct.content}</td>
                        <td class="content-cell">${anct.creationTime}</td>
                        <td class="content-cell">作者：${anct.creator}</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr style="background-color: rgb(199,199,199)">
                            <%--                        <td rowspan="2" style="text-align:center; padding-left:20px;"><input type="checkbox" name="id[]" value="" />${vs.index+1}</td>--%>
                        <td colspan="4" class="title-cell">${anct.title}</td>
                    </tr>
                    <tr style="background-color: rgb(199,199,199)">
                        <td class="content-cell">${anct.content}</td>
                        <td class="content-cell">${anct.creationTime}</td>
                        <td class="content-cell">作者：${anct.creator}</td>
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
                        <a href="/anct/ancpattlist?pageNum=${pageInfo.prePage}">上一页</a>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                        <c:choose>
                            <c:when test="${i == pageInfo.pageNum}">
                                <a class="active-page" href="/anct/ancpattlist?pageNum=${i}">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/anct/ancpattlist?pageNum=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageInfo.isLastPage}">
                        <a href="javascript:alert('已经是最后一页了')" >下一页</a>
                    </c:if>
                    <c:if test="${not pageInfo.isLastPage}">
                        <a href="/anct/ancpattlist?pageNum=${pageInfo.nextPage}">下一页</a>
                    </c:if>
                    <a href="/anct/ancpattlist?pageNum=${pageInfo.pages}">尾页</a>
                </div>
            </td>
        </tr>
    </table>
</div>
<script>
    function del(id, mid) {
        if (confirm("您确定要删除吗?")) {
            window.location.href = "/anct/anctdelete?announcementId=" + id;
        }
    }
</script>
</body>
</html>