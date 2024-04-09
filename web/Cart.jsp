<%-- 
    Document   : Cart
    Created on : Dec 6, 2023, 11:16:48 PM
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
        <h1>Cart Details</h1>
        <c:if test="${sessionScope.cart == null}">
            No data
        </c:if>
        <c:if test="${sessionScope.cart != null}">
            <table>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Quantity</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${sessionScope.cart}" var="item">
                        <tr>
                            <td>${item.key.mobileID}</td>
                            <td>${item.key.mobileName}</td>
                            <td>${item.value}</td>
                            <td><a href="removeItem?id=${item.key.mobileID}">Delete Item</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <a href="Order">Check out</a>
    </body>
</html>
