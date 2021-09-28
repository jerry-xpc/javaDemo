<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2020/3/14
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("ctx",request.getContextPath());
%>

<body>
欢迎加入马士兵教育
${hello}<br>
request:${requestScope.request}<br/>
session:${sessionScope.request}<br/>
<h>-----------</h><br>
session:${sessionScope.userName}<br>
request:${requestScope.userName}<br>
<img src="${ctx}/imge/1.jpg">
</body>
</html>
