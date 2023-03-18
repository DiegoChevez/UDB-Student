<!DOCTYPE html>
<html lang="es">

<head>
    <title>Variables predefinidas</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width,user-scalable=no,initialscale=1.0,maximum-scale=1.0,minimum-scale=1.0" />
    <link rel="stylesheet" href="css/predefinidas.css" />
    <script src="js/modernizr.custom.lis.js"></script>
</head>

<body>
    <?php
    printf("<div id=\"contenedor\">\n");
    printf("<header>\n");
    printf("\t<h1>Variables predefinidas - Matrices superglobales</h1>\n");
    printf("\t<img src=\"img/bg-header.png\" alt=\"Variables predefinidas\"title=\"Variables predefinidas\"\n");
    printf("</header>\n");
    printf("<section>\n");
    printf("<article>\n");
    printf("\t<p>En esta página se ilustrará cómo se utilizan algunas variables predefinidas\n");
    printf("\ten el lenguaje PHP. Estas variables están disponibles para cualquier script\n");
    printf("\tque se ejecute y las utilice.</p>\n");
    printf("\t<p>El valor de estas variables dependerá del servidor sobre el que se ejecuten, \n");
    printf("\tde la versión de este y de la configuración que tenga.</p>\n");
    printf("<h3>Ejemplos de utilización:</h3>\n");
    printf("<ul>\n<li>El nombre del servidor donde se está ejecutando este script es: <b><i>\$_SERVER['SERVER_NAME'] = %s</i></b></li>\n", $_SERVER['SERVER_NAME']);
    printf("<li>El directorio raíz de documentos en el servidor web es: <b><i>\$_SERVER['DOCUMENT_ROOT'] = %s</i></b></li>\n", $_SERVER['DOCUMENT_ROOT']);
    printf(
        "<li>El software que está utilizando es: <b><i>\$_SERVER['SERVER_SOFTWARE'] = %s</i></b></li>\n",
        $_SERVER['SERVER_SOFTWARE']
    );
    printf(
        "<li>El protocolo que se está utilizando para ver esta página es: <b><i>\$_SERVER['SERVER_PROTOCOL'] = %s</i></b></li>\n",
        $_SERVER['SERVER_PROTOCOL']
    );
    printf(
        "<li>El puerto de la máquina usado por el servidor web para la comunicación HTTP es: <b><i>\$_SERVER['SERVER_PORT'] = %s</i></b></li>\n",
        $_SERVER['SERVER_PORT']
    );
    printf("<li>La dirección IP de su computadora es: <b><i>\$_SERVER['REMOTE_ADDR'] = %s</i></b></li>\n", $_SERVER['REMOTE_ADDR']);
    printf("<li>La ruta del script actual en el servidor es: <b><i>\$_SERVER['SCRIPT_NAME'] = %s</i></b></li>\n", $_SERVER['SCRIPT_NAME']);
    printf(
        "<li>La ruta absoluta del script que se está ejecutando actualmente: <b><i>\$_SERVER['SCRIPT_FILENAME'] = %s</i></b></li>\n",
        $_SERVER['SCRIPT_FILENAME']
    );
    //Determinando si el valor de esta variable está vacío o no
    $query_string = !empty($_SERVER['QUERY_STRING']) ? $_SERVER['QUERY_STRING'] :
        "(No existe)";
    printf("<li>La cadena de consulta de la petición de la página (si existe) es: <b><i>\$_SERVER['QUERY_STRING'] = %s</i></b></li>\n", $query_string);
    printf("<li>La URI que se empleó para acceder a la página es: <b><i>\$_SERVER['REQUEST_URI'] = %s</i></b></li>\n", $_SERVER['REQUEST_URI']);
    printf(
        "<li>El puerto empleado por el equipo del usuario para comunicarse con el servidor es: <b><i>\$_SERVER['REMOTE_PORT'] = %s</i></b></li>\n",
        $_SERVER['REMOTE_PORT']
    );
    printf(
        "<li>El idioma definido por el navegador de tu computadora es: <b><i>\$_SERVER['HTTP_ACCEPT_LANGUAGE'] = %s</i></b></li>\n",
        $_SERVER['HTTP_ACCEPT_LANGUAGE']
    );
    printf(
        "<li>Estás viendo esta página en un navegador: <b><i>\$_SERVER['HTTP_USER_AGENT'] = %s</i></b></li>\n",
        $_SERVER['HTTP_USER_AGENT']
    );
    printf(
        "<li>El puerto de comunicación con el servidor de la computadora que estás utilizando es: <b><i>\$_SERVER['REMOTE_PORT'] = %s</i></b></li>\n",
        $_SERVER['REMOTE_PORT']
    );
    printf(
        "<li>La ubicación y el nombre del archivo que contiene el script que estás ejecutando es: <b><i>\$_SERVER['PHP_SELF'] = %s</i></b></li>\n</ul>",
        $_SERVER['PHP_SELF']
    );
    printf("</article>\n");
    printf("</section>\n");
    printf("</div>\n");
    ?>
</body>

</html>