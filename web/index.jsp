
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>user</title>
</head>
<%
  pageContext.setAttribute("ctx",request.getContextPath());
%>
<body>
<form action="${ctx}/user" method="post">
  编号：<input type="text" name="id"><br>
  姓名：<input type="text" name="name"><br>
  年龄：<input type="text" name="age"><br>
  性别：<input type="text" name="gender"><br>
  省份：<input type="text" name="address.province"><br>
  城市：<input type="text" name="address.city"><br>
  区域：<input type="text" name="address.town"><br>
  <input type="submit" value="提交"><br>
</form>
</body>
</html>
