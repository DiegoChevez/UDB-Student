<?php
 //error_reporting(E_ALL ^ E_NOTICE);
 require_once("funcioneseditor.php");
 if(isset($_POST['savefile'])){
 savefile();
 }
 elseif(isset($_GET['filename'])){
 displayeditform();
 }
 elseif(isset($_POST['createfile'])){
 createfile();
 }
 else{
 displayfilelist();
 }
?>
