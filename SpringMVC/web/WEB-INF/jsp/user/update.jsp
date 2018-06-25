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
<%--http://localhost:8080/test/user/wjl/update--%>
<head>
    <title>修改用户</title>
</head>
<body>
    <form:form method="post" modelAttribute="user">
        <form:input path="name"/><form:errors path="name"/> <br/>
        <form:password path="password"/><form:errors path="password"/> <br/>
        <input type="submit" value="修改用户"/>
    </form:form>
</body>
</html>
