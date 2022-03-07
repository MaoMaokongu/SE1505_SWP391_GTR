<%-- 
    Document   : account
    Created on : Mar 5, 2022, 10:57:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Account | Data Tables</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="bootstrap.min.css">
        <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">

        <!-- Font Awesome -->
        <link rel="stylesheet" href="font-awesome.min.css">
        <link rel="stylesheet" href="path/to/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
           folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="_all-skins.min.css">
        <!-- font account -->
        <link rel="stylesheet" href="account.css" />
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->

        <!-- Google Font -->
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>

    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <header class="main-header">
                <!-- Logo -->
                <a href="../../index2.html" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>P</b>S</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>Projects System</b></span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- Messages: style can be found in dropdown.less-->
                            <li class="dropdown messages-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-envelope-o"></i>
                                    <span class="label label-success">4</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">You have 4 messages</li>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
                                            <li>
                                                <!-- start message -->
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="Chinh Truong.png" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Chinh Truong - Be
                                                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                    </h4>
                                                    <p>Fighting!!!</p>
                                                </a>
                                            </li>
                                            <!-- end message -->
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="Van Trung.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Van Trung - Fe
                                                        <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                                    </h4>
                                                    <p>Fighting!!!</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="Thanh Phu.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Thanh Phu - Be
                                                        <small><i class="fa fa-clock-o"></i> Today</small>
                                                    </h4>
                                                    <p>Fighting!!!</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="Thanh Hai.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Thanh Hai - Be
                                                        <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                                    </h4>
                                                    <p>Fighting!!!</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="Diu Huong.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Diu Huong - Fe
                                                        <small><i class="fa fa-clock-o"></i> 2 days</small>
                                                    </h4>
                                                    <p>Fighting!!!</p>
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#">See All Messages</a></li>
                                </ul>
                            </li>
                            <!-- Notifications: style can be found in dropdown.less -->
                            <li class="dropdown notifications-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-bell-o"></i>
                                    <span class="label label-warning">6</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header">You have 6 notifications</li>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-users text-aqua"></i> 3 new members joined today
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-warning text-yellow"></i> you have received 1 invited
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-users text-red"></i> 2 new members joined
                                                </a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#">View all</a></li>
                                </ul>
                            </li>

                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="admin.png" class="user-image" alt="User Image">
                                    <span class="hidden-xs">User</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="admin.png" class="img-circle" alt="User Image">

                                        <p>
                                            User
                                            <small>Member since Feb. 2022</small>
                                        </p>
                                    </li>
                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                        <div class="pull-left">
                                            <a href="#" class="btn btn-default btn-flat">Profile</a>
                                        </div>
                                        <div class="pull-right">
                                            <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="admin.png" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>User</p>
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <!-- <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i
                                        class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form> -->
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="treeview active">
                            <a href="#">
                                <i class="fa fa-dashboard"></i> <span>DashBoard</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li class="active"><a href="#"><i class="fa fa-circle-o"></i> Account</a></li>
                                <li><a href="group.jsp"><i class="fa fa-circle-o"></i> Groups</a></li>
                                <li><a href="../../projects.jsp"><i class="fa fa-circle-o"></i> Projects</a></li>
                                <li><a href="ProjectHadSign.jsp"><i class="fa fa-circle-o"></i> Projects Had Signed</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        My Profile
                        <!-- <small>without group</small> -->
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Account</li>
                    </ol>
                </section>

                <!-- Main content -->
                <div class="profile">
                    <div class="left">
                        <img src="user.png" alt="user" width="200">
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
                                                <h4>Điểm mạnh</h4>
                                                <p>C++/C#</p>
                                                <p>Java</p>
                                                <p>Web Design</p>
                                            </div>
                                            <div class="data">
                                                <h4>Đồ án đã chọn</h4>
                                                <p>Web đăng kí đồ án</p>
                                            </div>
                                        </div>
                                        <div class="editprofile">
                                            <a href="#">Edit</a>&emsp;&emsp;&emsp;<a href="#">Save</a>
                                        </div>
                                    </div>

                                </div>
                                </div>
                                <!-- /.content -->
                                </div>


                                <!-- Add the sidebar's background. This div must be placed
                               immediately after the control sidebar -->
                                <div class="control-sidebar-bg"></div>
                                </div>
                                <!-- ./wrapper -->

                                <!-- jQuery 3 -->
                                <script src="jquery.min.js"></script>
                                <!-- Bootstrap 3.3.7 -->
                                <script src="bootstrap.min.js"></script>
                                <!-- SlimScroll -->
                                <script src="jquery.slimscroll.min.js"></script>
                                <!-- FastClick -->
                                <script src="fastclick.js"></script>
                                <!-- AdminLTE App -->
                                <script src="adminlte.min.js"></script>
                                <!-- AdminLTE for demo purposes -->
                                <script src="demo.js"></script>
                                <!-- page script -->
                                </body>

                                </html>
