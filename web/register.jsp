<%--
  Created by IntelliJ IDEA.
  User: FUYU
  Date: 2021/3/27
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h3 align="center">注册账号</h3>
<form name=loginForm action="<%=request.getContextPath()%>/register" method=post>
    <table align="center">
        <tr>
            <td>用户名：</td><td><input type=text name=username /></td>
        </tr>
        <tr>
            <td>密码：</td><td><input type=password name=password /></td>
        <tr/>
        <tr>
            <td colspan="2",align="center">
                <input     type="submit" value="注册" />
                <a href="index.jsp"><input type="button"  style="margin-left: 100px" value="返回"></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
