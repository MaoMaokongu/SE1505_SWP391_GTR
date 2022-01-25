<%-- 
    Document   : my group
    Created on : Jan 25, 2022, 9:40:28 AM
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
        <link rel="stylesheet" href="css/MyGroup.css" />
        <title>Student Notification</title>
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
                    <a href="projects.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-project-diagram me-2"></i>Projects</a>
                    <a href="account.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i 
                            class="fas fa-user me-2"></i>Account</a>
                    <a href="Messages.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i 
                            class="fas fa-comments me-2"></i>Messages</a>
                    <a href="Details.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i 
                            class="fas fa-file-signature me-2"></i></i>Project Have Signed</a>
                    <a href="create group.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i 
                            class="fas fa-users-cog me-2"></i>Create Group</a>
                    <a href="my group.jsp" class="list-group-item list-group-item-action bg-transparent second-text active"><i 
                            class="fas fa-users me-2"></i></i>My Group</a>
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
                        <h2 class="fs-2 m-0">My Group</h2>
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
                        <h3 class="fs-4 mb-3">Member List</h3>

                        <div class="row">
                            <div class="input-group col-sm">
                                <div class="form-outline">
                                    <input type="text" id="form1" class="form-control" placeholder="Email" />
                                </div>
                                <button type="button" class="btn btn-primary">
                                    Invite
                                </button>
                            </div>

                            <!-- filter -->
                            <div class="list col-sm">
                                <i class="fas fa-filter"></i>
                                <select class="select">
                                    <option disabled selected>Project</option>
                                    <option value="web">Web Develope</option>
                                    <option value="mobile">Mobile App</option>
                                    <option value="desktop">Desktop App</option>
                                    <option value="java">Java app</option>
                                </select>
                            </div>
                        </div>

                        <div class="col">
                            <table class="table bg-white rounded shadow-sm  table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col" width="50">#</th>
                                        <th scope="col">UserID</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Gender</th>
                                        <th scope="col">Leader</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>SE151138</td>
                                        <td>trunglvse151138@fpt.edu.vn</td>
                                        <td>Le Van Trung</td>
                                        <td>Male</td>
                                        <td>True</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <th scope="row">4</th>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>

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
</body>
</html>
