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
    <title>增加医生信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
<%--    <script>
        $(document).ready(function() {
            $('form').submit(function(event) {
                var proName = $('input[name="proName"]').val();
                if (proName === '') {
                    alert('职称名称不能为空');
                    event.preventDefault(); // 阻止表单提交
                }
            });
        });
    </script>--%>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/prot/save">
            <div class="form-group">
                <div class="label">
                    <label>職稱名稱：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="protitleName" />
                    <div class="tips"></div>
                </div>
            </div>
            <%--<div class="clear"></div>--%>
            <div class="form-group">
                <div class="label">
                    <label>職稱描述：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="protitleDescription" value="" />
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
