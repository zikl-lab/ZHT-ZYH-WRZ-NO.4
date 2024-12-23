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
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>住院预约</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/hos/save">
            <div class="form-group">
                <div class="label">
                    <label>病人：</label>
                </div>
                <div class="field">
                    <select name="hosPId" class="input w50">
                        <option value="-1">無</option>
                        <c:forEach items="${list1}" var="pat">
                            <option value="${pat.patientId}">${pat.patientName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>病房号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="hosRoom" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>住院费用：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="hosCost" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>支付状态：</label>
                </div>
                <div class="field">
                    <select name="hosPStatus" class="input w50">
                        <option value="paid">paid</option>
                        <option value="unpaid">unpaid</option>
                        <option value="partially_paid">partially_paid</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>保险：</label>
                </div>
                <div class="field">
                    <select name="hosInsured" class="input w50">
                        <option value="1">true</option>
                        <option value="0">false</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>住院状态：</label>
                </div>
                <div class="field">
                    <select name="hosStatus" class="input w50">
                        <option value="admitted">admitted</option>
                        <option value="discharged">discharged</option>
                        <option value="in_progress">in_progress</option>
                    </select>
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

</body>
</html>