<%--
  Created by IntelliJ IDEA.
  User: gjs
  Date: 2020/10/27
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello Word</title>
  </head>
  <%
    pageContext.setAttribute("ctx",request.getContextPath());
  %>
  <body>
    <form action="${ctx}/ishello" method="post">
        <input type="text" name="username" /><br>
        <input type="submit" value="提交" />
    </form>
  </body>
</html>
