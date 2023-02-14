package mediateca.materialEscrito;
import mediateca.Main;
import mediateca.dom.DOMHelper;


import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


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
		String id = JOptionPane.showInputDialog(null, "Introduce la fecha de registro","ID",
				JOptionPane.QUESTION_MESSAGE);
		String titulo = JOptionPane.showInputDialog(null, "Introduce el titulo","Titulo",
				JOptionPane.QUESTION_MESSAGE);
		String autor = JOptionPane.showInputDialog(null, "Introduce el autor","Autor",
				JOptionPane.QUESTION_MESSAGE);
		String xpage = JOptionPane.showInputDialog(null, "Introduce el Numero de Paginas","Numero de Paginas",
				JOptionPane.QUESTION_MESSAGE);
		String editorial = JOptionPane.showInputDialog(null, "Introduce la editorial","Editorial",
				JOptionPane.QUESTION_MESSAGE);
		String ffPublicacion = JOptionPane.showInputDialog(null, "Introduce la fecha de publicacion","Fecha de " +
						"Publicacion",
				JOptionPane.QUESTION_MESSAGE);
		String unidades = JOptionPane.showInputDialog(null, "Introduce las unidades a registrar","Unidades Disponibles",
				JOptionPane.QUESTION_MESSAGE);

		try {
			Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/libros.xml");
			Element libros = d.getDocumentElement();
			Element libro = d.createElement("libro");

			Element CodigoID  = d.createElement("CodigoID");
			CodigoID.appendChild(d.createTextNode("LIB"+id));
			libro.appendChild(CodigoID);

			Element Titulo = d.createElement("Titulo");
			Titulo.appendChild(d.createTextNode(titulo));
			libro.appendChild(Titulo);

			Element Autor = d.createElement("Autor");
			Autor.appendChild(d.createTextNode(autor));
			libro.appendChild(Autor);

			Element NumPage = d.createElement("NumPage");
			NumPage.appendChild(d.createTextNode(xpage));
			libro.appendChild(NumPage);

			Element Editorial = d.createElement("Editorial");
			Editorial.appendChild(d.createTextNode(editorial));
			libro.appendChild(Editorial);

			Element FechaPublicacion = d.createElement("FechaPublicacion");
			FechaPublicacion.appendChild(d.createTextNode(ffPublicacion));
			libro.appendChild(FechaPublicacion);

			Element UnidadesDisp = d.createElement("UnidadesDisp");
			UnidadesDisp.appendChild(d.createTextNode(unidades));
			libro.appendChild(UnidadesDisp);

			libros.appendChild(libro);

			DOMHelper.saveXMLContent(d, "ejercicio-2/src/mediateca/libros.xml");

		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void modificarMaterial() {
		String id = JOptionPane.showInputDialog(null, "Introduce el ID del Regitro a Modificar", "Modificar Material",
				JOptionPane.QUESTION_MESSAGE);
		try {
			Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/libros.xml");
			NodeList nl = d.getElementsByTagName("libro");
			for (int i = 0; i < nl.getLength(); i++) {
				Element material = (Element) nl.item(i);
				if (material.getElementsByTagName("CodigoID")
							.item(0)
							.getTextContent()
							.equals(id)) {

					String N_titulo = JOptionPane.showInputDialog(null, "Introduce el nuevo titulo","Titulo",
							JOptionPane.QUESTION_MESSAGE);
					String N_autor = JOptionPane.showInputDialog(null, "Introduce el nuevo autor","Autor",
							JOptionPane.QUESTION_MESSAGE);
					String N_xpage = JOptionPane.showInputDialog(null, "Introduce el nuevo Numero de Paginas","Numero" +
									" de Paginas",
							JOptionPane.QUESTION_MESSAGE);
					String N_editorial = JOptionPane.showInputDialog(null, "Introduce la nueva editorial","Editorial",
							JOptionPane.QUESTION_MESSAGE);
					String N_ffPublicacion = JOptionPane.showInputDialog(null, "Introduce la nueva fecha de " +
									"publicacion","Fecha de Publicacion",
							JOptionPane.QUESTION_MESSAGE);
					String N_unidades = JOptionPane.showInputDialog(null, "Introduce las  unidades a registrar",
							"Unidades Disponibles",
							JOptionPane.QUESTION_MESSAGE);

					material.getElementsByTagName("Titulo").item(0).setTextContent(N_titulo);
					material.getElementsByTagName("Autor").item(0).setTextContent(N_autor);
					material.getElementsByTagName("NumPage").item(0).setTextContent(N_xpage);
					material.getElementsByTagName("Editorial").item(0).setTextContent(N_editorial);
					material.getElementsByTagName("FechaPublicacion").item(0).setTextContent(N_ffPublicacion);
					material.getElementsByTagName("UnidadesDisp").item(0).setTextContent(N_unidades);

					DOMHelper.saveXMLContent(d, "ejercicio-2/src/mediateca/libros.xml");
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void listarMaterial(){
		Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/libros.xml");
		NodeList nl = d.getElementsByTagName("libro");
		for (int i = 0; i < nl.getLength(); i++) {
			Element material = (Element) nl.item(i);
			System.out.println("------------------------------------------------------");
			System.out.println("Codigo Libro: " + material.getElementsByTagName("CodigoID").item(0).getTextContent());
			System.out.println("------------------------------------------------------");
			System.out.println("Titulo: " + material.getElementsByTagName("Titulo").item(0).getTextContent());
			System.out.println("Autor: " + material.getElementsByTagName("Autor").item(0).getTextContent());
			System.out.println("Numero de Paginas: " + material.getElementsByTagName("NumPage").item(0).getTextContent());
			System.out.println("Editorial: " + material.getElementsByTagName("Editorial").item(0).getTextContent());
			System.out.println("Unidades Disponibles: " + material.getElementsByTagName("UnidadesDisp").item(0).getTextContent());
			System.out.println("------------------------------------------------------\n");
		}
	}

	@Override
	public void borrarMaterial() {
		String id = JOptionPane.showInputDialog(null, "Introduce el ID del Regitro a Eliminar", "Eliminar Material",
				JOptionPane.QUESTION_MESSAGE);
		try {
			Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/libros.xml");
			NodeList nl = d.getElementsByTagName("libro");
			for (int i=0; i<nl.getLength();i++){
				Element material = (Element) nl.item(i);
				if(material.getElementsByTagName("CodigoID").item(0).getTextContent().equals(id)){
					material.getParentNode().removeChild(material);
				}
				DOMHelper.saveXMLContent(d,"ejercicio-2/src/mediateca/libros.xml");
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void buscarMaterial()  {
		//Variables comunes
		int op;

		//Inicializamos un Scanner para poder recibir datos desde la consola
		Scanner reader = new Scanner(System.in);

		//Pedimos el valor a buscar
		String id = JOptionPane.showInputDialog(null, "Introduce el ID del Regitro a Buscar", "Buscar Material",
				JOptionPane.QUESTION_MESSAGE);
		if(id.isEmpty()){
			System.out.println("----------------------------------------");
			System.out.println("\t\t**CAMPOS VACIOS**");
			System.out.println("----------------------------------------");
			System.out.println("Vuelva a intentarlo");
			buscarMaterial();
		}else {
			//Realizamos un try/cash para poder terminar o arrojar errores si estos suceden antes de interactuar
			try {

				Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/libros.xml");//Llamamos a nuestro documento xml con el interactuaremos
				NodeList nl = d.getElementsByTagName("libro");//Hacemos una lista de los nodos del documento / libros

				for (int i=0; i<nl.getLength();i++){ //Recorreremos la lista tantas veces como el número de libros

					Element material = (Element) nl.item(i); //Cada vez que se recorra material se le asignara un nodo

					if(material.getElementsByTagName("CodigoID").item(0).getTextContent().equals(id)){
						//Si el ID entrante es encontrado lo mostramos

						System.out.println("------------------------------------------------------");
						System.out.println("Codigo Libro: " + material.getElementsByTagName("CodigoID").item(0).getTextContent());
						System.out.println("------------------------------------------------------");
						System.out.println("Titulo: " + material.getElementsByTagName("Titulo").item(0).getTextContent());
						System.out.println("Autor: " + material.getElementsByTagName("Autor").item(0).getTextContent());
						System.out.println("Numero de Paginas: " + material.getElementsByTagName("NumPage").item(0).getTextContent());
						System.out.println("Editorial: " + material.getElementsByTagName("Editorial").item(0).getTextContent());
						System.out.println("Unidades Disponibles: " + material.getElementsByTagName("UnidadesDisp").item(0).getTextContent());
						System.out.println("------------------------------------------------------\n");

					}else {
						System.out.println("Registro no encontrado");
						i= nl.getLength();
					}
				}
				System.out.println("------------------------------------------------------\n");
				System.out.println("[1]Buscar otro\n[2]Regresar\n[0]Salir");
				System.out.println("------------------------------------------------------");
				System.out.print("Opcion: ");
				op = reader.nextInt();
				switch (op){
					case 1:
						buscarMaterial();
						break;
					case 2:
						Main.main(null);
						break;
					case 0:
						System.exit(0);
						break;
					default:
						System.out.println("----------------------------------------");
						System.out.println("\t\t**DATOS INVALIDOS**");
						System.out.println("----------------------------------------");
						System.out.println("Presione Enter...");
						System.exit(0);
				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}



	}



}
