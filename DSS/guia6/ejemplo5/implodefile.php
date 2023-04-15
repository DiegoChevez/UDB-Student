<!DOCTYPE html>
<html lang="es">
<head>
 <meta charset="utf-8" />
 <title>Accediendo a las líneas de un archivo</title>
 <link rel="stylesheet" href="css/form.css" />
</head>
<body>
<header>
 <h2>Uso de explode e implode</h2>
</header>
<section>
<article>
<?php
 include_once("functions.lib.php");
 if(!isset($_POST['submit'])):
 showform();
 else:
 processfile();
 endif;
?>
</article>
</section>
</body>
</html>