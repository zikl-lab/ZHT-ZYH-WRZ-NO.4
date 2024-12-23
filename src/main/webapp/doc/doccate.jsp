<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title>医生列表</title>
  <link rel="stylesheet" href="/css/pintuer.css">
  <link rel="stylesheet" href="/css/admin.css">
  <script src="/js/jquery-3.7.1.min.js"></script>
  <script src="/js/pintuer.js"></script>
</head>
<body>
<!--<form method="post" action="" id="listform">-->
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
  <div class="padding border-bottom" >
    <ul class="search" style="padding-left:10px;">
      <li> <a class="button border-main icon-plus-square-o" href="/doc/docadd.jsp"> 添加内容</a> </li>
      <li>搜索：</li>
      <li>
      </li>
      <if condition="$iscid eq 1">
        <li>
          <select name="deptId" class="input" style="width:200px; line-height:17px;" onchange="changesearch()">
            <option value="">请选择科室</option>
            <c:forEach items="${list1}" var="dept">
              <option value="${dept.departmentId}">${dept.departmentName}</option>
            </c:forEach>
          </select>
        </li>
      </if>
      <li>
        <input type="text" placeholder="请输入搜索姓名" name="nameKeywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
        <input type="text" placeholder="请输入搜索工号" name="jobKeywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
        <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
    </ul>
  </div>
  <table class="table table-hover text-center">
    <thead>
    <tr>
      <th width="100" style="text-align:left; padding-left:20px;">ID</th>
      <!--     <th width="10%">排序</th>-->

      <th>工号</th>
      <th>姓名</th>
      <th>头像</th>
      <th>手机号</th>
      <th>挂号费</th>
      <th>入职日期</th>
      <th>科室名称</th>
      <th>职称</th>
      <!--<th width="10%">更新时间</th>-->
      <th width="310">操作</th>
    </tr>

    </thead>

    <tbody id="docBody">
    </tbody>

    <tr>
      <td colspan="8"><div class="pagelist">
        <a href="" id ="pre">上一页</a>
        <a href="javascript void(0)" id="next" onclick="nextPage()">下一页</a>
        <a href="">尾页</a>
      </div></td>
    </tr>
  </table>
</div>
<!--</form>-->
<script type="text/javascript">
  //发送Ajax请求 请求doc/list
  function initDocList(p){
    var deptId = $("select[name='deptId']").val();
    $.ajax({
      type: "GET",
      url:"/doc/doccate",
      data: {
        "pageNum": p,
        "deptId": deptId
      },
      dataType: "json",
      success: function (res) {
        console.log("res", res);
        $("#docBody").empty();
        $.each(res.list , function (i,v){
          var trObj = $("<tr></tr>");
          trObj.append($("<td>"+(i+1)+"</td>"));
          trObj.append($("<td>"+v.jobNumber+"</td>"));
          trObj.append($("<td>"+v.name+"</td>"));
          trObj.append($('<td><img width="70" height="50" src="/image/'+v.avatar+'"></img></td>'));
          trObj.append($("<td>"+v.phone+"</td>"));
          trObj.append($("<td>"+v.registrationFee+"</td>"));
          trObj.append($("<td>"+v.entryDate+"</td>"));
          trObj.append($("<td>"+v.departments.departmentName+"</td>"));
          trObj.append($("<td>"+v.professionalTitles.titleName+"</td>"));
          trObj.append($('<td><a class="button border-main" href="/toEdit?deptId='+v.departmentId+'"> <span class="icon-edit"></span> 修改</a></td>'));
          trObj.appendTo($("#docBody"));
        });
        $(".pagelist span").remove()
        //页码遍历
        for(var i=0;i<res.pages;i++){

          var $span = $("<span onclick='changePage($(this).html())'>"+(i+1)+"</span>")
          if((i+1) == res.pageNum){
            $span.attr("class","current")
          }
          $("#next").before($span)

        }
      }
    })

  }
  $(function (){
    initDocList();

  })


  //搜索
  function changesearch(){
    var $docName = $("input[name='nameKeywords']").val();
    var $jobNumber = $("input[name='jobKeywords']").val();
    var $deptId = $("select[name='deptId'] option:selected").val();

    // 调用initDocList函数并传递当前搜索条件
    initDocList(1, $docName, $jobNumber, $deptId);
  }

  function initDocList(p, docName = "", jobNumber = "", deptId = 6){
    $.ajax({
      type: "GET",
      url:"/doc/doccate",
      data: {
        "pageNum": p,
        "deptId": deptId,
        "docName": docName,
        "jobNumber": jobNumber
      },
      dataType: "json",
      success: function (res) {
        console.log("res", res);
        $("#docBody").empty();

        // 填充表格内容
        $.each(res.list , function (i,v){
          // 填充表格行的代码保持不变
        });

        $(".pagelist span").remove();

        // 页码遍历
        for(var i=0; i < res.pages; i++){
          var $span = $("<span onclick='changePage($(this).html())'>"+(i+1)+"</span>");
          if((i+1) == res.pageNum){
            $span.attr("class", "current")
          }
          $("#next").before($span);
        }
      }
    });
  }

  $(function (){
    initDocList(1);
  });

  function nextPage(){
    //获取当前页码
    //页码+1
    var currentPageNumber = $("span[class='current']").text()
    initDocList(Number(currentPageNumber)+1)

  }

  //单个删除
  function del(id,mid,iscid){
    if(confirm("您确定要删除吗?")){

    }
  }
  //改变页
  function changePage(p){
    // alert(p)
    initDocList(p)
  }

  //全选
  $("#checkall").click(function(){
    $("input[name='id[]']").each(function(){
      if (this.checked) {
        this.checked = false;
      }
      else {
        this.checked = true;
      }
    });
  })

  //批量删除
  function DelSelect(){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){
      var t=confirm("您确认要删除选中的内容吗？");
      if (t==false) return false;
      $("#listform").submit();
    }
    else{
      alert("请选择您要删除的内容!");
      return false;
    }
  }

  //批量排序
  function sorts(){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");
      return false;
    }
  }


  //批量首页显示
  function changeishome(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }

  //批量推荐
  function changeisvouch(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){


      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }

  //批量置顶
  function changeistop(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }


  //批量移动
  function changecate(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){

      $("#listform").submit();
    }
    else{
      alert("请选择要操作的内容!");

      return false;
    }
  }

  //批量复制
  function changecopy(o){
    var Checkbox=false;
    $("input[name='id[]']").each(function(){
      if (this.checked==true) {
        Checkbox=true;
      }
    });
    if (Checkbox){
      var i = 0;
      $("input[name='id[]']").each(function(){
        if (this.checked==true) {
          i++;
        }
      });
      if(i>1){
        alert("只能选择一条信息!");
        $(o).find("option:first").prop("selected","selected");
      }else{

        $("#listform").submit();
      }
    }
    else{
      alert("请选择要复制的内容!");
      $(o).find("option:first").prop("selected","selected");
      return false;
    }
  }

</script>
</body>
</html>