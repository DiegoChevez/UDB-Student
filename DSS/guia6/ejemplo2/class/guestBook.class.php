<?php
 class guestBook {
 //Propiedades
 protected $name;
 protected $address;
 protected $phone;
 protected $birthday;
 private $file;
 //Métodos para escritura de las propiedades
 function setName($name){
 $this->name = $name;
 }
 function setAddress($address){
 $this->address = $address;
 }
 function setPhone($phone){
 $this->phone = $phone;
 }
 function setBirthday($birthday){
 $this->birthday = $birthday;
 }
 function setFile($file){
 $this->file = $file;
 }
 //Métodos para lectura de las propiedades
 function getName($name){
 return $this->name;
 }
 function getAddress($address){
 return $this->address;
 }
 function getPhone($phone){
 return $this->phone;
 }
 function getBirthday($birthday){
 return $this->birthday;
 }
 function getFile($file){
 return $this->file;
 }
 function showGuest(){
 echo "<div id=\"showGuest\">";
 echo "$this->name.<br>";
 echo "$this->address.<br>";
 echo "$this->phone.<br>";
 echo "$this->birthday.<br>";
 echo "</div>";
 }
 function saveGuest(){
 $outputstring = $this->name . " : " . $this->address . " : ";
 $outputstring .= $this->phone . " : " . $this->birthday . "\n";
 $path = "$_SERVER[DOCUMENT_ROOT]/../guest/$this->file";
 @$fh = fopen($path, "ab");
 if(!$fh){
 $fh = fopen($path, "wb");
 }
 fwrite($fh, utf8_decode($outputstring), strlen($outputstring));
 fclose($fh);
 echo "<h3>Datos salvados en la ruta indicada $path";
 }
 }
?>