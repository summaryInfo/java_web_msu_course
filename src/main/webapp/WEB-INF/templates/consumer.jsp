<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <link href="res/style.css" rel="stylesheet" type="text/css">
        <title>Consumers View</title>
        <style>
            .toggle-label span { width: 15.33%; }
            .table-header > span { width: 15.53%; }
        </style>
    </head>
    <body>
        <div class="collapsible-table">
            <form class="table-query" method="GET" action="consumer">
                <span>
                    <label for="id"> ID </label>
                    <input type="number" id="query_id" name="id" value="${idvalue}">
                </span>
                <span>
                    <label for="name"> Name </label>
                    <input type="text" id="query_name" name="name" value="${namevalue}">
                </span>
                <span>
                    <label for="description"> Description </label>
                    <input type="text" id="query_description" name="description" value="${descriptionvalue}">
                </span>
                <span>
                    <label for="address"> Address </label>
                    <input type="text" id="query_address" name="address" value="${addressvalue}">
                </span>
                <span>
                    <label for="tel"> Phone </label>
                    <input type="text" id="query_tel" name="tel" value="${telvalue}">
                </span>
                <span>
                    <label for="email"> E-Mail </label>
                    <input type="text" id="query_email" name="email" value="${emailvalue}">
                </span>
                <input type="submit" id="query_query" name="query" value="Apply query"/>
                <input type="submit" id="query_create" name="create" value="+" formaction="consumer_applyedit" formmethod="POST"/>
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
                <span> Address </span>
                <span> Phone </span>
                <span> E-Mail </span>
            </div>
            <c:forEach items="${cats}" var="item">
                <input id="collapsible-${item.consumerId}" class="toggle" type="checkbox">
                <label for="collapsible-${item.consumerId}" class="toggle-label">
                    <span> ${item.consumerId} </span>
                    <span> ${item.name} </span>
                    <span> ${item.description} </span>
                    <span> ${item.address} </span>
                    <span> ${item.tel} </span>
                    <span> ${item.email} </span>
                </label>
                <div id="collapsible-content-${item.consumerId}" class="collapsible-content">
                    <div class="content-inner">
                        <form method="POST" action="consumer_applyedit">
                            <input type="hidden" name="qid" value="${item.consumerId}">
                            <span>
                                <label for="name"> Name </label>
                                <input type="text" name="name" value="${item.name}">
                            </span>
                            <span>
                                <label for="description"> Description </label>
                                <input type="text" name="description" value="${item.description}">
                            </span>
                            <span>
                                <label for="address"> Address </label>
                                <input type="text" name="address" value="${item.address}">
                            </span>
                            <span>
                                <label for="tel"> Phone </label>
                                <input type="text" name="tel" value="${item.tel}">
                            </span>
                            <span>
                                <label for="email"> E-Mail </label>
                                <input type="text" name="email" value="${item.email}">
                            </span>
                            <input type="submit" name="edit" value="Apply edit"/>
                            <input type="submit" name="delete" value="Delete" formaction="consumer_delete"/>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>

