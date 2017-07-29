<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="Generator" content="EditPlusÂ®">
     <meta name="Author" content="梦想星辰大海">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>主页 - cms后台模板</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/layui/css/layui.css">
</head>

<body>
    <blockquote class="layui-elem-quote">
        下载： <a href="https://github.com/buexplain/layuicms/archive/master.zip" target="_blank">点击下载</a>
        <hr>
        说明：
        <br>
        这是一个简单的后台模板布局
        <br>
        侧边栏导航只能支持到二级，什么时候支持到三级就看 <a href="https://github.com/sentsin/">贤心</a> 大神了。
    </blockquote>
    <script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript">
        /**
         * å¯¹layuiè¿è¡å¨å±éç½®
         */
        layui.config({
            base: 'js/'
        });
    </script>
</body>
</html>