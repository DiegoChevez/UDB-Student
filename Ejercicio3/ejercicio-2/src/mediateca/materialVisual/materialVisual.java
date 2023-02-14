package mediateca.materialVisual;

import mediateca.material.material;

public abstract class materialVisual extends material {

	String Genero;
	String Duracion;

	public materialVisual(String _CodigoID, String _Titulo, String _Genero, String _Duracion){
		super(_CodigoID, _Titulo);
		Duracion = _Duracion;
		Genero = _Genero;
	}


}

