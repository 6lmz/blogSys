<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/29
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %><html>
<head>
    <title>${user.name}的主页</title>
</head>
<body>
<c:if test="${my.id!=null}">
    <h1>用户：${my.name}</h1>
</c:if>

<h1>欢迎来到${user.name}的主页</h1>
<h3><a href="xxblog?user_id=${user.id}&my_id=${my.id}">他的博客</a></h3>
<div style="background-color: #eaeaea;font-size: 1em;">
    用户：${user.name}<br>
    生日：${user.birthday}<br>
    注册时间:${user.registerTime}<br>
</div>


</body>
</html>
