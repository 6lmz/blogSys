<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/29
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>我的博客</title>
</head>
<body>
<p>用户：${user.name}</p>
<h1>我的博客</h1>

<c:choose>
    <c:when test="${user.blogList[0].id!=null}">
        <c:forEach items="${user.blogList}" var="blog" varStatus="status">
            <div style="margin: 0.5em 0;background-color: #e2e2e2;">
                <form action="modtitle?blog_id=${blog.id}&user_id=${user.id}" method="post">
                <h3 style="margin:0.5em 0;"><a href="showblog?blog_id=${blog.id}&my_id=${user.id}"> ${blog.title}&nbsp;</a></h3>
                    <input type="text" name="title" >
                <input type="submit" value="修改标题"></form>
                <p style="display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;overflow: hidden;width: 20em;margin: 0.5em 0;font-size: 0.8em;">${blog.context} </p>
<%--                <a href="modtitle?id=${user.id}">--%>
<%--                    <button>修改标题</button>--%>
<%--                </a>--%>
                <a href="delblog?blog_id=${blog.id}&user_id=${user.id}$my_id=${user.id}">
                    <button>删除该博客</button>
                </a>
                &emsp;<br>

            </div>
        </c:forEach>
    </c:when>

    <c:otherwise><h2>你还没有发表过博客</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
