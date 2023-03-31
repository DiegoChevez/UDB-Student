<?php
//Se manejarán sesiones por lo tanto incluir librería de seguridad
require_once('seguridad.php');
spl_autoload_register(function ($class_name){
require("class/" . $class_name . ".class.php");
});
//Definiendo opciones del menú principal en una matriz asociativa que
//será pasada como tercer argumento en el constructor de la clase Page
$menu = array(
"home.php" => "Inicio",
"ingreso.php" => "Proceso de ingreso",
"documentos.php" => "Documentos de ingreso",
"costos.php" => "Costos",
"salir.php" => "Salir"
);
//Creando una página, instanciando la clase page
$homepage = new page("Nuevo Ingreso - UDB", "Nuevo Ingreso, Nuevo Ingreso UDB, Proceso de nuevo ingreso, Estudiante de nuevo ingreso", $menu);
$homepage->content = <<<PAGE
<div class="rediv" id="contenido">
<h4>
<span>Bienvenido {$_SESSION['nombreusr']} </span>
</h4>
<p>
<img src="imagenes/foto_indexflt.jpg" width="715" height="400" />
</p>
<p>&nbsp;</p>
<p>
<strong>Enlaces de interés:</strong>
<div id="divfootimg" class="rediv">
<a href="http://www.udb.edu.sv/udb/index.php/pagina/ver/pago_en_linea" target="_blank">
<img src="imagenes/footimg3.jpg" width="150" height="75" border="0" />
</a>
</div>
<div id="divfootimg" class="rediv">
<a href="http://cnap.udb.edu.sv" target="_blank">
<img src="imagenes/footimg2.jpg" width="150" height="75" border="0" />
</a>
</div>
<div id="divfootimg" class="rediv">
<a href="http://www.udb.edu.sv/udb/index.php/pagina/ver/progyserv_coordidiomas" target="_blank">
<img src="imagenes/aprendeidiomas.png" width="150" height="75" border="0" />
</a>
</div>
<div id="divfootimg" class="rediv">
<a href="http://www.udb.edu.sv/udb/index.php/pagina/ver/live-edu" target="_blank">
<img src="imagenes/footimg6.jpg" width="150" height="75" border="0" />
</a>
</div>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
PAGE;
echo $homepage->display();
?>