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
    <script>
        function toggleSubMenu(index) {//index=1
            //获取按钮对象
            var $button = $('button[onclick="toggleSubMenu(' + index + ')"');
            //切换+ -  三元运算符
            $button.html(($button.html() === '+')? '-' : '+');
            //获取index对应的子菜单
            var $subMenu = $('#subMenu' + index);
            //修改子菜单的display 样式
            $subMenu.css('display', ($subMenu.css('display') === 'none')? 'table-row' : 'none');
            $.ajax({
                type:"GET",
                url:"/dept/second",
                data:{"deptPid":$button.attr("deptPid")},
                dataType:"json",
                success:function (res) {
                    //console("res",res)
                    $("#subMenu"+index+" tbody").empty()
                    $.each(res , function (i,v){
                        var trObj = $("<tr></tr>");
                        trObj.append($("<td>"+v.departmentId+"</td>"));
                        trObj.append($("<td>"+v.departmentName+"</td>"));
                        trObj.append($("<td>"+v.departmentDescription+"</td>"));
                        trObj.append($(' <td> <div class="button-group"> <a class="button border-main" href="/dept/depttoedit?deptId='+v.departmentId+'"> <span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="del('+v.departmentId+', 1)"> <span class="icon-trash-o"></span>删除</a></div> </td>'));
                        trObj.appendTo($("#subMenu"+index+" tbody"));
                    });
                }
            })
        }
    </script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <div class="padding border-bottom">
        <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><a href="/dept/first" target="right"><span class="icon-plus-square-o"></span> 添加分类</a></button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <td>编号</td>
            <td>展開/摺叠</td>
            <td>科室名称</td>
            <td>上级科室</td>
            <td>科室等级</td>
            <td>科室路径</td>
            <td>科室介绍</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="dept" varStatus="vs">
            <c:choose>
                <c:when test="${(vs.index+1)%2==0}">
                    <tr style="background-color: rgb(255, 175, 175)">
                        <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />${vs.index+1}</td>
                        <td><button deptPid="${dept.departmentId}" onclick="toggleSubMenu(${vs.index+1})">+</button></td>
                        <td>${dept.departmentName}</td>
                        <td>${dept.departmentPid}</td>
                        <td>${dept.departmentLevel}</td>
                        <td>${dept.departmentPath}</td>
                        <td>${dept.departmentDescription}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" id="editLink1" href="/dept/depttoedit?deptId=${dept.departmentId}">
                                    <span class="icon-edit"></span> 修改
                                </a>
                                <a class="button border-red" href="javascript:void(0)" onclick="del(${dept.departmentId}, 1)">
                                    <span class="icon-trash-o"></span> 删除
                                </a>
                            </div>
                        </td>
                    </tr>
                    <tr style="display: none" id="subMenu${vs.index+1}">
                        <td colspan="8">
                            <table class="table table-hover text-center">
                                <thead>
                                <tr>
                                    <td>编号</td>
                                    <td>科室名称</td>
                                    <td>科室介绍</td>
                                    <td>操作</td>
                                </tr>
                                </thead>
                                <tbody>

                            </tbody>

                            </table>
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr style="background-color: rgb(175, 175, 175)">
                        <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />${vs.index+1}</td>
                        <td><button deptPid="${dept.departmentId}" onclick="toggleSubMenu(${vs.index+1})">+</button></td>
                        <td>${dept.departmentName}</td>
                        <td>${dept.departmentPid}</td>
                        <td>${dept.departmentLevel}</td>
                        <td>${dept.departmentPath}</td>
                        <td>${dept.departmentDescription}</td>
                        <td>
                            <div class="button-group">
                                <a class="button border-main" id="editLink2" href="/dept/depttoedit?deptId=${dept.departmentId}">
                                    <span class="icon-edit"></span> 修改
                                </a>
                                <a class="button border-red" href="javascript:void(0)" onclick="del(${dept.departmentId}, 1)">
                                    <span class="icon-trash-o"></span> 删除
                                </a>
                            </div>
                        </td>
                    </tr>
                    <tr style="display: none" id="subMenu${vs.index+1}">
                        <td colspan="8">
                            <table class="table table-hover text-center">
                                <thead>
                                <tr>
                                    <td>编号</td>
                                    <td>科室名称</td>
                                    <td>科室介绍</td>
                                    <td>操作</td>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
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
                        <a href="/dept/deptlist?pageNum=${pageInfo.prePage}">上一页</a>
                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="i">
                        <c:choose>
                            <c:when test="${i == pageInfo.pageNum}">
                                <a class="active-page" href="/dept/deptlist?pageNum=${i}">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/dept/deptlist?pageNum=${i}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageInfo.isLastPage}">
                        <a href="javascript:alert('已经是最后一页了')" >下一页</a>
                    </c:if>
                    <c:if test="${not pageInfo.isLastPage}">
                        <a href="/dept/deptlist?pageNum=${pageInfo.nextPage}">下一页</a>
                    </c:if>
                    <a href="/dept/deptlist?pageNum=${pageInfo.pages}">尾页</a>
                </div>
            </td>
        </tr>
    </table>
</div>
<script>
    function del(id, mid) {
        if (confirm("您确定要删除吗?")) {
            window.location.href = "/dept/deptdelete?deptId="+id; // Redirect if confirmed
        }
        // No else block needed, so nothing happens when the user cancels
    }
</script>
</body>
</html>