<%@ page import="com.model.user.User" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/4/12
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
    <%User u = (User)request.getSession().getAttribute("user");%>
    <h1>欢迎登录,<%=u.getUname()%></h1>
</body>
</html>
