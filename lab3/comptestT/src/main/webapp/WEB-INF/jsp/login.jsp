<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="CSS/index.css">
        <link rel="stylesheet" href="CSS/bootstrap.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script type="text/javascript" src="JS/bootstrap.js"></script>
    </head>

    <body>
        <form action="j_spring_security_check" method="POST">
            <div class="form-group">
                <label>Логин</label>
                <input type="text" class="form-control" name="j_username" placeholder="Логин" style="width: 150px">
            </div>
            <div class="form-group">
                <label>Пароль</label>
                <input type="password" class="form-control" name="j_password" placeholder="Пароль" style="width: 150px">
            </div>
            <div class="btn-group-vertical" style="width: 150px;">
                <button type="submit" class="btn btn-primary">Войти</button>
            </div>
        </form>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/>
        <font color="blue">
            <span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
        </font>
    </body>
</html>