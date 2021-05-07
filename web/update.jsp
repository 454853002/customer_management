<%--
  Created by IntelliJ IDEA.
  User: FUYU
  Date: 2021/3/27
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<h3 align="center">修改客户信息</h3>
<form action="<%=request.getContextPath()%>/update" method="post">
    <table align="center">
         <tr>
             <td ></td> <td><input type="hidden"  id="ID" name="ID" /></td>
         </tr>
        <tr>
            <td>姓名：</td><td><input type=text id="name" name=name /></td>
        </tr>
        <tr>
            <td>性别：</td><td><input type=text id="sex" name=sex /></td>
        <tr/>
        <tr>
            <td>出生日期：</td><td><input type=text id="birth" name=birth /></td>
        <tr/>
        <tr>
            <td>电话：</td><td><input type=text id="phone" name=phone /></td>
        <tr/>
        <tr>
            <td>备注：</td><td><input type=text id="note" name=note /></td>
        <tr/>

        <tr>
            <td colspan="2",align="center">
                <input     type="submit" value="修改" />
                <a href="${pageContext.request.contextPath}/return" style="margin-left: 180px"><input type="button" value="取消"></a>
            </td>
        </tr>
    </table>
</form>

</body>
  <script>
      var url = location.search;
      console.log(url);
      var id = decodeURI(url.split("&")[1]);
      var name =decodeURI(url.split("&")[2]);
      var sex =decodeURI(url.split("&")[3]);
      var birth =decodeURI(url.split("&")[4]);
      var phone =decodeURI(url.split("&")[5]);
      var note =decodeURI(url.split("&")[6]);
      document.getElementById("ID").value=id;
      document.getElementById("name").value = name;
      document.getElementById("sex").value = sex;
      document.getElementById("birth").value = birth;
      document.getElementById("phone").value = phone;
      document.getElementById("note").value = note;

  </script>


</html>
