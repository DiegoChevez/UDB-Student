<?php
$tablas = $_POST['datosTabla'];
$i = 0;
?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <title>Document</title>
</head>
<body class="container">


<?php
echo "<h1 style = ","text-align:center",">Tabla del ",$tablas,"</h1>";

echo "<table class =","centered",">";

echo "<thead>";
echo "<tr>";
echo "<th>Multiplicando</th>";
echo "<th></th>";
echo "<th>Multiplicador</th>";
echo "<th>Producto</th>";
echo "</tr>";
echo "</thead>";


while($i < 10){

    
    ++$i;
    $resultado = ($tablas * $i);
    echo "<tbody>";
    echo "<tr>";
    echo "<td>", $tablas ,"</td>";
    echo "<td> x </td>";
    echo "<td>", $i ,"</td>";
    echo "<td>", $resultado ,"</td>";
    echo "</tr>";

}

?>
</table>
<br>
<br>
<div class="container center-align">
<a class="waves-effect waves-light btn" href="IngresoDatos.html" >Regresar</a>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</body>
</html>

