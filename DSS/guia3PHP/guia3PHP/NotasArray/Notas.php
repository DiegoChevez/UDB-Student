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
    echo "Datos de los estudiantes: <br>";

    foreach ($notas as $alumnos){
        echo "<br>";

            foreach($alumnos as $key => $value){
                
                echo $key, ": ", $value, "\n <br>";

            }

    }

?>