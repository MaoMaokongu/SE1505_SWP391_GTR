<%-- 
    Document   : importExcel
    Created on : Mar 16, 2022, 10:34:28 AM
    Author     : haitu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="ImportExcelController" enctype="multipart/form-data">
            Select file to upload: <input type="file" name="file" size="60" /><br /><br /> 
            <input type="submit" value="Upload" />
        </form>

        <table>
            <thead>				
                <tr>
                    <th scope="col" width="50">#</th>
                    <th scope="col" width="50">UserId</th>
                    <th scope="col" width="50">Email</th>
                    <th scope="col" width="50">Username</th>
                    <th scope="col" width="50">Gender</th>
                    <th scope="col" width="50">Role</th>
                    <th scope="col" width="50">Group</th>
                    <th scope="col" width="50">IsLeader</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" varStatus="counter" items="${requestScope.LIST_STUDENT}">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${student.get(1)}</td>
                        <td>${student.get(2)}</td>
                        <td>${student.get(3)}</td>
                        <td>${student.get(4)}</td>
                        <td>${student.get(5)}</td>
                        <td>${student.get(6)}</td>
                        <td>${student.get(7)}</td>                       
                    <tr>
                    </c:forEach>
            </tbody>
        </table>
    </body>
</html>
