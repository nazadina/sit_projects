<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculations</title>
         <link rel="stylesheet" href="CSS/index.css">
        <link rel="stylesheet" href="CSS/bootstrap.css" type="text/css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script type="text/javascript" src="JS/bootstrap.js"></script>
    </head>
     <a href="${pageContext.request.contextPath}/index"><button class="btn btn-primary" style="width: 280px">На главную</button></a>
    <body>
        <script>
            jQuery(function() {
                $('#salary').on('click', function() {
                    var list = ${list};
                    $.each(list, function(index, value) {
                        if (index === 0) {
                            alert("З/П рабочих: " + value + "рублей");
                        }
                    });
                });
                $('#b').on('click', function() {
                    var list = ${list};
                    $.each(list, function(index, value) {
                        if (index === 1) {
                            alert("Затраты на сырье: " + value + "рублей");
                        }
                    });
                });
            });

        </script>
        <h1>  Расчеты</h1>
        <form onsubmit="return jQuery()">
            <p/><br/><button type="submit" class="btn btn-primary" id="salary" style="width: 250px;">З/П рабочих</button>
            <p/><br/><button type="submit" class="btn btn-primary" id="b" style="width: 250px;">Затраты на сырье</button>
            <p/><br/><button type="submit" class="btn btn-primary" id="salary" style="width: 250px;">затраты на заказы</button>
            <p/><br/><button type="submit" class="btn btn-primary" id="b" style="width: 250px;">Затраты напроиз-во изделия</button>
        </form>
    </body>
</html>
