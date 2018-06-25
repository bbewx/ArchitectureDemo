<%--
  Created by IntelliJ IDEA.
  User: WJL
  Date: 2017/3/12
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<%--http://localhost:8080/test/user/wjl--%>
<head>
    <title>用户信息</title>
</head>
<body>
        姓名：${user.name} <br/>
        密码：${user.password} <br/>
</body>
</html>
