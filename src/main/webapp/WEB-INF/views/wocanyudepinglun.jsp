<%--
  Created by IntelliJ IDEA.
  User: 刘明珠
  Date: 2020/6/29
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %><html>
<head>
    <title>我参与的文章评论</title>
</head>
<body>
<p>用户：${user.name}</p>
<h1>我参与的评论</h1>
<c:choose>
    <c:when test="${map!=null}">
        <c:forEach items="${map}" var="m" varStatus="status">
            <h3><a href="showblog?blog_id=${m.key.id}&my_id=${user.id}"> ${m.key.title}&nbsp</a></h3>
            <p>我的评论：${m.value.content} </p>
            &emsp;
            <a href="delmypinglun?com_id=${m.value.id}&user_id=${user.id}">
                <button>删除</button>
            </a><br><br>

        </c:forEach>
    </c:when>

    <c:otherwise><h2>你还没有发表过评论</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
