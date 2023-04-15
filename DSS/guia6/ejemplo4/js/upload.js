//Esta es una variable de control para mantener nombres
//diferentes de cada campo de texto creado dinámicamente.
var numero = 0; 
var idText = 0; 
var idField = 0; 
var idSpan = 0; 
window.onload = init;
function init() {
 //Asociando el enlace Subir otro archivo al enlace apropiado
 var link = document.getElementById("addfieldlink");
 if(link.addEventListener){
 link.addEventListener("click", addCampo, false);
 }
 else if(link.attachEvent){
 link.attachEvent("onclick", addCampo);
 }
 // para añadirle funcionalidad al span del primer input file type
 var span = document.getElementById("spanadj");
 if (span.addEventListener) {
 span.addEventListener("click",function(){
 var adj = document.getElementById("uploadBtn0");
 adj.click();
 adj.onchange = function(){
 document.getElementById('uploadFile0').value = this.value;
 }
 },false);
 }
}
//Esta funcion nos devuelve el tipo de evento disparado
evento = function (evt) {
 return (!evt) ? event : evt;
}
//Con esta funcion crea dinamicamente los nuevos campos file
addCampo = function () { 
 //Contador para los elementos dinámicos que se generarán
 ++numero;
 //Creamos un nuevo div para que contenga el nuevo campo
 nDiv = document.createElement('div');
 //con esto se establece la clase del elemento div
 nDiv.className = 'contenedor';
 //Este es el id del div, aquí la utilidad de la variable numero
 //nos permite darle un id unico
 nDiv.id = 'file' + (numero);
 //Creando un elemento input que estará deshabilitado
 nInput = document.createElement('input');
 //Colocando los atributos para el elemento input type=text
 nInput.type = 'text';
 //Establecer el id del campo de texto deshabilitado
 nInput.id = 'uploadFile' + (numero);
 //Colocando el placeholder
 nInput.placeholder = 'Seleccionar archivo';
 //Agregando el atributo para que el control esté deshabilitado
 nInput.disabled = 'disabled';
 
 //Creamos otro div que contendrá los elementos 
 nDivAdjunto = document.createElement('div');
 nDivAdjunto.className = "file-upload btn";
 //Creando el elemento span que hará las veces del botón
 //incluido en los campos input type=file cuando este elemento 
 //se oculte y se cambie por un span y un campo de texto
 nSpan = document.createElement('span');
 nSpan.className = "btn btn-primary";
 nSpan.innerHTML = 'Adjunto';
 nSpan.id = (numero);
 nSpan.onclick = addOneClick;
 //Creamos el input type=file para el formulario:
 nCampo = document.createElement('input');
 //Le damos un nombre, es importante que se nombre como vector/matriz, 
 //pues todos los campos compartiran el nombre en un arreglo,
 //asi es mas facil procesar posteriormente con php
 nCampo.name = 'archivos[]';
 //Establecemos el tipo de campo
 nCampo.type = 'file';
 //Agregar id al campo input type=file
 nCampo.id = 'uploadBtn' + (numero);
 //Agregar la clase al elemento input type=file
 nCampo.className = 'upload';
 
 //Creando un elemento a href para poder eliminar un campo 
 //que ya no deseemos
 a = document.createElement('a');
 //El link debe tener el mismo nombre de la div padre, para efectos 
 //de localizarla y eliminarla
 a.name = nDiv.id;
 //Este link no debe ir a ningun lado
 a.href = 'javascript:void(0)';
 //Establecemos que dispare esta funcion en click
 a.onclick = elimCamp;
 //Con esto ponemos el texto del link
 a.innerHTML = 'Eliminar';
 
 //Integrar los elementos que se han creado al documento,
 //primero usamos la función appendChild para adicionar 
 //el campo input type=file nuevo y luego los otros elementos
 //que realizarán la funcionalidad de este mismo campo una vez
 //que el input type=file sea ocultado para un mejor aspecto.
 nDiv.appendChild(nInput);
 nDiv.appendChild(nDivAdjunto);
 nDivAdjunto.appendChild(nSpan);
 nDivAdjunto.appendChild(nCampo);
 nDivAdjunto.appendChild(a);
 //Ahora si recuerdan, en el html hay una div cuyo id es 'adjuntos', 
 //bien con esta función obtenemos una referencia a ella para usar 
 //de nuevo appendChild y adicionar la div que hemos creado, la cual 
 //contiene el campo file con su link de eliminación:
 container = document.getElementById('conteGeneral');
 container.appendChild(nDiv);
}
//Con esta función eliminamos el campo cuyo link de eliminación sea presionado
elimCamp = function (evt){
 evt = evento(evt);
 nCampo = rObj(evt);
 console.log(nCampo.name);
 div = document.getElementById(nCampo.name);
 div.parentNode.removeChild(div);
}
addOneClick = function (evt){
 evt = evento(evt);
 nCampo = rObj(evt);
 div = document.getElementsByTagName("span")[this.id];
 file = "uploadBtn"+div.id;
 var fileUp = document.getElementById(file);
 console.log(fileUp);
 var adj = document.getElementById(fileUp.id);
 adj.click();
 adj.onchange = function(){
 document.getElementById('uploadFile'+div.id).value = this.value;
 }
}
//Con esta función recuperamos una instancia del objeto que disparó el evento
rObj = function (evt) { 
 return evt.srcElement ? evt.srcElement : evt.target;
}