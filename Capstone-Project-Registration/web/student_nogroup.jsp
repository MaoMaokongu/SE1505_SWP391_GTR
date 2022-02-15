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
        <title>List Student have no group</title>
    </head>

    <body>
        <c:set var="loginUser" value="${sessionScope.USER}"></c:set>
        <c:if test="${loginUser == null || loginUser.role.name ne 'Student'}">
            <c:redirect url="index.jsp"></c:redirect>
        </c:if>
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
                        Project Registration
                    </div>
                </div>
                <div class="list-group list-group-flush my-3">
                    <a href="studentproject.jsp"
                       class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-project-diagram me-2"></i>Projects</a>
                    <a href="studentprofile.jsp"
                       class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                            class="fas fa-user me-2"></i>Account</a>
                    <a href="MessageController"
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
                        <h2 class="fs-2 m-0">List Student have no group</h2>
                    </div>

                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle second-text fw-bold" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fas fa-user me-2"></i>${sessionScope.USER.userName}
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
                        <h3 class="fs-4 mb-3"></h3>
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
                            ${requestScope.INVITE}
                            <table class="table bg-white rounded shadow-sm  table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col" width="50">#</th>
                                        <th scope="col" width="50">User ID</th>
                                        <th scope="col" width="50">Email</th>
                                        <th scope="col" width="50">Username</th>
                                        <th scope="col" width="50">Gender</th>
                                        <th scope="col" width="50"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- 1.LIST_INVITATION_BYGROUP -->
                                    <c:forEach var="invitation" varStatus="counter" items="${requestScope.LIST_INVITATION_BYGROUP}">
                                        <tr>
                                            <th>${counter.count}</th>
                                            <td>${invitation.user.userId}</td>
                                            <td>${invitation.user.email}</td>
                                            <td>${invitation.user.userName}</td>
                                            <td>${invitation.user.gender}</td>
                                            <td>
                                                <button id="demo" type="button" class="btn btn-primary">${invitation.status.name}</button>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                        
                                    <!-- 2.LIST_NO_GROUP_USER -->
                                    <c:forEach var="usernogroup" varStatus="counter" items="${requestScope.LIST_NO_GROUP_USER}">
                                        <tr>
                                            <th>${counter.count}</th>
                                            <td>${usernogroup.userId}</td>
                                            <td>${usernogroup.email}</td>
                                            <td>${usernogroup.userName}</td>
                                            <td>${usernogroup.gender}</td>
                                            <td>
                                                <c:url var="invite" value="InviteUserController">
                                                    <c:param name="receiver_email" value="${usernogroup.email}"></c:param>
                                                    <c:param name="sender_email" value="${sessionScope.USER.email}"></c:param>
                                                    <c:param name="group_name" value="${sessionScope.USER.group.name}"></c:param>
                                                </c:url>
                                                <!--<button id="demo" type="button" class="btn btn-primary" onclick="myFunction()">invite</button>-->   
                                                <a href="${invite}" id="change" class="btn btn-primary" type="button" onclick="myFunction()">Invite</a>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
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
            function myFunction() {
                document.getElementById("change").innerHTML = "Pending...";
                
                // document.getElementById("demo").style.color = "red";
            }
        </script> 
    </body>

</html>