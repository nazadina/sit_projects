<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Пользователи</title>
        <link rel="stylesheet" href="CSS/page.css" type="text/css">
        <link rel="stylesheet" href="CSS/bootstrap.css" type="text/css">
    </head>
    <body>
        <h1>
            Список пользователей
            <a href="${pageContext.request.contextPath}/index"><button class="btn btn-primary" style="width: 120px;">На главную</button></a>
            <ul class="nav navbar-nav navbar-right">
                <spring:message code="user.logged" />: <sec:authentication property="name"/> <sec:authentication property="authorities"/>
                <a href="logout"><button class="btn btn-primary" style="width: 100px; margin-right: 10px">Выход</button></a>
            </ul>
        </h1>
        <form:form action="user.do" method="POST" commandName="user">
            <table style="float: left">
                <tr>
                    <td valign="middle">
                        №:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="ID" style="width: 300px;"<form:input  path="id" />
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
                        Логин:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Логин" style="width: 150px;"<form:input  path="login" />
                    </td>
                    <td valign="middle">
                        Пароль:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Пароль" style="width: 300px;"<form:input  path="password" />
                    </td>
                    <td valign="middle">
                        Статус:
                    </td>
                    <td valign="middle">
                        <input class="form-control" placeholder="Статус" style="width: 150px;"<form:input  path="status" />
                    </td>
                </tr>
            </table>
        </form:form>
        <br>
        <div class="scrollbar" style="height: 650px">
            <table style="height: 100%; width: 100%;">
                <td style="vertical-align:top">
                    <table border="1" class="table table-bordered">
                        <th>№</th>
                        <th>Логин</th>
                        <th>Пароль</th>
                        <th>Статус</th>
                            <c:forEach items="${userList}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.login}</td>
                                <td>${user.password}</td>
                                <td>${user.status}</td>
                            </tr>
                        </c:forEach>
                    </table>
            </table>
        </div>
    </body>
</html>
