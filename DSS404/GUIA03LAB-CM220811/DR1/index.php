<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body class="container" style="background-color:#260101;">

  <div class="card text-center">
    <div class="card-header">
      Calculadora de Potencias
    </div>
    <div class="card-body">
      <h5 class="card-title">Resolvamos Potencias</h5>
      <form action="<?php htmlspecialchars($_SERVER['PHP_SELF']) ?>" method="post">
        <div class="row g-3">
          <div class="col">
            <input type="number" class="form-control" placeholder="base: 25, 40, 1, 5.6" name="base">
          </div>
          <div class="col">
            <input type="number" class="form-control" placeholder="Potencia: 5, 10, 2" name="potencia">
          </div>
        </div>
        <br>
        <div class="d-grid gap-2 col-6 mx-auto">
          <input type="submit" class="btn btn-warning" value="Calcular" name="btnEnviar">
          <input class="btn btn-success" type="submit" name="limpiar" value="Limpiar">
        </div>
      </form>


      <?php

      if (isset($_POST['btnEnviar'])) {
        $base = $_POST['base'];
        $potencia = $_POST['potencia'];
        $x = $base;

        for ($i = 1; $i < $potencia; $i++) {
          $x = $x * $base;
        }

        echo' <div class="card-footer text-muted">
        '. $x .'
      </div>';
      }


      ?>
    </div>



  </div>




  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>

</html>