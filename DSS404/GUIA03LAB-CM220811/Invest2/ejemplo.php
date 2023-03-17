<!-- Investigue sobre el uso de funciones anónimas en PHP, indicando los motivos por los cuáles pueden
ser utilizadas e implemente un ejemplo simple de cada caso.-->

<?php

    $ejemplo = function($var){
        echo "hola como estas ". $var;
    };



    echo $ejemplo("Diego");

?>



<!-- Practicamente las funciones anonimas, las cuales por logica no estan enlzadas a un nombre o metodo, en este caso son usadas de muchas formas ya que estas se prestanpara cualquier objetivo sin necesidad de ligarlas a una accion en especifica  -->