<?php
class View{
 function __construct(){
 
 }
 function renderView($vista){//Notara que nunca hacemos un redirect puntual a una vista
 require 'views/' . $vista; // Entonces llamamos ese codigo y añadimos el recurso vista
 }
}