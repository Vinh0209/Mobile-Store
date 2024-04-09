<%-- 
    Document   : AddNewMobile
    Created on : Dec 7, 2023, 12:36:32 PM
    Author     : kienb
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add New Mobile</h1>
        <form action="addMobile" method="post">
            Mobile ID
            <br>
            <input type="text" name="id" required="" maxlength="10" value="${requestScope.id}">
            <br>
            Mobile Name
            <br>
            <input type="text" name="name" required="" maxlength="20" value="${requestScope.mobileName}">
            <br>
            Year Of Production
            <br>
            <input type="number" name="year" required="" min="1990" max="2023" value="${requestScope.year}">
            <br>
            Price
            <br>
            <input type="number" name="price" value="${requestScope.price}" required="" min="1">
            <br>
            Description
            <br>
            <textarea name="description" maxlength="250">${requestScope.description}</textarea>
            <br>
            Quantity
            <br>
            <input type="number" name="quantity" value="${requestScope.quantity}" required="" min="1">
            <br>
            Not Sale
            <input type="radio" name="sale" value="0" ${requestScope.isSale eq true ? 'checked' : ''} required>Yes
            <input type="radio" name="sale" value="1" ${requestScope.isSale eq false ? 'checked' : ''}>No
            <br>
            <c:if test="${requestScope.error != null}">
                <div style="color: red">${requestScope.error}</div>
            </c:if>
            <c:if test="${requestScope.report != null}">
                <div style="color: green">${requestScope.report}</div>
            </c:if>
            <input type="submit" value="Create">
        </form>
    </body>
</html>
