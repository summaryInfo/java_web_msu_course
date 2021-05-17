<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <link href="res/style.css" rel="stylesheet" type="text/css">
        <title>Product Instances View</title>
        <style>
            .toggle-label span { width: 10.22%; }
            .table-header > span { width: 10.35%; }
        </style>
    </head>
    <body>
        <div class="collapsible-table">
            <form class="table-query" method="GET" action="instance">
                <span>
                    <label for="id"> ID </label>
                    <input type="number" id="query_id" name="id" value="${idvalue}">
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
                    <label for="arrival"> Arrival From </label>
                    <input type="text" pattern="\d{1,4}-\d{2}-\d{2} \d{1,2}:\d{1,2}:\d{1,2}" id="query_arrival" name="arrival" value="${arrivalvalue}">
                </span>
                <span>
                    <label for="arrivalhi"> Arrival To </label>
                    <input type="text" pattern="\d{1,4}-\d{2}-\d{2} \d{1,2}:\d{1,2}:\d{1,2}" id="query_arrivalhi" name="arrivalhi" value="${arrivalhivalue}">
                </span>
                <span>
                    <label for="expires"> Expires From </label>
                    <input type="text" pattern="\d{1,4}-\d{2}-\d{2} \d{1,2}:\d{1,2}:\d{1,2}" id="query_expires" name="expires" value="${expiresvalue}">
                </span>
                <span>
                    <label for="expireshi"> Expires To </label>
                    <input type="text" pattern="\d{1,4}-\d{2}-\d{2} \d{1,2}:\d{1,2}:\d{1,2}" id="query_expireshi" name="expireshi" value="${expireshivalue}">
                </span>
                <span>
                    <label for="room"> Room </label>
                    <input type="number" id="query_room" name="room" value="${roomvalue}">
                </span>
                <span>
                    <label for="shelf"> Shelf </label>
                    <input type="number" id="query_shelf" name="shelf" value="${shelfvalue}">
                </span>
                <span>
                    <label for="source"> Source </label>
                    <input type="number" id="query_source" name="source" value="${sourcevalue}">
                </span>
                <span>
                    <label for="destination"> Destination </label>
                    <input type="number" id="query_destination" name="destination" value="${destinationvalue}">
                </span>
                <input type="submit" id="query_query" name="query" value="Apply query"/>
                <input type="submit" id="query_create" name="create" value="+" formaction="instance_applyedit" formmethod="POST"/>
            </form>
            <c:if test="${errormsg.length() > 0}">
                <div class="error">
                    ${errormsg}
                </div>
            </c:if>
            <div class="table-header">
                <span> ID </span>
                <span> Product </span>
                <span> Amount </span>
                <span> Arrival </span>
                <span> Expires </span>
                <span> Room </span>
                <span> Shelf </span>
                <span> Source </span>
                <span> Destination </span>
            </div>
            <c:forEach items="${cats}" var="item">
                <input id="collapsible-${item.instanceId}" class="toggle" type="checkbox">
                <label for="collapsible-${item.instanceId}" class="toggle-label">
                    <span> ${item.instanceId} </span>
                    <span> <a href="product?id=${item.product.productId}">${item.product.productId}</a> </span>
                    <span> ${item.amount} </span>
                    <span> ${item.arrival == null ? "" : formatter.format(item.arrival)} </span>
                    <span> ${item.expires == null ? "" : formatter.format(item.expires)} </span>
                    <span> ${item.roomNo} </span>
                    <span> ${item.shelfNo} </span>
                    <span> <a href="supply?id=${item.source == null ? '' : item.source.supplyId}">${item.source == null ? '' : item.source.supplyId}</a> </span>
                    <span> <a href="orider?id=${item.destination == null ? '' : item.destination.orderId}">${item.destination == null ? '' : item.destination.orderId}</a> </span>
                </label>
                <div id="collapsible-content-${item.instanceId}" class="collapsible-content">
                    <div class="content-inner">
                        <form method="POST" action="instance_applyedit">
                            <input type="hidden" name="qid" value="${item.instanceId}">
                            <span>
                                <label for="product"> Product </label>
                                <input type="number" product="product" value="${item.product.productId}">
                            </span>
                            <span>
                                <label for="amount"> Amount </label>
                                <input type="number" step="any" name="amount" value="${item.amount}">
                            </span>
                            <span>
                                <label for="arrival"> Arrival </label>
                                <input type="datetime-local" name="arrival" value="${item.arrival == null ? "" : formatter.format(item.arrival)}">
                            </span>
                            <span>
                                <label for="expires"> Expires </label>
                                <input type="datetime-local" name="expires" value="${item.expires == null ? "" : formatter.format(item.expires)}">
                            </span>
                            <span>
                                <label for="room"> Room </label>
                                <input type="number" name="room" value="${item.roomNo}">
                            </span>
                            <span>
                                <label for="shelf"> Shelf </label>
                                <input type="number" name="shelf" value="${item.shelfNo}">
                            </span>
                            <span>
                                <label for="source"> Source </label>
                                <input type="number" name="source" value="${item.source == null ? '' : item.source.supplyId}">
                            </span>
                            <span>
                                <label for="destination"> Destination </label>
                                <input type="text" name="destination" value="${item.destination == null ? '' : item.destination.orderId}">
                            </span>
                            <input type="submit" name="edit" value="Apply edit"/>
                            <input type="submit" name="delete" value="Delete" formaction="instance_delete"/>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>

