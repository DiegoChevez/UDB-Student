
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body class="container">

    <div class="card">
        <div class="card-header">
            Convertidor de Dolares a Euros
        </div>
        <div class="card-body">
            <h5 class="card-title">Escribe la cantidad a convertir</h5>

            <form class="row g-3" method="post" action="<?php htmlspecialchars( $_SERVER['PHP_SELF']) ?>">
                <div class="col-auto">
                    <label for="staticEmail2" class="visually-hidden">Dolares</label>
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="Dolares" name="dolares">
                </div>
                <div class="col-auto">
                    <label for="inputPassword2" class="visually-hidden">Password</label>
                    <input type="n" class="form-control" id="inputPassword2" placeholder="$500" name="Ndolares">
                </div>
                <div class="col-auto">
                    <input type="submit" class="btn btn-success mb-3" value="Calcular" name="btnEnviar">
                </div>
            </form>
        </div>
    </div>
    <?php
        echo '<table class="table table-striped">';
        echo    '<thead>';
        echo        '<tr>';
        echo            '<th scope="col">#</th>';
        echo               '<th scope="col">Dolares</th>';
        echo                '<th scope="col">Euros</th>';
        echo        '</tr>';
        echo    '</thead>';
        echo    '<tbody>';
        if(isset($_POST['btnEnviar'])){
            $Ndolares = $_POST['Ndolares']; 
            $Neuros = $Ndolares*1.09;
            
            echo        '<tr>';
            echo            '<th scope="row">1</th>';
            echo            '<td>'.$Ndolares.'</td>';
            echo            '<td>'.$Neuros.'</td>';
            echo        '</tr>';
            
        }
        echo        '</tbody>';
        echo '</table>';

        function Datos(){
            
        }
        
    ?>




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>

</html>