<%--
  Created by IntelliJ IDEA.
  User: Erick
  Date: 28/3/2023
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html><html>
<head>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

  <title>Macs R Poo</title>

  <style>
    .inline-80 {
      display: inline-block;
      width: 80px;
    }
  </style>
</head>
<body>
<div>
  &nbsp;
</div>



<div>
  &nbsp;
</div>

<div class="container" id="menu">
  <form method="post" action="GenerarSession">
    <input type="hidden" value="salir" name="operacion">
    <input style="margin-left: 45%;" type="submit" value="Cerrar cessi&oacute;n" class="btn btn-success">
  </form>
</div>

<div>
  &nbsp;
</div>

<div class="container" id="listing">
  <h3>Listing</h3>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>Code</th>
      <th>Description</th>
      <th>UOM</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>NU-CH-000001</td>
      <td>Chocolate chip cookies</td>
      <td>Pack</td>
      <td>
        <a href="#" class="btn btn-default">Edit</a> &nbsp;
        <a href="#" class="btn btn-default">Default</a>
      </td>
    </tr>
    </tbody>
  </table>
</div>

<div class="container" id="new-entry">
  <h3>New Entry</h3>
  <form>
    <div class="form-group">
      <label class="inline-80">Code</label> &nbsp;
      <input type="text" id="code" />
    </div>
    <div class="form-group">
      <label class="inline-80">Description</label> &nbsp;
      <input type="text" id="descr" />
    </div>
    <div class="form-group">
      <label class="inline-80">UOM</label> &nbsp;
      <input type="text" id="uom" />
    </div>
    <div class="form-group">
      <input type="submit" value="Save" class="btn btn-primary" />
    </div>
  </form>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>