<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/23
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>用户登录</h1>
    <form action="login" method="post">
        用户名：<input type="text" name="name" />
        密码：<input type="text" name="password" />
        <input type="submit" value="登录" />
    </form>
</body>
</html>
