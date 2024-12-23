<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
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
    <div class="panel-head"><strong class="icon-reorder"> 排班列表</strong></div>
    <div class="padding border-bottom">
        <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><a href="/schedule/scheadd" target="right"><span class="icon-plus-square-o"></span> 添加排班情况</a></button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th >排班编号</th>
            <th >医生编号</th>
            <th >日期</th>
            <th >时间</th>
            <th >科室编号</th>
            <th >是否空闲</th>
            <th >累计</th>
            <th >评价</th>
            <th >操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="sche" varStatus="vs">
            <c:choose>
                <c:when test="${(vs.index+1)%2==0}">
                    <tr style="background-color: rgb(230,250,81)">
                        <td>${sche.scheduleId}</td>
                        <td>${sche.doctorId}</td>
                        <td>${sche.date}</td>
                        <td>${sche.shiftTime}</td>
                        <td>${sche.departmentId}</td>
                        <td>${sche.isAvailable}</td>
                        <td>${sche.visitCount}</td>
                        <td>${sche.remarks}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" href="/schedule/schetoedit?scheduleId=${sche.scheduleId}">
                                    <span class="icon-edit"></span> 修改
                                </a>
                                <a class="button border-red" href="javascript:void(0)" onclick="del(${sche.scheduleId}, 1)">
                                    <span class="icon-trash-o"></span> 删除
                                </a>
                            </div>
                        </td>
                        <script>
                            var scheduleId = ${sche.scheduleId};
                            document.getElementById('editLink1').setAttribute('href', '/schedule/schetoedit?scheduleId=' + scheduleId);
                        </script>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td>${sche.scheduleId}</td>
                        <td>${sche.doctorId}</td>
                        <td>${sche.date}</td>
                        <td>${sche.shiftTime}</td>
                        <td>${sche.departmentId}</td>
                        <td>${sche.isAvailable}</td>
                        <td>${sche.visitCount}</td>
                        <td>${sche.remarks}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" href="/schedule/schetoedit?scheduleId=${sche.scheduleId}">
                                    <span class="icon-edit"></span> 修改
                                </a>
                                <a class="button border-red" href="javascript:void(0)" onclick="del(${sche.scheduleId}, 1)">
                                    <span class="icon-trash-o"></span> 删除
                                </a>
                            </div>
                        </td>
                        <script>
                            var scheduleId = ${sche.scheduleId};
                            document.getElementById('editLink1').setAttribute('href', '/schedule/schetoedit?scheduleId=' + scheduleId);
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
                        <a href="/schedule/schedulelist?pageNum=${pageInfo.prePage}">上一页</a>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                        <c:choose>
                            <c:when test="${i == pageInfo.pageNum}">
                                <a class="active-page" href="/schedule/schedulelist?pageNum=${i}">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/schedule/schedulelist?pageNum=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageInfo.isLastPage}">
                        <a href="javascript:alert('已经是最后一页了')" >下一页</a>
                    </c:if>
                    <c:if test="${not pageInfo.isLastPage}">
                        <a href="/schedule/schedulelist?pageNum=${pageInfo.nextPage}">下一页</a>
                    </c:if>
                    <a href="/schedule/schedulelist?pageNum=${pageInfo.pages}">尾页</a>
                </div>
            </td>
        </tr>

    </table>

</div>
<script>
    function del(id, mid) {
        if (confirm("您确定要删除吗?")) {
            window.location.href = "/schedule/schedelete?scheduleId="+id;
        }
    }
</script>

</body></html>