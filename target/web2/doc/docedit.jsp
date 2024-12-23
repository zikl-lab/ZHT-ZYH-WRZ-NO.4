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
    <title>修改医生信息</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="/js/jquery-3.7.1.min.js"></script>
    <script src="/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/doc/docedit" enctype="multipart/form-data">
            <input type="hidden" name="doctorId" value="${doctors.doctorId}">
            <div class="form-group">
                <div class="label">
                    <label>医生工号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="doctorNumber" value="${doctors.doctorNumber}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>医生密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" name="doctorPassword" value="${doctors.doctorPassword}"/>
                    <div class="tips"></div>
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>医生姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="doctorName" value="${doctors.doctorName}" />
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>医生头像：</label>
                    <br>
                </div>
                <!-- 输入框 -->
                <input type="text" id="url1" name="doctorAvatar" class="input tips" style="width: 25%; float: left;" value="${doctors.doctorAvatar}" data-toggle="hover" data-place="right" data-image="">

                <!-- 浏览上传按钮 -->
                <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传" style="float: left;" onclick="document.getElementById('fileInput').click();">

                <!-- 文件上传 -->
                <input type="file" id="fileInput" class="input w50" name="fileInput" style="display: none;">

                <!-- JavaScript 代码 -->
                <script>
                    // 当文件选择后更新输入框显示
                    document.getElementById('fileInput').addEventListener('change', function() {
                        var fileName = this.files[0].name;
                        document.getElementById('url1').value = fileName; // 更新输入框的值为文件名
                    });
                </script>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>医生电话号码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="doctorPhone" value="${doctors.doctorPhone}" />
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>医生电子邮箱：</label>
                </div>
                <div class="field">
                    <input type="email" class="input w50" name="doctorEmail" value="${doctors.doctorEmail}" />
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>医生简介：</label>
                </div>
                <div class="field">
                    <textarea class="input w50" name="doctorIntion" value="${doctors.doctorIntion}"></textarea>
                </div>
            </div>
            <br><br><br>
            <div class="form-group">
                <div class="label">
                    <label>挂号费：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="doctorReFee" value="${doctors.doctorReFee}" />
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>入职日期：</label>
                </div>
                <div class="field">
                    <input type="date" class="input w50" name="doctorEnData" value="${doctorEnData}" />
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>所屬科室：</label>
                </div>
                <div class="field">
                    <select name="doctorDeptId" class="input w50">
                        <option value="-1">無</option>
                        <c:forEach items="${list1}" var="dept">
                            <option value="${dept.departmentId}">${dept.departmentName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <br><br>
            <div class="form-group">
                <div class="label">
                    <label>職稱：</label>
                </div>
                <div class="field">
                    <select name="doctorProTitleId" class="input w50">
                        <option value="-1">無</option>
                        <c:forEach items="${list2}" var="prot">
                            <option value="${prot.protitleId}">${prot.protitleName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <br><br>

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