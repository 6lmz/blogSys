
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>查看所有博客</title>
</head>
<body>
<p>用户：${my.name}</p>
<h1>查看所有博客</h1>

<form action="mfindTitle?user_id=${my.id}" method="post">
    <input type="text" name="title" value="${title}">
    <input type="submit" value="搜索博客">
</form>
<a href="write?user_id=${my.id}">写博客</a><br>
<a id="myblog" href="myBlog?user_id=${my.id}">我的博客</a><br>
<a href="myWriteCom?user_id=${my.id}">我参与的评论</a><br>
<a href="ComFrom?user_id=${my.id}">我的文章评论</a><br>
<a href="alllog?user_id=${my.id}">系统日志</a><br>
<a href="findAllUser?user_id=${my.id}">用户管理</a><br>
<a href="allblog?user_id=${my.id}">查看所有博客</a>

<c:forEach items="${users}" var="user" varStatus="status">

    <c:forEach items="${user.blogList}" var="blog" varStatus="status">
        <div style="margin: 0.5em 0;background-color: #e2e2e2;">
                <%--    ${blog.id}&nbsp;--%>
            <h3 style="margin:0.5em 0;"><a href="showblog?blog_id=${blog.id}&my_id="> ${blog.title}&nbsp;</a></h3>
            <h6 style="margin:0.5em 0;">作者：${user.name}</h6>
            <p style="display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;overflow: hidden;width: 20em;margin: 0.5em 0;font-size: 0.8em;"> ${blog.context} </p></div>
        <a href="mdelblog?blog_id=${blog.id}&my_id=${my.id}">
            <button>删除该博客</button>
        </a>
        &emsp;<br>
    </c:forEach>

</c:forEach>

<c:forEach items="${map}" var="m" varStatus="status">

    <%--    <c:forEach items="${}" var="blog" varStatus="status">--%>
    <div style="margin: 0.5em 0;background-color: #e2e2e2;">
            <%--    ${blog.id}&nbsp;--%>
        <h3 style="margin:0.5em 0;"><a href="showblog?blog_id=${m.key.id}&my_id=${my.id}"> ${m.key.title}&nbsp;</a></h3>
        <h6 style="margin:0.5em 0;">作者：${m.value.name}</h6>
        <p style="display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;overflow: hidden;width: 20em;margin: 0.5em 0;font-size: 0.8em;"> ${m.key.context} </p>
                <a href="mdelblog?blog_id=${m.key.id}&my_id=${my.id}">
                    <button>删除该博客</button>
                </a>
    </div>
    <%--    </c:forEach>--%>

</c:forEach>
</body>
</html>
