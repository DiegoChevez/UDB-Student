<?php
class page
{
    //Atributos de la clase
    public $content;
    public $title = "Centro de Estudios de Postgrados - Universidad Don Bosco &copy;";
    public $keywords = "Universidad Don Bosco, UDB, Educaci&oacute;n con estilo salesiano";
    public $buttons = array(
        "Inicio" => "home.php",
        "Carreras" => "carreras.php",
        "Institucional" => "institucional.php",
        "Contacto" => "contacto.php"
    );
    //Operaciones de la clase
    public function __set($name, $value)
    {
        $this->name = $value;
    }
    public function display()
    {
        echo "<!DOCTYPE html>\n";
        echo "<html lang=\"es\">\n<head>\n";
        echo "\t<meta charset=\"utf-8\" />\n";
        $this->displayTitle();
        $this->displayKeywords();
        $this->displayStyles("css/home.css");
        $this->displayScripts("js/modernizr.custom.lis.js");
        echo "</head>\n<body>\n";
        $this->displayHeader();
        $this->displayMenu($this->buttons);
        echo $this->content;
        $this->displayFooter();
        echo "</body>\n</html>";
    }
    public function displayTitle()
    {
        echo "\t<title>" . $this->title . "</title>\n";
    }
    public function displayKeywords()
    {
        echo "\t<meta name=\"keywords\" content=\"" . $this->keywords . "\" />\n";
    }
    public function displayStyles($estilos)
    {
        //Patrón de expresión regular para verificar
        //si la extensión del archivo es .css
        $patron = "%\.{1}(css)$%i";
        $styles = "";
        if (is_array($estilos)) :
            foreach ($estilos as $cssfile) :
                $styles .= "\t<link rel=\"stylesheet\" href=\"" . $cssfile . "\" />\n";
            endforeach;
        else :
            $styles .= "\t<link rel=\"stylesheet\" href=\"" . $estilos . "\" />\n";
        endif;
        echo $styles;
    }
    public function displayScripts($scripts)
    {
        //Patrón de expresión regular para verificar
        //que la extensión del archivo es .js
        $patron = "%\.{1}(js)$%i";
        if (is_array($scripts)) :
            foreach ($scripts as $scriptfile) :
                echo "\t<script type=\"text/javascript\" src=\"" . $scriptfile . "\"></script>\n";
            endforeach;
        else :
            if (!empty($scripts)) :
                if (preg_match($patron, $scripts)) :
                    echo "\t<script type=\"text/javascript\" src=\"" . $scripts . "\"></script>\n";
                endif;
            endif;
        endif;
        $scripts = "\t<script type=\"text/javascript\" src=\"" . $scripts . "\"></script>\n";
    }
    public function displayHeader()
    {
        $header = <<<HEADER
    <!-- page header -->
    <section>
    <article>
    <table width="100%" cellpadding="12" cellspacing="0" border="0">
    <tr bgcolor="black">
    <td align="left">
    <img src="img/logo.gif" alt="Logo URL" height="70" width="70" />
    </td>
    <td>
    <h1>Universidad Don Bosco</h1>
    </td>
    <td align="right">
    <img src="img/logo.gif" alt="Logo URL" height="70" width="70" />
    </td>
    </tr>
    </table>
    HEADER;
        echo $header;
    }
    public function displayMenu($buttons)
    {
        $menu = "<ul id=\"mainmenu\">\n\t";
        //Calcular tamaño
        $width = 100 / count($buttons);
        foreach ($buttons as $name => $url) {
            $menu .= "<li>\n\t\t";
            $menu .= $this->displayButton($width, $name, $url, !$this->isURLCurrentPage($url)) .
                "\n\t\t";
            $menu .= "</li>\n";
        }
        $menu .= "</ul>\n";
        echo $menu;
    }
    function isURLCurrentPage($url)
    {
        if (strpos($_SERVER['PHP_SELF'], $url) == false) :
            return false;
        else :
            return true;
        endif;
    }
    public function displayButton($width, $name, $url, $active = true)
    {
        $button = "";
        if ($active) :
            $button .= "<a href=\"" . $url . "\">\n\t\t";
            $button .= "<img src=\"img/url-icon.png\" alt=\"" . $name . "\" />\n\t";
            $button .= "</a>\n\t";
            $button .= "<a href=\"" . $url . "\">\n\t\t";
            $button .= "<span class=\"menu\">" . $name . "</span>\n\t";
            $button .= "</a>\n";
        else :
            $button .= "<img src=\"img/url-icon.png\" alt=\"" . $name . "\" />\n\t";
            $button .= "<span class=\"menu\">" . $name . "</span>\n";
        endif;
        return $button;
    }
    public function displayFooter()
    {
        $footer = <<<FOOT
    <!-- Pie de la página -->
    <table id="footer">
    <tr>
    <td>
    <p class="foot">
    <a href="http://www.udb.edu.sv" target="_blank">Universidad Don Bosco</a>
    </p>
    <p class="foot">Centro de Estudios de Postgrados.</p>
    </td>
    </tr>
    </table>
    </article>
    </section>
    FOOT;
        echo $footer;
    }
}
