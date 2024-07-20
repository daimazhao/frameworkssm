<%--
  Created by IntelliJ IDEA.
  User: Mr.zhao
  Date: 2024/6/12
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student_add</title>
    <style>
        body {
            background-color: burlywood;
        }
    </style>
</head>
<body>
    <form action="/student/save" method="post" style="width: 50%;height: 30%; margin: 20% auto;background-color: aquamarine">

        姓名:<input type="text" name="name"><br>
        性别：
            男<input type="radio" name="sex" value="男">
            女<input type="radio" name="sex" value="女">
        <br>
        电话:<input type="text" name="tel"><br>
        爱好:<input type="text" name="hobbies"><br>
        备注:<textarea name="remark"></textarea><br>
        <button>提交</button>
    </form>
</body>
</html>
