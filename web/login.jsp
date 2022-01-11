<%-- 
    Document   : login
    Created on : Jan 10, 2022, 10:35:39 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <style>
            h4{
                color: red;
            }
        </style>
    </head>
    <body>
        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/SWP_loginApi/LogingoogleController&response_type=code
           &client_id=90676323264-m344qcc3bv607iu3jttu76l9ec5g0ekt.apps.googleusercontent.com&approval_prompt=force">Login With Google</a></br>  
        <h4>${requestScope.ERROR_LOGIN}</h4>   
    </body>
</html>
