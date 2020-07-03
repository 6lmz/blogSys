<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/29
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>写博客</title>
</head>
<body>
<p>用户：${user.name}</p>

<h1 >写博客</h1>
<form action="write?user_id=${user.id}" method="post">
    标题：<input type="text" name="title" />
    内容：<input type="text" name="context" />
    <input type="submit" value="发表" />
</form>

</body>
</html>
