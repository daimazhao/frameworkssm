<%--
  Created by IntelliJ IDEA.
  User: Mr.zhao
  Date: 2024/6/13
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student_update</title>
    <style>
        body {
            background-color: #d5de87;
        }
    </style>
</head>
<body>
    <form action="/student/updateStudent" method="post" style="width: 50%;height: 30%; margin: 20% auto;background-color: aquamarine">
    <%--修改和增加不同的是增加因为自增ID的原因我们是向后端传递id的。但是更新的时候因为需要使用id进行更新
    所以在更在更新页面中一定将id给传递到后端，并且在页面中要隐藏传递--%>
        <input type="hidden" name="id" value="${student.id}">
        姓名:<input type="text" name="name" value="${student.name}"><br>
        性别：
        男<input type="radio" name="sex" value="男"<c:if test="${student.sex =='男'}">checked</c:if>>
        女<input type="radio" name="sex" value="女"<c:if test="${student.sex =='女'}">checked</c:if>>
        <br>
        电话:<input type="text" name="tel" value="${student.tel}"><br>
        爱好:<input type="text" name="hobbies" value="${student.hobbies}"><br>
        备注:<textarea name="remark">${student.remark}</textarea><br>
        <button>update</button>
    </form>
</body>
</html>
