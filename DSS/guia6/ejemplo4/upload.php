<!DOCTYPE html>
<html lang="es">
<head>
 <meta charset="utf-8" />
 <title>Subir múltiples archivos</title>
 <link rel="stylesheet" 
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
 <link rel="stylesheet" href="css/upload.css" />
</head>
<body>
<?php 
define("PATH", "archivos");
 //Verificar que la matriz asociativa $_FILES["archivos"] haya sido definida
 if (isset($_FILES["archivos"])) {
 //De ser así se procesa cada uno de los archivos.
 //Para poder hacerlo es conveniente obtener la cantidad 
 //de elementos que tiene matriz $_FILES["archivos"]
 $total = count($_FILES["archivos"]["name"]);
 //este for recorre la matriz $_FILES
 for($i = 0; $i < $total; $i++){
 //Las propiedades definidas para cada archivo son: 
 //1. 'tmp_dir': directorio temporal en el servidor donde se aloja el archivo
 //2. 'name': nombre original del archivo seleccionado por el usuario
 //3. 'size': tamaño en bytes del archivo
 //Para recorrer uno a uno los archivos que se hayan decidido subir al servidor
 //se utilizará el contador $i. En caso de que solo se suba un archivo el ciclo
 //se ejecutará una sola vez.
 $tmp_name = $_FILES["archivos"]["tmp_name"][$i];
 $name = $_FILES["archivos"]["name"][$i];
 $size = $_FILES["archivos"]["size"][$i];
 //echo "<h3>$size bytes</h3>";
 if($size > 2621440){
 echo "<h3>El tamaño del archivo es superior al admitido por el 
servidor</h3><br>";
 echo "<a href=\"uploadfile.html\">Intentar de nuevo</a>";
 }
 echo "<h3 class=\"title\">Archivo " . ($i+1) . ":</h3>";
 echo "<b>el nombre original:</b> ";
 echo $name;
 echo "<br />";
 echo "<b>el nombre temporal:</b> \n";
 echo $tmp_name;
 echo "<br />";
 echo "<b>el tamaño del archivo:</b> \n";
 echo number_format($size, 2);
 echo " bytes<br />";
 //Verificar la carpeta en el servidor donde se alojarán los archivos 
 //que se desean subir. Si no existe esta carpeta se creará y si no
 //es posible crearla se lanzará un error y se terminará el script
 if(!file_exists(PATH)){
 //Crear el directorio y asignar los permisos al mismo
 if(!mkdir(PATH, 0777, true)) {
 die('No se ha podido crear el directorio');
 }
 }
 //Una vez que es procesado cada archivo correctamente, se moverá 
 //a una carpeta específica en el servidor, en este caso se usará 
 //la carpeta files/.
 if(move_uploaded_file($tmp_name, PATH . "/" . utf8_decode($name))){
 echo "Se ha cargado correctamente el archivo " . 
 "<a href=\"archivos/" . urldecode($name) . "\" target=\"_blank\">" . 
$name . "</a>\n" . " en el servidor.\n<br />\n";
 }
 else{
 switch($_FILES['archivos']['error'][$i]){
 //No hay error, pero puede ser un ataque
case UPLOAD_ERR_OK:
 echo "<p>Se ha producido un problema con la carga del archivo.</p>\n";
break;
 //El tamaño del archivo es mayor que upload_max_filesize
case UPLOAD_ERR_INI_SIZE:
 echo "<p>El archivo es demasiado grande, no se puede cargar.</p>\n";
 break;
 //El tamaño del archivo es mayor que MAX_FILE_SIZE
case UPLOAD_ERR_FORM_SIZE:
 echo "<p>El archivo es demasiado grande, no se pudo cargar.</p>\n";
 break;
 //Solo se ha cargado parte del archivo
case UPLOAD_ERR_PARTIAL:
 echo "<p>Sólo se ha cargado una parte del archivo.</p>\n";
break;
 //No se ha seleccionado ningún archivo para subir
case UPLOAD_ERR_NO_FILE:
 echo "<p>Debe elegir un archivo para cargar.</p>\n";
break;
 //No hay directorio temporal
case UPLOAD_ERR_NO_TMP_DIR:
 echo "<p>Problema con el directorio temporal. Parece que no 
existe</p>\n";
 break;
 default:
 echo "<p>Se ha producido un problema al intentar mover el archivo " 
. $name . "</p>\n";
 break;
 }
 }
 }
 }
 else{
 echo "<h3>No se han seleccionado archivos.</h3>";
 }
?>
</body>
</html>