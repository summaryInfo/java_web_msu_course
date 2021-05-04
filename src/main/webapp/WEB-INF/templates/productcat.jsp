<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <link href="res/style.css" rel="stylesheet" type="text/css">
        <title>Product Categories View</title>
    </head>
    <body>
        <div class="collapsible-table">
            <form class="table-query">
                <span>
                    <label for="id"> ID </label>
                    <input type="text" id="id" name="id" value="${idvalue}">
                </span>
                <span>
                    <label for="name"> Name </label>
                    <input type="text" id="name" name="name" value="${namevalue}">
                </span>
                <span>
                    <label for="name"> Description </label>
                    <input type="text" id="description" name="description" value="${descriptionvalue}">
                </span>
                <input type="submit" value="Apply query" formaction="productcat" method="get"/>
            </form>
            <div class="table-header">
                <span> ID </span>
                <span> Name </span>
                <span> Description </span>
            </div>
            <c:forEach items="${cats}" var="item">
                <input id="collapsible-${item.categoryId}" class="toggle" type="checkbox">
                <label for="collapsible-${item.categoryId}" class="toggle-label">
                    <span> ${item.categoryId} </span>
                    <span> ${item.name} </span>
                    <span> ${item.description} </span>
                </label>
                <div class="collapsible-content">
                    <div class="content-inner">
                        <p> More... (TODO) </p>
                    </div>
                </div>
                </c:forEach>
        </div>
    </body>
</html>

