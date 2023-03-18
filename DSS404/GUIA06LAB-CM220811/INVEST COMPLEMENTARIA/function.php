<?php

if(isset($_POST['btn-cargar'])){
    $file = file_get_contents('carpeta/infor.txt', false, null, 0, null);
    echo  $file;
}

if(isset($_POST['btn-save'])){
    $input = $_POST['input'];
    $texto = "Hola Programador ".$input;
    $file = 'carpeta/infor.txt';
    $escribir = file_put_contents($file, $texto);
    header('location: admin.php');
}