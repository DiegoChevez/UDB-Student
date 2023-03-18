<?php
    spl_autoload_register(function ($class_name) {
        require("class/" . $class_name . ".class.php");
    });

    //Creando el objeto página
    $homepage = new page();
    $homepage->content = <<<PAGE
        <!-- page content -->
        <div class="card mb-3">
            <img src="img/banner.jpg" class="card-img-top" alt="..." style="height:500px;">
            <div class="card-body">
                <h5 class="card-title">Institucional</h5>
                <p class="card-text">La Universidad Don Bosco es una institución apolítica, de inspiración cristiana, sin fines de lucro, creada con carácter permanente y perteneciente a la Institución Salesiana, por fundación y carisma. Fundada en 1984 es continuadora del esfuerzo iniciado por Don Bosco y se orienta hacia la centralidad de la persona y la educación integral de los jóvenes.     
                Es una entidad sólida enfocada en la educación superior con estilo salesiano a través de iniciativas institucionales significativas, tales como: un Modelo Educativo, la planificación estratégica y táctica de mediano plazo, y a la vez, la construcción de una institucionalidad e integridad cada vez más orientada a mejorar continuamente.
                La UDB le apuesta continuamente a la excelencia académica y la responsabilidad social en su contexto geográfico e histórico; con una apuesta sólida por la innovación que le ha permitido adentrarse progresivamente en la internacionalización y dar su aporte a la sociedad del conocimiento.</p>
            </div>
        </div>
        <br>
        <h2>Conocenos</h2>
        <div class="card-group">
            <div class="card">
                <img src="img/ft1.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                <h5 class="card-title">MISIÓN</h5>
                <p class="card-text">Somos una institución de Educación Superior con carisma salesiano dedicada a la formación integral de la persona humana, por medio de la investigación, la ciencia, la cultura, la tecnología, la innovación y el compromiso con la comunidad para la construcción de una sociedad libre, justa y solidaria.</p>
                </div>
                
            </div>
            <div class="card">
                <img src="img/ft3.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                <h5 class="card-title">VISIÓN</h5>
                <p class="card-text">Una universidad salesiana, líder a nivel nacional y referente a nivel regional por su modelo educativo; reconocida por la innovación curricular; por el desarrollo profesional y la internacionalización de sus estudiantes, educadores y personal de gestión; por la ejecución de proyectos de investigación, desarrollo e innovación; por sus publicaciones de impacto; por sus programas de grado y postgrado acreditados internacionalmente; por sus programas a distancia únicos e innovadores; por el mejoramiento continuo de la calidad y por la gestión de sus recursos físicos, tecnológicos y financieros para la sostenibilidad de la institución.</p>
                </div>
                
            </div>
            <div class="card">
                <img src="img/ft2.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                <h5 class="card-title">IDEARIO</h5>
                <p class="card-text">La Universidad Don Bosco es continuadora del esfuerzo iniciado por Don Bosco y que se orienta hacia la educación integral de los jóvenes.
                El Ideario de la UDB es el conjunto de ideas, principios y criterios que de manera organizada, conforman su "ideal" o su "deber ser"; nace de la rica experiencia pedagógica de más de un siglo heredada a los salesianos por Don Bosco, la cual se enriquece a través de los desafíos que surgen desde el contexto local (Soyapango) y nacional (El Salvador).
                Creado en 2001, reúne la mística universitaria enraizada en los valores evangélicos, la flexibilidad del estilo educativo de Don Bosco y la preocupación por acompañar al joven en su proceso de madurez; así como el perfil del profesional que convoca.</p>
                </div>
            
            </div>
        </div>
    PAGE;
    echo $homepage->display();
?>