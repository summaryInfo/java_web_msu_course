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
                    <input type="number" id="id" name="id" value="${idvalue}">
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
                    <label for="arrivallo"> Arrival From </label>
                    <input type="text" pattern="\d{1,4}-\d{2}-\d{2} \d{1,2}:\d{1,2}:\d{1,2}" id="arrivallo" name="arrivallo" value="${arrivallovalue}">
                </span>
                <span>
                    <label for="arrivalhi"> Arrival To </label>
                    <input type="text" pattern="\d{1,4}-\d{2}-\d{2} \d{1,2}:\d{1,2}:\d{1,2}" id="arrivalhi" name="arrivalhi" value="${arrivalhivalue}">
                </span>
                <span>
                    <label for="expireslo"> Expires From </label>
                    <input type="text" pattern="\d{1,4}-\d{2}-\d{2} \d{1,2}:\d{1,2}:\d{1,2}" id="expireslo" name="expireslo" value="${expireslovalue}">
                </span>
                <span>
                    <label for="expireshi"> Expires To </label>
                    <input type="text" pattern="\d{1,4}-\d{2}-\d{2} \d{1,2}:\d{1,2}:\d{1,2}" id="expireshi" name="expireshi" value="${expireshivalue}">
                </span>
                <span>
                    <label for="room"> Room </label>
                    <input type="number" id="room" name="room" value="${roomvalue}">
                </span>
                <span>
                    <label for="shelf"> Shelf </label>
                    <input type="number" id="shelf" name="shelf" value="${shelfvalue}">
                </span>
                <span>
                    <label for="source"> Source </label>
                    <input type="number" id="source" name="source" value="${sourcevalue}">
                </span>
                <span>
                    <label for="destination"> Destination </label>
                    <input type="number" id="destination" name="destination" value="${destinationvalue}">
                </span>
                <input type="submit" name="query" value="Apply query"/>
                <input type="submit" name="create" value="+" formaction="instance_applyedit" formmethod="POST"/>
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
                    <span> ${formatter.format(item.arrival)} </span>
                    <span> ${formatter.format(item.expires)} </span>
                    <span> ${item.roomNo} </span>
                    <span> ${item.shelfNo} </span>
                    <span> <a href="supply?id=${item.source == null ? '' : item.source.supplyId}">${item.source == null ? '' : item.source.supplyId}</a> </span>
                    <span> <a href="orider?id=${item.destination == null ? '' : item.destination.orderId}">${item.destination == null ? '' : item.destination.orderId}</a> </span>
                </label>
                <div class="collapsible-content">
                    <div class="content-inner">
                        <form method="POST" action="instance_applyedit">
                            <input type="hidden" id="qid", name="qid", value="${item.instanceId}">
                            <span>
                                <label for="product"> Product </label>
                                <input type="number" id="product" product="product" value="${item.product.productId}">
                            </span>
                            <span>
                                <label for="amount"> Amount </label>
                                <input type="number" step="any" id="amount" name="amount" value="${item.amount}">
                            </span>
                            <span>
                                <label for="arrival"> Arrival </label>
                                <input type="datetime-local" id="arrival" name="arrival" value="${formatter.format(item.arrival)}">
                            </span>
                            <span>
                                <label for="expires"> Expires </label>
                                <input type="datetime-local" id="expires" name="expires" value="${formatter.format(item.expires)}">
                            </span>
                            <span>
                                <label for="room"> Room </label>
                                <input type="number" id="room" name="room" value="${item.roomNo}">
                            </span>
                            <span>
                                <label for="shelf"> Shelf </label>
                                <input type="number" id="shelf" name="shelf" value="${item.shelfNo}">
                            </span>
                            <span>
                                <label for="source"> Source </label>
                                <input type="number" id="source" name="source" value="${item.source == null ? '' : item.source.supplyId}">
                            </span>
                            <span>
                                <label for="destination"> Destination </label>
                                <input type="text" id="destination" name="destination" value="${item.destination == null ? '' : item.destination.orderId}">
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

