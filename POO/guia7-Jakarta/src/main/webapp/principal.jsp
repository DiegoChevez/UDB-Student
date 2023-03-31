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
    <a style="cursor: pointer;" data-bs-toggle="modal" data-bs-target="#exampleModal" class="text-info">Registrese aqui</a>
</div>
<form method="post" action="GeneraSession">
    <input type="hidden" value="salir" name="operacion">
    <input style="margin-left: 45%;" type="submit" value="Cerrar cessi&oacute;n" class="btn btn-success">
</form>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registro personas</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">X</button>
            </div>
            <div class="modal-body">
                <form id="save-form" class="form" action="RegistrarPersona" method="post">
                    <h3 class="text-center text-info">Registro</h3>
                    <div class="form-group">
                        <label for="nombre" class="text-info">Nombre persona:</label><br>
                        <input type="text" name="nombre" id="nombre" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="edad" class="text-info">Edad persona:</label><br>
                        <input type="number" name="edad" id="edad" class="form-control" required min="18" max="100">
                    </div>
                    <div class="form-group">
                        <label for="sexo" class="text-info">Sexo persona:</label><br>
                        <select class="form-control" name="sexo" id="sexo">
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="ocupacion" class="text-info">Ocupacion persona:</label><br>
                        <select class="form-control" name="ocupacion" id="ocupacion">
                            <option value="1">Administrador</option>
                            <option value="2">Jefe de Área</option>
                            <option value="3">Jefe de desarrollo</option>
                            <option value="4">Empleado</option>
                            <option value="5">Programador</option>

                        </select>
                    </div>
                    <div class="form-group">
                        <label for="fecha" class="text-info">Fecha nacimiento persona:</label><br>
                        <input type="date" name="fecha" id="fecha" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="usuario" class="text-info">Usuario:</label><br>
                        <input type="text" name="usuario" id="usuario" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label  class="text-info">Password:</label><br>
                        <input type="password" name="password" class="form-control" required>
                    </div>
                    <div class="form-group">
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
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Ocupación</th>
        <th scope="col">Usuario</th>
        <th scope="col">Contraseña</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
    </tr>
    <tr>
        <th scope="row">2</th>
        <td>Jacob</td>
        <td>Thornton</td>
        <td>@fat</td>
    </tr>
    <tr>
        <th scope="row">3</th>
        <td colspan="2">Larry the Bird</td>
        <td>@twitter</td>
    </tr>
    </tbody>
</table>


</body>
</html>