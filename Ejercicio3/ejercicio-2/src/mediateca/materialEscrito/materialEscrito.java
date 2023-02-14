package mediateca.materialEscrito;

import mediateca.material.material;

public abstract class materialEscrito extends material {

	  String Unidades;
	 String Editorial;
	public materialEscrito(String _CodigoID, String _Titulo, String _Unidades, String _Editorial) {
		super(_CodigoID, _Titulo);
		Unidades = _Unidades;
		Editorial = _Editorial;
	}

}

