<?php

$nombre1 = $_POST['nombre1'];
$ntarea1 = $_POST['tarea1'];
$ninv1 = $_POST['investigacion1'];
$nparcial1 = $_POST['parcial1'];

$nombre2 = $_POST['nombre2'];
$ntarea2 = $_POST['tarea2'];
$ninv2 = $_POST['investigacion2'];
$nparcial2 = $_POST['parcial2'];

$nombre3 = $_POST['nombre3'];
$ntarea3 = $_POST['tarea3'];
$ninv3 = $_POST['investigacion3'];
$nparcial3 = $_POST['parcial3'];

$notas = array(

    'alumno1' => array(

        "Nombre" => $nombre1,
        "Parcial" => $nparcial1,
        "Investigación" => $ninv1,
        "Tarea" => $nparcial1,
        "Promedio ponderado" => (($nparcial1*0.5)+($ninv1*0.3)+($ntarea1*0.2))

    ), 

    'alumno2' => array(

        "Nombre" => $nombre2,
        "Parcial" => $nparcial2,
        "Investigación" => $ninv2,
        "Tarea" => $nparcial2,
        "Promedio ponderado" => (($nparcial2*0.5)+($ninv2*0.3)+($ntarea2*0.2))

    ),
    
    'alumno3' => array(

        "Nombre" => $nombre3,
        "Parcial" => $nparcial3,
        "Investigación" => $ninv3,
        "Tarea" => $nparcial3,
        "Promedio ponderado" => (($nparcial3*0.5)+($ninv3*0.3)+($ntarea3*0.2))

    )

    );
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <title>Document</title>
</head>
<body class="container">
    
<?php

echo "<h1 style =","text-align:center",">Datos de los estudiantes </h1><br>";
echo "<table class=","striped",">";

foreach ($notas as $alumnos){

    echo "<thead >";
        echo "<tr>";
            echo "<th>Información</th>";
            echo "<th>Descripción</th>";
        echo "</tr>";
    echo "</thead>";

        foreach($alumnos as $key => $value){
            echo "<tbodylass=","striped",">";
            echo "<tr>";
            echo "<td>", $key ,"</td>";
            echo "<td>", $value ,"</td>";
            echo "</tr>";
        }
}

echo "</table>";

?>

<br>

<div class="container center-align">
<a class="waves-effect waves-light btn" href="RecepcionDatos.html" >Regresar</a>
</div>

<br>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>

