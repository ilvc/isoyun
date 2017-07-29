<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="云搜 数据采集平台">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>iLvc - 云搜 数据采集平台 </title>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/card.css">
</head>

<body>
<!-- 布局容器 -->
<div class="layui-layout layui-layout-admin">

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <div class="layui-tree">
                <ul>
                   <%-- <c:forEach items="" var="" >

                    </c:forEach>--%>

                       <li>123</li>
                       <li>123</li> <li>123</li>
                       <li>123</li>
                       <li>123</li> <li>123</li>
                       <li>123</li>
                       <li>123</li>
                       <li>123</li>
                       <li>123</li> <li>123</li> <li>123</li>
                       <li>123</li>
                </ul>
            </div>
        </div>
    </div>
    <!-- 主体 -->
    <div class="layui-body " style="left: 30px; padding-top: 30px">
            Hello World!

    </div>

    <!-- 底部 -->
    <div class=" layui-layout layui-footer" style="text-align: center; left: 0;height: 40px; display: block">
        Copyright © 2017 <a href="http://www.isoyun.cc" target="_blank"> isoyun </a> Powered by iLvc | Lvc唯爱 <br/>本站所有资源均由网友上传转载，如有侵犯您的权益，请联系我们，我们尽快删除。站长QQ：2442669938
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/plugin/layui/layui.js"></script>
<script type="text/javascript">

    layui.use(["element","layer","jquery"],function(){

        var $=layui.jquery,element=layui.element,layer=layui.layer;


    });



</script>
</body>
</html>