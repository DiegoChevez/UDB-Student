<?php
class MainController extends Controller{//extenderemos de controller para poder acceder a sus funciones
 function __construct(){
 //parent::__construct(); codigo de la primera parte de la guia
 //$this->view->mensaje1= "Parametro enviado a la vista";
 //$this->view->renderView('main/main.php');
 }
 
 function principal(){
 parent::__construct();//llamamos el constructor de Controller, para poder acceder a la instancia de view
 $this->view->listaPersonas= $this->model->listaPersonas();//enviamos arreglos de objetos a las vistas
 $this->view->listaOcupaciones= $this->model->listaOcupaciones();
 $this->view->persona= $this->model->obtenerPersona();//enviamos un objeto en particular a la vista
 $this->view->listaOcupaciones2= $this->model->listaOcupaciones();
 $this->view->renderView('main/main.php');//llamando al metodo renderView para pintar la vista
 
 }
 function agregarPersona(){
 parent::__construct();
 $nombre = $_POST["nombre"];
 $edad = $_POST["edad"];
 $telefono = $_POST["telefono"];
 $sexo = $_POST["sexo"];
 $ocupacion = $_POST["ocupacion"];
 $fecha = $_POST["fecha"];
 $this->model->agregarPersona($nombre,$edad,$telefono,$sexo,$ocupacion,$fecha);//invocamos al model y a la funcion del modelo
 header('Location:'. constant('URL')."Main/principal");//notese el redirect al metodo principal, esto para no enviar nuevamente los parametros de ese metodo
 }
 function eliminarPersona($id){
 
 header('Location:'. constant('URL')."Main/principal");
 }
}
?>
