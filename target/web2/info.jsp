<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>就诊和住院概况</title>
    <style>
        .userFont {
            height: 150px;
            width: 250px;
            float: right;
            color: white;
        }
        .spanCure {
            font-size: 15px;
            margin-top: 60px;
            margin-bottom: 15px;
        }
        .spanPeople {
            font-size: 18px;
        }
        .userImage {
            height: 150px;
            width: 150px;
            font-size: 130px;
            color: white;
            position: relative;
            left: 40px;
            top: 10px;
            float: left;
        }
        .indexPeople {
            height: 200px;
            width: 440px;
            background: #58b9ae;
            float: left;
            margin: 30px;
        }
    </style>
</head>
<body>
<div class="indexPeople" style="margin-left: 350px">
    <div class="userImage">
        <i class="el-icon-user" style="font-size: 132px"></i>
    </div>
    <div class="userFont">
        <div class="spanCure">
            <span>就诊概况</span>
        </div>
        <div class="spanPeople">
            <span id="orderPeople">今天预约挂号总人数：加载中...</span>
        </div>
    </div>
</div>
<div class="indexPeople">
    <div class="userImage">
        <i class="el-icon-office-building" style="font-size: 132px"></i>
    </div>
    <div class="userFont">
        <div class="spanCure">
            <span>住院概况</span>
        </div>
        <div class="spanPeople">
            <span id="bedPeople">今天住院总人数：加载中...</span>
        </div>
    </div>
</div>
<div>
    <img src="images/16.png" style="width: 641px;margin-left: 490px;">
</div>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        function fetchData(url, elementId) {
            fetch(url)
                .then(response => response.json())
                .then(data => {
                    if (data.status !== 200) {
                        alert("数据请求失败");
                    } else {
                        document.getElementById(elementId).textContent = '今天预约挂号总人数：' + data.count;
                    }
                })
                .catch(error => console.error('Error:', error));
        }

        fetchData('/status', 'orderPeople');
        fetchData('/hospitalization_status', 'bedPeople');
    });
</script>
</body>
</html>