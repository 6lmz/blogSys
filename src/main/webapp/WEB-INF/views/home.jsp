<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/28
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>欢迎回来</title>
</head>
<body>
<h1>欢迎${my.name}</h1>
<form action="findTitle?user_id=${id}" method="post">
    <input type="text" name="title" value="${title}">
    <input type="submit" value="搜索">
</form>
<a href="write?user_id=${my.id}">写博客</a><br>
<a  id="myblog"  href="myBlog?user_id=${id}" >我的博客</a><br>
<a href="myWriteCom?user_id=${id}">我参与的评论</a><br>
<a href="ComFrom?user_id=${id}">我的文章评论</a><br>
<c:if test="${num==1}">
    <a href="alllog?user_id=${id}">系统日志</a><br>
    <a href="findAllUser?user_id=${id}">用户管理</a><br>
    <a href="allblog?user_id=${id}">查看所有博客</a><br>
</c:if>

<c:forEach items="${map}" var="m" varStatus="status">

    <div style="margin: 0.5em 0;background-color: #e2e2e2;">

        <h3 style="margin:0.5em 0;"><a href="showblog?blog_id=${m.key.id}&my_id=${my.id}"> ${m.key.title}&nbsp;</a></h3>
        <h6 style="margin:0.5em 0;">作者：${m.value.name}</h6>
        <p style="display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;overflow: hidden;width: 20em;margin: 0.5em 0;font-size: 0.8em;"> ${m.key.context} </p></div>


</c:forEach>
</body>
</html>
