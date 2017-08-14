<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>  <c:if test="${chapter==null}">${novel.chapters.get(0).chaptername}</c:if>
        <c:if test="${chapter!=null}">${chapter.chaptername}</c:if>  《<c:if test="${chapter==null}">${novel.chapters.get(0).novelname}</c:if>
        <c:if test="${chapter!=null}">${chapter.novelname}</c:if>》 i-搜云小说 </title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="alternate icon" type="image/png" href="${pageContext.request.contextPath}/resource/plugin/AmazeUI/assets/i/favicon.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugin/AmazeUI/assets/css/amazeui.min.css"/>
    <style>
        @media only screen and (min-width: 641px) {
            .am-offcanvas {
                display: block;
                position: static;
                background: none;
            }

            .am-offcanvas-bar {
                position: static;
                width: auto;
                background: none;
                -webkit-transform: translate3d(0, 0, 0);
                -ms-transform: translate3d(0, 0, 0);
                transform: translate3d(0, 0, 0);
            }
            .am-offcanvas-bar:after {
                content: none;
            }

        }

        @media only screen and (max-width: 640px) {
            .am-offcanvas-bar .am-nav>li>a {
                color:#ccc;
                border-radius: 0;
                border-top: 1px solid rgba(0,0,0,.3);
                box-shadow: inset 0 1px 0 rgba(255,255,255,.05)
            }

            .am-offcanvas-bar .am-nav>li>a:hover {
                background: #404040;
                color: #fff
            }

            .am-offcanvas-bar .am-nav>li.am-nav-header {
                color: #777;
                background: #404040;
                box-shadow: inset 0 1px 0 rgba(255,255,255,.05);
                text-shadow: 0 1px 0 rgba(0,0,0,.5);
                border-top: 1px solid rgba(0,0,0,.3);
                font-weight: 400;
                font-size: 75%
            }

            .am-offcanvas-bar .am-nav>li.am-active>a {
                background: #1a1a1a;
                color: #fff;
                box-shadow: inset 0 1px 3px rgba(0,0,0,.3)
            }

            .am-offcanvas-bar .am-nav>li+li {
                margin-top: 0;
            }
        }

        .my-head {
            margin-top: 40px;
            text-align: center;
        }

        .my-button {
            position: fixed;
            top: 0;
            right: 0;
            border-radius: 0;
        }
        .my-sidebar {
            padding-right: 0;
            border-right: 1px solid #eeeeee;
        }

        .my-footer {
            border-top: 1px solid #eeeeee;
            padding: 10px 0;
            margin-top: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<header class="am-g my-head">
    <div class="am-u-sm-12 am-article">
        <h1 class="am-article-title"><c:if test="${chapter==null}">${novel.chapters.get(0).chaptername}</c:if>
            <c:if test="${chapter!=null}">${chapter.chaptername}</c:if>
        </h1>
        <p class="am-article-meta">${novel.author},《<c:if test="${chapter==null}">${novel.chapters.get(0).novelname}</c:if>
            <c:if test="${chapter!=null}">${chapter.novelname}</c:if>》</p>
    </div>
</header>
<hr class="am-article-divider"/>
<div class="am-g am-g-fixed">
    <div class="am-u-md-9 am-u-md-push-3">
        <div class="am-g">
            <div class="am-u-sm-11 am-u-sm-centered">
                <div class="am-cf am-article">
                    ${novel.chapters.get(0).content.replaceAll("[a-zA-Z]","").replace("    ","<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").replace("FQxSw.com","")}
                    ${chapter.content.replaceAll("[a-zA-Z]","").replace("    ","<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").replace("FQxSw.com","")}
                </div>
                <hr/>
                <div style="display: inline">
                    <a href="上一章"></a>
                    <a href="目录"></a>
                    <a href="下一章"></a>

                </div>
            </div>
        </div>
    </div>
    <div class="am-u-md-3 am-u-md-pull-9 my-sidebar">
        <div class="am-sticky-placeholder" style="height: 996px; margin: 0px;">
            <div id="amz-offcanvas" class="am-offcanvas doc-offcanvas" style="margin: 0px;">
                <section  id="sidebar" class="amz-sidebar am-offcanvas-bar" style="overflow-y: scroll;height: 80%">
                    <ul class="am-nav" >
                        <li>
                            <c:if test="${chapter==null}">${novel.chapters.get(0).chaptername}</c:if>
                            <c:if test="${chapter!=null}">${chapter.chaptername}</c:if>
                        </li>
                        <li class="am-nav-header">目录</li>
                        <c:forEach items="${novel.chapters}" var="chapter" end="30">
                            <li><a href="${pageContext.request.contextPath}/novel/read/${novel.novelId}/${chapter.chapterId}">${chapter.chaptername}</a></li>
                        </c:forEach>
                    </ul>
                </section>
            </div>
        </div>
    </div>
    <a href="#sidebar" class="am-btn am-btn-sm am-btn-success am-icon-bars am-show-sm-only my-button" data-am-offcanvas><span class="am-sr-only">侧栏导航</span></a>
</div>

<footer class="my-footer">
    <p><small>© Copyright 2013-2017 isoyun by the iLvc | Lvc唯爱</small></p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${pageContext.request.contextPath}/resource/plugin/AmazeUI/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="${pageContext.request.contextPath}/resource/plugin/AmazeUI/assets/js/amazeui.min.js"></script>
</body>
</html>