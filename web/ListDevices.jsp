<%-- 
    Document   : ListDevices
    Created on : Dec 6, 2023, 10:50:32 PM
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
        <h1>List Devices</h1>
        <a href="ViewCart">View Cart</a>
        <form action="${pageContext.request.contextPath}/devices">
            Min : <input type="number" name="min" value="${requestScope.min}">
            <br>
            Max : <input type="number" name="max" value="${requestScope.max}">
            <br>
            <input type="submit" value="Search">
        </form>
        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>Sale</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.mobiles}" var="item">
                    <tr>
                        <td>${item.mobileID}</td>
                        <td>${item.mobileName}</td>
                        <td>${item.price}</td>
                        <td>${item.quantity}</td>
                        <td>${item.isSale}</td>
                        <td><a href="addToCart?id=${item.mobileID}">Add To Cart</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
