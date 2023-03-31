function iniciar(){
    var classname, tag="";
    var btnfind = document.getElementById("btnSend");
    if(btnfind.addEventListener){
        btnfind.addEventListener("click", function(){
            //Es de suponer que el valor del campo de texto y del campo select del formulario
            //estará establecido cuando se haga clic sobre el botón Encontrar
            classname = document.frmclass.txtname.value;
            tag = document.frmclass.selelement[document.frmclass.selelement.selectedIndex].value;
            alert("Se han encontrado " + findClassInElements(classname, tag) + " elemento(s) " + tag.toString() + " con la clase " + classname);
        }, false);
    }
    else if(btnfind.attachEvent){
        btnfind.attachEvent("onclick", function(){
            //Es de suponer que el valor del campo de texto y del campo select del formulario
            //estará establecido cuando se haga clic sobre el botón Encontrar
            classname = document.frmclass.txtname.value;
            tag = document.frmclass.selelement[document.frmclass.selelement.selectedIndex].value;
            alert("Se han encontrado " + findClassInElements(classname, tag) + " elementos " + tag.toString() + " con la clase " + classname);
        });
    }
}

function findClassInElements(className, type){
    //Detectar el elemento sobre el que se realizará la búsqueda de la clase.
    //Pude ser un elemento en particular o todos los elementos
    var elems = document.getElementsByTagName(type || "*");
    //En este caso el patrón de la expresión regular incluirá una variable,
    //por lo tanto estará obligado a usar el contructor RegExp.
    var regex = new RegExp("(^|\\s)" + className + "(\\s|$)");
    var results = new Array();
    //El ciclo recorre toda la página comprobando en el elemento enviado a la función
    //si la clase está presente o no en dicho elemento. Si lo está se guarda dentro
    //de la matriz o arreglo results.
    for(var i=0, length=elems.length; i<length; i++){
        if(regex.test(elems[i].className)){
            results.push(elems[i]);
        }
    }
    //Se devuelve el total encontrado
    return results.length;
}

//Asociando función que manejará el evento load al cargar la página
if(window.addEventListener){
    window.addEventListener("load", iniciar, false);
}
else if(window.attachEvent){
    window.attachEvent("onload", iniciar);
}