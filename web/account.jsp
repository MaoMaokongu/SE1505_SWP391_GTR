<%-- 
    Document   : account
    Created on : Jan 25, 2022, 9:18:03 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="css/account.css" />
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <title>Student Account</title>
        
    </head>

    <body>
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
                    <!-- <a href="index.html" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-bell me-2"></i>Notification</a> -->
                    <a href="projects.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-project-diagram me-2"></i>Projects</a>
                    <a href="account.jsp" class="list-group-item list-group-item-action bg-transparent second-text active"><i
                            class="fas fa-user me-2"></i>Account</a>
                    <a href="Messages.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-comments me-2"></i>Messages</a>
                    <a href="Details.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-file-signature me-2"></i></i>Project Have Signed</a>
                    <a href="create group.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-users-cog me-2"></i>Group</a>
                    <!-- <a href="my group.html" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-users me-2"></i></i>My Group</a> -->
                    <!-- <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-map-marker-alt me-2"></i>Outlet</a> -->
                    <a href="#" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
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
                <!-- ----------------------------------------- -->

                <div class="profile">
                    <div class="left">
                        <img src="img/user.png" alt="user" width="200">
                        <h4>Username</h4>
                        <p>ID: SExxxxxx</p>
                        <h6 class="ltitle">Slogan</h6>
                        <h5>
                            "the saddest part of life is when the person who gave you the best memories becomes a memory."
                            <h5>
                                </div>

                                <div class="right">
                                    <div class="info">
                                        <h3>Information</h3>
                                        <div class="info_data">
                                            <div class="data">
                                                <h4>Email</h4>
                                                <p>---------@fpt.edu.vn</p>
                                            </div>
                                            <div class="data">
                                                <h4>Gender</h4>
                                                <p>Male</p>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="projects">
                                        <h3>Projects</h3>
                                        <div class="projects_data">
                                            <div class="data">
                                                <h4>Role</h4>
                                                <p>Student</p>
                                            </div>
                                            <div class="data">
                                                <h4>Group Name</h4>
                                                <p>------------</p>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="projects">
                                        <h3>Skill</h3>
                                        <div class="projects_data">
                                            <div class="data">
                                                <h4>Äiá»m máº¡nh</h4>
                                                <p>C++/C#</p>
                                                <p>Java</p>
                                                <p>Web Design</p>
                                            </div>
                                            <div class="data">
                                                <h4>Äá» Ã¡n ÄÃ£ chá»n</h4>
                                                <p>Web ÄÄng kÃ­ Äá» Ã¡n</p>
                                            </div>
                                        </div>
                                        <div class="editprofile">
                                            <a href="#">Edit</a>&emsp;&emsp;&emsp;<a href="#">Save</a>
                                        </div>
                                        <!-- <a href="#">Edit</a><a href="#">Save</a> -->
                                    </div>

                                    <!-- <div class="editprofile">
                                        <a href="#">Edit</a>&emsp;&emsp;&emsp;<a href="#">Save</a>
                                    </div> -->

                                </div>
                                </div>
                                </div>
                                </div>
                                <!-- ------------------------------------------------ -->

                                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
                                <script>
                                    var el = document.getElementById("wrapper");
                                    var toggleButton = document.getElementById("menu-toggle");

                                    toggleButton.onclick = function () {
                                        el.classList.toggle("toggled");
                                    };
                                </script>

                                </body>
                                </html>
