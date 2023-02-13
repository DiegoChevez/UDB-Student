package mediateca.material;

public abstract class material {

	String CodigoID;
	String Titulo;
	public material(String _CodigoID, String _Titulo){
		CodigoID = _CodigoID;
		Titulo = _Titulo;
	}

	public abstract void agregarMaterial();

	public abstract void modificarMaterial();

	public abstract void listarMaterial();

	public abstract void borrarMaterial();

	public abstract void buscarMaterial();

}
