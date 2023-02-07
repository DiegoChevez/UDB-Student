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
            <p>Realice un script que le permita determinar si un carácter ingresado por el usuario a través de un
                formulario, es una vocal (mayúscula, minúscula o acentuada), una consonante (mayúscula o
                minúscula), un número (del 0 al 9) o símbolos (.,;:()""''!¡¿?#$%&, etc). En caso de no ser ninguno
                de estos caracteres, debe mostrar un mensaje que indique que "el carácter ingresado no se puede
                procesar".</p>
        </blockquote>
        <figcaption class="blockquote-footer">
            Enunciado <cite title="Source Title">Problema 2</cite>
        </figcaption>
    </figure>

    <form action="<?php htmlspecialchars($_SERVER['PHP_SELF']) ?>" method="post">
        <div class="col-12">
            <label for="inputCaracter" class="form-label">Caracteres</label>
            <input type="text" class="form-control" id="inputCaracter" placeholder="ABC" name="Caracter">
        </div>
        <br>
        <div class="row g-2">
            <div class="col-6" style="text-align: center;">
                <input type="submit" class="btn btn-warning" value="Analizar" name="btnEnviar">
            </div>
            <div class="col-6" style="text-align: center;">
                <input type="submit" class="btn btn-warning" value="Limpiar" name="btnLimpiar">
            </div>
        </div>
    </form>

    <?php
    if (isset($_POST['btnEnviar'])) {
        $cadena = $_POST['Caracter'];
        $regexLETRAS = '/^[b-df-hj-np-tv-z]+$/';
        $regexNumeros = '/^([0-9])*$/';
        $regexChar = '[:punct:]';
        $regexVocales = '/^[aeiouAEIOU]+$/';

        if ($cadena == "") {
            echo '<div class="alert alert-warning" role="alert">
                    Campos Vacios!
                </div>';
        } else {
            if (preg_match($regexLETRAS, $cadena)) {
                echo '<div class="card text-center text-bg-light">
                        <div class="card-header">
                            Analisis 
                        </div>
                        <div class="card-body">
                        <h5 class="card-title">Tu cadena solo contiene letras </h5>
                        <p class="card-text"></p>
                    </div>
                    <div class="card-footer text-muted">
                        ' . $cadena . '
                    </div>
                </div>';
            } else {
                if (preg_match($regexChar, $cadena)) {
                    echo '<div class="card text-center text-bg-light">
                                <div class="card-header">
                                    Analisis 
                                </div>
                                <div class="card-body">
                                <h5 class="card-title">Tu cadena solo contiene simbolos y signos de puntuacion </h5>
                                <p class="card-text"></p>
                            </div>
                            <div class="card-footer text-muted">
                                ' . $cadena . '
                            </div>
                        </div>';
                } else {
                    if (preg_match($regexNumeros, $cadena)) {
                        echo '<div class="card text-center text-bg-light">
                                    <div class="card-header">
                                        Analisis 
                                    </div>
                                    <div class="card-body">
                                    <h5 class="card-title">Tu cadena solo contiene numeros </h5>
                                    <p class="card-text"></p>
                                </div>
                                <div class="card-footer text-muted">
                                    ' . $cadena . '
                                </div>
                            </div>';
                    } else {
                        if (preg_match($regexVocales, $cadena)) {
                            echo '<div class="card text-center text-bg-light">
                                    <div class="card-header">
                                        Analisis 
                                    </div>
                                    <div class="card-body">
                                    <h5 class="card-title">Tu cadena solo contiene vocales </h5>
                                    <p class="card-text"></p>
                                </div>
                                <div class="card-footer text-muted">
                                    ' . $cadena . '
                                </div>
                            </div>';
                        } else {
                            if (preg_match('/^[0-9a-zA-Z]+$/', $cadena)) {
                                echo '<div class="card text-center text-bg-light">
                                        <div class="card-header">
                                            Analisis 
                                        </div>
                                        <div class="card-body">
                                        <h5 class="card-title">Tu cadena contiene letras y numeros </h5>
                                        <p class="card-text"></p>
                                    </div>
                                    <div class="card-footer text-muted">
                                        ' . $cadena . '
                                    </div>
                                </div>';
                            } else {
                                if (preg_match('/^[a-zA-Z\W]+$/', $cadena)) {
                                    echo '<div class="card text-center text-bg-light">
                                    <div class="card-header">
                                        Analisis 
                                    </div>
                                    <div class="card-body">
                                    <h5 class="card-title">Tu cadena contiene letras y simbolos </h5>
                                    <p class="card-text"></p>
                                </div>
                                <div class="card-footer text-muted">
                                    ' . $cadena . '
                                </div>
                            </div>';
                                } else {
                                    if (preg_match($regexLETRAS, $cadena) && preg_match($regexVocales, $cadena)) {
                                        echo '<div class="card text-center text-bg-light">
                                    <div class="card-header">
                                        Analisis 
                                    </div>
                                    <div class="card-body">
                                    <h5 class="card-title">Tu cadena contiene letras y vocales </h5>
                                    <p class="card-text"></p>
                                </div>
                                <div class="card-footer text-muted">
                                    ' . $cadena . '
                                </div>
                            </div>';
                                    } else {
                                        if (preg_match('/^[0-9\W]+$/', $cadena)) {
                                            echo '<div class="card text-center text-bg-light">
                                    <div class="card-header">
                                        Analisis 
                                    </div>
                                    <div class="card-body">
                                    <h5 class="card-title">Tu cadena contiene numeros y simbolos </h5>
                                    <p class="card-text"></p>
                                </div>
                                <div class="card-footer text-muted">
                                    ' . $cadena . '
                                </div>
                            </div>';
                                        } else {
                                            if (preg_match($regexNumeros, $cadena) && preg_match($regexVocales, $cadena)) {
                                                echo '<div class="card text-center text-bg-light">
                                    <div class="card-header">
                                        Analisis 
                                    </div>
                                    <div class="card-body">
                                    <h5 class="card-title">Tu cadena contiene numeros y vocales </h5>
                                    <p class="card-text"></p>
                                </div>
                                <div class="card-footer text-muted">
                                    ' . $cadena . '
                                </div>
                            </div>';
                                            } else {
                                                if (preg_match($regexVocales, $cadena) && preg_match($regexChar, $cadena)) {
                                                    echo '<div class="card text-center text-bg-light">
                                                    <div class="card-header">
                                                        Analisis 
                                                    </div>
                                                    <div class="card-body">
                                                    <h5 class="card-title">Tu cadena contiene Vocales y simbolos </h5>
                                                    <p class="card-text"></p>
                                                </div>
                                                <div class="card-footer text-muted">
                                                    ' . $cadena . '
                                                </div>
                                            </div>';
                                                } else {
                                                    echo '<div class="card text-center text-bg-light">
                                    <div class="card-header">
                                        Analisis 
                                    </div>
                                    <div class="card-body">
                                    <h5 class="card-title">Tu cadena ingresada no se ha podido procesar </h5>
                                    <p class="card-text"></p>
                                </div>
                                <div class="card-footer text-muted">
                                    ' . $cadena . '
                                </div>
                            </div>';
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
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