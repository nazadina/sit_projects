<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Рабочие</title>
        <link rel="stylesheet" href="CSS/page.css" type="text/css">
        <link rel="stylesheet" href="CSS/bootstrap.css" type="text/css">
    </head>
    <body>
        <h1>
            Список рабочих
            <a href="${pageContext.request.contextPath}/index"><button class="btn btn-primary" style="width: 230px;">На главную</button></a>
            <ul class="nav navbar-nav navbar-right">
                <spring:message code="user.logged" />: <sec:authentication property="name"/> <sec:authentication property="authorities"/>
                <a href="logout"><button class="btn btn-primary" style="width: 100px; margin-right: 10px">Выход</button></a>
            </ul>
        </h1>
        <form:form action="worker.do" method="POST" commandName="worker">
            <table style="float: left">
                <tr>
                    <td valign="top">
                        ID:
                    </td>
                    <td valign="top">
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
                    <td valign="middle" style="color: ">
                        Фамилия:
                    </td>
                    <td valign="middle">
                        <input class="form-control" id="tf1" placeholder="Фамилия" style="width: 200px;"<form:input  path="surname" />
                    </td>
                    <td valign="middle">
                        Имя:
                    </td>
                    <td valign="middle">
                        <input class="form-control" id="tf2" placeholder="Имя" style="width: 200px;"<form:input  path="name" />
                    </td>
                    <td valign="middle">
                        Отчество:
                    </td>
                    <td valign="middle">
                        <input class="form-control" id="tf3" placeholder="Отчество" style="width: 200px;"<form:input  path="patronymic" />
                    </td>
                    <td valign="middle">
                        Возраст:
                    </td>
                    <td valign="middle">
                        <input class="form-control" id="tf3" placeholder="Возраст" style="width: 200px;"<form:input  path="age" />
                    </td>
                </tr>
                <tr>
                    <td valign="middle">
                        Опыт:
                    </td>
                    <td valign="middle">
                        <input class="form-control" id="tf3" placeholder="Опыт" style="width: 200px;"<form:input  path="experience" />
                    </td>
                    <td valign="middle">
                        Отработано часов:
                    </td>
                    <td valign="middle">
                        <input class="form-control" id="tf3" placeholder="Отработано часов" style="width: 200px;"<form:input  path="hoursWork" />
                    </td>
                    <td valign="middle">
                        Часовая ставка:
                    </td>
                    <td valign="middle">
                        <input class="form-control" id="tf3" placeholder="Часовая ставка" style="width: 200px;"<form:input  path="hourlyRate" />
                    </td>
                    <td valign="middle">
                        Премия:
                    </td>
                    <td valign="middle">
                        <input class="form-control" id="tf3" placeholder="Премия" style="width: 200px;"<form:input  path="award" />
                    </td>
                </tr>
                <tr>
                    <td valign="middle">
                        Номер заказа:
                    </td>
                    <td valign="middle">
                        <input class="form-control" id="tf3" placeholder="Номер заказа" style="width: 200px;"<form:input  path="orderId" />
                    </td>
                    <td valign="middle">
                        Номер должности:
                    </td>
                    <td valign="middle">
                        <input class="form-control" id="tf3" placeholder="Номер должности" style="width: 200px;"<form:input  path="roleId" />
                    </td>
                </tr>
            </table>
        </form:form>
        <br>
        <div class="scrollbar" style="height: 600px">
            <table style="height: 100%; width: 100%;">
                <td style="vertical-align:top">
                    <table class="table table-bordered">
                        <th>№</th>
                        <th>Фамилия</th>
                        <th>Имя</th>
                        <th>Отчество</th>
                        <th>Возраст</th>
                        <th>Опыт</th>
                        <th>Отработано часов</th>
                        <th>Часовая ставка</th>
                        <th>Премия</th>
                        <th>Номер заказа</th>
                        <th>Номер должности</th>
                            <c:forEach items="${workerList}" var="worker">
                            <tr>
                                <td>${worker.id}</td>
                                <td>${worker.surname}</td>
                                <td>${worker.name}</td>
                                <td>${worker.patronymic}</td>
                                <td>${worker.age}</td>
                                <td>${worker.experience}</td>
                                <td>${worker.hoursWork}</td>
                                <td>${worker.hourlyRate}</td>
                                <td>${worker.award}</td>
                                <td>${worker.orderId}</td>
                                <td>${worker.roleId}</td>
                            </tr>
                        </c:forEach>
                    </table>
            </table>
        </div>
    </body>
</html>
