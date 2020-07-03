<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/29
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>系统日志</title>
</head>
<body>
<h1>${user.name}</h1>
<h1>系统日志</h1>

<a href="write?user_id=${user.id}">写博客</a><br>
<a id="myblog" href="myBlog?user_id=${user.id}">我的博客</a><br>
<a href="myWriteCom?user_id=${user.id}">我参与的评论</a><br>
<a href="ComFrom?user_id=${user.id}">我的文章评论</a><br>
<a href="alllog?user_id=${user.id}">系统日志</a><br>
<a href="findAllUser?user_id=${user.id}">用户管理</a><br>
<a href="allblog?user_id=${user.id}">查看所有博客</a>

<c:forEach items="${logs}" var="log" varStatus="status">

    <div style="margin: 0.5em 0;background-color: #e2e2e2;">
    操作:${log.operate}&nbsp;&nbsp;&nbsp;操作时间:${log.operateTime} &nbsp;&nbsp;&nbsp;用户id:${log.user_id}<br>

</c:forEach>
</body>
</html>
