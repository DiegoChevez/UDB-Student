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
        <form class="row g-3" action="function.php" method="POST">
            <div class="col-auto">
                <label for="staticEmail2" class="visually-hidden">Email</label>
                <input type="text" readonly class="form-control-plaintext" value="texto a guardar:">
            </div>
            <div class="col-auto">
                <label for="inputPassword2" class="visually-hidden">Texto</label>
                <input type="text" class="form-control" placeholder="txt" name="input">
            </div>
            <div class="col-auto">
                <input type="submit" class="btn btn-primary mb-3" name="btn-save" value="Guardar">
                <button type="submit" class="btn btn-primary mb-3" name="btn-cargar">Cargar</button>
            </div>
        </form>
        
    </center>





    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>

</html>