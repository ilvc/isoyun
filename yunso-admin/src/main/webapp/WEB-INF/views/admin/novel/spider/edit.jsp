<%--
  Created by IntelliJ IDEA.
  User: iLvc
  Date: 2017/7/24
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/plugin/layui/css/layui.css">
    <title>添加小说</title>
</head>
<body>
    <div class="layui-main">
        <fieldset class="layui-elem-field layui-field-title">
            <legend>小说爬虫管理 - 添加小说</legend>
            <div class="layui-field-box">
                <form class="layui-form" action="${pageContext.request.contextPath}/admin/c/novel/spider/start" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label">NDesc</label>
                        <div class="layui-input-block">
                            <input type="text" name="ndesc" required  lay-verify="required" placeholder="操作描述" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">StartUrl</label>
                        <div class="layui-input-block">
                            <input type="text" name="startUrl" required  lay-verify="required" placeholder="请输入StartUrl" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">TargetUrl</label>
                        <div class="layui-input-block">
                            <input type="text" name="targetUrl"    placeholder="请输入TargetUrl" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">ChaptetNum</label>
                        <div class="layui-input-inline">
                            <input type="text" name="chapternum"  placeholder="请输入ChaptetNum" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">起始章节（抓取章节的标识，必选）</div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">State</label>
                        <div class="layui-input-block">
                            <select name="state" lay-verify="required">
                                <option value=""></option>
                                <option value="first">first</option>
                                <option value="update">update</option>

                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">Type</label>
                        <div class="layui-input-block">
                            <select name="type" lay-verify="required">
                                <option value=""></option>
                                <option value="novelInfo">novelInfo</option>
                                <option value="novelChapter">novelChapter</option>

                            </select>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>


            </div>
        </fieldset>

    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/plugin/layui/layui.js"></script>
    <script type="text/javascript">
        /**
         * 对layui进行全局配置
         */
        layui.config({
            base: '${pageContext.request.contextPath}/resource/plugin/mods/'
        });

        //Demo
        layui.use(['form','jquery'], function(){
            var form = layui.form();
            var $ =layui.jquery;

            //监听提交
            form.on('submit(formDemo)', function(data){
                layer.msg(JSON.stringify(data.field));

                $.ajax({
                    type : 'POST',
                    contentType : 'application/json',
                    url:"${pageContext.request.contextPath}/admin/c/novel/spider/start",
                    data:JSON.stringify(data.field),
                    success:function(data){
                        layer.msg(data);
                    }
                });
                return false;
            });
        });
    </script>
</body>
</html>
