<?php
class OcupacionBean 
{
    private $idOcupacion;
    private $ocupacion;
    
    function setIdOcupacion($idOcupacion){
    $this->idOcupacion=$idOcupacion;
    }
    function getIdOcupacion(){
    return $this->idOcupacion;
    }
    function setOcupacion($ocupacion){
    $this->ocupacion=$ocupacion;
    }
    function getOcupacion(){
    return $this->ocupacion;
    }
   }
   ?>