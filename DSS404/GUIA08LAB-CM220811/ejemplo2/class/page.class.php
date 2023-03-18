<?php
/**************************************************
*  Descripción: Clase para crear páginas web      *
*  Creador: Ricardo Elías                         *
*  Fuente: Libro Desarrollo web con PHP y MySQL   *
*  Fecha: 10-marzo-2013                           *
***************************************************/
class page {
	//Atributos de la clase
	public $content;
	public $title;
	public $keywords;
	public $buttons = array();

	//Constructor de la clases
  public function __construct($titulo, $keywords, $opciones){
    $this->title = $titulo;
    //Este argumento debe ser una cadena con las palabras clave
    //separadas por comas
    $this->keywords = $keywords;
    //Las opciones de menú y sus enlaces deben ser pasadas
    //usando una matriz asociativa
    if(is_array($opciones)){
      foreach($opciones as $link => $page){
        $this->buttons[$link] = $page;
      }
    }
    else{
      die("Las opciones deben ser pasadas a esta propiedad como una matriz asociativa");
    }
  }

  //Operaciones de la clase 
	public function __set($name, $value){
    $this->name = $value;
	}

	public function display(){
		echo "<!DOCTYPE html>\n";
		echo "<html lang=\"es\">\n<head>\n";
    echo "\t<meta charset=\"utf-8\" />\n";
		$this->displayTitle();
		$this->displayKeywords();
		//$this->displayStyles("css/home.css");
    $this->displayStyles("css/incripcion_css.css");
		//$this->displayScripts("js/modernizr.custom.lis.js");
		echo "</head>\n<body>\n";
    $this->displayHeader();
    $this->displayMenu($this->buttons);
    echo $this->content;
    $this->displayFooter();
    echo "</body>\n</html>";
	}

	public function displayTitle(){
    echo "\t<title>" . $this->title . "</title>\n";
	}

	public function displayKeywords(){
		echo "\t<meta name=\"keywords\" content=\"" . $this->keywords . "\" />\n";
	}

	public function displayStyles($estilos){
		//Patrón de expresión regular para verificar
    //si la extensión del archivo es .css
    $patron = "%\.{1}(css)$%i";
    $styles = "";
    if(is_array($estilos)):
      foreach($estilos as $cssfile):
        $styles .= "\t<link rel=\"stylesheet\" href=\"" . $cssfile . "\" />\n";
      endforeach;
    else: 
      $styles .= "\t<link rel=\"stylesheet\" href=\"" . $estilos . "\" />\n";
    endif;
    echo $styles;
	}

  public function displayScripts($scripts){
    //Patrón de expresión regular para verificar
    //que la extensión del archivo es .js
    $patron = "%\.{1}(js)$%i";
    if(is_array($scripts)):
      foreach($scripts as $scriptfile):
        echo "\t<script src=\"" . $scriptfile . "\"></script>\n";
      endforeach;
    else:
        if(!empty($scripts)):
          if(preg_match($patron, $scripts)):
            echo "\t<script src=\"" . $scripts . "\"></script>\n";
          endif;
        endif;
    endif;
    $scripts = "\t<script src=\"" . $scripts . "\"></script>\n";
  }

	public function displayHeader(){
		$header = <<<HEADER
    <!-- page header -->
    <section>
      <article>
        <div id="encabezado"></div>
        <div id="contenedor">  
HEADER;
        echo $header;
	}

  public function displayMenu($menuoptions){
?>
    <div class="rediv" id="slidebar">
      <div class="rediv" id="slidebart">
        Menú Principal
      </div>
<?php
    $menu  = "<ul id=\"mainmenu\">\n\t";
    //Calcular tamaño
    $width = 116/count($menuoptions);
    foreach($menuoptions as $url => $name):
      $menu .= "<li>\n\t\t";
      $menu .= $this->displayButton($width, $name, $url, !$this->isURLCurrentPage($url)) . "\n\t\t";
      $menu .= "</li>\n";    
    endforeach;
    $menu .= "</ul>\n";
    echo $menu;
?>
      <div id="slidebar2" class="rediv">
      <div class="rediv" id="slidebart">
        Datos Importantes
      </div>
      <p>
        <strong>Horarios de Atención</strong><br /><br />
        <u>Colecturía</u><br />
        <strong>Lunes  a viernes: </strong><br />
        7:00 a.m. a 5:30 p.m. <br />
        Sin cerrar al mediodía<br /><br />
        <strong>Sábado: </strong><br />
        8:00 a.m. a 12:00 m.<br /><br />
        <u>Gestión Social y <br />
        Administración Académica</u><br />
        <strong>Lunes  a viernes: </strong><br />
        7:00 a.m. a 12:00 m. <br />
        1:00 p.m. a 5:30 p.m.<br />
        <strong>Sábado: </strong><br />
        8:00 a.m. a 12:00 m.<br /><br />
        <strong>PBX:</strong> (503) 2251-8200.
      </p>
    </div> <!-- Fin del div id=slidebar2 -->
  </div> <!-- Fin del div id=slidebar -->
<?php
	}

  function isURLCurrentPage($url){
    if(strpos($_SERVER['PHP_SELF'], $url) == false):
      return false;
    else:
      return true;
    endif;

  }

  public function displayButton($width, $name, $url, $active=true){
    $button = "";
    if($active):
      $button .= "<a href=\"" . $url . "\">\n\t\t";
      $button .= "<span class=\"menu\">" . $name . "</span>\n\t";
      $button .= "</a>\n";
    else:
      $button .= "<span class=\"menu\">" . $name . "</span>\n";
    endif;
    return $button;
  }

  public function displayFooter(){
    $footer = <<<FOOT
        <!-- Pie de la página -->
        <p>
          UDB 2013. Derechos Reservados &copy; <br />
          Calle Plan del Pino Km 1 1/2, Ciudadela Don Bosco, Soyapango, 
          San Salvador, C.A<br />
          Tel. (503)22518200<br />
          <strong>
            <a href="http://www.udb.edu.sv" target="_blank">http://www.udb.edu.sv</a>
          </strong>
        </p>
      </div> <!-- Fin del div id=contenido -->
    </div> <!-- Fin del div id=contenedor -->
    <div id="footerwrap"></div>
  </article>
</section>
FOOT;
    echo $footer;
  }
}
?>