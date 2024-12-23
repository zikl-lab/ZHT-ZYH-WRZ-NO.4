<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>就诊列表</title>
    <link rel="stylesheet" href="/css/pintuer.css">
    <link rel="stylesheet" href="/css/admin.css">
    <script src="/js/jquery-3.7.1.min.js"></script>
    <script src="/js/pintuer.js"></script>

</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <div class="padding border-bottom">
        <button type="button" class="button border-yellow" onclick="window.location.href='/con/confirst'"><span class="icon-plus-square-o"></span> 添加就诊信息</button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <td>编号</td>
            <td>就诊编号</td>
            <td>患者编号</td>
            <td>医生编号</td>
            <td>就诊时间</td>
            <td>是否住院登记</td>
            <td>是否住院</td>
            <td>医嘱病例</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="con" varStatus="vs">
            <c:choose>
                <c:when test="${(vs.index+1)%2==0}">
                    <tr style="background-color: rgb(255, 175, 175)">
                        <td>${vs.index+1}</td>
                        <td>${con.consultationId}</td>
                        <td>${con.patientId}</td>
                        <td>${con.doctorId}</td>
                        <td>${con.consultationTime}</td>
                        <td>${con.isHospitalRegistered}</td>
                        <td>${con.isHospitalized}</td>
                        <td>${con.medicalAdviceCase}</td>
                        <td><div class="button-group">
                            <a class="button border-main" href="/con/toEdit?consultationId=${con.consultationId}">
                                <span class="icon-edit"></span> 修改</a>
                            <a class="button border-red" href="javascript:void(0)" onclick="return del(${con.consultationId},1)">
                                <span class="icon-trash-o"></span> 删除</a> </div></td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr style="background-color: rgb(255, 175, 175)">
                        <td>${vs.index+1}</td>
                        <td>${con.consultationId}</td>
                        <td>${con.patientId}</td>
                        <td>${con.doctorId}</td>
                        <td>${con.consultationTime}</td>
                        <td>${con.isHospitalRegistered}</td>
                        <td>${con.isHospitalized}</td>
                        <td>${con.medicalAdviceCase}</td>
                        <td><div class="button-group">
                            <a class="button border-main" href="/con/toEdit?consultationId=${con.consultationId}">
                                <span class="icon-edit"></span> 修改</a>
                            <a class="button border-red" href="javascript:void(0)" onclick="return del(${con.consultationId},1)">
                                <span class="icon-trash-o"></span> 删除</a> </div></td>
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
                        <a href="/con/conlist?pageNum=${pageInfo.prePage}">上一页</a>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                        <a href="/con/conlist?pageNum=${i}">${i}</a>
                    </c:forEach>
                    <c:if test="${pageInfo.isLastPage}">
                        <a href="javascript:alert('已经是最后一页了')" >下一页</a>
                    </c:if>
                    <c:if test="${not pageInfo.isLastPage}">
                        <a href="/con/conlist?pageNum=${pageInfo.nextPage}">下一页</a>
                    </c:if>
                    <a href="/con/conlist?pageNum=${pageInfo.pages}">尾页</a>
                </div>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    function del(id,mid){
        if(confirm("您确定要删除吗?")){
            window.location.href = "/con/delete?deptId="+id; // Redirect if confirmed

        }
    }
</script>
</body>
</html>