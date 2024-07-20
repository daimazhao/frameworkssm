<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr.zhao
  Date: 2024/6/26
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>shopping_list</title>
</head>
<body>
    <div style="margin: 10% ">
        <h3>${sessionScope.users.userName}的购物车</h3>
        <table border="1" cellpadding="5" cellspacing="0" width="100%">
            <tr>
                <th>序号</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品数量</th>
                <th>操作</th>
            </tr>
            <c:forEach var="sc" varStatus="vs" items="${list}">
                <tr>
                    <td align="center">${vs.index+1}</td>
                    <td align="center">${sc.products.productName}</td>
                    <td align="center">${sc.products.price}</td>
                    <td align="center">${sc.quantity}</td>
                    <td align="center">
                        <button onclick="del('${sc.cartId}')">delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
