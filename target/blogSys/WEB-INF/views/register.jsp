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
    <title>注册</title>
</head>
<body>
<h1>注册</h1>
<form action="register" method="post" >
    <div>
        用户名：<input type="text" name="name"/><br>
        密码：<input type="text" name="password"/><br>
        生日<input type="date" name="birthday"/><br>
        权限：<input type="checkbox" name="roleList[0].power" value="普通用户"/>普通用户
        <input type="checkbox" name="roleList[1].power" value="管理员"/>管理员
    </div>
    <input type="submit" value ="确定"/>
    <input type="reset" value="重置"/>
</form>
</body>
</html>
