<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1"/>
        <link href="res/style.css" rel="stylesheet" type="text/css">
        <title>Providers View</title>
    </head>
    <body>
        <div class="collapsible-table">
            <form class="table-query" method="GET" action="provider">
                <span>
                    <label for="id"> ID </label>
                    <input type="text" id="id" name="id" value="${idvalue}">
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
                    <label for="address"> Address </label>
                    <input type="text" id="address" name="address" value="${addressvalue}">
                </span>
                <span>
                    <label for="tel"> Phone </label>
                    <input type="text" id="tel" name="tel" value="${telvalue}">
                </span>
                <span>
                    <label for="email"> E-Mail </label>
                    <input type="text" id="email" name="email" value="${emailvalue}">
                </span>
                <input type="submit" name="query" value="Apply query"/>
                <input type="submit" name="create" value="+" formaction="provider_applyedit" formmethod="POST"/>
            </form>
            <div class="table-header">
                <span> ID </span>
                <span> Name </span>
                <span> Description </span>
                <span> Address </span>
                <span> Phone </span>
                <span> E-Mail </span>
            </div>
            <c:forEach items="${cats}" var="item">
                <input id="collapsible-${item.providerId}" class="toggle" type="checkbox">
                <label for="collapsible-${item.providerId}" class="toggle-label">
                    <span> ${item.providerId} </span>
                    <span> ${item.name} </span>
                    <span> ${item.description} </span>
                    <span> ${item.address} </span>
                    <span> ${item.tel} </span>
                    <span> ${item.email} </span>
                </label>
                <div class="collapsible-content">
                    <div class="content-inner">
                        <form method="POST" action="provider_applyedit">
                            <input type="hidden" id="qid", name="qid", value="${item.providerId}">
                            <span>
                                <label for="name"> Name </label>
                                <input type="text" id="name" name="name" value="${item.name}">
                            </span>
                            <span>
                                <label for="description"> Description </label>
                                <input type="text" id="description" name="description" value="${item.description}">
                            </span>
                            <span>
                                <label for="address"> Address </label>
                                <input type="text" id="address" name="address" value="${item.address}">
                            </span>
                            <span>
                                <label for="tel"> Phone </label>
                                <input type="text" id="tel" name="tel" value="${item.tel}">
                            </span>
                            <span>
                                <label for="email"> E-Mail </label>
                                <input type="text" id="email" name="email" value="${item.email}">
                            </span>
                            <input type="submit" name="edit" value="Apply edit"/>
                            <input type="submit" name="delete" value="Delete" formaction="provider_delete"/>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
