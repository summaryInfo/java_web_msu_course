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
            <form class="table-query" method="GET" action="productcat">
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
                <input type="submit" name="query" value="Apply query"/>
                <input type="submit" name="create" value="+" formaction="productcat_applyedit" formmethod="POST"/>
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
                        <form method="POST" action="productcat_applyedit">
                            <input type="hidden" id="qid", name="qid", value="${item.categoryId}">
                            <span>
                                <label for="name"> Name </label>
                                <input type="text" id="name" name="name" value="${item.name}">
                            </span>
                            <span>
                                <label for="name"> Description </label>
                                <input type="text" id="description" name="description" value="${item.description}">
                            </span>
                            <input type="submit" name="edit" value="Apply edit"/>
                            <input type="submit" name="delete" value="Delete" formaction="productcat_delete"/>
                        </form>
                    </div>
                </div>
                </c:forEach>
        </div>
    </body>
</html>

