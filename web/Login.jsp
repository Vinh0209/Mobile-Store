<%-- 
    Document   : Login
    Created on : Dec 6, 2023, 10:13:14 PM
    Author     : kienb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            User Name : <input type="text" name="username" required="">
            <br><!-- comment -->
            Password : <input type="number" name="password" required="">
            <br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
