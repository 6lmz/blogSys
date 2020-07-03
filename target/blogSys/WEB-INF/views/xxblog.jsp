<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/29
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${xx.name}的博客</title>
</head>
<body>

<c:if test="${my.id!=null}">
    <h1>用户：${my.name}</h1>
</c:if>

<%--<input type="hidden" name="user_id" value="${user.id}">--%>
<%--<p>${user.name}</p>--%>
<%--<h1>我的博客</h1>--%>
<h1>${user.name}的博客</h1>

<c:choose>
    <c:when test="${user.blogList[0].id!=null}">
        <c:forEach items="${user.blogList}" var="blog" varStatus="status">
            ${blog.id}&nbsp;
            <a href="showblog?blog_id=${blog.id}&my_id=${user.id}"> ${blog.title}&nbsp;</a>
            ${blog.context} <br>
        </c:forEach>
    </c:when>

    <c:otherwise><h2>还没有发表过博客</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
