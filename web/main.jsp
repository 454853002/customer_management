<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: FUYU
  Date: 2021/3/26
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户信息管理系统</title>
</head>
<body>
     <h3 align="center">客户信息管理系统</h3>
    <form action="<%=request.getContextPath()%>/user" method=post>
    <table id="table" border="1" align="center" >
           <tr>
               <th>ID</th>
               <th>姓名</th>
               <th>性别</th>
               <th>出生日期</th>
               <th>电话</th>
               <th>备注</th>
               <th>修改</th>
               <th>删除</th>
           </tr>
          <%
              Map<String, String> ids = (Map<String, String>) request.getAttribute("ids");
              Map<String, String> names = (Map<String, String>) request.getAttribute("names");
              Map<String, String> sexes = (Map<String, String>) request.getAttribute("sexes");
              Map<String, String> births = (Map<String, String>) request.getAttribute("births");
              Map<String, String> phones = (Map<String, String>) request.getAttribute("phones");
              Map<String, String> notes = (Map<String, String>) request.getAttribute("notes");

              for (int i = 0; i < ids.size(); i++) {
                  out.println("<tr onmousemove=\"test(this)\" ><td >"+ids.get(String.valueOf(i))+"</td>");
                  out.println("<td>"+names.get(String.valueOf(i))+"</td>");
                  out.println("<td>"+sexes.get(String.valueOf(i))+"</td>");
                  out.println("<td>"+births.get(String.valueOf(i))+"</td>");
                  out.println("<td>"+phones.get(String.valueOf(i))+"</td>");
                  out.println("<td>"+notes.get(String.valueOf(i))+"</td>");
                  out.println("<td>   <a href=\"#\" onclick=\"update()\">修改</a></td>");
                  out.println("<td><a href=\"#\"    onclick=\"del()\"  >删除</a></td>");
              }
          %>
    </table>
</form>
<form  action="<%=request.getContextPath()%>/reupdate" method=post>
    <div align="center">
        姓名：<input name="name" type="text"  width="100px"/>
        <select name="select_sex">
            <option  name ="sex_m">男</option>
            <option  name="sex_f">女</option>
        </select>
        出生日期：<input name="birthday" type="text"  width="100px"/>
        <input type="submit" value="查询">
        <a href="adduser.jsp"><input  style="margin-left:50px;margin-bottom: 20px "  type="button"  width="100px" value="增加用户"/></a>
    </div>

</form>


</body>
 <script type="text/javascript">
     var  id,name,sex,birth,phone,note;
     function test(obj) {
          id = encodeURI(obj.getElementsByTagName("td")[0].innerHTML);
          name =encodeURI(obj.getElementsByTagName("td")[1].innerHTML);
          sex =encodeURI(obj.getElementsByTagName("td")[2].innerHTML);
          birth =encodeURI(obj.getElementsByTagName("td")[3].innerHTML);
          phone =encodeURI(obj.getElementsByTagName("td")[4].innerHTML);
          note =encodeURI(obj.getElementsByTagName("td")[5].innerHTML);
     }
     function update() {
         console.log(id);
         location.href='update.jsp?'+'&'+id+'&'+name+'&'+sex+'&'+birth+'&'+phone+'&'+note;
     }
     function del(){
         location.href='delete.jsp?&'+id;
     }

 </script>
</html>
