<!DOCTYPE html>
<html lang="es">
<head>
 <meta charset="utf-8" />
 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
 <meta name="viewport" content="width=device-width, initial-scale=1"/>
 <title>Administrador de archivos</title>
 <link rel="stylesheet" href="css/filemanager.css" />
 <!--[if IE]>
 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
 <![endif]-->
</head>
<body>
<header>
 <h1>Administrador de archivos</h1>
</header>
<section>
<article id="manager">
<?php
 if(!isset($_GET['directorio']) || $_GET['directorio'] == "."):
 $directorio = ".";
 $nombre_directorio = "/";
 else:
 if(isset($_GET['directorio']) && $_GET['directorio'] !== null):
 $directorio = $_GET['directorio'];
 $nombre_directorio = "\t" . basename($directorio);
 endif;
 endif;
 //Cambiar al directorio que se ha recibido como parámetro en la URL
 if(!chdir($directorio)):
 die("<h3>ERROR: No se puede acceder a este directorio</h3>");
 endif;
 $tabla = "<table>\n\t";
 $tabla .= "<caption>Elementos del directorio: $nombre_directorio</caption>\n\t";
 //Abrir el manejador del directorio
 $manejador = opendir(".");
 //Procesar todos los elementos del directorio que también pueden ser directorios
 while($elemento = readdir($manejador)):
 if(is_dir($elemento) && ($elemento != "." && !($directorio == "." && $elemento == 
".."))):
 if($elemento == ".."):
 $ruta = dirname($directorio);
 $item = "<span>Directorio anterior</span>";
 else:
 $ruta = $directorio . "/" . $elemento;
 $item = "<span>$elemento</span>";
 endif;
 $tabla .= "<tr>\n\t\t<td>\n\t\t\t";
 $tabla .= "<a href=\"administrador.php?directorio="; 
 $tabla .= rawurlencode($ruta) . "\">\n\t\t\t\t";
 $tabla .= "<img src=\"img/openfolder.png\" alt=\"Cambiar a $elemento\" 
/>\n\t\t\t";
 $tabla .= "</a>\n\t\t";
 $tabla .= "</td>\n\t";
 $tabla .= "<td>\n\t\t\t";
 $tabla .= $elemento;
 $tabla .= "</td>\n\t\t</tr>\n\t";
 //echo $tabla;
 endif;
 endwhile;
 //Rebobinar el manejador de directorio
 rewinddir($manejador);
 //Procesar todos los elementos del directorio que son archivos
 while($elemento = readdir($manejador)):
 if(!is_dir($elemento)):
 $tabla .= "<tr>\n\t\t";
 $tabla .= "<td>\n\t\t\t";
 $tabla .= "<a href=\"" . $directorio . "/" . $elemento . "\">\n\t\t\t\t";
 $tabla .= "<img src=\"img/file.jpg\" alt=\"Mostrar $elemento\" />\n\t\t\t";
 $tabla .= "</a>\n\t\t";
 $tabla .= "</td>\n\t\t";
 $tabla .= "<td>$elemento</td>\n\t\t";
 $tabla .= "<td>\n\t\t\t";
 $tabla .= "<a href=\"operacionesarchivo.php?directorio="; 
 $tabla .= rawurlencode($directorio . "/" . $elemento) . "\">\n\t\t\t\t";
 $tabla .= "<img src=\"img/toolsicon.png\" alt=\"Operaciones con $elemento\" 
/>\n\t\t\t";
 $tabla .= "</a>\n\t\t";
 $tabla .= "</td>\n\t";
 $tabla .= "</tr>\n";
 endif;
 endwhile;
 //Cerrar el manejador de directorio
 closedir($manejador);
 $tabla .= "</table>\n";
 echo $tabla;
?>
</article>
</section>
</body>
<script src="js/modernizr.custom.lis.js"></script>
</html>