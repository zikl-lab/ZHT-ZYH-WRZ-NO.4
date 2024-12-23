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
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加预约</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/appoint/save">
            <div class="form-group">
                <div class="label">
                    <label>病人编号：</label>
                </div>
                <div class="field">
                    <select name="appointPId" class="input">
                        <option value="-1">無</option>
                        <c:forEach items="${list2}" var="pat">
                            <option value="${pat.patientId}">${pat.patientName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>医生编号：</label>
                </div>
                <div class="field">
                    <select name="appointDId" class="input">
                        <option value="-1">無</option>
                        <c:forEach items="${list1}" var="doc">
                            <option value="${doc.doctorId}">${doc.doctorName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>预约日期：</label>
                </div>
                <div class="field">
                    <input type="date" class="input" name="appointDate"  />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>预约时间：</label>
                </div>
                <div class="field">
                    <input type="time" class="input" name="appointTime"  />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>