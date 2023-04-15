<?php
class Controller{
 function __construct(){//cada instacia de controller o invocacion a este instanciara una nueva vista
 
 $this->view = new View();
 }
 function loadModel($model){//se manda a llamar para cargar el modelo, notara que cada controller esta ligado a cada model
 $url = 'models/'.$model.'Model.php';// Para este caso el MainController y MainModel estan estechamente ligados
 if(file_exists($url)){
 require $url;
 $modelName = $model. 'Model';
 $this->model = new $modelName;
 }
 }
}
?>