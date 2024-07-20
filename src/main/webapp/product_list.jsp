<%--
  Created by IntelliJ IDEA.
  User: Mr.zhao
  Date: 2024/6/19
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>product_list</title>
    <script>
        function showDetail(id){
            location.href = "/product/showDetail?id="+id
        }
    </script>

</head>
<body>

    <div style="width: 80%; margin: 10% auto">
        <br>
        欢迎你${sessionScope.users.userName}
        <a href="/user/logout">
            退出
        </a>
        <a href="/shopCart/list?userId=${sessionScope.users.userId}">加购物车</a>
        <table border="1" cellpadding="5" cellspacing="0" width="100%">
            <tr>
                <th><input type="checkbox" id="checkAllStu">All</th>
                <th>序号</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>详情</th>
            <c:forEach var="products" varStatus="i" items="${list}">
                <tr>
                    <td><input type="checkbox" name="productIds" value="${products.productId}"></td>
                    <td align="center">${i.count}</td>
                    <td align="center">${products.productName}</td>
                    <td align="center">${products.price}</td>
                    <td align="center">
                        <button onclick="showDetail(${products.productId})">详情</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
