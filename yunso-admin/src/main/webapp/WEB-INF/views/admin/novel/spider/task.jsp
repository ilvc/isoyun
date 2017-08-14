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
            <legend>小说爬虫管理 - 任务管理</legend>

            <table class="layui-table">
                <colgroup>
                    <col >
                    <col >
                    <col >
                    <col >
                </colgroup>
                <thead>
                <tr>
                    <th>id</th>
                    <th>ndesc</th>
                    <th>novelNum</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${nOPInfo_list}" var="nOpInfo">
                    <tr>
                        <td>${nOpInfo.id}</td>
                        <td>${nOpInfo.ndesc}</td>
                        <td>${nOpInfo.type}</td>
                        <td><button   class="layui-btn layui-btn-small " onclick="taskFun('${pageContext.request.contextPath}/admin/c/novel/spider/start/${nOpInfo.id}');">Start</button >
                        <button  class="layui-btn layui-btn-small layui-btn-warm" onclick="taskFun('${pageContext.request.contextPath}/admin/c/novel/spider/stop/${nOpInfo.id}');">Stop</button>
                       <button  class="layui-btn layui-btn-small layui-btn-danger" onclick="taskFun('${pageContext.request.contextPath}/admin/c/novel/spider/delete/${nOpInfo.id}');">Delete</button></td>
                    </tr>

                </c:forEach>


                </tbody>
            </table>


        </fieldset>

    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/plugin/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
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

               /* $.ajax({
                    type : 'POST',
                    contentType : 'application/json',
                    url:"${pageContext.request.contextPath}/admin/c/novel/spider/start",
                    data:JSON.stringify(data.field),
                    success:function(data){
                        layer.msg(data);
                    }
                })*/



        });

        function taskFun(url) {
            $.post(url,function (data) {
                layer.msg(data);
            });
        }
    </script>
</body>
</html>
