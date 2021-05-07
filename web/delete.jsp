<%--
  Created by IntelliJ IDEA.
  User: FUYU
  Date: 2021/3/28
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <form action="${pageContext.request.contextPath}/delete" method="post">
          <table>
              <tr>
                  <td><a href="">你是否要删除该条数据？</a></td>
                  <td><input type="hidden"  id="ID" name="ID" value="12"/></td>
              </tr>
              <tr>
                  <td colspan="2",align="center">
                      <input     type="submit" value="确认" />
                      <a href="${pageContext.request.contextPath}/return"><input type="button" value="取消"></a>
                  </td>
              </tr>
          </table>

      </form>
</body>
<script>
    var url = location.search;
    console.log(url);
    var id = decodeURI(url.split("&")[1]);
    document.getElementById("ID").value=id;
    console.log(id)
</script>

</html>
