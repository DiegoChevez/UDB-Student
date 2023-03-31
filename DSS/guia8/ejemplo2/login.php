<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8" />
<title>Autenticación PHP</title>
<link rel="stylesheet" href="css/modernform.css" />
</head>
<body>
<header>
<h1>Formulario de inicio de sesión</h1>
</header>
<section>
<article>
<?php
if(isset($_GET["errorusuario"]))
if($_GET["errorusuario"]=="si"){
?>
<span class="error">
Datos incorrectos
</span>
<?php
}
else{
?>
<span class="msg">
Introduce tu nombre de usuario y contraseña
</span>
<?php
}
?>
<div class="container">
<section class="tabblue">
<ul class="tabs blue">
<li>
<input type="radio" name="tabs blue" id="tab1" checked="">
<label for="tab1">Inicio de sesión</label>
<div id="tab-content1" class="tab-content">
<p>
Ingrese sus datos de usuario.
</p>
<form name="frmclass" id="classname" action="autenticacion.php" method="POST">
<span class="tabaddon"><i class="fa fa-user fa-2x"></i></span>
<input type="text" name="usuario" id="usuario" placeholder="(Ingrese su usuario)" required class="field" />
<span class="tabaddon"><i class="fa fa-degree fa-2x"></i></span>
<input type="password" name="contrasena" id="constrasena" placeholder="(Ingrese su contraseña)" required class="field" />
<div class="btn">
<input type="submit" name="btnSend" id="btnSend" value="Ingresar" />
</div>
</form>
</div>
</li>
</ul>
</section>
</div>
<p>
Debes estar registrado en el sistema para poder ingresar.
Si no estás registrado consulta al administrador, cómo
obtener tu usuario y contraseña.
</p>
</article>
</section>
</body>
</html>