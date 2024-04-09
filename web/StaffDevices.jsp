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
        <a href="addMobile">Add New Mobile</a>
        <form action="${pageContext.request.contextPath}/devices">
            <input type="text" name="search" value="${requestScope.search}" placeholder="Search By ID or Name ...">
            <input type="submit" value="Search">
        </form>
        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>isSale</td>
                    <td colspan="2">Action</td>
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
                        <td><a href="deleteMobile?id=${item.mobileID}">Delete</a></td>
                        <td><a href="updateMobile?id=${item.mobileID}">Update</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
