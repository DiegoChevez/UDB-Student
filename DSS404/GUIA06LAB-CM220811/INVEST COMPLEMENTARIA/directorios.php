<?php

$dir = "../DISCUSION DE RESULTADOS";
if(is_dir($dir)){
    if($dh = opendir($dir)){
        While (($file = readdir($dh)) !== false){
            echo "Nombre del archivo" . $file . "<br>";
        }
    }
}


?>