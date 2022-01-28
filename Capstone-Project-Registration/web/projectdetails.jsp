<%-- 
    Document   : projectdetails
    Created on : Jan 23, 2022, 10:03:43 PM
    Author     : admin
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
        <title>Student Notification</title>
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
                    <a href="#"
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

                <div class="container">

                    <div class="main">
                        <div class="home">
                            <div class="left">
                                <h1 class="heading-1">the light star</h1>
                                <img src="img/news.jpg" class="home-img" alt="Paper photo">

                                <h2 class="heading-2">
                                    Lorem ipsum dolor sit amet consectetur adipisicing elit cupiditate possimus.Lorem ipsum dolor sit, amet consectetur adipisicing elit. Odio, veritatis!Lorem ipsum dolor sit, amet consectetur adipisicing elit. Odio, veritatis!
                                </h2>
                            </div>

                            <div class="right">
                                <!-- <h3 class="heading-3">Another Project</h3>
                                <div class="lists">
                                  <div class="list">
                                    <img src="img/list-img-1.jpg" alt="photo 1">
                                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Odio, veritatis!</p>
                                  </div>
                      
                                  <div class="list">
                                    <img src="img/list-img-2.jpg" alt="photo 2">
                                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Odio, veritatis!</p>
                                  </div>
                      
                                  <div class="list">
                                    <img src="img/list-img-3.jpg" alt="photo 3">
                                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Odio, veritatis!</p>
                                  </div>
                      
                                  <div class="list">
                                    <img src="img/list-img-4.jpg" alt="photo 4">
                                    <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Odio, veritatis!</p>
                                  </div>
                                </div>
                              </div> -->
                            </div>
                            <!-- <div class="content">
                              <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Odio, veritatis!</p>
                            </div> -->
                        </div>

                        <!-- <article>
                          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eos suscipit labore nihil voluptatum recusandae facere dicta veritatis iusto tempore, debitis officia qui nostrum repellendus autem numquam obcaecati sunt itaque in repudiandae expedita omnis saepe modi explicabo error! Sunt quaerat vitae omnis eaque culpa nihil sequi velit ullam fugiat, cupiditate atque quasi eum obcaecati, cumque officiis iure ipsam! Inventore voluptate dignissimos nemo! In exercitationem rerum sunt quo maxime consequatur ab accusamus explicabo voluptatem ratione. Eveniet hic, quibusdam repellendus illum quas provident corrupti dolores assumenda quis explicabo rerum reiciendis, tempore expedita iure ab numquam, facilis officia pariatur veritatis iste mollitia quam neque.</p>
                  
                          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Sapiente sint assumenda, alias blanditiis tempora quae, ea necessitatibus magnam velit culpa expedita optio voluptatem. Ad tenetur iure quisquam inventore! In sunt error quis magni quibusdam quos alias id odio eius eum, nostrum odit voluptates iste delectus harum labore nulla est quo?</p>
                  
                          <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam aliquid molestiae, dolore cupiditate iusto cumque et sit praesentium magni fuga! Saepe neque rerum, illo possimus quasi ipsum nostrum sapiente sequi harum asperiores unde pariatur officia magni tempore, ipsa molestias odit eligendi aspernatur sunt soluta dolores suscipit? Modi consectetur porro similique. Eaque magnam quae doloribus voluptates pariatur nulla beatae non tempore nisi, explicabo sequi. Quisquam blanditiis aliquam optio culpa! Placeat fugiat a aliquid fuga accusamus non minus reiciendis quia delectus! Maxime, facere laborum, reprehenderit aut obcaecati cumque cupiditate quam a ex consectetur velit ipsa? Repellat dolor voluptate esse, placeat eius veniam quae atque sapiente sunt autem. Quod ea ducimus illo voluptatum eveniet in assumenda voluptates veritatis numquam magnam consequuntur sunt explicabo, harum dolorum nostrum laborum fugiat velit! Perferendis consectetur totam voluptatem commodi sapiente quas? Modi voluptas laborum officia atque consequuntur quos ipsum incidunt vero corrupti fuga maiores, enim at ex dolores!</p>
                        </article>
                      </div>
                    </div>
                  
                    <blockquote>
                      Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut, perferendis nisi. Nisi, obcaecati sed. Doloremque omnis minima esse ullam cupiditate sint accusantium, itaque temporibus delectus commodi quidem atque id aut, nam, dolorum eligendi impedit. Porro labore dolore et accusamus, ea alias omnis eveniet dolor voluptate veritatis. Nisi assumenda perspiciatis facilis tenetur a ducimus atque dolorum. Non maiores porro minima incidunt quod deserunt ullam id error veniam debitis! Quia, nulla aspernatur.
                    </blockquote> -->
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
