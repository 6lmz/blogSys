<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/28
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${blog.title}</title>
</head>
<body>
<c:if test="${u.id!=null}">
    <h1>用户：${u.name}</h1>
</c:if>
<h1>标题：${blog.title}</h1>
<h6 style="margin:0.5em 0;"><a href="xxhome?user_id=${user.id}&my_id=${u.id}">作者：${user.name}</a></h6>
<p style="background-color: #e2e2e2">内容：<br>${blog.context}</p>
<h4>评论：</h4>
<c:choose>
    <c:when test="${map!=null}">
        <c:forEach items="${map}" var="m" varStatus="status">
            <a href="xxhome?user_id=${m.value.id}&my_id=${u.id}">用户：${m.value.name}</a>&nbsp;&nbsp;&nbsp;${m.key.content}<br><br>
        </c:forEach>
    </c:when>
    <c:otherwise><h2>还没有人评论过博客</h2>
    </c:otherwise>
</c:choose>
<form action="writeComment?blog_id=${blog.id}" method="post">
    <input type="hidden" name="user_id" value="${u.id}">
    <input type="text" name="content" onclick="tips(${u.id})" />
    <input type="submit" value="评论" />
</form>
</body>
<script>
    function tips(id) {
        if(id==null){
            alert("请先登录才能进行评价")
        }

    }
</script>
</html>
