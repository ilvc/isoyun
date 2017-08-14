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
    <title>iLvc - 云搜 数据采集平台 后台管理首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugin/layui/css/layui.css">
</head>

<body>
    <!-- 布局容器 -->
    <div class="layui-layout layui-layout-admin">
        <!-- 头部 -->
        <div class="layui-header">
            <div class="layui-main">
                <!-- logo -->
                <a href="/" style="color: #c2c2c2; font-size: 18px; line-height: 60px;">iLvc - 云搜</a>
                <!-- 水平导航 -->
                <ul class="layui-nav" style="position: absolute; top: 0; right: 0; background: none;">
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                            进入前台
                        </a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">
                           设置
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;">
                                    个人信息
                                </a>
                            </dd>
                            <dd>
                                <a href="javascript:;">
                                    修改密码
                                </a>
                            </dd>
                            <dd>
                                <a href="javascript:;">
                                    退出登录
                                </a>
                            </dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>

        <!-- 侧边栏 -->
        <div class="layui-side layui-bg-black">
            <div class="layui-side-scroll">
                <ul class="layui-nav layui-nav-tree" lay-filter="left-nav" style="border-radius: 0;">
                	<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
                	 <li class="layui-nav-item layui-nav-itemed">
					    <a href="javascript:;" data-url="http://ilvc.me" data-id="1" >博客</a>
					  </li>
					   <li class="layui-nav-item layui-nav-itemed">
					    <a href="javascript:;" data-url="${pageContext.request.contextPath}/admin/admin/main/" data-id="2" >主页</a>
					  </li>
					  <li class="layui-nav-item layui-nav-itemed">
					    <a href="javascript:;">小说爬虫管理</a>
					    <dl class="layui-nav-child">
					      <dd><a href="javascript:;" data-url="${pageContext.request.contextPath}/admin/r/novel/spider/edit" data-id="4" >添加小说</a></dd>
					      <dd><a href="javascript:;" data-url="${pageContext.request.contextPath}/admin/r/novel/spider/manager" data-id="8">小说管理</a></dd>
					      <dd><a href="javascript:;" data-url="${pageContext.request.contextPath}/admin/r/novel/spider/task" data-id="7">任务管理</a></dd>
					    </dl>
					  </li>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;">网盘爬虫管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${pageContext.request.contextPath}/admin/r/novel/spider/edit" data-id="5" >添加资源</a></dd>
                            <dd><a href="javascript:;">资源管理</a></dd>
                            <dd><a href="javascript:;">任务管理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;">博文爬虫管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${pageContext.request.contextPath}/admin/r/novel/spider/edit" data-id="6" >添加博文</a></dd>
                            <dd><a href="javascript:;">博文管理</a></dd>
                            <dd><a href="javascript:;">任务管理</a></dd>
                        </dl>
                    </li>
					</ul>
            </div>
        </div>

        <!-- 主体 -->
        <div class="layui-body">
            <!-- 顶部切换卡 -->
            <div class="layui-tab layui-tab-brief" lay-filter="top-tab" lay-allowClose="true" style="margin: 0;">
                <ul class="layui-tab-title"></ul>
                <div class="layui-tab-content"></div>
            </div>
        </div>

        <!-- 底部 -->
        <div class="layui-footer" style="text-align: center; line-height: 44px;">
            Copyright © 2017 <a href="http://www.iLvc.com" target="_blank"> isoyun </a> Powered by iLvc | Lvc唯爱
        </div>
    </div>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/plugin/layui/layui.js"></script>
    <script type="text/javascript">
        /**
         * 对layui进行全局配置
         */
        layui.config({
            base: '${pageContext.request.contextPath}/resource/plugin/mods/'
        });

        /**
         * 初始化整个cms骨架
         */
        layui.use(['cms'], function() {
            var cms = layui.cms('left-nav', 'top-tab');
/* 
            cms.addNav([
                {id: 1, pid: 0, node: '主页', url: '${pageContext.request.contextPath}/admin/main'},
                {id: 7, pid: 0, node: '登录', url: '${pageContext.request.contextPath}/admin/login'},
                {id: 2, pid: 0, node: '搜索引擎', url: ''},
                {id: 3, pid: 2, node: '百度', url: 'https://www.baidu.com/'},
                {id: 4, pid: 2, node: '必应', url: 'http://cn.bing.com/'},
                {id: 5, pid: 2, node: '360', url: 'https://www.so.com/'},
                {id: 6, pid: 2, node: '搜狗', url: 'https://www.sogou.com/'},
                {id: 8, pid: 0, node: '博客', url: 'http://www.ilvc.me/'},
            ], 0, 'id', 'pid', 'node', 'url'); */

            cms.bind(60 + 41 + 20 + 44); //头部高度 + 顶部切换卡标题高度 + 顶部切换卡内容padding + 底部高度

            cms.clickLI(0);
        });
    </script>
</body>
</html>