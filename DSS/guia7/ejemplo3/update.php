<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8" />
	<title>Actualizar información del usuario con PDO</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
<div class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-offset-2 col-md-8">
					<h1>Actualizar</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-offset-2 col-md-8">
			<div class="row">
				<div class="col-md-offset-2 col-md-8">
					<a href="index.php" class="btn btn-default">Back</a>	
				</div>
			</div>				
		</div>
	</div>
    <div class="row">
        <div class="col-md-offset-2 col-md-8">
        <form action="update.php" method="POST">
<?php 
$id=null;
if (!empty($_GET)) {
$id=$_GET['id'];
include 'connection.php';
$cn =  Database::connect();
$cn->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
$query = $cn->prepare("SELECT * FROM usuario where idusuario = ?");
$query->execute(array($_GET['id']));
$data = $query->fetch(PDO::FETCH_ASSOC);	
echo '
	<div>
		<label for="-">-</label>
		<input type="text" value="'.$data["idusuario"].'" class="cod" readonly="readonly" name="idusuario">
	</div>
	<div>
		<label for="-">-</label>
		<input type="text" value="'.$data["nombre"].'" placeholder="Nombre cuenta" name="nombre">
	</div>
	<div>
		<label for="-">-</label>
		<input type="text" value="'.$data["apellido"].'" placeholder="Descripcion"  name="apellido">
	</div>
	<div>
		<label for="-">-</label>
		<input type="text" value="'.$data["edad"].'" placeholder="Tipo"  name="edad">
	</div>
	<div>
		<label for="-">-</label>
		<input type="text" value="'.$data["genero"].'" placeholder="Er"  name="genero">
	</div>
	<div>
		<label for="-">-</label>
		<input type="text" value="'.$data["ciudad"].'" placeholder="Er"  name="ciudad">
	</div>
';
Database::disconnect();
}	
?>
		<div>
			<input type="submit" class="btn btn-success" value="Actualizar">
		</div>
	    </form>
        </div>
    </div>
</div>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js" ></script>
</body>
</html>
<?php 
if (!empty($_POST)) {
	include 'connection.php';
	$id = trim($_POST['idusuario']);
	$nombre = trim($_POST['nombre']);
	$apellido = trim($_POST['apellido']);
	$edad = trim($_POST['edad']);
	$genero = trim($_POST['genero']);
	$ciudad = trim($_POST['ciudad']);
	$cnu = Database::connect();
	$cnu->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	$query = $cnu->prepare("UPDATE usuario SET nombre = ?, apellido = ?, edad = ?, genero = ?, ciudad= ? WHERE idusuario = ?");
	$query->execute(array($nombre, $apellido, $edad, $genero, $ciudad, $id));
	Database::disconnect();
	header("Location: index.php");
}
?>
