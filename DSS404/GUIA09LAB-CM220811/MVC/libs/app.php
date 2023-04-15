<?php
require_once 'controllers/ErrorController.php';
class App{
 function __construct(){
 
 $url = isset($_GET["url"]) ? $_GET["url"] : null;//obtenemos todo lo que venga despues de localhost/dss/mvc y validamos que si el campo viene vacio este sera null
 
 $url = rtrim($url,'/');//limpiamos la url para evitar parametros como localhost/dss/mvc//////Controller
 $url = explode('/',$url);//convertimos a un arreglo todo lo que venga despues de la raiz del proyecto
 
 if(empty($url[0])){
 $archivoController = 'controllers/MainController.php';//creamos la url para invocar el archivo del controlador
 require_once($archivoController);
 $controller = new MainController();
 $controller->loadModel('Main');
 $controller->principal();
 return false;
 }
 
 $archivoController = 'controllers/' . $url[0]. 'Controller.php';//creamos la url para invocar el archivo del controlador
 
 $clase= $url[0]. 'Controller';//nombre de la clase a instaciar MainController
 if(file_exists($archivoController)){//validamos que el archivo exista
 require_once $archivoController;//invocamos el archivo con el controlador
 $controller = new $clase;//instanciamos la clase del controlador
 $controller->loadModel($url[0]);
 if(isset($url[1])){
 if(method_exists($controller,$url[1])){//verificamos si el metodo existe en el controller
 if(isset($url[2])){//verificamos si viene un parametro metodo o funcion del cotroller
 $controller->{$url[1]}($url[2]);
 }
 $controller->{$url[1]}();//aqui invocaremos a las acciones o funciones de cada controller
 }else{
 $controller = new ErrorController();//de lo contrario invocamos a controller de error
 }
 
 }else{
 $controller = new ErrorController();//de lo contrario invocamos a controller de error
 }
}else{
    $controller = new ErrorController();//de lo contrario invocamos a controller de error
    }
    }
   }
   ?>
   