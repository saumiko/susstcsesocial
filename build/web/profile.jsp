<%-- 
    Document   : Profile
    Created on : Dec 5, 2016, 9:24:14 PM
    Author     : saumiko
--%>
<% response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    /*HTTP 1.1*/ response.setHeader("Pragma", "no-cache");
    /*HTTP 1.0*/ response.setDateHeader("Expires", -1);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SUST CSE Social Network</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- jvectormap -->
        <link rel="stylesheet" href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <header class="main-header">

                <!-- Logo -->
                <a href="home.jsp" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>SUST</b></span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>SUST CSE</b>Social Network</span>
                </a>

                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <!-- Navbar Right Menu -->
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- Messages: style can be found in dropdown.less-->
                            <li class="dropdown messages-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-envelope-o"></i>
                                    <span class="label label-success"><!-- কয়টা মেসেজ সেটা লেখা থাকবে --></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header"> </li>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
<!--                                            <li> start message 
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Support Team
                                                        <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                             end message 
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        AdminLTE Design Team
                                                        <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Developers
                                                        <small><i class="fa fa-clock-o"></i> Today</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="dist/img/user3-128x128.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Sales Department
                                                        <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <div class="pull-left">
                                                        <img src="dist/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                                                    </div>
                                                    <h4>
                                                        Reviewers
                                                        <small><i class="fa fa-clock-o"></i> 2 days</small>
                                                    </h4>
                                                    <p>Why not buy a new awesome theme?</p>
                                                </a>
                                            </li>-->
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#">See All Messages</a></li>
                                </ul>
                            </li> 
                            <!-- Notifications: style can be found in dropdown.less -->
                            <li class="dropdown notifications-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-bell-o"></i>
                                    <span class="label label-warning"><!--10--></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="header"><!--You have 10 notifications--></li>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
