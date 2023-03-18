<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8" />
    <title>Formulario dinámico</title>
    <!-- <link rel="stylesheet" href="css/fonts.css" /> -->
    <link rel="stylesheet" href="css/demo.css" />
    <!-- Estilos tomados desde de los ejemplos de http://voky.com.ua/ -->
    <link rel="stylesheet" href="css/sky-forms.css" />
    <link rel="stylesheet" href="css/sky-forms-purple.css" />
    <!--[if lt IE 9]>
 <link rel="stylesheet" href="css/sky-forms-ie8.css">
 <![endif]-->

    <!--[if lt IE 10]>
 <script
src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
 <script src="js/jquery.placeholder.min.js"></script>
 <![endif]-->
    <!--[if lt IE 9]>
 <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
 <script src="js/sky-forms-ie8.js"></script>
 <![endif]-->
</head>

<body class="bg-purple">
    <div class="body">
        <h1>Generador de formulario</h1>
        <?php
        spl_autoload_register(function ($classname) {
            include_once "class/" . $classname . ".class.php";
        });

        echo "<form name=\"form\" action=\"mostrarform.php\" method=\"POST\" class=\"sky-form\"
onsubmit=\"return true\">\n\t";
        echo "\t<header>Formulario dinámico</header>\n";
        echo "\t<fieldset>\n";
        //En el array $campos se crean todos los campos que van a conformar el formulario
        //utilizando todas las clases que se han creado para cada uno de los controles
        //de formulario considerados para este ejemplo
        $campos = array(
            new campotexto("nombre", "Nombre: ", "El nombre completo", "Nombre completo", 40),
            new campotexto(
                "apellido",
                "Apellido: ",
                "El apellido completo",
                "Apellido completo",
                30
            ),
            new campocheckbox(
                "deportes",
                "Deportes",
                "Deportes:",
                "Deportes
favoritos",
                array(
                    "opciones" => array(
                        "Fútbol" => "Fútbol",
                        "Basketball" => "Basketball",
                        "Volleyball" => "Volleyball",
                        "Beisball" => "Beisball",
                        "Tenis" => "Tenis"
                    ),
                    "estados" => array(
                        true,
                        false,
                        false,
                        true,
                        false
                    )
                ),
                false
            ),
            new campotextarea("observaciones", "Observaciones: ", 6, 50, "Háganos sus comentarios", "Envíenos sus comentarios"),
            new camposelect(
                "nacionalidad",
                "Nacionalidad: ",
                "Seleccione su acionalidad",
                1,
                '',
                array(
                    "El Salvador" => "El Salvador",
                    "Guatemala" => "Guatemala",
                    "Honduras" => "Honduras",
                    "Costa Rica" => "Costa Rica",
                    "Nicaragua" => "Nicaragua",
                    "Panamá" => "Panamá"
                )
            ),
            new camposubmit("enviar", "", "Enviar", "Enviar el formulario")
        );
        foreach ($campos as $campo) {
            $campo->pinta_campo();
        }
        echo "</fieldset>\n";
        echo "</form>\n";
        ?>
    </div>
</body>

</html>