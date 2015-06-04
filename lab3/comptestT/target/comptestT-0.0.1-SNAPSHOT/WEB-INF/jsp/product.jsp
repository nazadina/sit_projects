<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Изделие</title>
        <link rel="stylesheet" href="CSS/page.css" type="text/css">
        <link rel="stylesheet" href="CSS/bootstrap.css" type="text/css">
    </head>
    <body>
        <h1>
            Список изделий
            <a href="${pageContext.request.contextPath}/index"><button class="btn btn-primary" style="width: 230px">На главную</button></a>
            <ul class="nav navbar-nav navbar-right">
                <spring:message code="user.logged" />: <sec:authentication property="name"/> <sec:authentication property="authorities"/>
                <a href="logout"><button class="btn btn-primary" style="width: 100px; margin-right: 10px">Выход</button></a>
            </ul>
        </h1>
        <form:form action="product.do" method="POST" commandName="product">
            <table style="float: left">
                <tr>
                    <td valign="middle">
                        №:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="ID" style="width: 200px;"<form:input  path="id" />
                    </td>
                    <td colspan="2">
                        <button class="btn btn-primary" id="btn" type="submit" name="action" value="Add" style="width: 150px;">Добавить</button>
                        <button class="btn btn-primary" type="submit" name="action" value="Edit" style="width: 150px;">Изменить</button>
                        <button class="btn btn-primary" type="submit" name="action" value="Delete" style="width: 150px;">Удалить</button>
                        <button class="btn btn-primary" type="submit" name="action" value="Search" style="width: 150px;">Найти</button>
                    </td>
                </tr>
                <tr>
                    <td valign="middle">
                        Наименование:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Наименование" style="width: 200px;"<form:input  path="name" />
                    </td>
                    <td valign="middle">
                        Количество:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Количество" style="width: 200px;"<form:input  path="count" />
                    </td>
                    <td valign="middle">
                        Артикул:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Артикул" style="width: 200px;"<form:input  path="article" />
                    </td>
                </tr>
                <tr>
                    <td valign="middle">
                        Описание:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Описание" style="width: 200px;"<form:input  path="description" />
                    </td>
                    <td valign="middle">
                        Вес:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Вес" style="width: 200px;"<form:input  path="weight" />
                    </td>
                    <td valign="middle">
                        Номер заказа:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Номер заказа" style="width: 200px;"<form:input  path="orderId" />
                    </td>
                </tr>
            </table>
        </form:form>
        <br>
        <div class="scrollbar" id="style-default" style="height: 550px">
            <table style="height: 100%; width: 100%;">
                <td style="vertical-align:top">
                    <table class="table table-bordered">
                        <th>№</th>
                        <th>Наименование</th>
                        <th>Количество</th>
                        <th>Артикул</th>
                        <th>Описание</th>
                        <th>Вес</th>
                        <th>Номер заказа</th>
                            <c:forEach items="${productList}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.count}</td>
                                <td>${product.article}</td>
                                <td>${product.description}</td>
                                <td>${product.weight}</td>
                                <td>${product.orderId}</td>
                            </tr>
                        </c:forEach>
                    </table>
            </table>
        </div>
    </body>
</html>