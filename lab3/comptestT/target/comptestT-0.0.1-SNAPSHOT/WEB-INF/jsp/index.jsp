<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start page</title>
        <link rel="stylesheet" href="CSS/index.css">
        <link rel="stylesheet" href="CSS/bootstrap.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script type="text/javascript" src="JS/bootstrap.js"></script>

    </head>

    <body onload="startTime()">
        <script type="text/javascript">
            function startTime()
            {
                var tm = new Date();
                var h = tm.getHours();
                var m = tm.getMinutes();
                var s = tm.getSeconds();
                m = checkTime(m);
                s = checkTime(s);
                document.getElementById('txt').innerHTML = h + ":" + m + ":" + s;
                t = setTimeout('startTime()', 500);
            }
            function checkTime(i)
            {
                if (i < 10)
                {
                    i = "0" + i;
                }
                return i;
            }
        </script>

        <h1>
            <ul class="nav navbar-nav navbar-right">
                <spring:message code="user.logged"/>: <sec:authentication property="name"/> <sec:authentication property="authorities"/>
                <a href="logout"><button class="btn btn-primary" style="margin-right: 10px">Выход</button></a>
            </ul>
            <p id="txt"> </p>
        </h1>

        <sec:authorize access="hasAnyRole('Администратор','Менеджер','Механик')">
            <p/><a href="${pageContext.request.contextPath}/AcceptOrder">
                <button class="btn btn-primary" style="width:150px;">Заказы</button></a>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('Администратор')">
            <p/><a href="${pageContext.request.contextPath}/ConfEnterprise">
                <button class="btn btn-primary" style="width:150px;">Предприятие</button></a>
            <p/><a href="${pageContext.request.contextPath}/Crude">
                <button class="btn btn-primary" style="width:150px;">Сырье</button></a>
            <p/><a href="${pageContext.request.contextPath}/product">
                <button class="btn btn-primary" style="width:150px;">Изделие</button></a>
            <p/><a href="${pageContext.request.contextPath}/user">
                <button class="btn btn-primary" style="width:150px;">Пользователи</button></a>
            <p/><a href="${pageContext.request.contextPath}/worker">
                <button class="btn btn-primary" style="width:150px;">Рабочие</button></a>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('Администратор','Менеджер','Механик')">
            <p/><a href="${pageContext.request.contextPath}/calculations">
                <button class="btn btn-primary" style="width:150px;">Расчеты</button></a>
            </sec:authorize>

    </body>
</html>
