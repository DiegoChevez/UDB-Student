package complementario.settings.registros;

import complementario.settings.MetodosCRUD;

public abstract class Datos extends MetodosCRUD {

	public String nombre;
	
	public Datos(String nombre) {

	this.nombre = nombre;
	
	}

}
