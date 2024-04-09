<%-- 
    Document   : UpdateMobile
    Created on : Dec 7, 2023, 12:06:33 PM
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
        <h1>Update Mobile</h1>
        <form action="updateMobile" method="post">
            <input type="hidden" name="id" value="${requestScope.mobile.mobileID}">
            Price
            <br>
            <input type="number" name="price" value="${requestScope.mobile.price}" required="" min="1">
            <br>
            Description
            <br>
            <textarea name="description" maxlength="250">${requestScope.mobile.description}</textarea>
            <br>
            Quantity
            <br>
            <input type="number" name="quantity" value="${requestScope.mobile.quantity}" required="" min="1">
            <br>
            Not Sale
            <input type="radio" name="sale" value="0" ${requestScope.mobile.isSale eq true ? 'checked' : ''} required>Yes
            <input type="radio" name="sale" value="1" ${requestScope.mobile.isSale eq false ? 'checked' : ''}>No
            <br>
            <input type="submit" value="Update">
        </form>
    </body>
</html>
