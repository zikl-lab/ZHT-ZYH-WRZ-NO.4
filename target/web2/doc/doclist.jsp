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
    <div class="padding border-bottom">
        <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><a href="/doc/docadd" target="right"><span class="icon-plus-square-o"></span> 添加醫生</a></button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <td>编号</td>
            <td>医生工号</td>
            <td>医生密码</td>
            <td>医生姓名</td>
            <td>医生头像/图片名</td>
            <td>医生电话号码</td>
            <td>医生电子邮箱</td>
            <td>医生简介</td>
            <td>挂号费</td>
            <td>入职日期</td>
            <td>所屬科室标识符</td>
            <td>职称</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="doc" varStatus="vs">
            <c:choose>
                <c:when test="${(vs.index+1)%2==0}">
                    <tr style="background-color: rgb(255, 175, 175)">
                        <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />${vs.index+1}</td>
                        <td>${doc.doctorNumber}</td>
                        <td>${doc.doctorPassword}</td>
                        <td>${doc.doctorName}</td>
                        <td><img width="70" height="50" src="/doctor/${doc.doctorAvatar}"/></td>
                        <td>${doc.doctorPhone}</td>
                        <td>${doc.doctorEmail}</td>
                        <td>${doc.doctorIntion}</td>
                        <td>${doc.doctorReFee}</td>
                        <td>${doc.doctorEnData}</td>
                        <td>${doc.doctorDeptId}</td>
                        <td>${doc.doctorProTitleId}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" href="/doc/docinftoedit?doctorsId=${doc.doctorId}">
                                    <span class="icon-edit"></span> 修改
                                </a>
                                <a class="button border-red" href="javascript:void(0)" onclick="return del(${doc.doctorId},1)">
                                    <span class="icon-trash-o"></span> 删除</a>
                            </div>
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr style="background-color: rgb(175, 175, 175)">
                        <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />${vs.index+1}</td>
                        <td>${doc.doctorNumber}</td>
                        <td>${doc.doctorPassword}</td>
                        <td>${doc.doctorName}</td>
                        <td><img width="70" height="50" src="/doctor/${doc.doctorAvatar}"/></td>
                        <td>${doc.doctorPhone}</td>
                        <td>${doc.doctorEmail}</td>
                        <td>${doc.doctorIntion}</td>
                        <td>${doc.doctorReFee}</td>
                        <td>${doc.doctorEnData}</td>
                        <td>${doc.doctorDeptId}</td>
                        <td>${doc.doctorProTitleId}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" href="/doc/doctoedit?doctorsId=${doc.doctorId}">
                                    <span class="icon-edit"></span> 修改
                                </a>
                                <a class="button border-red" href="javascript:void(0)" onclick="return del(${doc.doctorId},1)">
                                    <span class="icon-trash-o"></span> 删除</a>
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
                        <a href="/doc/doclist?pageNum=${pageInfo.prePage}">上一页</a>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                        <c:choose>
                            <c:when test="${i == pageInfo.pageNum}">
                                <a class="active-page" href="/doc/doclist?pageNum=${i}">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/doc/doclist?pageNum=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageInfo.isLastPage}">
                        <a href="javascript:alert('已经是最后一页了')" >下一页</a>
                    </c:if>
                    <c:if test="${not pageInfo.isLastPage}">
                        <a href="/doc/doclist?pageNum=${pageInfo.nextPage}">下一页</a>
                    </c:if>
                    <a href="/doc/doclist?pageNum=${pageInfo.pages}">尾页</a>
                </div>
            </td>
        </tr>
    </table>
</div>
<script>
    function del(id, mid) {
        if (confirm("您确定要删除吗?")) {
            window.location.href = "/doc/docdelete?deptId="+id; // Redirect if confirmed
        }
        // No else block needed, so nothing happens when the user cancels
    }
</script>
</body>
</html>