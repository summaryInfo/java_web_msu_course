<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <link href="res/style.css" rel="stylesheet" type="text/css">
        <title>Orders View</title>
        <style>
            .toggle-label span { width: 23%; }
            .table-head > span { width: 23.3%; }
        </style>
    </head>
    <body>
        <div class="collapsible-table">
            <form class="table-query" method="GET" action="order">
                <span>
                    <label for="id"> ID </label>
                    <input type="text" id="id" name="id" value="${idvalue}">
                </span>
                <span>
                    <label for="consumer"> Consumer </label>
                    <input type="number" id="consumer" consumer="consumer" value="${consumervalue}">
                </span>
                <span>
                    <label for="product"> Product </label>
                    <input type="number" id="product" name="product" value="${productvalue}">
                </span>
                <span>
                    <label for="amountlo"> Amount From </label>
                    <input type="number" step="any" id="amountlo" name="amountlo" value="${amountlovalue}">
                </span>
                <span>
                    <label for="amounthi"> Amount To </label>
                    <input type="number" step="any" id="amounthi" name="amounthi" value="${amounthivalue}">
                </span>
                <span>
                    <label for="timelo"> Time From </label>
                    <input type="datetime-local" id="timelo" name="timelo" value="${timelovalue}">
                </span>
                <span>
                    <label for="timehi"> Time To </label>
                    <input type="datetime-local" id="timehi" name="timehi" value="${timehivalue}">
                </span>
                <span>
                    <label for="completed"> Completed </label>
                    <select type="checkbox" id="completed" name="completed" value="${completedvalue}">
                        <option value="">Any</option>
                        <option value="true">True</option>
                        <option value="false">False</option>
                    </select>
                </span>
                <input type="submit" name="query" value="Apply query"/>
                <input type="submit" name="create" value="+" formaction="order_applyedit" formmethod="POST"/>
            </form>
            <c:if test="${errormsg.length() > 0}">
                <div class="error">
                    ${errormsg}
                </div>
            </c:if>
            <div class="table-header">
                <span> ID </span>
                <span> Consumer </span>
                <span> Product </span>
                <span> Amount </span>
                <span> Time </span>
                <span> Completed </span>
            </div>
            <c:forEach items="${cats}" var="item">
                <input id="collapsible-${item.orderId}" class="toggle" type="checkbox">
                <label for="collapsible-${item.orderId}" class="toggle-label">
                    <span> ${item.orderId} </span>
                    <span> ${item.consumerId} </span>
                    <span> ${item.productId} </span>
                    <span> ${item.amount} </span>
                    <span> ${item.time} </span>
                    <span> ${item.completed} </span>
                </label>
                <div class="collapsible-content">
                    <div class="content-inner">
                        <form method="POST" action="order_applyedit">
                            <input type="hidden" id="qid", name="qid", value="${item.orderId}">
                            <span>
                                <label for="consumer"> Consumer </label>
                                <input type="number" id="consumer" name="consumer" value="${item.consumerId}">
                            </span>
                            <span>
                                <label for="product"> Product </label>
                                <input type="number" id="product" name="product" value="${item.productId}">
                            </span>
                            <span>
                                <label for="amount"> Amount </label>
                                <input type="number" step="any" id="amount" name="amount" value="${item.amount}">
                            </span>
                            <span>
                                <label for="time"> Time </label>
                                <input type="datetime-local" id="time" name="time" value="${item.time}">
                            </span>
                            <span>
                                <label for="completed"> Completed </label>
                                <input type="checkbox" id="completed" name="completed" value="${item.completed}">
                            </span>
                            <input type="submit" name="edit" value="Apply edit"/>
                            <input type="submit" name="delete" value="Delete" formaction="order_delete"/>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>

