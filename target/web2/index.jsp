<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>城市医院预约平台</title>
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link rel="stylesheet" type="text/css" href="css/layout.css"/>
    <link rel="stylesheet" type="text/css" href="css/ui.css">
</head>
<body>
<!-- 顶部 -->
<div class="top" id="top">
    <div class="wrap">
        <p class="call">010-114/116114电话预约</p>
        <p class="welcome">欢迎来到北京科技大学附属医院预约挂号统一平台&nbsp;请&nbsp;
            <a href="/loginturn">登录</a>
        </p>
    </div>
</div>
<!-- header区域 -->
<div class="header" id="header">
    <div class="wrap">
        <a class="logo" href="main.html"> <img src="/images/yy.png" alt=""> </a>
        <div class="search ui-search">
            <!-- 搜索栏 -->
            <div class="ui-search-selected">医院</div>
            <div class="ui-search-select-list">
                <a href="#1">科室</a>
                <a href="#1">职称</a>
                <a href="#1">医院</a>
            </div>
            <input type="text" name="search-content" class="ui-search-input" placeholder="请输入搜索内容">
            <a href="#" class="ui-search-submit">&nbsp;</a>
        </div>
    </div>
</div>
<!-- 导航栏 -->
<div class="nav" id="nav">
    <div class="wrap">
        <div class="menu" ><a href="#" class="link">首页</a></div>
        <a href="#" class="link">按医院挂号</a>
        <a href="#" class="link">按科室挂号</a>
        <a href="#" class="link">按疾病挂号</a>
        <a href="#" class="link">最新公告</a>
        <a href="#" class="link right">北京科技大学附属医院</a>
    </div>
</div>
<!-- 医院简绍区域 -->
<div class="banner" id="banner">
    <div class="wrap">
        <div class="title">
            <span class="title-left">北京科技大学附属医院 <a href="#">关注医院</a></span>
            <span class="title-right">
            <span class="title-right-tips">等级:</span>三级甲等 &nbsp;&nbsp;
            <span class="title-right-tips">区域:</span>东城区 &nbsp;&nbsp;
            <span class="title-right-tips">分类:</span>中国医科院医院 &nbsp;&nbsp;
          </span>
        </div>
        <div class="banner-content">
            <div class="left">
                <img src="/images/door.png" width="200" height="200" alt="">
            </div>
            <div class="middle">
                <span class="icon-address">[本院]北京市海淀区学院路30号</span>
                <span class="icon-web">官网：https://www.ustb.edu.cn/</span>
                <span class="icon-tel">本院咨询台：010-62325294</span>
                <span class="icon-trans">邮箱：zhaoshengzixun@ustb.edu.cn</span>
                <span class="icon-tels">北京科技大学西门（成府路口南站）：26、331、375、
                    438、478、484、490、603、606、632、693、928、145、夜4、夜14；<br>
                    北京科技大学南门（学院桥东站）：386、490、609、613、400、484、751、928、特9、夜4；<br>
                    北京科技大学北门（北京科技大学北门站）：86、307、311、484、508、928；<br>
                    北京科技大学东门（志新村小区西站）：928。</span>
            </div>
            <div class="right">
                <img src="/images/wait.png" width="250" height="220" alt="">
            </div>
        </div>

    </div>
</div>
<!-- 医院体系区域 -->
<div class="content " id="content" >
    <div class="wrap">
        <!-- 导航栏 -->
        <div class="nav">
<%--            <a href="/dept/deptlist?ifturn=1" class="link selected">预约挂号</a>--%>
            <a href="#2" class="link">医院介绍</a>
            <a href="#2" class="link">医生信息</a>
            <a href="#2" class="link">查询取消</a>
        </div>
        <div class="schedule hidden" >
            <span>科室排班表</span>
            <span class="back"><a href="#">返回科室列表</a></span>
        </div>
    </div>
</div>



