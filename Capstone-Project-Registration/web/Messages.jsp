<%-- 
    Document   : Messages
    Created on : Jan 25, 2022, 9:39:47 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="css/styles.css" />
        <title>Home Page</title>
    </head>

    <body>
    <c:url var="logoutLink" value="LogoutController">
        <c:param name="action" value="Logout"></c:param>
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
                <a href="studentproject.jsp"
                   class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-project-diagram me-2"></i>Projects</a>
                <a href="studentprofile.jsp"
                   class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-user me-2"></i>Account</a>
                <a href="#"
                   class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-comments me-2"></i>Messages</a>
                <a href="projectdetails.jsp"
                   class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-file-signature me-2"></i></i>Project Have Signed</a>
                <a href="GroupController"
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
                    <h2 class="fs-2 m-0">Messages</h2>
                </div>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle second-text fw-bold" href="#" id="navbarDropdown"
                               role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fas fa-user me-2"></i>Admin
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



                <!-- <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle second-text fw-bold" href="#" id="navbarDropdown"
                                    role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fas fa-user me-2"></i>Filter
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Profile</a></li>
                                    <li><a class="dropdown-item" href="#">Settings</a></li>
                                    <li><a class="dropdown-item" href="#">Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div> -->





                <div class="row my-5">
                    <!-- <h3 class="fs-4 mb-3"></h3> -->
                    <!-- <li class="search-box">
                        <i class="fas fa-search"></i>&emsp;&emsp;
                        <input type="text" placeholder="Search...">
                        
                    </li> -->

                    <!-- Search -->
                    <!-- <div class="d-flex flex-row">
                        <div class="input-group d-flex justify-content-start">
                            <div class="form-outline">
                                <input type="search" id="form1" class="form-control" />
                            </div>
                            <button type="button" class="btn btn-primary">
                                <i class="fas fa-search"></i>
                            </button>
                        </div> -->

                    <!-- filter -->
                    <!-- <div class="list d-flex align-items-center justify-content-start">
                        <i class="fas fa-filter"></i>
                        <select class="select">
                            <option >Spring 2022</option>
                            <option value="web">Fall 2021</option>
                            <option value="mobile">Summer 2021</option>
                            <option value="desktop">Spring 2021</option>
                        </select>
                    </div> -->
                    <!-- </div> -->


                    <!-- <><button class="btn sort">Sort</button></i> -->
                    <div class="col">
                        <table class="table bg-white rounded shadow-sm  table-hover">
                            <thead>
                                <tr>
                                    <th scope="col" width="50">#</th>
                                    <th>Sender</th>
                                    <th>Message</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Nguyễn Thế Hoàng</td>
                                    <td>focus on learning...</td>
                                    <td><button id="myBtn1" class="btn btn-primary">see more</button></td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>yyy</td>
                                    <td>xxx</td>
                                    <td><button id="myBtn2" class="btn btn-primary">see more</button></td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td>yyy</td>
                                    <td>xxx</td>
                                    <td><button id="myBtn3" class="btn btn-primary">see more</button></td>
                                </tr>
                                <tr>
                                    <th scope="row">4</th>
                                    <td>yyy</td>
                                    <td>xxx</td>
                                    <td><button id="myBtn4" class="btn btn-primary">see more</button></td>
                                </tr>
                                <tr>
                                    <th scope="row">5</th>
                                    <td>yyy</td>
                                    <td>xxx</td>
                                    <td><button id="myBtn5" class="btn btn-primary">see more</button></td>
                                </tr>
                                <tr>
                                    <th scope="row">6</th>
                                    <td>yyy</td>
                                    <td>xxx</td>
                                    <td><button id="myBtn6" class="btn btn-primary">see more</button></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <div id="myModal" class="modal">

                        <!-- Modal content -->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h2>Modal Header</h2>
                                <span class="close">&times;</span>

                            </div>
                            <div class="modal-body">
                                <p>Some text in the Modal Body</p>
                                <p>Some other text...</p>
                            </div>
                            <!-- <div class="modal-footer">
                              <h3>Modal Footer</h3>
                            </div> -->
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- modal see more -->
    <script src="js/SeeMore.js"></script>

    <!-- /#page-content-wrapper -->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        var el = document.getElementById("wrapper");
        var toggleButton = document.getElementById("menu-toggle");

        toggleButton.onclick = function () {
            el.classList.toggle("toggled");
        };

        var dropdown = document.getElementsByClassName("dropdown-btn");
        var i;

        for (i = 0; i < dropdown.length; i++) {
            dropdown[i].addEventListener("click", function () {
                this.classList.toggle("active");
                var dropdownContent = this.nextElementSibling;
                if (dropdownContent.style.display === "block") {
                    dropdownContent.style.display = "none";
                } else {
                    dropdownContent.style.display = "block";
                }
            });
        }
    </script>





    <!-- <script src="js/SeeMore.js"></script> -->
</body>
</html>
