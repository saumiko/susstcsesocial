<%-- 
    Document   : newuser.jsp
    Created on : Dec 4, 2016, 9:04:37 PM
    Author     : saumiko
--%>

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
        <!-- Theme style -->
        <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
        <!-- iCheck -->
        <link rel="stylesheet" href="plugins/iCheck/square/blue.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="index.html"><b>SUST CSE</b>Social Network</a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body">
                <p class="login-box-msg">SIGN UP</p>

                <form action="userinfoservlet" method="post">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" pattern="[a-zA-Z0-9_.]{3,15}" placeholder="username" name="username" required="required">
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" class="form-control" placeholder="Password" name="password" required="required">
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <select class="form-control div-toggle" data-target=".usercode" name="usertype">
                            <option value="1" data-show=".student">Student</option>
                            <option value="2" data-show=".teacher">Teacher</option>
                            <option value="3" data-show=".employee">Employee</option>
                        </select>
                    </div>

                    <div class="usercode">
                        <div class="student hide">
                            <input type="text" class="form-control" pattern="[0-9]{4}(331)[0-9]{3}" placeholder="Enter your Registration No." id="login-user" name="userid">

                        </div>
                        <div class="teacher hide">
                            <input type="text" class="form-control" pattern="[A-Z]+" placeholder="Enter your Teacher ID" id="login-user" name="userid">

                        </div>
                        <div class="employee hide">
                            <input type="text" class="form-control" pattern="[A-Z]+" placeholder="Enter your Employee ID" id="login-user" name="userid">

                        </div>
                    </div>
                    <p class="login-box-msg"><br>Please provide your real information.</p>
                    <div class="row">
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" style="margin-left: 136%;"class="btn btn-primary btn-block btn-flat">Register</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>
            </div>
            <!-- /.login-box-body -->
        </div>
        <!-- /.login-box -->

        <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
        <script type="text/javascript" src="js/divchange.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="plugins/iCheck/icheck.min.js"></script>
        <script>
            $(function () {
                $('input').iCheck({
                    checkboxClass: 'icheckbox_square-blue',
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%' // optional
                });
            });
        </script>

    </body>
</html>

