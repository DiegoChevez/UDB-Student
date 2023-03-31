<?php
session_start();
session_destroy();
?>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8" />
<title>Contenido no seguro</title>
<link rel="stylesheet" href="css/incripcion_css.css" />
<link rel="stylesheet" href="css/font-league-gothic.css" />
</head>
<body>
<section>
<article>
<div id="boardgame">
<h3>
Ahora estás fuera de la aplicación segura.
</h3>
</div>
</article>
</section>
<br />
<br />
<a href="login.php">Iniciar sesión</a>
</body>
</html>