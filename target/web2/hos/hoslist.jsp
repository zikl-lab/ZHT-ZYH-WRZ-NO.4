
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
    <div class="panel-head"><strong class="icon-reorder"> 预约列表</strong></div>
    <div class="padding border-bottom">
        <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><a href="/hos/first" target="right"><span class="icon-plus-square-o"></span> 添加住院信息</a></button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <td>编号</td>
            <td>病人编号</td>
            <td>病房号</td>
            <td>住院费用</td>
            <td>支付状态</td>
            <td>保险</td>
            <td>住院状态</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="hos" varStatus="vs">
            <c:choose>
                <c:when test="${(vs.index+1)%2==0}">
                    <tr style="background-color: rgb(230,250,255)">
                        <%--<td style="text-align:center; padding-left:20px;">${vs.index+1}</td>--%>
                        <td>${hos.hospitalizationId}</td>
                        <td>${hos.patientId}</td>
                        <td>${hos.roomNumber}</td>
                        <td>${hos.cost}</td>
                        <td>${hos.paymentStatus}</td>
                        <td>${hos.isInsured}</td>
                        <td>${hos.hospitalizationStatus}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" <%--id="editLink1" --%>href="/hos/hostoedit?hosId=${hos.hospitalizationId}">
                                    <span class="icon-edit"></span> 修改
                                </a>
                                <a class="button border-red" href="javascript:void(0)" onclick="del(${hos.hospitalizationId}, 1)">
                                    <span class="icon-trash-o"></span> 删除
                                </a>
                            </div>
                        </td>

                        <script>
                            // Assuming deptId is available in JavaScript
                            var hosId = ${hos.hospitalizationId};
                            document.getElementById('editLink1').setAttribute('href', '/hos/hostoedit?hosId=' + hosId);
                        </script>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr style="background-color: rgb(255,255,255)">
                        <%--<td style="text-align:center; padding-left:20px;">${vs.index+1}</td>--%>
                        <td>${hos.hospitalizationId}</td>
                        <td>${hos.patientId}</td>
                        <td>${hos.roomNumber}</td>
                        <td>${hos.cost}</td>
                        <td>${hos.paymentStatus}</td>
                        <td>${hos.isInsured}</td>
                        <td>${hos.hospitalizationStatus}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" <%--id="editLink2"--%> href="/hos/hostoedit?hosId=${hos.hospitalizationId}">
                                    <span class="icon-edit"></span> 修改
                                </a>
                                <a class="button border-red" href="javascript:void(0)" onclick="del(${hos.hospitalizationId}, 1)">
                                    <span class="icon-trash-o"></span> 删除
                                </a>
                            </div>
                        </td>

                        <script>
                            // Assuming deptId is available in JavaScript
                            var hosId = ${hos.hospitalizationId}; // Replace with actual deptId value
                            document.getElementById('editLink2').setAttribute('/hos/hostoedit?hosId=' + hosId);
                        </script>
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
                        <a href="/hos/hoslist?pageNum=${pageInfo.prePage}">上一页</a>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                        <c:choose>
                            <c:when test="${i == pageInfo.pageNum}">
                                <a class="active-page" href="/hos/hoslist?pageNum=${i}">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/hos/hoslist?pageNum=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageInfo.isLastPage}">
                        <a href="javascript:alert('已经是最后一页了')" >下一页</a>
                    </c:if>
                    <c:if test="${not pageInfo.isLastPage}">
                        <a href="/hos/hoslist?pageNum=${pageInfo.nextPage}">下一页</a>
                    </c:if>
                    <a href="/hos/hoslist?pageNum=${pageInfo.pages}">尾页</a>
                </div>
            </td>
        </tr>
    </table>
</div>
<script>
    function del(id, mid) {
        if (confirm("您确定要删除吗?")) {
            window.location.href = "/hos/hosdelete?hosId="+id; // Redirect if confirmed
        }
        // No else block needed, so nothing happens when the user cancels
    }
</script>
</body>
</html>