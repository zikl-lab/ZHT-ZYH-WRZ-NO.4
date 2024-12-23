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
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/pat/patinfedit">
            <input type="hidden" name="patientId" value="${patients.patientId}">
            <div class="form-group">
                <div class="label">
                    <label>病人身份证号码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientIdCard" value="${patients.patientCard}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>病人密码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientPassword" value="${patients.patientPassword}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>患者姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientName" value="${patients.patientName}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>患者头像：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientAvatar" value="${patients.patientAvatar}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>患者电话号码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientPhone" value="${patients.patientPhone}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>患者电子邮箱：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientEmail" value="${patients.patientEmail}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>患者账号余额：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="patientBalance" value="${patients.patientBalance}"/>
                    <div class="tips"></div>
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
</body></html>
