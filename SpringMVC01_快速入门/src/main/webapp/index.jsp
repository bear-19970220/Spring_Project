<%--
Created by IntelliJ IDEA.
User: FTDN
Date: 2019/12/17
Time: 17:50
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
request：${requestScope.message}
session：${sessionScope.message}

<a href="${pageContext.request.contextPath}/sayHi.smvc">点击</a>

<hr/>


<form action="${pageContext.request.contextPath}/">
    <input type="checkbox" name="">



    <input type="submit" value="POJO 数组">
</form>


</body>
</html>
