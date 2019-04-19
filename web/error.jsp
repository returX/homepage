<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/4/17
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出错了</title>
</head>
<body>
    <%String msg = (String) request.getAttribute("msg");%>
    <h1><%=msg%></h1>
    <form action='/Register.jsp' method='post'>
        <input type="submit" value="返回注册"/>
        <input type="submit" value="返回登录" formaction="/index.jsp"/>
</body>
</html>
