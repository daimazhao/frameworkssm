<%--
  Created by IntelliJ IDEA.
  User: Mr.zhao
  Date: 2024/6/20
  Time: 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div style="margin: 25%">
        <form action="/user/login" style="text-align: center">
            用户名:<input type="text" name="username" value="${param.username}" placeholder="请输入账号">
            密码:<input type="text" name="password" value="${param.password}" placeholder="请输入密码">
            <input type="submit" value="登录">
        </form>
    </div>
</body>
</html>
