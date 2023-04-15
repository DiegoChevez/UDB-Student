<?php
class View{
 function __construct(){
 echo "<p>soy la vista base</p>";
 }
 function renderView($vista){
 require 'views/' . $vista;
 }
}