<?php
class Controller{
 function __construct(){
 echo "<p>soy el controller base</p>";
 $this->view = new View();
 }
}
?>