<?php
    spl_autoload_register(function ($class_name) {
        require("class/" . $class_name . ".class.php");
    });

    //Creando el objeto página
    $homepage = new page();
    $homepage->content = <<<PAGE
        <!-- page content -->
        <div id="topcontent">
            <div id="textbox">
                <div id="title">
                    <h2>BIENVENIDOS</h2>
                </div>
                <div id="paragraph">
                    <p>
                        La Universidad Don Bosco en sus 27 años de experiencia educativa,
                        ha mantenido una expansión constante en su oferta académica,
                        lo cual puede comprobarse en su trayectoria desde su creación en
                        1984.<br />
                        Con la apertura del Centro de Estudios de Postgrados (CEP), la Universidad
                        Don Bosco promueve un nuevo horizonte de las posibilidades educativas
                        con el propósito de responder objetivamente a necesidades concretas
                        del país.
                    </p>
                </div>
            </div>
            <div id="picture">
                <img src="img/plaza-de-las-banderas.jpg" alt="Imagen de portada" width="800"
                height="370" longdesc="Imagen de portada" />
            </div>
        </div>
    PAGE;
    echo $homepage->display();
?>