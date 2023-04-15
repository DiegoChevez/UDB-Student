<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" arialabelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Agregar persona</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" arialabel="Close">X</button>
            </div>
            <div class="modal-body">
                <form role="form" id="formactualiza" action="<?php echo constant("URL") 
?>Main/agregarPersona" method="POST">
                    <div class="col-md-12" id="conten">
                        <input type="hidden" name="id" id="idpersona">

                        <div class="form-group">
                            <label for="nombre">Ingrese el nombre de la persona:</label>
                            <div class="input-group">
                                <input type="text" class="form-control" name="nombre" placeholder="Ingresa 
el nombre" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="edad">Ingrese la edad de la persona:</label>
                            <div class="input-group">
                                <input type="number" class="form-control" name="edad" placeholder="Ingresa 
la edad" required>
                            </div>
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" arialabelledby="exampleModalLabel"
                                aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Agregar persona</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <form role="form" id="formactualiza" action="<?php echo constant("URL") 
?>Main/agregarPersona" method="POST">
                                                <div class="col-md-12" id="conten">
                                                    <input type="hidden" name="id" id="idpersona">

                                                    <div class="form-group">
                                                        <label for="nombre">Ingrese el nombre de la persona:</label>
                                                        <div class="input-group">
                                                            <input type="text" class="form-control" name="nombre"
                                                                placeholder="Ingresa 
el nombre" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="edad">Ingrese la edad de la persona:</label>
                                                        <div class="input-group">
                                                            <input type="number" class="form-control" name="edad"
                                                                placeholder="Ingresa 
la edad" required>
                                                        </div>