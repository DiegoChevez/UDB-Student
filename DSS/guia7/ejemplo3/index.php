<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8" />
    <title>CRUD con PDO</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
<div class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-offset-2 col-md-8">
					<h1>Crear, Obtener, Actualizar y Borrar (CRUD) con PDO.</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-offset-2 col-md-8">
			<div class="row">
				<div class="col-md-offset-2 col-md-8">
					<a href="create.php" class="btn btn-primary">Create</a>	
				</div>
			</div>				
		</div>
	</div>
    <div class="row">
        <div class="col-md-offset-2 col-md-8">
			<table class="table table-bordered">
				<thead >
					<tr>
						<th class="text-center">#</th>
						<th class="text-center">Nombre</th>
						<th class="text-center">Apellido</th>
						<th class="text-center">Operaciones</th>
					</tr>
				</thead>
				<tbody>
					<?php 
						include 'connection.php';
						$pdocn = Database::connect();
						$sql = ('SELECT * FROM usuario ORDER BY idusuario DESC');
						foreach ($pdocn->query($sql) as $row) {
						echo 	'<tr>
									<td class="text-center">'.$row["idusuario"].'</td>
									<td class="text-center">'.$row["nombre"].'</td>
									<td class="text-center">'.$row["apellido"].'</td>
									<td class="text-center">
										<a href="read.php?id='.$row["idusuario"].'" class="btn btn-default">Obtener</a>											
										<a href="update.php?id='.$row["idusuario"].'" class="btn btn-success">Modificar</a>
										<a href="read.php?id='.$row["idusuario"].'" class="btn btn-danger">Eliminar</a>
									</td>
								</tr>';
						}
					 ?>						
				</tbody>
			</table>		
        </div>
    </div>
</div>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js" ></script>
</body>
</html>
