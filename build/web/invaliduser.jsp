<%-- 
    Document   : ForgotPassword
    Created on : Dec 4, 2016, 9:33:05 PM
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
      <p class="login-box-msg"><strong>Password Assistance</strong></p>
      <p class="login-box-msg">Enter your SUSTian E-mail<br><small>Your login credentials will be sent here.</small></p>
    <p class="login-box-msg"></p>
    <form action="forgotpassservelet" method="post">
      <div class="form-group has-error">
          <input type="text" class="form-control" id="inputError" name="mail" pattern="[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+(@student.sust.edu)|[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+(@sust.edu)" required="required">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        <span class="help-block">No user found with this e-mail account!</span>
      </div>
      <br>
      <div class="row">
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" style="margin-left: 136%;" class="btn btn-primary btn-block btn-flat">Submit</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
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
