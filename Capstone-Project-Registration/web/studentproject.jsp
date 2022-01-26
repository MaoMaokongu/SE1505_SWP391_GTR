<%-- 
    Document   : studentproject
    Created on : Jan 23, 2022, 10:03:33 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="css/styles.css" />
        <title>Student Notification</title>
        <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css" /> -->
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.4/css/dataTables.bootstrap5.min.css" />
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap5.min.js"></script>
        <style>
            :root {
                --main-bg-color: #009d63;
                --main-text-color: #009d63;
                --second-text-color: #bbbec5;
                --second-bg-color: #c1efde;
            }

            .primary-text {
                color: var(--main-text-color);
            }

            .second-text {
                color: var(--second-text-color);
            }

            .primary-bg {
                background-color: var(--main-bg-color);
            }

            .secondary-bg {
                background-color: var(--second-bg-color);
            }

            .rounded-full {
                border-radius: 100%;
            }

            #wrapper {
                overflow-x: hidden;
                background-image: linear-gradient(
                    to right,
                    #baf3d7,
                    #c2f5de,
                    #cbf7e4,
                    #d4f8ea,
                    #ddfaef
                    );
            }

            #sidebar-wrapper {
                min-height: 100vh;
                margin-left: -15rem;
                -webkit-transition: margin 0.25s ease-out;
                -moz-transition: margin 0.25s ease-out;
                -o-transition: margin 0.25s ease-out;
                transition: margin 0.25s ease-out;

            }

            #sidebar-wrapper .sidebar-heading {
                padding: 0.875rem 1.25rem;
                font-size: 1.2rem;
            }

            #sidebar-wrapper .list-group {
                width: 15rem;
            }

            #page-content-wrapper {
                min-width: 100vw;
            }

            #wrapper.toggled #sidebar-wrapper {
                margin-left: 0;

            }

            #menu-toggle {
                cursor: pointer;
            }

            .list-group-item {
                border: none;
                padding: 20px 30px;
            }

            .list-group-item.active {
                background-color: transparent;
                color: var(--main-text-color);
                font-weight: bold;
                border: none;
            }

            @media (min-width: 768px) {
                #sidebar-wrapper {
                    margin-left: 0;
                }

                #page-content-wrapper {
                    min-width: 0;
                    width: 100%;
                }

                #wrapper.toggled #sidebar-wrapper {
                    margin-left: -15rem;
                }
            }

            .slider{
                max-width: 1800px;
                display: flex;
                /* padding-left: 130px; */
            }
            .slider .card{

                flex: 1;
                margin: 0 10px;
                background: #fff;
            }
            .slider .card .img{
                height: 200px;
                width: 100%;
            }
            .slider .card .img img{
                height: 100%;
                width: 100%;
                object-fit: cover;
            }
            .slider .card .content{
                padding: 10px 20px;
            }
            .card .content .title{
                font-size: 25px;
                font-weight: 600;
            }
            .card .content .sub-title{
                font-size: 20px;
                font-weight: 600;
                color: #e74c3c;
                line-height: 20px;
            }
            .card .content p{
                text-align: justify;
                margin: 10px 0;
            }
            .card .content .btn{
                display: block;
                text-align: left;
                margin: 10px 0;
            }
            .card .content .btn button{
                background: #e74c3c;
                color: #fff;
                border: none;
                outline: none;
                font-size: 17px;
                padding: 5px 8px;
                border-radius: 5px;
                cursor: pointer;
                transition: 0.2s;
            }
            .card .content .btn button:hover{
                transform: scale(0.9);
            }


            /* search box */
            li.search-box{
                border-radius: 6px;
                background-color: var(--primary-color-light);
                cursor: pointer;
                transition: var(--tran-05);
            }

            li.search-box input{
                height: 100%;
                width: 100%;
                outline: none;
                border: none;
                background-color: var(--primary-color-light);
                color: var(--text-color);
                border-radius: 6px;
                font-size: 17px;
                font-weight: 500;
                transition: var(--tran-05);
            }

            li {
                list-style: none;
                height: 100%;
                background-color: transparent;
                display: flex;
                align-items: center;
                height: 100%;
                border-radius: 6px;
                text-decoration: none;
                transition: var(--tran-03);
            }
        </style>
    </head>

    <body>
        <c:url var="logoutLink" value="LogoutController">
            <c:param name="action" value="Logout"></c:param>
        </c:url>
        <c:url var="group" value="GroupController">
            <c:param name="groupName" value="${sessionScope.USER.group.name}"></c:param>
        </c:url>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar -->
            <div class="bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom">
                    <img src="img/logo.png" width="80px" height="80px">
                    <div>
                        Projects System
                    </div>
                </div>
                <div class="list-group list-group-flush my-3">
                    <a href="#"
                       class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-project-diagram me-2"></i>Projects</a>
                    <a href="studentprofile.jsp"
                       class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-user me-2"></i>Account</a>
                    <a href="Messages.jsp"
                       class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-comments me-2"></i>Messages</a>
                    <a href="projectdetails.jsp"
                       class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-file-signature me-2"></i></i>Project Have Signed</a>
                    <a href="${group}"
                       class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-users-cog me-2"></i>Group</a>
                    <a href="${logoutLink}" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
                            class="fas fa-power-off me-2"></i>Logout</a>
                </div>
            </div>

            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">
                <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                    <div class="d-flex align-items-center">
                        <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                        <h2 class="fs-2 m-0">Dashboard</h2>
                    </div>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle second-text fw-bold" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fas fa-user me-2"></i>Student
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Profile</a></li>
                                    <li><a class="dropdown-item" href="#">Settings</a></li>
                                    <li><a class="dropdown-item" href="#">Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
                <div class="container-fluid px-4">

                    <div class="row my-5">
                        <div class="col">
                            <jsp:useBean id="list_project" class="com.group6.capstoneprojectregistration.daos.ProjectDAO" scope="request"></jsp:useBean>
                                <table border ="1" class="table bg-white rounded shadow-sm  table-hover" id="example">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Mentor</th>
                                            <th>Co-Mentor</th>
                                            <th>Number Of Students</th>
                                            <th>Description</th>
                                            <th>Semester</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${list_project.listProject}" var="project" >
                                        <tr>
                                            <th>${project.projectId}</th>
                                            <td>${project.name}</td>
                                            <td>${project.mentor}</td>
                                            <td>${project.coMentor}</td>
                                            <td>${project.numOfStus}</td>
                                            <td>${project.discription}</td>
                                            <td>${project.semester.name}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        var el = document.getElementById("wrapper");
        var toggleButton = document.getElementById("menu-toggle");

        toggleButton.onclick = function () {
            el.classList.toggle("toggled");
        };
    </script>
    <script>
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
</body>

</html>
