<%-- 
    Document   : student-no-group
    Created on : Mar 19, 2022, 4:15:46 PM
    Author     : PC
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
                        <h3 class="box-title">Students</h3>
                        <small>without group</small>
                        <!-- <div class="box-tools">
                        
                        <div class="input-group input-group-sm" style="width: 150px;">
                          <input type="text" name="table_search" class="form-control pull-right" placeholder="Search">
        
                          <div class="input-group-btn">
                            <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                          </div>
                        </div>
                      </div> -->
                        <div class="box-tools">
                            <button type="button" class="btn btn-default btn-sm btn-student">
                                <a href="StudentNoGroupRandomController">Random</a>
                            </button>
                        </div>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-header clearfix">
                        <ul class="pagination pagination-sm no-margin pull-left">
                            <i>Show</i>
                            <select class="select">
                                <option><a href="#">10</a></option>
                                <option><a href="#">15</a></option>
                                <option><a href="#">25</a></option>
                                <option><a href="#">30</a></option>
                            </select>
                            <i>entries</i>
                        </ul>
                        <ul class="pagination pagination-sm no-margin pull-right">
                            <i class="fas fa-filter">Filter</i>
                            <select class="select">
                                <option><a href="#">Spring 2022</a></option>
                                <option><a href="#">Fall 2021</a></option>
                                <option><a href="#">Summer 2021</a></option>
                                <option><a href="#">Spring 2021</a></option>
                            </select>
                        </ul>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body table-responsive no-padding">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th style="width : 10px">#</th>
                                    <th>Student Id</th>
                                    <th>Name</th>
                                    <th style="width : 120px">Semester</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${sessionScope.ADMIN_LIST_USER_NO_GROUP}" var="list" varStatus="count">
                                    <tr>
                                        <td>${count.count}</td>
                                        <td>${list.userId}</td>
                                        <td>${list.userName}</td>
                                        <td></td>
                                        
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer clearfix">
                        <ul class="pagination pagination-sm no-margin pull-right">
                            <!-- <li><a href="#">&laquo;</a></li> -->
                            <li><a href="#">Previous</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">Next</a></li>
                            <!-- <li><a href="#">&raquo;</a></li> -->
                        </ul>
                    </div>
                </div>
                <!-- /.box -->
            </div>
        </div>
    </body>
</html>
