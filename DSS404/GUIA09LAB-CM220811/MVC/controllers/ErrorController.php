<?php
class ErrorController extends Controller{
 function __construct(){
 parent::__construct();
 $this->view->mensaje= "Error al cargar la pagina o recurso";
 $this->view->renderView('error/error.php');
 
 }
}
?>