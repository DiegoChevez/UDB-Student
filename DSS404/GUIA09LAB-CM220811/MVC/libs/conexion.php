<?php
class Conexion{
 private $host;
 private $username;
 private $password;
 private $bd;
 function __construct(){
 $this->host=constant('HOST');//llamamos las constantes del archivo config.php
 $this->username=constant('USER');
 $this->password=constant('PASSWORD');
 $this->bd=constant('DB');
 }
 function conectar(){
 try{
 $con = new PDO("mysql:dbname=$this->bd;host=$this->host", $this->username,$this->password);//usaremos la libreria o clase PDO para las conexiones 
 return $con;//retornaremos la bdd, que en este caso sera personabdd
 }catch(Exception $e){
 $error = 'Error encontrado en conexión de Base de datos :( : '. $e->getMessage(). "\n";
 return $error;
 }
 }
 function desconectar($conexion){
 try{
 $conexion->query('KILL CONNECTION_ID()');//eliminaremos cualquier conexion
 $conexion = null;//haremos null la bdd, para dar fin a cualquier comunicacion al servicio de mysql
 }catch(Exception $e){
 $error = 'Error encontrado en conexión de Base de datos :( : '. $e->getMessage(). "\n";
 return $error;
 }
 }
}
?>