<div class="content-lists clearfix">
    <div class="wrap clearfix">
        <%--<div class="content-list focus">
            <div class="content-tab">
                <div class="caption">开放预约科室</div>
                <div class="content-table">
                    <table>

                    </table>
                </div>
            </div>
            <div class="content-news">
                <div class="caption">
                    预约规则
                    <span>更新时间每日8：30更新</span>
                </div>
                <div class="content-news-tips">
                    <div class="line">
                        <div class="line-name">预约周期:</div><div>7天</div>
                    </div>
                    <div class="line">
                        <div class="line-name">放号时间:</div><div>8：30</div>
                    </div>
                    <div class="line">
                        <div class="line-name">停诊时间:</div>
                        <div>下午14：00停止次日预约挂号，周五14：00停挂至下周一</div>
                    </div>
                    <div class="line">
                        <div class="line-name">退号时间:</div>
                        <div>就诊前一工作日14：00前取消</div>
                    </div>
                    <div class="line">
                        <div class="line-name">特殊规则:</div>
                        <div>取号地点不同：本院区预约号区号地点：
                            海淀区北京科技大学附属医院门诊楼一层大厅挂号窗口取号。
                            本院区预约号取号地点：雄安新区北京科技大学附属医院分院
                            门诊楼一层大厅挂号窗口或新门诊楼各楼层挂号/收费窗口取号。</div>
                    </div>
                </div>
            </div>
        </div>--%>
        <div class="content-list">
            <!-- 医院介绍 -->
            <div class="content-lists">
            <div class="hospitals">
                医院介绍
            </div>
            <div class="content-tips">
                <div class="lines">
                    欢迎来到我们的医院，这里是您健康的守护者和治疗的港湾。我们致力于为每一位患者提供全面的医疗服务和关怀，<br>
                    结合先进的医疗技术和人性化的护理理念，为您和您的家人提供高质量的医疗保障。<br>
                    我们的设施和服务包括：<br>
                    1. 专业医疗团队：<br>
                    - 我们拥有一支由经验丰富的医生、护士和医疗技术人员组成的专业团队，他们致力于为患者提供最佳的医疗护理。<br>
                    2. 先进的医疗设备：<br>
                    - 我们引进了国际先进的医疗设备和技术，确保诊断和治疗过程更加精准和有效。<br>
                    3. 全面的医疗服务：<br>
                    - 我们提供从预防保健到急救抢救的全方位医疗服务，包括但不限于内科、外科、妇产科、儿科、心脏科等专业治疗。<br>
                    4. 温馨的护理环境：<br>
                    - 我们致力于营造一个舒适、温馨的护理环境，让患者在治疗过程中感受到家的温暖。<br>
                    5. 个性化护理：<br>
                    - 我们重视每一位患者的个性化需求，根据病情和患者的健康状况制定个性化的治疗方案。<br>
                    6. 社区责任：<br>
                    - 我们积极参与社区健康活动，推动健康教育和预防医疗，为社区居民提供持续的健康支持和服务。<br>
                    我们竭诚欢迎您的到访，希望能为您提供优质的医疗服务，让您和您的家人享受健康快乐的生活。</div>
            </div>
            </div>
        </div>
        <div class="content-list">
            <!-- 就诊信息 -->
            <div class="stop-title">
                就诊信息
            </div>
            <table class="stop-tips-table">
                <tr>
                    <th>日期</th>
                    <th>星期</th>
                    <th>时段</th>
                    <th>科室</th>
                    <th>特长</th>
                    <th>职称</th>
                    <th>挂号费</th>
                    <th>可挂号数</th>
                    <th>剩余好数</th>
                    <th>替换方式</th>
                </tr>

            </table>
        </div>
        <div class="content-list">
            <!-- 查询取消 -->
            <div class="search-cancel">
                <div class="line">
                    <span>预约识别码:</span>
                    <input type="text" name="" value="">
                    <button type="button" name="" value="">查询订单</button>
                </div>
            </div>
        </div>
    </div>
    <div class="wrap clearfix hidden">
        <table>
            <tr>
                <td>
                    <div class="leftBtn">
                        <div class="wrap_btn">
                            <div class="btn"></div>
                        </div>
                        <div class="status">上午</div>
                        <div class="status">下午</div>
                        <div class="status">晚上</div>
                    </div>
                </td>
                <td>
                    <div class="main">
                        <div class="schedule_box clearfix">
                            <!-- 模板
                            <div class="schedule_box_item">
                              <div class="date">星期一 <br>2019-01-01</div>
                              <div class="status"></div>
                              <div class="status status_full">约满</div>
                              <div class="status"></div>
                            </div>
                          -->
                        </div>
                    </div>
                </td>
                <td>
                    <div class="rightBtn">
                        <div class="wrap_btn">
                            <div class="btn"></div>
                        </div>
                        <div class="status"></div>
                        <div class="status"></div>
                        <div class="status"></div>
                    </div>
                </td>
                <td>
                    <div class="content-news">
                        <div class="title">
                            预约规则
                        </div>
                        <div class="line">
                            <div class="line-name">预约周期:</div><div>7天</div>
                        </div>
                        <div class="line">
                            <div class="line-name">放号时间:</div><div>8：30</div>
                        </div>
                        <div class="line">
                            <div class="line-name">停诊时间:</div>
                            <div>下午14：00停止次日预约挂号，周五14：00停挂至下周一</div>
                        </div>
                        <div class="line">
                            <div class="line-name">退号时间:</div>
                            <div>就诊前一工作日14：00前取消</div>
                        </div>
                        <div class="line">
                            <div class="line-name">特殊规则:</div>
                            <div>取号地点不同：本院区预约号区号地点：
                                海淀区北京科技大学附属医院门诊楼一层大厅挂号窗口取号。
                                本院区预约号取号地点：雄安新区北京科技大学附属医院分院
                                门诊楼一层大厅挂号窗口或新门诊楼各楼层挂号/收费窗口取号。</div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr >
                <td colspan="4">
                    <div class="bottom">
                        <span class="choice">您还没有选择就诊日期</span>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>
</div>



<!-- footer -->
<div class="footer" id="footer">
    Copyright (c) 2018 Copyright Holder All Rights Reserved.
</div>
</body>
<!-- jquery的两种导入方式 -->
<!-- <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script> -->
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
<!-- ui.js用到jquery库，所以jquery的库的导入要在ui.js之前，否则提示$未定义 -->
<script type="text/javascript" src="js/ui.js"></script>


</script>
</html>

