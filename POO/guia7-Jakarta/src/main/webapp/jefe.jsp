<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
  HttpSession session_actual= request.getSession(false);
  String usuario =(String) session_actual.getAttribute("USER");
  String nombres =(String) session_actual.getAttribute("NAME");
  String rol =(String) session_actual.getAttribute("ROL");

  if (usuario==null){
    response.sendRedirect("login.jsp");
  }
%>
<html lang="es">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>Bienvenido <%=nombres%></title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/estilo.css">
  <script src="js/bootstrap.min.js" ></script>
</head>
<body class="container">
<h1 class="text-center">Bienvenido a POO404</h1>
<h2 class="text-center">
  Bienvenido: (<%=usuario%>) <%=nombres%> <%=rol%>
</h2>
<div id="register-link" class="btn-sm btn btn-dark">
  <a style="cursor: pointer;" data-bs-toggle="modal" data-bs-target="#exampleModal" class="text-info">Registrar caso</a>
</div>
<form method="post" action="GeneraSession">
  <input type="hidden" value="salir" name="operacion">
  <input style="margin-left: 45%;" type="submit" value="Cerrar cessi&oacute;n" class="btn btn-success">
</form>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Formulario de registro de casos</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">X</button>
      </div>
      <div class="modal-body">
        <form id="save-form" class="form" action="RegistrarCaso" method="post">
          <h3 class="text-center text-info">Ingrese los datos del caso </h3>
          <div class="form-group">
            <label for="nombre" class="text-info">Nombre de caso:</label><br>
            <input type="text" name="nameCase" id="nombre" class="form-control" required>
          </div>

          <div class="form-group">
            <label for="nombre" class="text-info">Descripcion:</label><br>
            <input type="text" name="description" id="descripcion" class="form-control" required>
          </div>

          <div class="form-group">
            <label for="ocupacion" class="text-info">Programador encargado del caso:</label><br>
            <select class="form-control" name="programmer" id="ocupacion">
              <option value="1">Diego</option>
              <option value="2">Cesar</option>
              <option value="3">Erick</option>
              <option value="4">Angie</option>
              <option value="5">Bryan</option>
            </select>
          </div>
          <div class="form-group">
            <label for="fecha" class="text-info">Fecha de ingreso del caso:</label><br>
            <input type="date" name="fecha" id="fecha" class="form-control">
          </div>

          <br>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <input type="submit" name="submit" class="btn btn-info btn-md" form="save-form" value="Enviar">
      </div>
    </div>
  </div>
</div>

</body>
</html>