<?php
 //Función que muestra todos los elementos descendientes directos
 //o indirectos del directorio que se pasa como parámetro
 function mostrar_arbol($raiz){
 $nivel = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
 echo $nivel . "<img src=\"directorio.gif\" alt=\"$raiz\" />";
 echo "<span>$raiz</span><br />";
 $manejador = opendir(".");
 while($elemento = readdir()):
 if(!is_dir($elemento)):
 echo $nivel . $nivel . "<img src=\"archivo.gif\" alt=\"$elemento\" 
/>\n\t\t\t";
 echo $elemento . "<br />\n\t\t\t";
 endif;
 endwhile;
 rewinddir($manejador);
 while($elemento = readdir($manejador)):
 if(is_dir($elemento) && $elemento != "." && $elemento != ".."):
 chdir($elemento);
 mostrar_arbol("$raiz/$elemento");
 endif;
 endwhile;
 closedir($manejador);
 chdir("..");
 }
 //Función que determina si ya existe en el directorio
 //el nombre que se proporciona como parámetro
 function existe_en_directorio($nombre){
 return file_exists($nombre);
 }
 //Función que determina si el directorio actual se encuentra vacío
 function esta_vacio_directorio(){
 $manejador = opendir(".");
 $contador = 0;
 while($elemento = readdir($manejador)):
 $contador++;
 endwhile;
 closedir($manejador);
 return ($contador == 2);
 }
 //Función que escribe un botón que al ser pulsado vuelve 
 //a mostrar el directorio indicado como parámetro
 function escribir_boton_volver($directorio){
 return "<form method=\"POST\" action=\"administrador.php?directorio=" .
 rawurlencode("$directorio") . "\">\n\t\t\t" .
 "<input type=\"submit\" name=\"volver\" value=\"Volver\" />\n\t\t" .
 "</form>\n\t";
 }
 //Función que muestra un mensaje de error y termina la ejecución del script
 function error($numero, $directorio){
 $htmlstr = "<!DOCTYPE html>\n";
 $htmlstr .= "<html lang=\"es\">\n";
 $htmlstr .= "<head>\n\t";
 $htmlstr .= "<title>Página de error</title>\n";
 $htmlstr .= "</head>\n";
 $htmlstr .= "<body>\n\t<header>\n\t\t";
 $htmlstr .= "<h1>ERROR: No se puede ";
 switch($numero):
 case 0:
 $htmlstr .= "acceder a este directorio</h1>\n\t";
 break;
 case 1:
 $htmlstr .= "crear este directorio</h1>\n\t";
 break;
 case 2:
 $htmlstr .= "borrar este directorio</h1>\n\t";
 break;
 case 3:
 $htmlstr .= "borrar este archivo</h1>\n\t";
 break;
 case 4:
 $htmlstr .= "copiar este archivo</h1>\n\t";
 break;
 case 5:
 $htmlstr .= "renombrar este archivo</h1>\n\t";
 break;
 endswitch;
 $htmlstr .= escribir_boton_volver($directorio) . "</header>\n</boby>\n</html>";
 die($htmlstr);
 }
 if(isset($_GET['directorio']) && ($_GET['directorio'] != null || $_GET['directorio'] != 
"")):
 $elemento = basename($_GET['directorio']);
 $ruta = dirname($_GET['directorio']);
 endif;
 //Cambio de directorio
 if(isset($_GET['operacion'])):
 if(($_GET['operacion'] >= 0 && $_GET['operacion'] <= 2 && !chdir($_GET['directorio'])) 
|| ($_GET['operacion'] >= 3 && $_GET['operacion'] <= 5 && !chdir($ruta))):
 error(0, ".");
 endif;
 //Ejecutar la operación requerida
 switch($_GET['operacion']):
 case 0:
 if(empty($_POST['nombre_directorio']) || 
 existe_en_directorio($_POST['nombre_directorio']) ||
 !mkdir($_POST['nombre_directorio'], 0777)):
 error(1, $_GET['directorio']);
 endif;
 $ruta = $_GET['directorio'];
 break;
 case 1:
 $htmlstr = "<!DOCTYPE html>\n";
 $htmlstr .= "<html lang=\"es\">\n";
 $htmlstr .= "<head>\n\t";
 $htmlstr .= "<title>Página de error</title>\n";
 $htmlstr .= "</head>\n";
 $htmlstr .= "<body>\n\t<header>\n\t\t";
 $htmlstr .= "<h1>Árbol completo de $elemento</h1>\n\t";
 $htmlstr .= "</header>\n";
 echo $htmlstr;
 break;
 case 2:
 if(!esta_vacio_directorio() || !rmdir(".")):
 error(2, $_GET['directorio']);
 endif;
 break;
 case 3:
 if(empty($elemento) || !existe_en_directorio($elemento) || 
 !unlink($elemento)):
 error(3, $ruta);
 endif;
 break;
 case 4:
 if(empty($_POST['destino']) || existe_en_directorio($_POST['destino']) ||
 !copy($elemento, $_POST['destino'])):
 error(4, $ruta);
 endif;
 break;
 case 5:
 if(empty($_POST['nuevo_nombre']) || 
existe_en_directorio($_POST['nuevo_nombre']) ||
 !rename($elemento, $_POST['nuevo_nombre'])):
 error(5, $ruta);
 endif;
 break;
 endswitch;
 endif;
 if(isset($_GET['operacion']) && $_GET['operacion'] != 1):
 header("Location: administrador.php?directorio=" . rawurlencode($ruta));
 endif;
?>
