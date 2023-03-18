<?php
$ip_address = $_SERVER['REMOTE_ADDR'];
$nombre_script = $_SERVER['PHP_SELF'];
$hora_actual = date('Y-m-d H:i:s');
$text = "El script ". $nombre_script." se ejecuto a las ". $hora_actual . " desde la ip: ". $ip_address . ",";
escritura($text); 


/* $ip_addressG = gethostbyname("www.google.com");
$ip_addressJ = gethostbyname("www.javatpoint.com");
$text2 = "Guardando la ip : ". $ip_addressG . "y la ip : " . $ip_addressJ;
escritura($text2);  */




function escritura($text){
  $archivo = "log.txt"; 
  $datos = $text; 
  $file = fopen($archivo, "a"); 
  fwrite($file, $datos. PHP_EOL); 
  fclose($file); 
}


?>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body class="container">

    <center>
        <h1>DOXEANDO...</h1>
        <div class="spinner-border text-success" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>
        <h1 style="color:#CCD4D9"><?php echo $text; ?></h1>
    </center>
    
    
    


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>