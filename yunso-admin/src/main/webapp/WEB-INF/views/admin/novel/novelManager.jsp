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
            <legend>小说爬虫管理 - 小说管理</legend>

            <table class="layui-table">
                <colgroup>
                    <col >
                    <col >
                    <col >
                    <col >
                    <col >
                    <col >
                </colgroup>
                <thead>
                <tr>
                    <th>novel_id</th>
                    <th>novel_namme</th>
                    <th>novelNum</th>
                    <th>author</th>
                    <th>newChapter</th>
                    <th>state</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${novelInfo_list}" var="novelInfo">
                    <tr>
                        <td>${novelInfo.novelId}</td>
                        <td>${novelInfo.novelName}</td>
                        <td>${novelInfo.novelnum}</td>
                        <td>${novelInfo.author}</td>
                        <td>${novelInfo.newchapter}</td>
                        <td>${novelInfo.state}</td>
                        <td><button   class="layui-btn layui-btn-small " onclick="taskFun('${pageContext.request.contextPath}/admin/c/novel/spider/update/${nOpInfo.id}');">update</button >
                        <button   class="layui-btn layui-btn-small layui-btn-danger " onclick="taskFun('${pageContext.request.contextPath}/admin/c/novel/spider/delete/${nOpInfo.id}');">delete</button ></td>
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

        });

        function taskFun(url) {
            $.post(url,function (data) {
                layer.msg(data);
            });
        }
    </script>
</body>
</html>
