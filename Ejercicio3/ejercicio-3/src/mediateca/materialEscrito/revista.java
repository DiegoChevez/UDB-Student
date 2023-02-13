package mediateca.materialEscrito;

public class revista extends materialEscrito {
	String Periodicidad;
	String FechaPublicacion;
	public revista(String _CodigoID, String _Titulo, String _Unidades, String _Editorial, String _Periodicidad,
				   String _FechaPublicacion){
		super(_CodigoID, _Titulo, _Unidades, _Editorial);

		Periodicidad = _Periodicidad;
		FechaPublicacion = _FechaPublicacion;

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