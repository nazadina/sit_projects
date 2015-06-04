<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Заказы</title>
        <!--<c:url value="/css/bootstrap.css" />-->
        <link rel="stylesheet" href="CSS/page.css" type="text/css">
        <link rel="stylesheet" href="CSS/bootstrap.css" type="text/css">
        <script src="JS/bootstrap.js"></script>
        <script src="JS/jquery.min.js"></script>
    </head>
    <body>

        <h1>
            Лист заказов
            <a href="${pageContext.request.contextPath}/index"><button class="btn btn-primary" style="width: 280px">На главную</button></a>
            <ul class="nav navbar-nav navbar-right">
                <spring:message code="user.logged" />: <sec:authentication property="name"/> <sec:authentication property="authorities"/>
                <a href="logout"><button class="btn btn-primary" style="width: 100px; margin-right: 10px">Выход</button></a>
            </ul>
        </h1>
        <script>
            jQuery(function() {
                $('#btn').on('click', function() {
                    var count = 0;
                    for (var i = 1; i < 6; i++) {
                        var text_field = $('#tf' + i);
                        if (text_field.val() === "") {
                            count++;
                        }
                    }
                    if (count !== 0) {
                        alert("Please fill in all fields");
                        count = 0;
                        return false;
                    }
                    return true;
                });
            });


        </script>



        <sec:authorize access="hasRole('Администратор')">
            <!--<form onsubmit="return jQuery()">-->
            <form:form action="AcceptOrder.do" method="POST" commandName="acceptOrder" enctype="UTF-8">
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
                            Описание:
                        </td>
                        <td valign="middle">
                            <input class="form-control" id="tf2" placeholder="Описание" style="width: 200px;"<form:input  path="description" />
                        </td>
                        <td valign="middle">
                            Дата:
                        </td>
                        <td valign="middle">
                            <input class="form-control" id="tf3" placeholder="Дата" style="width: 200px;"<form:input  path="deadline" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle">
                            Стоимость:
                        </td>
                        <td valign="middle">
                            <input class="form-control" id="tf4" placeholder="Стоимость" style="width: 200px;"<form:input  path="costDelivery" />
                        </td>
                        <td valign="middle">
                            Вес:
                        </td>
                        <td valign="middle">
                            <input class="form-control" id="tf5" placeholder="Вес" style="width: 200px;"<form:input  path="weight" />
                        </td>
                        <td valign="middle">
                            ID заказчика:
                        </td>
                        <td valign="middle">
                            <input class="form-control" id="tf1" placeholder="ID заказчика" style="width: 200px;"<form:input  path="enterpriseId" />
                        </td>
                    </tr>
                </table>
            </form:form>
        </sec:authorize>
        <!--</form>-->

        <br>
        <div class="scrollbar" style="height: 550px">
            <table style="height: 100%; width: 100%;">
                <tr style="width:50%; height: 90%;">
                    <td style="vertical-align:top">
                        <table class="table table-bordered">
                            <tr>
                                <td>№</td>
                                <td>Описание</td>
                                <td>Дата</td>
                                <td>Стоимость</td>
                                <td>Вес</td>
                                <td>ИД заказчика</td>
                            </tr>
                            <c:forEach items="${acceptOrderList}" var="acceptOrder">
                                <tr>
                                    <td>${acceptOrder.id}</td>
                                    <td>${acceptOrder.description}</td>
                                    <td>${acceptOrder.deadline}</td>
                                    <td>${acceptOrder.costDelivery}</td>
                                    <td>${acceptOrder.weight}</td>
                                    <td>${acceptOrder.enterpriseId}</td>
                                </tr>
                            </c:forEach>
                        </table>
            </table>
        </div>
    </body>
</html>
