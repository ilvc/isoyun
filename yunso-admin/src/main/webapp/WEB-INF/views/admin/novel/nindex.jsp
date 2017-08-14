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
    <!-- 头部 -->
    <div class="layui-header">
        <div class="layui-main">
            <!-- logo -->
            <a href="/" style="color: #c2c2c2; font-size: 18px; line-height: 60px;">iLvc - 搜云小说</a>
            <!-- 水平导航 -->
            <ul class="layui-nav" style="position: absolute; top: 0; right: 0; background: none;">
               <%-- <li class="layui-nav-item">
                    <a href="javascript:;">
                        进入前台
                    </a>
                </li>--%>
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



    <!-- 主体 -->
    <div class="layui-body " style="left: 30px; padding-top: 30px">
        <div>
            <fieldset class="layui-elem-field layui-field-title layui-box"><legend><a name="fieldset">isoyun - 嗖的一下，小说来了</a></legend></fieldset>
            <form action="" class="layui-from">

                <div  style="width: 60%;margin:0 auto">
                    <input type="text" style="height: 38px; line-height: 38px; line-height: 36px;padding:0 5px; border: 1px solid #e6e6e6;background-color: #fff;border-radius: 2px;width: 80%" placeholder="嗖的一下，小说来了">
                    <span class="">
                        <button class="btn btn-default layui-btn" style="left: 2px;" type="button"><i class="layui-icon">&#xe615;</i></button>
                   </span>
                </div><!-- /input-group -->
            </form>
        </div>
        <div class=" layui-clear">
            <fieldset class="layui-elem-field layui-field-title"><legend><a name="fieldset">isoyun - 精品小说,看了还看</a></legend></fieldset>
            <c:forEach items="${novelInfo_all}" var="novelInfo" >
            <div class="card TopstoryItem">
                <div class="card-head">
                    <span class="user-link"><a href="javascript:;">网友上传</a></span>
                   <%-- <span>赞同了回答</span><span class="QuestionItem-dot">·</span>
                    <span>1 小时前</span>--%>
                    <span> 最后更新：${novelInfo.newupdate}</span>
                </div>
                <div class="card-people">
                    <span><a href="http:ilvc.me"><img width="24px" height="24px" style="vertical-align: top;" src="${novelInfo.novelimg}" /></a></span>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <span><a href="ilvc.me" >${novelInfo.author}</a> </span>&nbsp;,&nbsp;
                    <span class="bio" style="text-align: center;font-weight: bold;">《${novelInfo.novelName}》</span>
                </div>
                <div class="card-title">
                    <h2 class="ContentItem-title" style="overflow: hidden">《${novelInfo.novelName}》<a href=ilvc.me"">${novelInfo.newchapter}</a></h2>
                </div>
                <div class="card-content">
                    <div class="card-content-left">
                        <div class="card-img">
                            <a href="htpp://lvc.me"><img  width="120px" height="150px" src="${novelInfo.novelimg}"/></a>
                        </div>
                    </div>
                    <div class="card-content-right">
					<span style=" white-space: normal;height: 75%;display: block;">
						${fn:substring(novelInfo.brief,0,106)}...
					</span>
                        <span style="display: inline-block;margin-top: 31px;"><a  class="layui-btn" href="${pageContext.request.contextPath}/novel/read/${novelInfo.novelId}">开始阅读</a></span>
                        <span style="display: inline-block;margin-top: 31px;"><a  class="layui-btn" href="${pageContext.request.contextPath}/novel/chapter/${novelInfo.novelId}">章节目录</a></span>
                        <span style="display: inline-block;margin-top: 31px;"><a  class="layui-btn" href="${pageContext.request.contextPath}/novel/conllection/${novelInfo.novelId}">加入收藏</a></span>
                    </div>
                </div>

                <div class="card-action" >

                </div>
            </div>
          </c:forEach>
            </table>


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

        $(document).ready(function(){
         /*   alert($(window).height()); //浏览器当前窗口可视区域高度
            alert($(document).height()); //浏览器当前窗口文档的高度
            alert($(document.body).height());//浏览器当前窗口文档body的高度
            alert($(document.body).outerHeight(true));//浏览器当前窗口文档body的总高度包括border padding margin

            alert($(window).width()); //浏览器当前窗口可视区域宽度
            alert($(document).width());//浏览器当前窗口文档对象宽度
            alert($(document.body).width());//浏览器当前窗口文档body的宽度
            alert($(document.body).outerWidth(true));//浏览器当前窗口文档body的总宽度包括border padding margin
            if($(window).width()<1366){
                $(".card").css("width","49%")
            }*/
            if($(window).width()<=1366){
                $(".card").css("width","49%")
            }
            $(window).resize(function () {          //当浏览器大小变化时
           /*     alert($(window).height());          //浏览器时下窗口可视区域高度
                alert($(document).height());        //浏览器时下窗口文档的高度
                alert($(document.body).height());   //浏览器时下窗口文档body的高度
                alert($(document.body).outerHeight(true)); //浏览器时下窗口文档body的总高度 包括border padding margin*/
                if($(window).width()<=1366){
                    $(".card").css("width","48%")
                }
                if($(window).width()>1366){
                    $(".card").css("width","31%")
                }

            });

            function searchToggle(obj, evt){
                var container = $(obj).closest('.search-wrapper');

                if(!container.hasClass('active')){
                    container.addClass('active');
                    evt.preventDefault();
                }
                else if(container.hasClass('active') && $(obj).closest('.input-holder').length == 0){
                    container.removeClass('active');
                    // clear input
                    container.find('.search-input').val('');
                    // clear and hide result container when we press close
                    container.find('.result-container').fadeOut(100, function(){$(this).empty();});
                }
            }



        })
    });



</script>
</body>
</html>