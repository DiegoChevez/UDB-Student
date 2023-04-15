<?php
class MainController extends Controller{
 function __construct(){
 parent::__construct();
 $this->view->mensaje1= "Parametro enviado a la vista";
 $this->view->renderView('main/main.php');
 }

 function accion(){
 echo "<p>hola soy la accion</p>";

 }
}
?>
