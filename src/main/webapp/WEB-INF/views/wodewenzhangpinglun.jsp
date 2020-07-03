<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/29
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的文章评论</title>
</head>
<body>
<p>用户：${user.name}</p>
<h1>我的文章评论</h1>
<c:choose>
    <c:when test="${blogs!=null}">
        <c:forEach items="${blogs}" var="b" varStatus="status">
        <c:forEach items="${b.commentList}" var="c" varStatus="status">
            <h3><a href="showblog?blog_id=${b.id}&my_id=${user.id}"> ${b.title}&nbsp</a></h3>
            <p>${c.content} </p>
            &emsp;
            <a href="delmywenzhangpinglun?com_id=${c.id}&user_id=${user.id}">
                <button>删除</button>
            </a><br><br>
        </c:forEach>
        </c:forEach>
    </c:when>

    <c:otherwise><h2>你还没有发表过评论</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
