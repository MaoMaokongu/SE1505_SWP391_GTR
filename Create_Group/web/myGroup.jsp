<%-- 
    Document   : yourGroup
    Created on : Jan 16, 2022, 11:24:38 AM
    Author     : admin
--%>

<%@page import="java.util.List"%>
<%@page import="dtos.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Group Page</title>
    </head>
    <body>
        <h1>My Group!</h1>
        <form action="SendMailController">
            Email: <input type="type" name="email" required=""/>
            <input type="submit" name="action" value="Invite"/>
            <input type="hidden" name="email_sender" value="${sessionScope.USER.email}"/>
            <input type="reset" name="Reset"/>
        </form>
        </br>
        <c:if test="${sessionScope.LIST_USER == null}">
            <h1>Empty</h1>
        </c:if>
        <c:if test="${sessionScope.LIST_USER != null}">
            <c:if test="${not empty sessionScope.LIST_USER}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>User ID</th>
                            <th>Email</th>
                            <th>Username</th>
                            <th>Gender</th>
                            <th>Leader</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" varStatus="counter" items="${sessionScope.LIST_USER}">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${user.user_id}</td>
                                <td>${user.email}</td>
                                <td>${user.username}</td>
                                <td>${user.gender}</td>
                                <td>${user.leader}</td>                               
                            </tr>   
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </c:if>

    </body>
</html>
