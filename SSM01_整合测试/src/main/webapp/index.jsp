<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/12/20
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录</h1>
<form action="${pageContext.request.contextPath}/" method="post">
    <input type="text" name="username" value="root"/>
    <input type="text" name="password" value="123456"/>
    <input type="submit" value="登录"/>
</form>

</body>
</html>
