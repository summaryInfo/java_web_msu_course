<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <link href="res/style.css" rel="stylesheet" type="text/css">
        <title>Products View</title>
        <style>
            .toggle-label span { width: 15.3%; }
            .table-header > span { width: 15.53%; }
        </style>
    </head>
    <body>
        <div class="collapsible-table">
            <form class="table-query" method="GET" action="product">
                <span>
                    <label for="id"> ID </label>
                    <input type="number" id="id" name="id" value="${idvalue}">
                </span>
                <span>
                    <label for="name"> Name </label>
                    <input type="text" id="name" name="name" value="${namevalue}">
                </span>
                <span>
                    <label for="description"> Description </label>
                    <input type="text" id="description" name="description" value="${descriptionvalue}">
                </span>
                <span>
                    <label for="category"> Category </label>
                    <input type="number" id="category" name="category" value="${categoryvalue}">
                </span>
                <span>
                    <label for="unit"> Unit </label>
                    <input type="text" id="unit" name="unit" value="${unitvalue}">
                </span>
                <span>
                    <label for="oversized"> Oversized </label>
                    <select type="text" id="oversized" name="oversized" value="${oversizedvalue}">
                        <option value="">Any</option>
                        <option value="true"  ${oversizedvalue == "true" ? "selected" : ""}>True</option>
                        <option value="false"  ${oversizedvalue == "false" ? "selected" : ""}>False</option>
                    </select>
                </span>
                <input type="submit" name="query" value="Apply query"/>
                <input type="submit" name="create" value="+" formaction="product_applyedit" formmethod="POST"/>
            </form>
            <c:if test="${errormsg.length() > 0}">
                <div class="error">
                    ${errormsg}
                </div>
            </c:if>
            <div class="table-header">
                <span> ID </span>
                <span> Name </span>
                <span> Description </span>
                <span> Category </span>
                <span> Unit </span>
                <span> Oversized </span>
            </div>
            <c:forEach items="${cats}" var="item">
                <input id="collapsible-${item.productId}" class="toggle" type="checkbox">
                <label for="collapsible-${item.productId}" class="toggle-label">
                    <span> ${item.productId} </span>
                    <span> ${item.name} </span>
                    <span> ${item.description} </span>
                    <span> <a href="productcat?id=${item.category.categoryId}">${item.category.categoryId}</a> </span>
                    <span> ${item.unit} </span>
                    <span> ${item.oversized} </span>
                </label>
                <div class="collapsible-content">
                    <div class="content-inner">
                        <form method="POST" action="product_applyedit">
                            <input type="hidden" id="qid", name="qid", value="${item.productId}">
                            <span>
                                <label for="name"> Name </label>
                                <input type="text" id="name" name="name" value="${item.name}">
                            </span>
                            <span>
                                <label for="description"> Description </label>
                                <input type="text" id="description" name="description" value="${item.description}">
                            </span>
                            <span>
                                <label for="category"> Category </label>
                                <input type="number" id="category" name="category" value="${item.category.categoryId}">
                            </span>
                            <span>
                                <label for="unit"> Unit </label>
                                <input type="text" id="unit" name="unit" value="${item.unit}">
                            </span>
                            <span>
                                <label for="oversized"> Oversized </label>
                                <input type="checkbox" id="oversized" name="oversized" ${item.oversized ? "checked" : ""}>
                            </span>
                            <input type="submit" name="edit" value="Apply edit"/>
                            <input type="submit" name="delete" value="Delete" formaction="product_delete"/>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>

