<?php
class PersonaBean
{
 private $idPersona;
 private $nombre;
 private $edad;
 private $telefono;
 private $sexo;
 private $ocupacion;
 private $fecha;
 function setIdPersona($idPersona)
 {
 $this->idPersona = $idPersona;
 }
 function getIdPersona()
 {
 return $this->idPersona;
 }
 function setNombre($nombre)
 {
    $this->nombre = $nombre;
}
function getNombre()
{
return $this->nombre;
}
function setEdad($edad)
{
$this->edad = $edad;
}
function getEdad()
{
return $this->edad;
}
function setTelefono($telefono)
{
$this->telefono = $telefono;
}
function getTelefono()
{
return $this->telefono;
}
function setSexo($sexo)
{
$this->sexo = $sexo;
}
function getSexo()
{
return $this->sexo;
}
function setOcupacion($ocupacion)
{
$this->ocupacion = $ocupacion;
}
function getOcupacion()
{
return $this->ocupacion;
}
function setFecha($fecha)
{
$this->fecha = $fecha;
}
function getFecha()
{
return $this->fecha;
}
}
?>