<!DOCTYPE html>
<html lang="es">
<head>
 <meta charset="utf-8" />
 <title>Operaciones con directorios</title>
 <link rel="stylesheet" href="css/filemanager.css" />
</head>
<body>
<header>
<h1>Operaciones con el directorio 
<?php
 error_reporting(E_ALL & ~E_NOTICE);
 if($_GET['directorio'] == "."):
 $nombre_directorio = " Raíz";
 else:
 $nombre_directorio = " " . basename($_GET['directorio']);
 endif;
 echo basename($nombre_directorio);
 $valor_directorio = rawurlencode($_GET['directorio']);
?>
</h1>
</header>
<section>
 <article>
 <?php
 $form = "\n\t\t<form method=\"POST\" 
action=\"operacion.php?operacion=0&directorio=";
 $form .= $valor_directorio . "\">\n\t\t\t";
 echo $form;
 ?>
 <input type="image" name="crear" id="crear" src="img/newfolder.png" alt="Crear 
directorio" />
 <label for="crear">Crear</label>
 <label for="nombre_directorio">Nombre directorio</label>
 <input type="text" name="nombre_directorio" id="nombre_directorio" 
placeholder="Nombre del directorio" /><br />
 </form>
 <?php
 $form = "\n\t\t<form method=\"POST\" action=";
 $form .= "\"operacion.php?operacion=1&directorio=$valor_directorio\">\n\t\t\t";
 echo $form;
 ?>
 <input type="image" name="mostrar" id="mostrar" src="img/folderopenfiles.jpg" 
alt="Mostrar directorio completo" />
 <label for="mostrar">Mostrar</label>
 </form>
 <?php
 $form = "<form method=\"POST\" action=\"operacion.php?operacion=2&directorio=";
 $form .= "$valor_directorio\">\n\t\t\t";
 echo $form;
 ?>
 <input type="image" name="borrar" id="borrar" src="img/deletefolder.png" 
alt="Borrar directorio" />
 <label for="borrar">Borrar</label>
 </form>
 <?php
 $form = "<form method=\"POST\" action=\"";
 $form .= "administrador.php?directorio=$valor_directorio\">\n\t\t\t";
 echo $form;
 ?>
 <input type="submit" name="volver" value="Volver al directorio" />
 </form>
 </article>
</section>
</body>
<script src="js/modernizr.custom.lis.js"></script>
</html>