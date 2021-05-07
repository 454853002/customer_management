<%--
  Created by IntelliJ IDEA.
  User: FUYU
  Date: 2021/3/26
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
        <h3  align="center">登录页面</h3>
        <%//显示信息
            String msg = (String) request.getAttribute("message");
            if(msg != null){
                out.println(msg);
            }
        %>
        <form name=loginForm action="<%=request.getContextPath()%>/login" method=post>
                  <table align="center">
                <tr>
                       <td>用户名：</td><td><input type=text name=username /></td>
                     </tr>
                      <tr>
                     <td>密码：</td><td><input type=password name=password /></td>
                    <tr/>
                    <tr>
                     <td colspan="2",align="center">

                         <input     type="submit" value="登录" />
                         <a href="register.jsp"><input type="button"  style="margin-left: 100px" value="注册"></a>
                     </td>
             </tr>
             </table>
         </form>
  </body>
</html>
