package mediateca.material;

import org.jdom2.JDOMException;

import java.io.IOException;

public abstract class material {

	String CodigoID;
	String Titulo;
	public material(String _CodigoID, String _Titulo){
		CodigoID = _CodigoID;
		Titulo = _Titulo;
	}

	public abstract void agregarMaterial() throws IOException, JDOMException;

	public abstract void modificarMaterial() throws IOException, JDOMException;

	public  abstract  void listarMaterial() throws IOException, JDOMException;

	public abstract void borrarMaterial() throws IOException, JDOMException;

	public abstract void buscarMaterial() throws IOException, JDOMException;

}
