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
 return false;
 }

 $archivoController = 'controllers/' . $url[0]. '.php';//creamos la url para invocar el archivo del controlador

 if(file_exists($archivoController)){//validamos que el archivo exista
 require_once $archivoController;//invocamos el archivo con el controlador
 $controller = new $url[0];//instanciamos la clase del controlador

 if(isset($url[1])){
 $controller->{$url[1]}();//aqui invocaremos a las acciones o funciones de cada controller
 }
 }else{
 $controller = new ErrorController();//de lo contrario invocamos a controller de error
 }
 }
}
?>