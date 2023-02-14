package mediateca.materialEscrito;

import mediateca.Main;
import mediateca.dom.DOMHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;
import java.util.Scanner;

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
	public void buscarMaterial()   {
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

				Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/revistas.xml");//Llamamos a nuestro
				// documento xml con él interactuaremos
				NodeList nl = d.getElementsByTagName("revista");//Hacemos una lista de los nodos del documento / libros

				for (int i=0; i<nl.getLength();i++){ //Recorreremos la lista tantas veces como el número de libros

					Element material = (Element) nl.item(i); //Cada vez que se recorra material se le asignara un nodo

					if(material.getElementsByTagName("CodigoID").item(0).getTextContent().equals(id)){
						//Si el ID entrante es encontrado lo mostramos

						System.out.println("------------------------------------------------------");
						System.out.println("Codigo Libro: " + material.getElementsByTagName("CodigoID").item(0).getTextContent());
						System.out.println("------------------------------------------------------");
						System.out.println("Titulo: " + material.getElementsByTagName("Titulo").item(0).getTextContent());
						System.out.println("Editorial: " + material.getElementsByTagName("Editorial").item(0).getTextContent());
						System.out.println("Periodicidad: " + material.getElementsByTagName("Periodicidad").item(0).getTextContent());
						System.out.println("Fecha de Publicacion: " + material.getElementsByTagName("FechaPublicacion").item(0).getTextContent());
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
				switch (op) {
					case 1 -> buscarMaterial();
					case 2 -> Main.main(null);
					case 0 -> System.exit(0);
					default -> {
						System.out.println("----------------------------------------");
						System.out.println("\t\t**DATOS INVALIDOS**");
						System.out.println("----------------------------------------");
						System.out.println("Presione Enter...");
						System.exit(0);
					}
				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}



	}

}
