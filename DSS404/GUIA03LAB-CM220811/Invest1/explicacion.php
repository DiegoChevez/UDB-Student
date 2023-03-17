<!-- 
    inclide(); y required(); 
    *Estas funciones lo que realizar es buscar y evaluar si un archivo existe y este funciona para asi añadirlo al archivo donde se ha seteado estas funciones*


    inclide(); y required(); 
    "Diferencia:"
    *Como explicamos antes estos dos practicamente realizar lo mismo, hacen lo mismo, en lo que radica la diferencia es que include() al fallar devolvera una advertencia caso contrario a required(); que este devolvera un error fatal* 

    *Es decir que include() al fallar nos emitira y mostrara el error pero continuara la ejucucion en cambio required para esta en caso de fallar*
-->

<?php

//require 'ejemplo.php';
//require_once 'ejemplo.php';


//include 'ejemplo.php';
include_once 'ejemplo.php';


echo prueba1(5,5);
echo "<br>hola";



?>


<!-- 
    PARA LAS FUCNIONES REQUIRED_ONCE(); Y INCLUDE_ONE 
    Estas funciones son practicamente identicas a sus funciones padres, "required(); y include()", con solo una diferencia la cual es que, si estas funciones evaluan que el archivo incluido o requerido para ejecutarse ya ha sido incluido o requerido, esta funcion ya no los incluira o los requeridad, ya que solamente puede haber un llamado de este documento, en cualquier documento donde se encuentren estas funciones.
-->