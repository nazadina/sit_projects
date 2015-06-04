<%-- 
    Document   : index
    Created on : 08.05.2015, 19:37:30
    Author     : Dina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Spy Servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <TITLE>Application form</TITLE>
    </head>
    <body BGCOLOR="#BBFFFF">
        <form method="GET" action="HelloServlet">
            <table  border="0" cellspacing="7" cellpadding="7">
            
     <tr>
    <td align="right" valign="top">Name</td>
    <td><input type="text" name="name" size="20"></td><br>
   </tr> 
   
    <tr>
    <td align="right" valign="top">Surname</td>
    <td><input type="text" name="surname" size="20"></td><br>
   </tr>
            
   <tr>
    <td align="right" valign="top" >Lastname</td>
    <td>
     <input type="text" name="lastname" size="20"><br>
    </td>
   </tr>
          
   <tr>
    <td align="right" colspan="2">
     <input type="submit" name="submit" value="Send !">
     
    </td>
   </tr>
            
        </form>
        <a href="/WebApplication1/NewServlet"> Application properties</a>   
        </table>
    </body>
</html>
