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

$nota1 = $_POST['Nota1'];
$nota2 = $_POST['Nota2'];
$nota3 = $_POST['Nota3'];
$nota4 = $_POST['Nota4'];
$nota5 = $_POST['Nota5'];

$uv1 = $_POST['UnVa1'];
$uv2 = $_POST['UnVa2'];
$uv3 = $_POST['UnVa3'];
$uv4 = $_POST['UnVa4'];
$uv5 = $_POST['UnVa5'];

$TotalUV = ($uv1 + $uv2 + $uv3 + $uv4 + $uv5);

echo "Nota de ciclo   |    UV    =    Nota de ciclo x UV"; 
echo "<br>";
echo $nota1,"\n", $uv1, "\n", ($nota1 * $uv1) ;
echo "<br>";
echo $nota2,"\n", $uv2, "\n", ($nota2 * $uv2) ;
echo "<br>";
echo $nota3,"\n", $uv3, "\n", ($nota3 * $uv3);
echo "<br>";
echo $nota4,"\n", $uv4, "\n", ($nota4 * $uv4);
echo "<br>";
echo $nota5 ,"\n", $uv5, "\n", ($nota5 * $uv5);
echo "<br>";

echo $uv1;
echo $uv2;
echo $uv3;
echo $uv4;
echo $uv5;

?>
</body>
</html>






