<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/29
  Time: 8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<p>用户：${my.name}</p>
<h1>用户管理</h1>

<form action="finduser?user_id=${my.id}" method="post">
    <input type="text" name="name">
    <input type="submit" value="搜索用户">
</form>
<a href="write?user_id=${my.id}">写博客</a><br>
<a id="myblog" href="myBlog?user_id=${my.id}">我的博客</a><br>
<a href="myWriteCom?user_id=${my.id}">我参与的评论</a><br>
<a href="ComFrom?user_id=${my.id}">我的文章评论</a><br>
<a href="alllog?user_id=${my.id}">系统日志</a><br>
<a href="findAllUser?user_id=${my.id}">用户管理</a><br>
<a href="allblog?user_id=${my.id}">查看所有博客</a>

<c:choose>
    <c:when test="${userList!=null}">
        <h3>所有用户</h3>
        <c:forEach items="${userList}" var="u" varStatus="status">
            <%--            ${u.id} &nbsp;&nbsp;--%>
            <a href="xxhome?user_id=${u.id}&my_id=${my.id}"> ${u.name}&nbsp;</a>
            <form action="modpwd?user_id=${u.id}&my_id=${my.id}" method="post">
                密码: ${u.password}<input type="text" name="password" >
                &nbsp;注册时间：${u.registerTime}
                <input type="submit" value="修改用户密码">
                &emsp;
            </form>
            <a href="deluser?user_id=${u.id}&my_id=${my.id}">
                <button>删除</button>
            </a><br>

        </c:forEach>
    </c:when>

    <c:otherwise><h2>用户不存在</h2>
    </c:otherwise>
</c:choose>

</body>
<script>
    function mod(pwd) {
        var input = document.getElementById("#pwd")

        input.style.border = null;
        input.style.outline = null;
    }
</script>
</html>
