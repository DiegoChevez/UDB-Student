<?php
function showform(){
?>
<form method="POST" action="<?php echo $_SERVER['PHP_SELF']; ?>" id="searchthis">
 <input type="text" name="firstname" id="namanyay-search-box" placeholder="(Nombre a 
buscar)"/>
 <input name="submit" id="namanyay-search-btn" value="Search" type="submit" />
</form>
<?php
}
function processfile(){
$filename = "files/datebook.txt";
//Obteniendo las líneas del archivo para asignarlas en una matriz
$rows = file($filename);
$firstname = trim($_POST['firstname']);
//Recorriendo una por una las líneas extraídas del archivo a través de la matriz
$count = 0;
foreach($rows as $register):
$fields = explode(":", $register);
 $fullname = explode(" ", $fields[0]);
 $phone = $fields[1];
 $address = $fields[2];
 $birthday = $fields[3];
 $salary = $fields[4];
 if(strcasecmp($fullname[0], $firstname) == 0):
 $birthday = explode("/", $birthday);
 $newstring = implode("<br />", 
 array($fields[0], 
 $phone, 
 $address, 
 implode("/", $birthday), 
 '$ ' . number_format(floatval($salary), 2, '.', ',')));
 echo "<p>" . $newstring . "</p>";
 $count++;
 endif;
endforeach;
if($count == 0):
echo "<p>El nombre " . $firstname . " no está en el archivo</p>";
endif;
}
?>