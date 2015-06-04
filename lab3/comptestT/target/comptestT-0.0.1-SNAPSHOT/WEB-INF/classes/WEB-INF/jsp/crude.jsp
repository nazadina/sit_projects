<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Сырье</title>
        <link rel="stylesheet" href="CSS/page.css" type="text/css">
        <link rel="stylesheet" href="CSS/bootstrap.css" type="text/css">
    </head>
    <body>
        <h1>
            Список сырья
            <a href="${pageContext.request.contextPath}/index"><button class="btn btn-primary" style="width: 270px">На главную</button></a>
            <ul class="nav navbar-nav navbar-right">
                <spring:message code="user.logged" />: <sec:authentication property="name"/> <sec:authentication property="authorities"/>
                <a href="logout"><button class="btn btn-primary" style="width: 100px; margin-right: 10px">Выход</button></a>
            </ul>
        </h1>
        <form:form action="Crude.do" method="POST" commandName="crude">
            <table style="float: left">
                <tr>
                    <td valign="middle">
                        №:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="ID" style="width: 150px;"<form:input  path="id" />
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
                        <input class="form-control" placeholder="Наименование" style="width: 150px;"<form:input  path="name" />
                    </td>
                    <td valign="middle">
                        Артикул:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Артикул" style="width: 150px;"<form:input  path="article" />
                    </td>
                    <td valign="middle">
                        Количество:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Количество" style="width: 150px;"<form:input  path="amount" />
                    </td>
                </tr>
                <tr>
                    <td valign="middle">
                        Стоимость:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Стоимость" style="width: 150px;"<form:input  path="cost" />
                    </td>
                    <td valign="middle">
                        Заметки:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Заметки" style="width: 150px;"<form:input  path="note" />
                    </td>
                    <td valign="middle">
                        Номер изделия:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Номер изделия" style="width: 150px;"<form:input  path="productId" />
                    </td>
                </tr>
            </table>
        </form:form>
        <br>
        <div class="scrollbar" style="height: 720px">
            <table style="height: 100%; width: 100%;">
                <td style="vertical-align:top">
                    <table border="1" class="table table-bordered">
                        <th>№</th>
                        <th>Наименование</th>
                        <th>Артикул</th>
                        <th>Количество</th>
                        <th>Стоимость</th>
                        <th>Заметки</th>
                        <th>Номер изделия</th>
                            <c:forEach items="${crudeList}" var="crude">
                            <tr>
                                <td>${crude.id}</td>
                                <td>${crude.name}</td>
                                <td>${crude.article}</td>
                                <td>${crude.amount}</td>
                                <td>${crude.cost}</td>
                                <td>${crude.note}</td>
                                <td>${crude.productId}</td>
                            </tr>
                        </c:forEach>
                    </table>
            </table>
        </div>
    </body>
</html>
