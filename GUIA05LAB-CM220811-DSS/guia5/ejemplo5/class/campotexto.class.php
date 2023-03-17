<?php
//Clase abstracta para algún tipo de campo de formulario
abstract class campoformulario
{
    //Propiedades de la clase abstracta
    protected $idcampo;
    protected $etiqueta;
    protected $capaayuda;
    //Constructor de la clase
    function __construct($id, $etiq, $ayuda)
    {
        $this->idcampo = $id;
        $this->etiqueta = $etiq;
        $this->capaayuda = $ayuda;
    }
    //Método abstracto que será implementado
    //por alguna de las clases hijas o derivadas
    abstract function pinta_campo();
    protected function poner_eventos_js()
    {
        $cmd_js = 'document.getElementById("c_" + this.name).style.visibility';
        $cmd2_js = 'document.getElementById("c_" + this.name).style.display';
        return " onfocus='$cmd_js=\"visible\"; $cmd2_js=\"inline-block\";'
onblur='$cmd_js=\"hidden\"; $cmd2_js=\"none\"'";
    }
    protected function poner_capa_ayuda()
    {
        //El identificador de la capa es
        //'c_' + nombre de la capa
        $s = "background: Lavender; ";
        $s .= "border: 1px solid #4D274F; ";
        $s .= "color: #7B0F86; ";
        $s .= "font: Bold 0.85em \"Open Sans\",Arial,Helvetica,sans-serif; ";
        $s .= "padding: 4px 6px; ";
        $s .= "position:relative; ";
        $s .= "text-shadow: 0 -1px 0 #BFADC0,\n 0 -2px 0 #B099B2,\n 0 -3px 0 #9C889F,\n
0 0 2px #816883,\n 0 -2px 3px #715973,\n 3px -3px 15px #000; ";
        $s .= "display: none; ";
        $s .= "visibility:hidden;";
        return "<span id='c_$this->idcampo' style='$s'>$this->capaayuda</span>\n";
    }
}

//Clase para un campo de formulario de tipo text
class campotexto extends campoformulario
{
    //Definiendo las propiedades
    private $placeholder;
    private $maxcar;
    //Creando un nuevo constructor
    function __construct($id, $etiq, $ayuda, $placehold, $maxcar)
    {
        parent::__construct($id, $etiq, $ayuda);
        $this->placeholder = $placehold;
        $this->maxcar = $maxcar;
    }
    //Implementando el método abstracto pinta_campo
    function pinta_campo()
    {
        $stag = "";
        $stag .= "\t<div class=\"row\">\n";
        $stag .= "\t<section class=\"col col-6\">\n";
        $stag .= "\t\t<label for=\"$this->idcampo\" class=\"input\">\n";
        $stag .= "\t\t<i class=\"icon-prepend icon-user\"></i>\n";
        $stag .= "\t\t<input type=\"text\" name=\"" . $this->idcampo . "\" id=\"" .
            $this->idcampo . "\" placeholder=\"" . $this->placeholder . "\" maxlength=\"" . $this->maxcar . "\"" . $this->poner_eventos_js() . " />\n";
        $stag .= $this->poner_capa_ayuda();
        $stag .= "</label>";
        $stag .= "\t</section>\n";
        $stag .= "\t</div>\n";
        echo $stag;
    }
}

//Clase para un campo de formulario tipo textarea
class campotextarea extends campoformulario
{
    //Propiedades
    private $placeholder;
    private $lineas;
    private $cols;
    //Definiendo un constructor para esta clase
    function __construct($id, $etiq, $lineas, $cols, $ayuda, $placehold)
    {
        parent::__construct($id, $etiq, $ayuda);
        $this->placeholder = $placehold;
        $this->lineas = $lineas;
        $this->cols = $cols;
    }
    function pinta_campo()
    {
        $tag = "\t<section>\n";
        $tag .= "\t\t<label for=\"$this->idcampo\" class=\"textarea\">$this->etiqueta\n";
        $tag .= "\t\t<textarea name=\"" . $this->idcampo . "\" id=\"" . $this->idcampo
            . "\" rows=\"" . $this->lineas . "\" cols=\"" . $this->cols . "\" " . $this->poner_eventos_js() . ">";
        $tag .= $this->placeholder;
        $tag .= "</textarea>\n";
        $tag .= $this->poner_capa_ayuda();
        $tag .= "</label>";
        $tag .= "\t</section>\n";
        echo $tag;
    }
}

