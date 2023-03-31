<?php
  //Se manejarán sesiones por lo tanto incluir librería de seguridad
  require_once('seguridad.php');

  spl_autoload_register(function ($class_name){
      require("class/" . $class_name . ".class.php");
  });

  //Incluyendo la matriz con las opciones de menú 
  //donde está definida la matriz $menu que se envía
  //como tercer argumento del constructor de la clase Page
  $menu = array(
    "home.php" => "Inicio",
    "ingreso.php" => "Proceso de ingreso",
    "documentos.php" => "Documentos de ingreso",
    "costos.php" => "Costos",
    "salir.php" => "Salir"
  );

  //Creando una página, instanciando la clase page
  $homepage = new page("Costos - Nuevo Ingreso UDB", "Costos de Nuevo Ingreso, Costos para alumnos de Nuevo Ingreso UDB, Costos de Ingreso", $menu);

  $homepage->content = <<<PAGE
            <table border="1">
               <caption>
                  <span>Bienvenido {$_SESSION['nombreusr']} </span>
               </caption>
               <thead>
                  <tr>
                     <th style="background-color:#05A9FF;color:White;">Pagos a realizar:</th>
                     <th style="background-color:#05A9FF;color:White;text-align:center;width:16%;">TMA</th>
                     <th style="background-color:#05A9FF;color:White;text-align:center;width:20%;">Otras carreras</th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td>Paquete informativo</td>
                     <td class="price">$&nbsp;12.00</td>
                     <td class="price">$&nbsp;12.00</td>
                  <tr>
                  <tr>
                     <td>Costos de ingreso* (otras carreras)</td>
                     <td class="price">&ndash;</td>
                     <td class="price">$&nbsp;70.00</td>
                  <tr>
                  <tr>
                     <td>Curso de Inducci&oacute;n a la Vida Universitaria (TMA)</td>
                     <td class="price">$&nbsp;30.00</td>
                     <td class="price">&ndash;</td>
                  <tr>
                  <tr>
                     <td>Matr&iacute;cula (TMA)</td>
                     <td class="price">$&nbsp;75.00</td>
                     <td class="price">&ndash;</td>
                  <tr>
                  <tr>
                     <td>Mensualidad</td>
                     <td class="price">$&nbsp;133.00</td>
                     <td class="price">Cuota diferenciada</td>
                  <tr>
                  <tr>
                     <td>
					    Otros servicios<br />
				        (Incluye: Seguro colectivo de accidentes personales, uso de biblioteca, talonario, carn&eacute;, 
					    cat&aacute;logo institucional, gu&iacute;a estudiantil, uso de Internet).
					 </td>
                     <td class="price">$&nbsp;44.00</td>
                     <td class="price">$&nbsp;44.00</td>
                  <tr>
                  <tr>
				     <td>
				        Laboratorios (importe que se cancela una vez al inicio del ciclo en materias espec&iacute;ficas
					    del plan de estudio de la carrera que cursas. Consulta en Escuelas):<br />
					    <ul>
					       <li>Laboratorios TMA</li>
						   <li>Laboratorios Tecnol&oacute;gico</li>
					       <li>Laboratorios de Ingenier&iacute;a y Licenciatura</li>
					       <li>Pr&aacute;ctica Docente (Profesorados y Licenciaturas)</li>
					       <li>Pr&aacute;ctica en Ortesis y Pr&oacute;tesis</li>
					       <li>Ingl&eacute;s T&eacute;cnico TMA</li>
					    </ul>
				     </td>
				     <td colspan="2" style="text-align:center">
				        <br />
				        <br />
				        <br />
					    $&nbsp;&nbsp;38.00<br />
						$&nbsp;&nbsp;33.00<br />
					    $&nbsp;&nbsp;43.00<br />
					    $&nbsp;&nbsp;17.00<br />
					    $119.30<br />
					    $&nbsp;&nbsp;28.00<br />
				     </td>
				  </tr>
               </tbody>
            </table>
          <p>(*) Los costos de ingreso dan derecho al Curso de Inducci&oacute;n a la Vida Universitaria,
          pruebas diagn&oacute;sticas y matr&iacute;cula. No se devuelven si el alumno no se inscribe 
          en la Universidad.<br />
          <!-- (**) La carrrera de Ingenier&iacute;a Aeron&aacute;utica tiene una cuota m&iacute;nima de $150.00. -->
          </p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
PAGE;
  echo $homepage->display();
?>