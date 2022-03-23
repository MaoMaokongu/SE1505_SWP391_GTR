<%-- 
    Document   : userpending
    Created on : Mar 15, 2022, 2:20:52 PM
    Author     : admin
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

        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Pending</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-header clearfix">
                        <ul class="pagination pagination-sm no-margin pull-right">

                        </ul>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body table-responsive no-padding">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th style="width : 10px">#</th>
                                    <th>Email</th>
                                    <th>Status</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <c:forEach var="invi" items="${sessionScope.INVITATION}" varStatus="count">
                                <tbody>
                                    <tr>
                                        <td style="width: 50px">${count.count}</td>
                                        <td style="width: 500px">${invi.userInvited}</td>
                                        <td style="width: 500px">${invi.status.name}....</td>
                                        <td>
                                            <form action="LeaderDeleteUserPendingController">
                                                <input type="hidden" name="userId" value="${invi.user.userId}"/>
                                                <input type="hidden" name="userInvited" value="${invi.userInvited}"/>
                                                <input type="hidden" name="leaderId" value="${sessionScope.USER.userId}"/>
                                                <input type="submit" value="Delete"/>
                                            </form>
                                        </td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </table>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer clearfix">
                        <c:if test="${sessionScope.INVITATION ne null}">
                            <c:if test="${sessionScope.INVITATION == null}">
                                <form class="pull-right">
                                    <input type="submit" value="Delete All"/>
                                </form>
                            </c:if>

                        </c:if>
                    </div>
                </div>
                <!-- /.box -->
            </div>
        </div>
    </body>
</html>
