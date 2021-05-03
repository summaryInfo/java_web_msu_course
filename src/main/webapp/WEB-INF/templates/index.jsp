<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Hello</title>
    </head>
<body>
    <c:forEach items="${ints}" var="item">
        ${item}<br>
    </c:forEach>
</body>
</html>

