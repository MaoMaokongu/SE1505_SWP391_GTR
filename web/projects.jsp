<%-- 
    Document   : projects
    Created on : Jan 25, 2022, 9:41:11 AM
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
        <link rel="stylesheet" href="css/projects.css" />
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">


        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
        <title>Student Projects</title>
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
                    <a href="projects.jsp"
                       class="list-group-item list-group-item-action bg-transparent second-text active"><i
                            class="fas fa-project-diagram me-2"></i>Projects</a>
                    <a href="account.jsp"
                       class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-user me-2"></i>Account</a>
                    <a href="Messages.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-comments me-2"></i>Messages</a>
                    <a href="Details.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-file-signature me-2"></i></i>Project Have Signed</a>
                    <a href="create group.jsp"
                       class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-users-cog me-2"></i>Group</a>
                    <!-- <a href="my group.html"
                        class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
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
                        <h2 class="fs-2 m-0">Projects</h2>
                    </div>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle second-text fw-bold" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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


                <div class="row my-5">
                    <h3 class="fs-4 mb-3">List of Projects</h3>
                    <div class="col">
                        <table id="table_id" class="display">
                            <thead>
                                <tr>
                                    <th scope="col" width="50">#</th>
                                    <th>Project Name</th>
                                    <th>Mentor</th>
                                    <th>Co-Mentor</th>
                                    <th>Number of Students</th>
                                    <th>Discription</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td scope="row">1</td>
                                    <td>xxx</td>
                                    <td>yyy</td>
                                    <td>zzz</td>
                                    <td>4</td>
                                    <td>Row 1 Data 1</td>
                                </tr>
                                <tr>
                                    <td scope="row">2</td>
                                    <td>Row 2 Data 2</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                </tr>
                                <tr>
                                    <td scope="row">3</td>
                                    <td>Row 2 Data 2</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                </tr>
                                <tr>
                                    <td scope="row">4</td>
                                    <td>Row 2 Data 2</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                </tr>
                                <tr>
                                    <td scope="row">5</td>
                                    <td>Row 2 Data 2</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                </tr>
                                <tr>
                                    <td scope="row">6</td>
                                    <td>Row 2 Data 2</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                </tr>
                                <tr>
                                    <td scope="row">7</td>
                                    <td>Row 2 Data 2</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                </tr>
                                <tr>
                                    <td scope="row">8</td>
                                    <td>Row 2 Data 2</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                </tr>
                                <tr>
                                    <td scope="row">9</td>
                                    <td>Row 2 Data 2</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                </tr>
                                <tr>
                                    <td scope="row">10</td>
                                    <td>Row 2 Data 2</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                </tr>
                                <tr>
                                    <td scope="row">11</td>
                                    <td>Row 2 Data 2</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                    <td>Row 2 Data 1</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- <script>
            $(".slider").owlCarousel({
              loop: true,
              autoplay: true,
              autoplayTimeout: 2000, //2000ms = 2s;
              autoplayHoverPause: true,
            });
         </script> -->

                <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>

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
                        $('#table_id').DataTable();
                    });
                </script>

                </body>
                </html>
