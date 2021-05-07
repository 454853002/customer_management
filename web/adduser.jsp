<%--
  Created by IntelliJ IDEA.
  User: FUYU
  Date: 2021/3/27
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户信息管理表</title>
</head>
<body>
    <h3 align="center">添加客户信息</h3>
    <form action="<%=request.getContextPath()%>/add" method="post">
        <table align="center">
            <tr>
                <td>姓名：</td><td><input type=text name=name /></td>
            </tr>
            <tr>
                <td>性别：</td><td><input type=text name=sex /></td>
            <tr/>
            <tr>
                <td>出生日期：</td><td><input type=password name=birth /></td>
            <tr/>
            <tr>
                <td>电话：</td><td><input type=password name=phone /></td>
            <tr/>
            <tr>
                <td>备注：</td><td><input type=password name=note /></td>
            <tr/>

            <tr>
                <td colspan="2",align="center">
                    <input     type="submit" value="添加" />
                    <a href="${pageContext.request.contextPath}/return"  style="margin-left: 200px"><input type="button" value="取消"></a>
                </td>
            </tr>
        </table>
    </form>
 </body>
</html>
