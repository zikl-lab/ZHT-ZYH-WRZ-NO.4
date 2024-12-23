<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<% System.out.println("a = " + request.getAttribute("a")); %>

<c:if test="${a != '1'}">
    <jsp:forward page="/login" />
</c:if>--%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>增加患者信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/pat/patsave">
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>患者身份证号码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientIdCard" value="" />
                    <div class="tips"></div>
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>患者密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="patientPassword" value="" />
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>患者姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientName" value="" />
                    <div class="tips"></div>
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>患者头像路径/图片名：</label>
                </div>
                <div class="field">
                    <input type="file" class="input w50" name="doctorAvatar" value="" style="border: none;" />
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>患者电话号码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientPhone" value="" />
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>患者电子邮箱：</label>
                </div>
                <div class="field">
                    <input type="email" class="input w50" name="patientEmail" />
                    <div class="tips"></div>
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>患者账户余额：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientBalance" value="" />
                </div>
            </div>
            <br><br>
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
