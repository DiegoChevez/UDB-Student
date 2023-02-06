<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
 
<?php
$tablas = $_POST['datosTabla'];
$i = 0;

echo "<h1>Tabla del ",$tablas,"</h1>";

while($i < 10){
    ++$i;
    $resultado = ($tablas * $i);
    echo $tablas, " x ", $i, " = ", $resultado, "<br>";  
    continue;

}

?>

<br>
<a href="IngresoDatos.html">Regresar</a>

</body>
</html>

