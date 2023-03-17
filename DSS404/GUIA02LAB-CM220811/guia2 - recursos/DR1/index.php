<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Discución de Resultados 1</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>

<body class="container" style="background-color: #312D30;color: #D8D6D5;">
    <h1 class="display-2" style="text-align: center;">¿Cuantos dias he vivido?</h1>
    <br>
    <figure class="text-center">
        <blockquote class="blockquote">
            <p>Cree un script que a partir de la fecha de nacimiento ingresada en un campo tipo number de
                formulario calcule el número de días que la persona que la ha ingresado ha vivido. Tome en
                cuenta los años bisiestos para obtener el cálculo exacto de días.</p>
        </blockquote>
        <figcaption class="blockquote-footer">
            Enunciado <cite title="Source Title">Problema 1</cite>
        </figcaption>
    </figure>

    <form action="<?php htmlspecialchars($_SERVER['PHP_SELF']) ?>" method="post">
        <div class="row g-3">
            <div class="col">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" class="form-control" placeholder="Nombre" name="nombre">
            </div>
            <div class="col">
                <label for="FechaNacimiento" class="form-label">Fecha de nacimiento:</label>
                <input type="date" class="form-control" placeholder="FechaNacimiento" name="FechaNacimiento">
            </div>
        </div>
        <br>
        <div class="row g-2">
            <div class="col-6" style="text-align: center;">
                <input type="submit" class="btn btn-warning" value="Calcular" name="btnEnviar">
            </div>
            <div class="col-6" style="text-align: center;">
                <input type="submit" class="btn btn-warning" value="Limpiar" name="btnLimpiar">
            </div>
        </div>
    </form>
    



    <?php



    if (isset($_POST['btnEnviar'])) {
        $user = $_POST['nombre'];
        $fechaNacimiento = $_POST['FechaNacimiento'];
        $fechaActual = date('Y-m-d');
        if($user==""){
            echo '<div class="alert alert-warning" role="alert">
                    Campos Vacios!
                </div>';
        }else{
            if($fechaNacimiento==""){
                echo '<div class="alert alert-warning" role="alert">
                    Campos Vacios!
                </div>';
            }else{
                $nacimiento = new DateTime($fechaNacimiento);
                $actual = new DateTime(date("Y-m-d"));
                $edad = $actual->diff($nacimiento);
                $años = $edad->format("%y");
                $biciestos = $años / 4;
                $dias = ($años * 365) + $biciestos;
                $DDtotales = round($dias);
                echo '<div class="card text-center text-bg-light">
                 <div class="card-header">
                  '. $user .'
                 </div>
                 <div class="card-body">
                  <h5 class="card-title">Tu has vivido...</h5>
                  <p class="card-text">Aproximadamente '. $DDtotales . ' dias' .  '</p>
                </div>
                <div class="card-footer text-muted">
                  '. $años . ' años'.'
                </div>
              </div>';
            }
            }
        }
        

    if (isset($_POST['btnLimpiar'])) {
        header("locate:index.php");
    }

    ?>






    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>

</html>