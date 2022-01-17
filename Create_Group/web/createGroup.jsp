<%-- 
    Document   : createGroup
    Created on : Jan 15, 2022, 8:13:30 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Group Page</title>
    </head>
    <body>
        <h1>Create Group Page</h1>
        <form action="CreateGroupController" method="POST">
            Enter Group Name:<input  type="text" name="group_name" required=""/>
            <input type="hidden" name="email" value="${sessionScope.USER.email}"/>
            <input type="submit" name="action" value="Create"/>
            <input type="reset" name="Reset"/>
        </form>
        ${requestScope.BUG}
        </br>
        <form action="JoinGroupController">
            Enroll: <input type="text" name="enroll" required=""/>
<!--            <input type="hidden" name="email" value=""/>-->
            <input type="submit" name="action" value="Join"/>
            <input type="reset" name="Reset"/>
        </form>
    </body>
</html>
