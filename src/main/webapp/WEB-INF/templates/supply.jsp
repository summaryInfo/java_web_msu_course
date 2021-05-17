<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <link href="res/style.css" rel="stylesheet" type="text/css">
        <title>Supplies View</title>
        <style>
            .toggle-label span { width: 15.33%; }
            .table-header > span { width: 15.53%; }
        </style>
    </head>
    <body>
        <div class="collapsible-table">
            <form class="table-query" method="GET" action="supply">
                <span>
                    <label for="id"> ID </label>
                    <input type="number" id="query_id" name="id" value="${idvalue}">
                </span>
                <span>
                    <label for="provider"> Provider </label>
                    <input type="number" id="query_provider" name="provider" value="${providervalue}">
                </span>
                <span>
                    <label for="product"> Product </label>
                    <input type="number" id="query_product" name="product" value="${productvalue}">
                </span>
                <span>
                    <label for="amount"> Amount From </label>
                    <input type="number" step="any" id="query_amount" name="amount" value="${amountvalue}">
                </span>
                <span>
                    <label for="amounthi"> Amount To </label>
                    <input type="number" step="any" id="query_amounthi" name="amounthi" value="${amounthivalue}">
                </span>
                <span>
                    <label for="time"> Time From </label>
                    <input type="text" pattern="\d{1,4}-\d{2}-\d{2} \d{1,2}:\d{1,2}:\d{1,2}" id="query_time" name="time" value="${timevalue}">
                </span>
                <span>
                    <label for="timehi"> Time To </label>
                    <input type="text" pattern="\d{1,4}-\d{2}-\d{2} \d{1,2}:\d{1,2}:\d{1,2}" id="query_timehi" name="timehi" value="${timehivalue}">
                </span>
                <span>
                    <label for="completed"> Completed </label>
                    <select type="checkbox" id="query_completed" name="completed" value="${completedvalue}">
                        <option value="">Any</option>
                        <option value="true"  ${completedvalue == "true" ? "selected" : ""}>True</option>
                        <option value="false"  ${completedvalue == "false" ? "selected" : ""}>False</option>
                    </select>
                </span>
                <input type="submit" name="query" id="query_query" value="Apply query"/>
                <input type="submit" name="create" id="query_create" value="+" formaction="supply_applyedit" formmethod="POST"/>
            </form>
            <c:if test="${errormsg.length() > 0}">
                <div class="error">
                    ${errormsg}
                </div>
            </c:if>
            <div class="table-header">
                <span> ID </span>
                <span> Provider </span>
                <span> Product </span>
                <span> Amount </span>
                <span> Time </span>
                <span> Completed </span>
            </div>
            <c:forEach items="${cats}" var="item">
                <input id="collapsible-${item.supplyId}" class="toggle" type="checkbox">
                <label for="collapsible-${item.supplyId}" class="toggle-label">
                    <span> ${item.supplyId} </span>
                    <span> <a href="provider?id=${item.provider.providerId}">${item.provider.providerId}</a> </span>
                    <span> <a href="product?id=${item.product.productId}">${item.product.productId}</a> </span>
                    <span> ${item.amount} </span>
                    <span> ${formatter.format(item.time)} </span>
                    <span> ${item.completed} </span>
                </label>
                <div id="collapsible-content-${item.supplyId}" class="collapsible-content">
                    <div class="content-inner">
                        <form method="POST" action="supply_applyedit">
                            <input type="hidden" name="qid" value="${item.supplyId}">
                            <span>
                                <label for="provider"> Provider </label>
                                <input type="text" name="provider" value="${item.provider.providerId}">
                            </span>
                            <span>
                                <label for="product"> Product </label>
                                <input type="text" name="product" value="${item.product.productId}">
                            </span>
                            <span>
                                <label for="amount"> Amount </label>
                                <input type="text" name="amount" value="${item.amount}">
                            </span>
                            <span>
                                <label for="datetime-local"> Time </label>
                                <input type="text" name="time" value="${formatter.format(item.time)}">
                            </span>
                            <span>
                                <label for="completed"> Completed </label>
                                <input type="checkbox" name="completed" value="true" ${item.completed ? "checked" : ""}>
                            </span>
                            <input type="submit" name="edit" value="Apply edit"/>
                            <input type="submit" name="delete" value="Delete" formaction="supply_delete"/>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
