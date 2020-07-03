<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/28
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>

<form action="findTitle?user_id=${id}" method="post">
    <input type="text" name="title" value="${title}">
    <input type="submit" value="搜索">
</form>

<a href="login">登录</a><br>
<a href="register">注册</a><br><br>

<c:forEach items="${map}" var="m" varStatus="status">

<%--    <c:forEach items="${}" var="blog" varStatus="status">--%>
        <div style="margin: 0.5em 0;background-color: #e2e2e2;">
                <%--    ${blog.id}&nbsp;--%>
            <h3 style="margin:0.5em 0;"><a href="showblog?blog_id=${m.key.id}&my_id=${my.id}"> ${m.key.title}&nbsp;</a></h3>
            <h6 style="margin:0.5em 0;">作者：${m.value.name}</h6>
            <p style="display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;overflow: hidden;width: 20em;margin: 0.5em 0;font-size: 0.8em;"> ${m.key.context} </p></div>
<%--    </c:forEach>--%>

</c:forEach>
</body>
</html>
