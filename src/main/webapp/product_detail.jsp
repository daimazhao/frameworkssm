<%--
  Created by IntelliJ IDEA.
  User: Mr.zhao
  Date: 2024/6/24
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>detail</title>
</head>
<body>
    <div style="margin: 20%" align="center">
        商品详情
        <p>商品名称：${products.productName}</p>
        <p>商品价格：<span id="price">${products.price}</span></p>

        <p>数量：<button onclick="sub()">-</button>
            <input style="width: 30px" type="text" value="1" id="num" onclick="heji()">
            <button onclick="add()">+</button>
        </p>
        <p>合计：<span style="color: #dc0e26" id="total"></span></p>
        <p>
            <button onclick="addCart(${sessionScope.users.userId},${products.productId})">加购物车</button>
        </p>
    </div>
</body>
</html>
<script>

    var num = document.getElementById("num");

    var price = document.getElementById("price");

    var total = document.getElementById("total");




    function addCart(userId,productId){
        //用户id
        //商品的id
        //数量
        location.href = "/shopCart/add?userId="+ userId +"&productId="+ productId +"&quantity="+num.value
    }

    function sub(){
        if(num.value>1){
            num.value--
        }
        heji()
    }

    function add(){
        num.value++
        heji()
    }

    function heji(){
        total.innerText = num.value * price.innerText
    }
    heji();
</script>

