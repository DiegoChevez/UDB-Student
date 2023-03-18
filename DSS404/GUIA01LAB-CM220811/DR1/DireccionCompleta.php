<?php 
$host= $_SERVER["HTTP_HOST"];
$url= $_SERVER["REQUEST_URI"];


?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Direccion Completa</title>
</head>
<body>
    <h1>Hola este archivo esta ubicado en la siguiente ubicacion:</h1>
    <h2 style="font-style: italic;font-weight: bold;">
        <?php echo "http://" . $host . $url; ?>        
    </h2>
</body>
</html>