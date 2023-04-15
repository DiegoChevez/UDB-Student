<!DOCTYPE html>
<html lang="es">
<head>
 <meta charset="utf-8" />
 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
 <meta name="viewport" content="width=device-width, initial-scale=1"/>
 <title>Operaciones con archivos</title>
 <link rel="stylesheet" href="css/filemanager.css" />
 <link rel="stylesheet" href="css/demo.css" />
 <link rel="stylesheet" href="css/component.css" />
 <!--[if IE]>
 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
 <![endif]-->
</head>
<body>
<header>
 <h1>Operaciones con el archivo
 <?php
 error_reporting(E_ALL & ~E_NOTICE);
 if(!empty($_GET['directorio']) && $_GET['directorio'] !== null):
 echo basename($_GET['directorio']);
 $valor_directorio = rawurlencode($_GET['directorio']);
 endif;
 ?>
 </h1>
</header>
<section>
 <article>
 <?php
 $form = "<form method=\"POST\" action=\"";
 $form .= "operacion.php?operacion=3&directorio=" . $valor_directorio . "\" 
class=\"ccform\">\n\t\t\t";
 echo $form;
 ?>
 <div class="ccfield-prepend">
 <input type="image" name="borrar" id="borrar" src="img/delete-file.gif" 
alt="Borrar archivo" class="ccimagefield" />
 <label for="borrar">Borrar</label>
 </div>
 </form>
 <?php
 $form = "<form method=\"POST\" action=\"";
 $form .= "operacion.php?operacion=4&directorio=" . $valor_directorio . "\" 
class=\"ccform\">\n\t\t\t";
 echo $form;
 ?>
 <div class="ccfield-prepend">
 <span class="ccform-addon">
 <i class="fa fa-user fa-2x fa-spin"></i>
 </span>
 <input type="text" name="destino" id="destino" placeholder="Nombre de la copia" 
required class="ccformfield" />
 <input type="image" name="copiar" id="copiar" src="img/copyfile.jpg" 
alt="Copiar archivo" class="ccimagefield" />
 <label for="copiar">Copiar</label>
 </div>
 </form>
 <?php
 $form = "<form method=\"POST\" action=\"";
 $form .= "operacion.php?operacion=5&directorio=" . $valor_directorio . "\" 
class=\"ccform\">\n\t\t\t";
 echo $form;
 ?>
 <div class="ccfield-prepend">
 <span class="ccform-addon">
 <i class="fa fa-envelope fa-2x"></i>
 </span>
 <input type="text" name="nuevo_nombre" id="nuevo_nombre" placeholder="Nuevo 
nombre" required class="ccformfield" />
 <input type="image" name="renombrar" id="renombrar" src="img/renamefile.png" 
alt="Renombrar archivo" class="ccimagefield" />
 <label for="renombrar">Renombrar</label>
 </div>
 </form>
 <?php
 $form = "<form method=\"POST\" action=\"";
 $form .= "administrador.php?directorio=" . 
rawurlencode(dirname($_GET['directorio'])) . "\">\n\t\t\t";
 echo $form;
 ?>
 <div class="ccfield-prepend">
 <input type="submit" name="volver" value="Volver al directorio" class="ccbtn" 
/>
 </div>
 </form>
 </article>
</section>
</body>
<script src="js/modernizr.custom.lis.js"></script>
</html>