<!--                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-warning text-yellow"></i> Very long description here that may not fit into the
                                                    page and may cause design problems
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-users text-red"></i> 5 new members joined
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-shopping-cart text-green"></i> 25 sales made
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-user text-red"></i> You changed your username
                                                </a>
                                            </li>-->
                                        </ul>
                                    </li>
                                    <li class="footer"><a href="#">View all</a></li>
                                </ul>
                            </li>
                            <!-- Tasks: style can be found in dropdown.less -->
                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="dist/img/saumik.jpg" class="user-image" alt="User Image">
                                    <span class="hidden-xs">Asif Mohaimen</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="dist/img/saumik.jpg" class="img-circle" alt="User Image">

                                        <p>
                                            Asif Mohaimen
                                            <small>Student</small>
                                        </p>
                                    </li>
                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                        <div class="pull-left">
                                            <a href="myProfile.jsp" class="btn btn-default btn-flat">Profile</a>
                                        </div>
                                        <div class="pull-right">
                                           <form action="LogoutServlet" method="POST">
                                                <button type="submit" class="btn btn-default btn-flat">Sign out</button>
                                            </form>
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
                            <img src="dist/img/saumik.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p>Asif Mohaimen</p>
                            <!--User Type-->
                            <p><i class="fa fa-circle text-success"></i> Student</p>
                        </div>
                    </div>
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="header">Menu</li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-home"></i> <span>Home</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#"><i class="fa fa-circle-o"></i> Friends</a></li>
                                <li><a href="#"><i class="fa fa-circle-o"></i> Class</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-pencil-square-o"></i>
                                <span>Edit Profile</span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-envelope"></i> <span>Mailbox</span>
                                <span class="pull-right-container">
                                    <small class="label pull-right bg-red"><!--5--></small>
                                </span>
                            </a>
                        </li>
                        <li class="header">Groups</li>
                        <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>SUST CSE Batch 2012</span></a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>\লুহা/ [আশাযোগ্য নহে]</span></a></li>
                        <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Unilever G-2</span></a></li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Profile
                    </h1>
                </section>

                <!-- Main content -->
                <section class="content">

                    <div class="row">
                        <div class="col-md-3">

                            <!-- Profile Image -->
                            <div class="box box-primary">
                                <div class="box-body box-profile">
                                    <img class="profile-user-img img-responsive img-circle" src="dist/img/summit.jpg" alt="User profile picture">

                                    <h3 class="profile-username text-center">Summit Haque</h3>

                                    <p class="text-muted text-center">Student</p>

                                    <a href="#" class="btn btn-primary btn-block"><b>Add Friend</b></a>
                                </div>
                                <!-- /.box-body -->
                            </div>
                            <!-- /.box -->

                            <!-- About Me Box -->
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">About Me</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <strong><i class="fa fa-book margin-r-5"></i> Academic Information</strong>

                                    <p class="text-muted">
                                        CSE 4/1
                                    </p>

                                    <hr>

                                    <strong><i class="fa fa-user-md margin-r-5"></i> Registration No.</strong>

                                    <p class="text-muted">2012331014</p>

                                    <hr>

                                    <strong><i class="fa fa-envelope margin-r-5"></i> SUSTian E-mail</strong>

                                    <p class="text-muted">summit.haque@student.sust.edu</p>

                                    <hr>

                                    <strong><i class="fa fa-calendar-check-o margin-r-5"></i> Date of Birth</strong>

                                    <p class="text-muted">November 11, 1993</p>

                                    <hr>

                                    <strong><i class="fa fa-heart margin-r-5"></i> Blood Group</strong>

                                    <p class="text-muted">O(+)ve</p>
                                </div>
                                <!-- /.box-body -->
                            </div>
                            <!-- /.box -->
                        </div>
                        <!-- /.col -->
                        <div class="col-md-9">
                            <div class="nav-tabs-custom">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#activity" data-toggle="tab">Activity</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="active tab-pane" id="activity">
                                        <!-- Post -->
                                        <div class="post">
                                            <div class="user-block">
                                                <img class="img-circle img-bordered-sm" src="dist/img/summit.jpg" alt="user image">
                                                <span class="username">
                                                    <a href="#">Summit Haque</a>
                                                </span>
                                            </div>
                                            <!-- /.user-block -->
                                            <p>
                                                প্রথম পোস্ট! টেস্ট করছি। দেখা যাক কিরকম হয় প্রোফাইল শেষমেষ।
                                            </p>
                                            <ul class="list-inline">
                                                <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-up margin-r-5"></i> Like</a></li>
                                                <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-down margin-r-5"></i> Dislike</a>
                                                </li>
                                                <li class="pull-right">
                                                    <a href="#" class="link-black text-sm"><i class="fa fa-comments-o margin-r-5"></i> Comments
                                                        (5)</a></li>
                                            </ul>

                                            <input class="form-control input-sm" type="text" placeholder="Type a comment">
                                        </div>
                                        <!-- /.post -->
                                        <!-- Post -->
                                        <div class="post">
                                            <div class="user-block">
                                                <img class="img-circle img-bordered-sm" src="dist/img/summit.jpg" alt="user image">
                                                <span class="username">
                                                    <a href="#">Summit Haque</a>
                                                </span>
                                            </div>
                                            <!-- /.user-block -->
                                            <p>
                                                দ্বিতীয় পোস্ট! টেস্ট করছি। দেখা যাক কিরকম হয় প্রোফাইল শেষমেষ।
                                            </p>
                                            <ul class="list-inline">
                                                <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-up margin-r-5"></i> Like</a></li>
                                                <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-down margin-r-5"></i> Dislike</a>
                                                </li>
                                                <li class="pull-right">
                                                    <a href="#" class="link-black text-sm"><i class="fa fa-comments-o margin-r-5"></i> Comments
                                                        (5)</a></li>
                                            </ul>

                                            <input class="form-control input-sm" type="text" placeholder="Type a comment">
                                        </div>
                                        <!-- /.post -->
                                        <!-- Post -->
                                        <div class="post">
                                            <div class="user-block">
                                                <img class="img-circle img-bordered-sm" src="dist/img/summit.jpg" alt="user image">
                                                <span class="username">
                                                    <a href="#">Summit Haque</a>
                                                </span>
                                            </div>
                                            <!-- /.user-block -->
                                            <p>
                                                তৃতীয় পোস্ট! টেস্ট করছি। দেখা যাক কিরকম হয় প্রোফাইল শেষমেষ।
                                            </p>
                                            <ul class="list-inline">
                                                <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-up margin-r-5"></i> Like</a></li>
                                                <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-down margin-r-5"></i> Dislike</a>
                                                </li>
                                                <li class="pull-right">
                                                    <a href="#" class="link-black text-sm"><i class="fa fa-comments-o margin-r-5"></i> Comments
                                                        (5)</a></li>
                                            </ul>

                                            <input class="form-control input-sm" type="text" placeholder="Type a comment">
                                        </div>
                                        <!-- /.post -->
                                        <!-- Post -->
                                        <div class="post">
                                            <div class="user-block">
                                                <img class="img-circle img-bordered-sm" src="dist/img/summit.jpg" alt="user image">
                                                <span class="username">
                                                    <a href="#">Summit Haque</a>
                                                </span>
                                            </div>
                                            <!-- /.user-block -->
                                            <p>
                                                চতুর্থ পোস্ট! টেস্ট করছি। দেখা যাক কিরকম হয় প্রোফাইল শেষমেষ।
                                            </p>
                                            <ul class="list-inline">
                                                <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-up margin-r-5"></i> Like</a></li>
                                                <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-down margin-r-5"></i> Dislike</a>
                                                </li>
                                                <li class="pull-right">
                                                    <a href="#" class="link-black text-sm"><i class="fa fa-comments-o margin-r-5"></i> Comments
                                                        (5)</a></li>
                                            </ul>

                                            <input class="form-control input-sm" type="text" placeholder="Type a comment">
                                        </div>
                                        <!-- /.post -->
                                        <!-- Post -->
                                        <div class="post">
                                            <div class="user-block">
                                                <img class="img-circle img-bordered-sm" src="dist/img/summit.jpg" alt="user image">
                                                <span class="username">
                                                    <a href="#">Summit Haque</a>
                                                </span>
                                            </div>
                                            <!-- /.user-block -->
                                            <p>
                                                পঞ্চম পোস্ট! টেস্ট করছি। দেখা যাক কিরকম হয় প্রোফাইল শেষমেষ।
                                            </p>
                                            <ul class="list-inline">
                                                <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-up margin-r-5"></i> Like</a></li>
                                                <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-down margin-r-5"></i> Dislike</a>
                                                </li>
                                                <li class="pull-right">
                                                    <a href="#" class="link-black text-sm"><i class="fa fa-comments-o margin-r-5"></i> Comments
                                                        (5)</a></li>
                                            </ul>

                                            <input class="form-control input-sm" type="text" placeholder="Type a comment">
                                        </div>
                                        <!-- /.post -->
                                    </div>
                                    <!-- /.tab-pane -->
                                </div>
                                <!-- /.tab-content -->
                            </div>
                            <!-- /.nav-tabs-custom -->
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Alpha</b> Version 
                </div>
                <strong>Copyright &copy; 2016 <a href="http://www.sust.edu">Shahjalal University of Science & Technology</a>.</strong> All rights
                reserved.
            </footer>


        </div>
        <!-- ./wrapper -->

        <!-- jQuery 2.2.3 -->
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- FastClick -->
        <script src="plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/app.min.js"></script>
        <!-- Sparkline -->
        <script src="plugins/sparkline/jquery.sparkline.min.js"></script>
        <!-- jvectormap -->
        <script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
        <!-- SlimScroll 1.3.0 -->
        <script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- ChartJS 1.0.1 -->
        <script src="plugins/chartjs/Chart.min.js"></script>
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="dist/js/pages/dashboard2.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="dist/js/demo.js"></script>
    </body>
</html>
