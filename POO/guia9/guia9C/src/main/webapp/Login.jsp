<%--
  Created by IntelliJ IDEA.
  User: Erick
  Date: 28/3/2023
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>
<body class="container">
<div class="container" id="login-dialog" style="margin-top: 20em;">
  <form class="col-lg-4 col-lg-offset-4" style="border: 1px solid #aaa; text-align: center;" id="login-form" class="form" action="GenerarSession" method="post">
    <div class="form-group">
      &nbsp;
    </div>
    <div class="form-group">
      <label>Username</label> &nbsp;
      <input type="text" id="username" name="username" />
    </div>
    <div class="form-group">
      <label>Password</label> &nbsp;
      <input type="password" id="password" name="password" />
    </div>
    <div class="form-group">
      <input type="submit" value="Login" class="btn btn-primary" />
    </div>
  </form>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
