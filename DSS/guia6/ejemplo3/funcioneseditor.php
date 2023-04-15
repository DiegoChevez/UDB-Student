<?php
 define("PATH", "archivos");
 function displayfilelist($message = ""){
 displaypageheader();
 if(!file_exists(PATH)) die("No se encontró el directorio");
 if(!($dir = dir(PATH))) die("No se puede abrir el directorio");
 if($message){
 echo "<p class=\"error\">$message</p>";
 }
 //Imprimiendo encabezados de la tabla
 $table = "<table id=\"file-data\">\n";
 $table .= "<caption>Seleccione el archivo a editar</caption>\n";
 $table .= "<thead>\n<tr>\n<th>\nNombre archivo\n</th>\n";
 $table .= "<th>\nTamaño\n</th>\n";
 $table .= "<th>\nModificación</th>\n</tr>\n</thead>\n";
 //Imprimiendo los archivos contenidos en el directorio y 
 //creando los enlaces para su edición
 $table .= "<tbody>\n";
 $numfilas = 0;
 while($filename = $dir->read()){
 $filepath = PATH . "/$filename";
 if($filename != "." && $filename != ".." && !is_dir($filepath) && strrchr($filename, 
".") == ".txt"){
 $clase = ($numfilas%2 != 0) ? "odd" : "even";
 $table .= "<tr class=\"$clase\">\n<td>\n";
 $table .= "<a href=\"editortexto.php?filename=" . urlencode((binary)$filename) . 
"\">";
 $table .= $filename . "</a>\n</td>\n";
 $table .= "<td>\n" . filesize($filepath) . "\n</td>\n";
 $table .= "<td>\n" . date("M j, Y H:i:s", filemtime($filepath)) . 
"\n</td>\n</tr>\n";
 }
 $numfilas++;
 }
 $dir->close();
 $table .= "</tbody>\n</table>\n";
 echo $table;
 $form = "<form name=\"nuevo\" action=\"editortexto.php\" method=\"POST\">\n";
 $form .= "<fieldset>\n<legend><span>Creando un nuevo archivo:</span></legend>\n";
 $form .= "<ul>\n<li>\n";
 $form .= "<div id=\"campo\">\n";
 $form .= "<label for=\"filename\">Nombre del archivo: </label>";
 $form .= "<input type=\"text\" name=\"filename\" id=\"filename\" placeholder=\"(Ingrese 
el nombre del archivo)\" maxlength=\"100\" />\n";
 $form .= "</div>\n</li>\n";
 $form .= "<li>\n<div id=\"boton\">\n";
 $form .= "<input type=\"submit\" name=\"createfile\" value=\"Crear archivo\" />";
 $form .= "</div>\n</li>\n</ul>\n";
 $form .= "</fieldset>\n</form>\n";
 echo $form;
 displaypagefooter();
 }
 
 function displayeditform($filename = ""){
 $archivo = isset($_GET['filename']) ? $_GET['filename'] : "";
 echo "<div id=\"info-file\">\n";
 //echo $archivo . "<br />\n";
 if(!$filename) $filename = basename($archivo);
 if(!$filename) die("Nombre de archivo inválido");
 $filepath = PATH . "/" . $filename;
 echo $filepath . "\n";
 echo "</div>\n";
 if(!file_exists($filepath)) die("Archivo no encontrado");
 displaypageheader();
 $editform = "<section id=\"formulario\">\n";
 $editform .= "\t<h2>Editando archivo: $filename</h2>\n";
 $editform .= "\t<form name=\"creararchivo\" action=\"editortexto.php\" 
method=\"POST\">\n";
 $editform .= "\t\t<div style=\"width:40em\">\n";
 $editform .= "\t\t\t<input type=\"hidden\" name=\"filename\" value=\"$filename\" />\n";
 $editform .= "\t\t\t<textarea name=\"filecontents\" id=\"filecontents\" cols=\"80\" 
rows=\"20\">\n";
 $editform .= file_get_contents($filepath) . "\n";
 $editform .= "</textarea>\n";
 $editform .= "\t\t\t<div style=\"clear:both\">\n";
 $editform .= "\t\t\t\t<input type=\"submit\" name=\"savefile\" value=\"Guardar archivo\" 
/>\n";
 $editform .= "\t\t\t\t<input type=\"submit\" name=\"cancel\" value=\"Cancelar\" />\n";
 $editform .= "\t\t\t</div>\n";
 $editform .= "\t\t</div>\n\t</form>\n";
 $editform .= "</section>\n";
 echo $editform;
 displaypagefooter();
 }
 
 function savefile(){
 $archivo = isset($_POST['filename']) ? $_POST['filename'] : "";
 $filename = basename($archivo);
 $filepath = PATH . "/$filename";
 if(file_exists($filepath)){
 $filecontents = isset($_POST['filecontents']) ? $_POST['filecontents'] : "";
 if(file_put_contents($filepath, $_POST['filecontents']) === false)
 die("<p class=\"error\">No se ha podido guardar el archivo</p>\n");
 displayfilelist();
 }
 else{
 die("Archivo no encontrado...");
 }
 }
 
 function createfile(){
 $filename = basename($_POST['filename']);
 echo $filename . "<br />\n";
 $filename = preg_replace("/[^A-Za-z0-9_\- ]/", "", $filename);
 if(!$filename){
 displayfilelist("<p class=\"error\">Nombre de archivo no v&aacute;lido. Pruebe con 
otro nombre.</p>");
 return;
 }
 $filename .= ".txt";
 $filepath = PATH . "/$filename";
 if(file_exists($filepath)){
 displayfilelist("El archivo $filename ya existe.");
 }
 else{
 if(file_put_contents($filepath, "") === false) 
 die("No se ha podido crear el archivo");
 chmod($filepath, 0777);
 displayeditform($filename);
 }
 }
 
 function displaypageheader(){
 echo "<!DOCTYPE html>\n";
 echo "<html lang=\"es\">\n";
 echo "<head>\n";
 echo "<title>Editor de texto basado en web</title>\n";
 echo "<meta charset=\"utf-8\" />\n";
 echo "<link rel=\"stylesheet\" href=\"css/page.css\" />\n";
 echo "</head>\n";
 echo "<body>\n";
 }
 
 function displaypagefooter(){
 echo "</body>\n";
 echo "</html>\n";
 }
?>