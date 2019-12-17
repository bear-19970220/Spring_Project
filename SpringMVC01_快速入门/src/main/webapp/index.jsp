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
你好，${requestScope.message}

<a href="${pageContext.request.contextPath}/demoC.smvc">点击</a>
</body>
</html>
