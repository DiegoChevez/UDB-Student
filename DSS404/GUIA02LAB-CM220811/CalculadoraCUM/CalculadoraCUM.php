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

$multi1 = ($nota1 * $uv1);
$multi2 = ($nota2 * $uv2);
$multi3 = ($nota3 * $uv3);
$multi4 = ($nota4 * $uv4);
$multi5 = ($nota5 * $uv5);

$TotalUV = ($uv1 + $uv2 + $uv3 + $uv4 + $uv5);
$TotalNGUV = ($multi1 + $multi2 + $multi3 + $multi4 + $multi5); 

$CUM = ($TotalNGUV / $TotalUV);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="tablas.css">
    <title>Document</title>
</head>
<body>
<table id="tablaCum">
<?php
 echo "<tr>";
 echo "<th>Nota</th>";
 echo" <th>Unidades valorativas</th>";
 echo "<th>Nota ganada X UV</th>";
 echo "</tr>";
 echo "<tr>";
 echo "<td>", $nota1 ,"</td>";
 echo" <td>", $uv1 ,"</td>";
 echo "<td>", $multi1 ,"</td>";
 echo "</tr>";
 echo "<tr>";
 echo "<td>", $nota2 ,"</td>";
 echo" <td>", $uv2 ,"</td>";
 echo "<td>", $multi2 ,"</td>";
 echo "</tr>";
 echo "<tr>";
 echo "<td>", $nota3 ,"</td>";
 echo" <td>", $uv3 ,"</td>";
 echo "<td>", $multi3 ,"</td>";
 echo "</tr>";
 echo "<tr>";
 echo "<td>", $nota4 ,"</td>";
 echo" <td>", $uv4 ,"</td>";
 echo "<td>", $multi4 ,"</td>";
 echo "</tr>";
 echo "<td>", $nota5 ,"</td>";
 echo" <td>", $uv5 ,"</td>";
 echo "<td>", $multi5 ,"</td>";
 echo "</tr>";
 echo "<tr>";
 echo "<td></td>";
 echo" <td> Total Unidades Valorativas : ", $TotalUV ,"</td>";
 echo "<td> Total nota ganada x UV: ", $TotalNGUV ,"</td>";
 echo "</tr>";
echo "</table>";

echo "<br>";
echo "CUM de ciclo: ", $CUM;

if ($CUM >= 7.5){

    echo "<br>";
    echo "Observación: Puede cursar un máximo de 32 unidades valorativas (UV) ya que poseé un CUM mayor a 7.5 ";

}else if($CUM >= 7.0 && $CUM < 7.5){

    echo "<br>";
    echo "Observación: Puede cursar un máximo de 24 unidades valorativas (UV) ya que poseé un CUM entre 7 y menor a 7.5";

}else if($CUM >= 6.0 && $CUM < 7.0){

    echo "<br>";
    echo "Observación: Puede cursar un máximo de 20 unidades valorativas (UV) ya que poseé un CUM entre 6 y menor a 7";

}else{

    echo "<br>";
    echo "Observación: Puede cursar un máximo de 16 unidades valorativas (UV) ya que poseé un CUM menor a 6";


}

?>

</body>
</html>






