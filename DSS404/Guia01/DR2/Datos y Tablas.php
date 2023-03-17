<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  </head>
  <body>
    <h1>Datos Personales</h1>
    <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Nombres</th>
            <th scope="col">Apellidos</th>
            <th scope="col">Lugar de Nacimiento</th>
            <th scope="col">Edad</th>
            <th scope="col">Carnet</th>
          </tr>
        </thead>
        <tbody>
            
            <?php 
            
            $nombres = <<<Nombres
            Diego Ernesto
            Nombres;
            
            $apellidos = <<<Apellidos
            Chevez Montes
            Apellidos;
            $LugarNN = <<<LugarDeNacimiento
            El Salvador, San Salvador
            LugarDeNacimiento;
            $edad = <<<edad
            18
            edad;
            $carnet = <<<carnet
            CM220811
            carnet;


            echo '<tr>';
            echo '<th scope="row">1</th>';
            echo '<td>'.$nombres.'</td>';
            echo '<td>'.$apellidos.'</td>';
            echo '<td>'.$LugarNN.'</td>';
            echo '<td>'.$edad.'</td>';
            echo '<td>'.$carnet.'</td>';
            echo '</tr>';


            ?>
          
        </tbody>
      </table>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
  </body>
</html>