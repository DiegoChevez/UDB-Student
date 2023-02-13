package mediateca.materialEscrito;

public class libros extends materialEscrito {
	String ISBN;
	String Autor;
	String NumPage;
	String AnnoPublicacion;
	public libros(String _CodigoID, String _Titulo, String _Unidades, String _Editorial, String _ISBN,
				  String _AnnoPublicacion, String _Autor, String _NumPage){
		super(_CodigoID, _Titulo, _Unidades, _Editorial);
		ISBN = _ISBN;
		Autor = _Autor;
		NumPage = _NumPage;
		AnnoPublicacion = _AnnoPublicacion;

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
