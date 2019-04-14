<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/4/12
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/Login.do" method="post">
        <input type="text" name="uname">
        <input type="password" name="pwd">
        <input type="submit" value="登录">
    </form>
    <a href="/Register.do">注册</a>
</body>
</html>
