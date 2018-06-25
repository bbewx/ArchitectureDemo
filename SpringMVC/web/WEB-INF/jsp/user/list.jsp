<%--
  Created by IntelliJ IDEA.
  User: WJL
  Date: 2017/3/12
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%--http://localhost:8080/test/user/users--%>
<head>
    <title>用户列表</title>
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/css/main.css"
          type="text/css">
</head>
<body>
    <a href="add">添加</a>-->${loginUser.name}
    <br/>
    <c:forEach items="${users}" var="user">
        <a href="${user.value.name}">${user.value.name}</a>
        -----${user.value.password}
        -----<a href="${user.value.name}/update">修改</a>
        <a href="${user.value.name}/delete">删除</a> <br/>
    </c:forEach>
</body>
</html>
