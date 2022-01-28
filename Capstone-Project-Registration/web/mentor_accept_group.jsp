<%-- 
    Document   : lecturer - projectlist
    Created on : Jan 25, 2022, 9:39:09 AM
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
        <link rel="stylesheet" href="css/styles.css" />
        <title>Lecturer Projects List</title>
    </head>

    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar -->
            <div class="bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom">
                    <img src="img/logo.png" width="80px" height="80px">
                    <div>
                        Project Registration
                    </div>
                </div>
                <div class="list-group list-group-flush my-3">
                    <a href="#"
                       class="list-group-item list-group-item-action bg-transparent second-text active"><i
                            class="fas fa-project-diagram me-2"></i>List of Groups</a>
                    <a href="mentor_view_group.jsp"
                       class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-user me-2"></i>Projects Guide</a>
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
                        <h2 class="fs-2 m-0">List of Groups Registers Project</h2>
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
                                    <i class="fas fa-user me-2"></i>Lecturer
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
                    <div class="list d-flex align-items-center justify-content-start">
                        <button type="button" class="btn btn-warning btn-sm btn-student">Import New Semester</button>
                        <button type="button" class="btn btn-primary btn-sm btn-student">Import Excel</button>
                    </div>

                    <div class="row my-5">
                        <h3 class="fs-4 mb-3">Projects Guide</h3>
                        <!-- Search -->
                        <div class="d-flex flex-row">
                            <div class="input-group d-flex justify-content-start">
                                <div class="form-outline">
                                    <input type="search" id="form1" class="form-control" />
                                </div>
                                <button type="button" class="btn btn-primary" style="margin-bottom: 15px">
                                    <i class="fas fa-search"></i>
                                </button>
                            </div>

                            <!-- filter -->
                            <div class="list d-flex align-items-center justify-content-start">
                                <i class="fas fa-filter"></i>
                                <select class="select">
                                    <option>Spring 2022</option>
                                    <option value="web">Fall 2021</option>
                                    <option value="mobile">Summer 2021</option>
                                    <option value="desktop">Spring 2021</option>
                                </select>
                            </div>

                        </div>
                        <div class="col">
                            <table class="table bg-white rounded shadow-sm  table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col" width="50">#</th>
                                        <th scope="col">Projects</th>
                                        <th scope="col">Group</th>
                                        <th scope="col">Group Leader</th>
                                        <th scope="col"></th>
                                        <th scope="col"></th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Web Develope</td>
                                        <td>Group 1</td>
                                        <td>Phu</td>
                                        <td><button class="btn btn-primary">Details</button></td>
                                        <td>
                                            <button class="btn1">Accept</button>
                                            <button class="btn2">Deny</button>
                                        </td>


                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>App Mobile</td>
                                        <td>Group 2</td>
                                        <td>Huong</td>
                                        <td><button class="btn btn-primary">Details</button></td>
                                        <td>
                                            <button class="btn3">Accept</button>
                                            <button class="btn4">Deny</button>
                                        </td>


                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>Desktop App</td>
                                        <td>Group 3</td>
                                        <td>Bao</td>
                                        <td><button class="btn btn-primary">Details</button></td>
                                        <td>
                                            <button class="btn5">Accept</button>
                                            <button class="btn6">Deny</button>
                                        </td>


                                    </tr>

                                </tbody>
                            </table>

                        </div>
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

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('.btn1').click(function () {
            $(this).addClass("loader1");

            setTimeout(function () {
                $('.btn1').addClass("finished1");
                $('.btn1').removeClass("loader1");
            }, 3500);

            // setTimeout(function() {
            //     $('.btn').removeClass("finished");
            //     $('.btn').removeClass("loader");
            // }, 6500);
        })
    })
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.btn2').click(function () {
            $(this).addClass("loader2");

            setTimeout(function () {
                $('.btn2').addClass("finished2");
                $('.btn2').removeClass("loader2");
            }, 3500);

            // setTimeout(function() {
            //     $('.btn').removeClass("finished");
            //     $('.btn').removeClass("loader");
            // }, 6500);
        })
    })
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.btn3').click(function () {
            $(this).addClass("loader3");

            setTimeout(function () {
                $('.btn3').addClass("finished3");
                $('.btn3').removeClass("loader3");
            }, 3500);
        })
    })
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.btn4').click(function () {
            $(this).addClass("loader4");

            setTimeout(function () {
                $('.btn4').addClass("finished4");
                $('.btn4').removeClass("loader4");
            }, 3500);
        })
    })
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.btn5').click(function () {
            $(this).addClass("loader5");

            setTimeout(function () {
                $('.btn5').addClass("finished5");
                $('.btn5').removeClass("loader5");
            }, 3500);
        })
    })
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('.btn6').click(function () {
            $(this).addClass("loader6");

            setTimeout(function () {
                $('.btn6').addClass("finished6");
                $('.btn6').removeClass("loader6");
            }, 3500);
        })
    })
</script>
</body>
</html>
