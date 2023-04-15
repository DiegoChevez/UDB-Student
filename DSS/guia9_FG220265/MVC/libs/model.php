<?php
class Model{
 function __construct(){
    $this->con= new Conexion();//instaciamos la clase conexion, para que cada vez que accedamos a este constructor invoquemos una conexion diferente
 
 }
}