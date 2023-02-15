package mediateca.materialVisual;

import mediateca.Main;
import mediateca.dom.DOMHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.swing.*;

public class dvds extends materialVisual {


	String Director;

	public dvds(String _CodigoID, String _Titulo, String _Genero, String _Duracion, String _Director) {
		super(_CodigoID, _Titulo, _Genero, _Duracion);
		Director = _Director;

	}

	@Override
	public void agregarMaterial() {
		String id = JOptionPane.showInputDialog(null, "Introduce la fecha de registro", "ID",
				JOptionPane.QUESTION_MESSAGE);
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
			agregarMaterial();
		} else {
			String titulo = JOptionPane.showInputDialog(null, "Introduce el titulo", "Titulo",
					JOptionPane.QUESTION_MESSAGE);
			if (titulo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				agregarMaterial();
			} else {
				String genero = JOptionPane.showInputDialog(null, "Introduce el autor", "Autor",
						JOptionPane.QUESTION_MESSAGE);
				if (genero.isEmpty()) {
					JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
					agregarMaterial();
				} else {
					String duracion = JOptionPane.showInputDialog(null, "Introduce la duracion del DVD en minutos:",
							"Duracion del CD",
							JOptionPane.QUESTION_MESSAGE);
					if (duracion.isEmpty()) {
						JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
						agregarMaterial();
					} else {
						String director = JOptionPane.showInputDialog(null, "Introduce la editorial:", "Editorial",
								JOptionPane.QUESTION_MESSAGE);
						if (director.isEmpty()) {
							JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
							agregarMaterial();
						} else {
							try {
								Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/dvds.xml");
								Element dvds = d.getDocumentElement();
								Element dvd = d.createElement("cd");

								Element CodigoID = d.createElement("CodigoID");
								CodigoID.appendChild(d.createTextNode("CD" + id));
								dvd.appendChild(CodigoID);

								Element Titulo = d.createElement("Titulo");
								Titulo.appendChild(d.createTextNode(titulo));
								dvd.appendChild(Titulo);

								Element Director = d.createElement("Artista");
								Director.appendChild(d.createTextNode(director));
								dvd.appendChild(Director);

								Element Genero = d.createElement("Genero");
								Genero.appendChild(d.createTextNode(genero));
								dvd.appendChild(Genero);

								Element Duracion = d.createElement("Duracion");
								Duracion.appendChild(d.createTextNode(duracion));
								dvd.appendChild(Duracion);

								dvds.appendChild(dvd);

								DOMHelper.saveXMLContent(d, "ejercicio-2/src/mediateca/dvds.xml");

								String[] op = {"Agregar Otro", "Salir", "Regresar"};
								int x = JOptionPane.showOptionDialog(null, "Material Añadido",
										"Mediateca",
										JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);
								switch (x) {
									case 0 -> agregarMaterial();
									case 1 -> System.exit(0);
									case 2 -> Main.main(null);
								}
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
					}
				}
			}
		}
	}


	@Override
	public void modificarMaterial() {
		String id = JOptionPane.showInputDialog(null, "Introduce el ID del Regitro a Modificar", "Modificar Material",
				JOptionPane.QUESTION_MESSAGE);
		if(id.isEmpty()){
			JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
			modificarMaterial();
		}else{
			try {
				Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/dvds.xml");
				NodeList nl = d.getElementsByTagName("dvd");
				for (int i = 0; i < nl.getLength(); i++) {
					Element material = (Element) nl.item(i);
					if (material.getElementsByTagName("CodigoID")
								.item(0)
								.getTextContent()
								.equals(id)) {

						String N_titulo = JOptionPane.showInputDialog(null, "Introduce el nuevo titulo","Titulo",
								JOptionPane.QUESTION_MESSAGE);
						if(N_titulo.isEmpty()){
							JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
							modificarMaterial();
						}else{
							String N_genero = JOptionPane.showInputDialog(null, "Introduce el autor", "Autor",
									JOptionPane.QUESTION_MESSAGE);
							if (N_genero.isEmpty()){
								JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
								agregarMaterial();
							}else {
								String N_duracion = JOptionPane.showInputDialog(null, "Introduce la duracion del DVD " +
												"en minutos:",
										"Duracion del CD",
										JOptionPane.QUESTION_MESSAGE);
								if(N_duracion.isEmpty()){
									JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
									agregarMaterial();
								}else {
									String N_director = JOptionPane.showInputDialog(null, "Introduce la editorial:",
											"Editorial",
											JOptionPane.QUESTION_MESSAGE);
									if(N_director.isEmpty()){
										JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
										agregarMaterial();
									}else {
										material.getElementsByTagName("Titulo").item(0).setTextContent(N_titulo);
										material.getElementsByTagName("Genero").item(0).setTextContent(N_genero);
										material.getElementsByTagName("Duracion").item(0).setTextContent(N_duracion);
										material.getElementsByTagName("Director").item(0).setTextContent(N_director);

										DOMHelper.saveXMLContent(d, "ejercicio-2/src/mediateca/dvds.xml");
									}
								}
							}
						}
					}
				}
				String[] op = {"Modificar Otro", "Salir", "Regresar"};
				int x = JOptionPane.showOptionDialog(null, "Material Modificado",
						"Mediateca",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);
				switch (x) {
					case 0 -> modificarMaterial();
					case 1 -> System.exit(0);
					case 2 -> Main.main(null);
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void listarMaterial(){
		try {
			Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/dvds.xml");
			NodeList nl = d.getElementsByTagName("dvd");
			for (int i = 0; i < nl.getLength(); i++) {
				Element material = (Element) nl.item(i);
				System.out.println("------------------------------------------------------");
				System.out.println("Codigo DVD: " + material.getElementsByTagName("CodigoID").item(0).getTextContent());
				System.out.println("------------------------------------------------------");
				System.out.println("Titulo: " + material.getElementsByTagName("Titulo").item(0).getTextContent());
				System.out.println("Genero: " + material.getElementsByTagName("Genero").item(0).getTextContent());
				System.out.println("Duracion: " + material.getElementsByTagName("Duracion").item(0).getTextContent());
				System.out.println("Director: " + material.getElementsByTagName("Director").item(0).getTextContent());
				System.out.println("------------------------------------------------------\n");
			}
			String[] op = {"Salir", "Regresar"};
			int x = JOptionPane.showOptionDialog(null, "Material Impreso",
					"Mediateca",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);
			switch (x) {
				case 0 -> System.exit(0);
				case 1 -> Main.main(null);
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void borrarMaterial() {
		String id = JOptionPane.showInputDialog(null, "Introduce el ID del Regitro a Eliminar", "Eliminar Material",
				JOptionPane.QUESTION_MESSAGE);
		if(id.isEmpty()){
			JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
			borrarMaterial();
		}else{
			try {
				Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/dvds.xml");
				NodeList nl = d.getElementsByTagName("dvd");
				for (int i=0; i<nl.getLength();i++){
					Element material = (Element) nl.item(i);
					if(material.getElementsByTagName("CodigoID").item(0).getTextContent().equals(id)){
						material.getParentNode().removeChild(material);
					}
					DOMHelper.saveXMLContent(d,"ejercicio-2/src/mediateca/dvds.xml");
				}
				String[] op = {"Eliminar Otro", "Salir", "Regresar"};
				int x = JOptionPane.showOptionDialog(null, "Material Eliminado",
						"Mediateca",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);
				switch (x) {
					case 0 -> borrarMaterial();
					case 1 -> System.exit(0);
					case 2 -> Main.main(null);
				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void buscarMaterial() {
		//Pedimos el valor a buscar
		String id = JOptionPane.showInputDialog(null, "Introduce el ID del Regitro a Buscar", "Buscar Material",
				JOptionPane.QUESTION_MESSAGE);
		if(id.isEmpty()){
			JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
			buscarMaterial();
		}else {
			try {
				Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/dvds.xml");//Llamamos a nuestro documento
				// xml con él interactuaremos
				NodeList nl = d.getElementsByTagName("dvd");//Hacemos una lista de los nodos del documento / libros

				for (int i=0; i<nl.getLength();i++){ //Recorreremos la lista tantas veces como el número de libros

					Element material = (Element) nl.item(i); //Cada vez que se recorra material se le asignara un nodo

					if(material.getElementsByTagName("CodigoID").item(0).getTextContent().equals(id)){
						//Si el ID entrante es encontrado lo mostramos
						System.out.println("------------------------------------------------------");
						System.out.println("Codigo Libro: " + material.getElementsByTagName("CodigoID").item(0).getTextContent());
						System.out.println("------------------------------------------------------");
						System.out.println("Titulo: " + material.getElementsByTagName("Titulo").item(0).getTextContent());
						System.out.println("Genero: " + material.getElementsByTagName("Genero").item(0).getTextContent());
						System.out.println("Duracion: " + material.getElementsByTagName("Duracion").item(0).getTextContent());
						System.out.println("Director: " + material.getElementsByTagName("Director").item(0).getTextContent());
						System.out.println("------------------------------------------------------\n");
					}
				}
				String[] op = {"Buscas Otro", "Salir", "Regresar"};
				int x = JOptionPane.showOptionDialog(null, "Material Encontrado",
						"Mediateca",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);
				switch (x) {
					case 0 -> buscarMaterial();
					case 1 -> System.exit(0);
					case 2 -> Main.main(null);
				}
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

}