class campocheckbox extends campoformulario
{
    //Definiendo las propiedades
    private $options = array();
    private $enlistados;
    //Creando el constructor de la clase campocheckbox
    function __construct($id, $name, $etiq, $ayuda, $options, $enlistados = false)
    {
        parent::__construct($id, $name, $etiq, $ayuda);
        $this->options = $options;
        $this->etiqueta = $etiq;
        $this->enlistados = $enlistados;
    }
    //Implementando el método abstracto crearcampo
    function pinta_campo()
    {
        $pos = 0; //Indica la posición en el arreglo de opciones del checkbox
        //echo "<label for=\"$this->idcampo" . $pos . "\">$this->etiqueta</label><br />\n";
        $stag = "";
        $stag .= "\t<section>\n";
        $stag .= "\t\t<label>" . $this->etiqueta . "</label>\n";
        //Recorriendo el array con las opciones del checkbox
        foreach ($this->options['opciones'] as $key => $value) {
            $stag .= "\t\t<label class=\"checkbox\">\n";
            $stag .= "\t\t<input type=\"checkbox\" value=\"$value\" name=\"$this->idcampo"
                . $pos . "\" id=\"$this->idcampo" . $pos . "\" ";
            $stag .= $this->options['estados'][$pos] == true ? "checked=\"checked\" " : "";
            $stag .= " /><i class=\"fa-check\"></i>$key</label>\n";
            $stag .= $this->enlistados == true ? "<br />\n" : "";
            $pos++;
        }
        $stag .= "\t</section>\n";
        echo $stag;
        echo $this->enlistados == true ? "<br />\n" : "";
    }
}

class camposelect extends campoformulario
{
    //Propiedades de la clase
    private $size;
    private $multiple;
    private $options = array();
    //Método constructor
    function __construct($id, $etiq, $ayuda, $size, $multiple, $options)
    {
        parent::__construct($id, $etiq, $ayuda);
        $this->size = $size;
        $this->multiple = $multiple;
        $this->options = $options;
    }
    function pinta_campo()
    {
        $mult = ($this->multiple != "") ? " " . $this->multiple : "";
        $seltag = "<div class=\"row\">\n";
        $seltag .= "\t<label for=\"" . $this->idcampo . "\" class=\"label col col-4\">$this->etiqueta</label><br />\n";
        $seltag .= "\t<section class=\"col col-5\">";
        $seltag .= "\t\t<label class=\"select\">";
        $seltag .= "\t\t<select name=\"" . $this->idcampo . "\" id=\"" . $this->idcampo
            . "\" size=\"" . $this->size . "\"" . $this->poner_eventos_js() . ">\n";
        foreach ($this->options as $key => $value) {
            $seltag .= "\t\t\t<option value=\"$key\">$value</option>\n";
        }
        $seltag .= "\t\t</select>\n";
        $seltag .= $this->poner_capa_ayuda();
        $seltag .= "\t\t<i></i>\n";
        $seltag .= "\t\t</label>\n";
        $seltag .= "</div>\n";
        echo $seltag;
    }
}
class camposubmit extends campoformulario
{
    //Propiedades adicionales
    private $value;
    //Constructor de la clase camposubmit
    function __construct($id, $etiq, $value, $ayuda)
    {
        parent::__construct($id, $etiq, $ayuda);
        $this->value = $value;
    }

    function pinta_campo()
    {
        $subtag = "<input type=\"submit\" name=\"" . $this->idcampo . "\" id=\"" . $this->idcampo . "\" value=\"" . $this->value . "\" class=\"button\"";
        $subtag .= $this->poner_eventos_js() . " />\n";
        $subtag .= $this->poner_capa_ayuda();
        $subtag .= "<br />\n";
        echo $subtag;
    }
}
?>