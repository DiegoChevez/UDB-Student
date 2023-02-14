package mediateca.materialVisual;

public class dvds extends materialVisual {


	String Director;
	public dvds(String _CodigoID, String _Titulo, String _Genero, String _Duracion, String _Director){
		super(_CodigoID, _Titulo, _Genero, _Duracion);
		Director = _Director;

	}
	@Override
	public void agregarMaterial() {

	}

	@Override
	public void modificarMaterial() {

	}

	@Override
	public void listarMaterial() {

	}

	@Override
	public void borrarMaterial() {

	}

	@Override
	public void buscarMaterial() {

	}
}