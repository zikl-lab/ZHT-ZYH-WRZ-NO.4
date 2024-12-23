<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<% System.out.println("a = " + request.getAttribute("a")); %>


<c:if test="${a != '1'}">
    <jsp:forward page="/login" />
</c:if>
--%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>修改就诊信息</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="/js/jquery-3.7.1.min.js"></script>
    <script src="/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/con/edit">
            <input type="hidden" name="consultationId" value="${consultation.consultationId}">
            <div class="form-group">
                <div class="label">
                    <label>患者编号：</label>
                </div>
                <div class="field">
                    <select name="patientId" class="input">
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
                    <select name="doctorId" class="input">
                        <option value="-1">無</option>
                        <c:forEach items="${list1}" var="doc">
                            <option value="${doc.doctorId}">${doc.doctorName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>时间：</label>
                </div>
                <div class="datetime">
                    <input type="datetime-local" class="input w50" name="consultationTime" step="1" value="${consultation.consultationTime}">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>是否住院登记：</label>
                </div>
                <div class="field">
                    <select name="isHospitalRegistered" class="input w50">
                        <option value="0">否</option>
                        <option value="1">是</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>是否住院：</label>
                </div>
                <div class="field">
                    <select name="isHospitalized" class="input w50">
                        <option value="0">否</option>
                        <option value="1">是</option>
                    </select>

                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>医嘱病例：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="medicalAdviceCase" value="${consultation.medicalAdviceCase}"/>
                    <div class="tips"></div>

                </div>
            </div>

            <%--<div class="form-group">
                <div class="label">
                    <label>科室名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="departmentName" />
                    <div class="tips"></div>
                </div>--%>
    </div>
    <div class="clear"></div>

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
</div>

</body>
</html>