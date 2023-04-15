
  


    function modificar(id, nombre,edad, telefono,sexo,ocupacion,fecha)
    {
      
        document.getElementById("idpersona").value=id;
        document.getElementById("nombre").value=nombre;
        document.getElementById("edad").value=edad;
        document.getElementById("sexo").value=sexo;
        document.getElementById("telefono").value=telefono;
        document.getElementById("ocupacion").value=ocupacion;
        document.getElementById("fecha").value=fecha;
        document.getElementById("operacion").value="modificar";
        
       

    }