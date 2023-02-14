package mediateca.materialVisual;

public class cds extends materialVisual {
	String Artista;
	String NumCanciones;
	String UnidadesDisp;
	public cds(String _CodigoID, String _Titulo, String _Genero, String _Duracion, String _Artista,
						  String _UnidadesDisp, String _NumCanciones){
		super(_CodigoID, _Titulo, _Genero, _Duracion);
		Artista = _Artista;
		NumCanciones = _NumCanciones;
		UnidadesDisp =_UnidadesDisp;

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