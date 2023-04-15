<?php
require "beans/PersonaBean.php";//llamamos los recursos beans, para acceder a sus clases.
require "beans/OcupacionBean.php";//llamamos los recursos beans, para acceder a sus clases.
class MainModel extends Model
{
 function __construct()
 {
 parent::__construct();//accedemos al constructor de Model, para poder usar la bdd
 }
 function listaPersonas()
 {
 $query = "SELECT * FROM persona a INNER JOIN ocupaciones o ON a.id_ocupacion = 
o.id_ocupacion";
 $this->conexion = $this->con->conectar();//accedemos a la funcion conectar, y por ende su return, 
el cual recordara es la bdd
 $resultado = $this->conexion->prepare($query); //preparamos la consulta
 $resultado->execute();//ejecutamos la consulta
 $array =array();
 while ($row = $resultado->fetch()) {//obtenemos los resultados de la consulta, aqui se convertiran 
en arreglos nativos de php que podemos recorrer y usar
 $persona = new PersonaBean();//instaciamos una nueva persona
 $ocupacion = new OcupacionBean();//instaciamos una nueva ocupacion, recordara que en 
Persona Bean hay un atributo llamado Ocupacion
 $persona->setIdPersona($row['id_persona']);
 $persona->setNombre($row['nombre_persona']);
 $persona->setEdad($row['edad_persona']);
 $persona->setTelefono($row['telefono_persona']);
 $persona->setSexo($row['sexo_persona']);
 $persona->setFecha($row['fecha_nac']);//setiamos los valore de persona
 $ocupacion->setOcupacion($row['ocupacion']);
 $ocupacion->setIdOcupacion($row['id_ocupacion']);
 $persona->setOcupacion($ocupacion);//finalmente cargamos el atributo ocupacion con un objeto 
ocupacion
 $array[]= $persona;//cargamos el arreglo
 }
 $this->con->desconectar($this->conexion);//cerramos la conexion
 return $array;//retornamos el arreglo
 }
 function listaOcupaciones()
 {
 $query = "SELECT * FROM ocupaciones";
 $this->conexion = $this->con->conectar();
 $resultado = $this->conexion->prepare($query);
 $resultado->execute();
 $array =array();
 while ($row = $resultado->fetch()) {//obtenemos los resultados de la consulta, aqui se convertiran 
en arreglos nativos de php que podemos recorrer y usar
$ocupacion = new OcupacionBean(); 
 $ocupacion->setOcupacion($row['ocupacion']);
 $ocupacion->setIdOcupacion($row['id_ocupacion']);
 
 $array[]= $ocupacion;//cargamos el arreglo
 }
 $this->con->desconectar($this->conexion);
 return $array;
 }
 function agregarPersona($nombre, $edad, $telefono, $sexo, $ocupacion, $fecha)
 {
 $query = "INSERT INTO persona (nombre_persona, edad_persona, telefono_persona, 
sexo_persona, id_ocupacion, fecha_nac) VALUES(:nombre,:edad,:telefono,:sexo,:ocupacion,:fecha)";
 $this->conexion = $this->con->conectar();
 $row = $this->conexion->prepare($query);
 $row->bindParam(':nombre', $nombre);//enviamos parametros a la consulta, esto evita inyecciones 
SQL
 $row->bindParam(':edad', $edad);
 $row->bindParam(':telefono', $telefono);
 $row->bindParam(':sexo', $sexo);
 $row->bindParam(':ocupacion', $ocupacion);
 $row->bindParam(':fecha', $fecha);
 return $row->execute();//devolvera un booleano dependiendo si la consulta y conexion fue exitosa
 }
 function obtenerPersona()
 {
 $id = 1;
 $query = "SELECT * FROM persona WHERE id_persona = :valor";
 $this->conexion = $this->con->conectar();
 $row = $this->conexion->prepare($query);
 $row->bindParam(':valor', $id);
 $row->execute();
 while ($row = $row->fetch()) {
 $persona = new PersonaBean();
 $ocupacion = new OcupacionBean();
 $persona->setIdPersona($row['id_persona']);
 $persona->setNombre($row['nombre_persona']);
 $persona->setEdad($row['edad_persona']);
 $persona->setTelefono($row['telefono_persona']);
 $persona->setSexo($row['sexo_persona']);
 $persona->setFecha($row['fecha_nac']);
 $ocupacion->setOcupacion(null);
 $ocupacion->setIdOcupacion($row['id_ocupacion']);
 $persona->setOcupacion($ocupacion);
 return $persona;
 }
 return $persona;
}
}
?>