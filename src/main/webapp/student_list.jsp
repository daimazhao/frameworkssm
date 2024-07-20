<%--
  Created by IntelliJ IDEA.
  User: Mr.zhao
  Date: 2024/6/12
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student_list</title>

    <script>

        function toAdd(){
            location = "/student_add.jsp"
        }

        function del(id){
            if(confirm("Are you sure?")) {
                location = "/student/deleteStudent?id=" + id;
            }
        }

        function toUpdate(id) {
            location = "/student/queryStudentById?id="+id;
        }

        function batchDelete() {
                //js
            var checkIds = [];
                //选中input框的dom对象
            var checkboxs = document.getElementsByName("studentIds")
                //遍历checkboxs
            for(var i = 0;i<checkboxs.length;i++){
                if(checkboxs[i].checked){
                        //被选中了
                    checkIds.push(checkboxs[i].value)
                }
            }
            if(checkIds.length === 0){
                alert("please select what you want to delete!");
                return
            }

            if(confirm("Are u sure?")){
                location = "/student/batchDeleteStudents?ids="+checkIds.join(',');
            }
        }

    </script>
</head>
<body>

    <div style="width: 80%; margin: 10% auto">
        <button onclick="toAdd()">add</button>
        <button onclick="batchDelete()">batchdelete</button>
        <br>

        <form action="/student/list" style="text-align: center">
        姓名:<input type="text" name="name" value="${param.name}" placeholder="支持模糊查询">
            性别:<select name="sex">
                    <option value="">--请选择--</option>
                    <option value="男"${param.sex == '男'?'selected':''}>男</option>
                    <option value="女"${param.sex == '女'?'selected':''}>女</option>
                </select>
            <input type="submit" value="快捷查询">
        </form>

        <table border="1" cellpadding="5" cellspacing="0" width="100%">
            <tr>
                <th><input type="checkbox" id="checkAllStu">All</th>
                <th>序号</th>
                <th>名称</th>
                <th>性别</th>
                <th>电话</th>
                <th>爱好</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <c:forEach var="student" varStatus="i" items="${list}">
                <tr>
                    <td><input type="checkbox" name="studentIds" value="${student.id}"></td>
                    <td align="center">${i.count}</td>
                    <td align="center">${student.name}</td>
                    <td align="center">${student.sex}</td>
                    <td align="center">${student.tel}</td>
                    <td align="center">${student.hobbies}</td>
                    <td align="center">${student.remark}</td>
                    <td align="center">
                        <button onclick="toUpdate('${student.id}')">modify</button>
                        <button onclick="del('${student.id}')">delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

<script>

    //获取allStudent 复选框
    var checkAll = document.getElementById("checkAllStu");
    //获取所有复选框
    var rowCheck = document.querySelectorAll('td input[type="checkbox"]')
    //添加事件监听,当复选框的选中状态发生改变，需要做某件事情
    checkAll.addEventListener('change',function (){
        //是否选中
        var isChecked = this.checked;
        //遍历，迭代
        rowCheck.forEach(checkbox => checkbox.checked =isChecked)
    })

</script>