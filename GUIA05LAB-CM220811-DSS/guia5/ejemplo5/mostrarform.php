<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8" />
    <title>Datos del formulario</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Bitter" />
    <link rel="stylesheet" href="css/liststyle.css" />
</head>

<body class="bg-cyan">
    <section>
        <div class="form-style">
            <h1>Datos del formulario</h1>
            <div class="numberlist">
                <?php
                if (isset($_POST['enviar'])) {
                    $lista = "<ol>\n";
                    foreach ($_POST as $name => $value) {
                        if (gettype($value) == "array" && $name != "enviar") {
                            foreach ($value as $dato) {
                                $lista .= "\t<li><a href=\"javascript:void(0);\">$name: " . $dato .
                                    "</a></li>\n";
                            }
                        }
                        if ($name != "enviar") {
                            $lista .= "\t<li><a href=\"javascript:void(0);\">$name: " . $value .
                                "</a></li>\n";
                        }
                    }
                    $lista .= "</ol>\n";
                    echo $lista;
                }
                ?>
            </div>
        </div>
        </article>
    </section>
</body>

</html>