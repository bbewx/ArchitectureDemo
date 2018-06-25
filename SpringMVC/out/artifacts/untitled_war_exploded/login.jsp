<%--
  Created by IntelliJ IDEA.
  User: WJL
  Date: 2017/3/24
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%--http://localhost:8080/test/login.jsp--%>
<form action="user/login" method="post">
    用户名：<input type="text" name="name"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit"/>
</form>
</body>
</html>
