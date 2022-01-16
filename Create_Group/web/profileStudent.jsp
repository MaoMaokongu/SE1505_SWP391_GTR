<%-- 
    Document   : profileStudent
    Created on : Jan 15, 2022, 12:00:19 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Student</title>
    </head>
    <body>
        <h1>Profile Student</h1>
        User ID: ${sessionScope.USER.user_id}</br>
        Email: ${sessionScope.USER.email}</br>
        UserName: ${sessionScope.USER.username}</br>
        Gender: ${sessionScope.USER.gender}</br>
        Role: ${sessionScope.USER.role_id.role_name}</br>
        Group Name: ${sessionScope.USER.group_id.group_name}</br>
    </body>
</html>
