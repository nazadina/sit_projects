<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Предприятия</title>
        <link rel="stylesheet" href="CSS/page.css" type="text/css">
        <link rel="stylesheet" href="CSS/bootstrap.css" type="text/css">
        <script src="JS/bootstrap.js"></script>
    </head>
    <body>
        <h1>
            Список предприятий
            <a href="${pageContext.request.contextPath}/index"><button class="btn btn-primary" style="width: 150px">На главную</button></a>
            <ul class="nav navbar-nav navbar-right">
                <spring:message code="user.logged" />: <sec:authentication property="name"/> <sec:authentication property="authorities"/>
                <a href="logout"><button class="btn btn-primary" style="width: 100px; margin-right: 10px">Выход</button></a>
            </ul>
        </h1>
        <form:form action="ConfEnterprise.do" method="POST" commandName="confEnterprise">
            <table style="float: left">
                <tr>
                    <td valign="top">
                        №:
                    </td>
                    <td valign="top">
                        <div class="form-group">
                            <input class="form-control" placeholder="ID" style="width: 500px;"<form:input  path="id" />
                        </div>
                    </td>
                </tr>
                <tr>
                    <td valign="top">
                        Наименование:
                    </td>
                    <td valign="top">
                        <div class="form-group">
                            <input class="form-control" placeholder="Наименование:" style="width: 100%;"<form:input path="name" />
                        </div>
                    </td>
                </tr>
            </table>
            <table style="float: left; margin-left: 10px;">
                <tr>
                    <td colspan="2">
                        <button class="btn btn-primary" id="btn" type="submit" name="action" value="Add" style="width: 150px;">Добавить</button>
                        <br/><button class="btn btn-primary" type="submit" name="action" value="Edit" style="width: 150px;">Изменить</button>
                        <br/><button class="btn btn-primary" type="submit" name="action" value="Delete" style="width: 150px;">Удалить</button>
                        <br/><button class="btn btn-primary" type="submit" name="action" value="Search" style="width: 150px;">Найти</button>
                    </td>
                </tr>
            </table>
        </form:form>
        <br>
        <div class="scrollbar" style="height: 550px">
            <table style="height: 100%; width: 100%;">
                <td style="vertical-align:top">
                    <table border="1" class="table table-bordered">
                        <th>№</th>
                        <th>Наименование:</th>
                            <c:forEach items="${confEnterpriseList}" var="confEnterprise">
                            <tr>
                                <td>${confEnterprise.id}</td>
                                <td>${confEnterprise.name}</td>
                            </tr>
                        </c:forEach>
                    </table>
            </table>
        </div>
    </body>
</html>
