package mediateca.materialEscrito;
import mediateca.Main;
import mediateca.dom.DOMHelper;


import org.w3c.dom.*;
import javax.swing.*;


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
		if(id.isEmpty()){
			JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
			agregarMaterial();
		} else{
			String titulo = JOptionPane.showInputDialog(null, "Introduce el titulo","Titulo",
					JOptionPane.QUESTION_MESSAGE);
			if (titulo.isEmpty()){
				JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
				agregarMaterial();
			}else{
				String autor = JOptionPane.showInputDialog(null, "Introduce el autor","Autor",
						JOptionPane.QUESTION_MESSAGE);
				if (autor.isEmpty()){
					JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
					agregarMaterial();
				}else {
					String xpage = JOptionPane.showInputDialog(null, "Introduce el Numero de Paginas","Numero de Paginas",
							JOptionPane.QUESTION_MESSAGE);
					if(xpage.isEmpty()){
						JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
						agregarMaterial();
					}else {
						String editorial = JOptionPane.showInputDialog(null, "Introduce la editorial","Editorial",
								JOptionPane.QUESTION_MESSAGE);
						if(editorial.isEmpty()){
							JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
							agregarMaterial();
						}else{
							String ffPublicacion = JOptionPane.showInputDialog(null, "Introduce la fecha de publicacion","Fecha de " +
											"Publicacion",
									JOptionPane.QUESTION_MESSAGE);
							if(ffPublicacion.isEmpty()){
								JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
								agregarMaterial();
							}else {
								String unidades = JOptionPane.showInputDialog(null, "Introduce las unidades a registrar","Unidades Disponibles",
										JOptionPane.QUESTION_MESSAGE);
								if(unidades.isEmpty()){
									JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
									agregarMaterial();
								}else{
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

										String[] op = {"Agregar Otro", "Salir", "Regresar"};
										int x = JOptionPane.showOptionDialog(null, "Material Añadido",
												"Mediateca",
												JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, op, op[0]);
										switch (x) {
											case 0 -> agregarMaterial();
											case 1 -> System.exit(0);
											case 2 -> Main.main(null);
										}
									}catch (Exception e){
										System.out.println(e.getMessage());
									}
								}
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
						if(N_titulo.isEmpty()){
							JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
							modificarMaterial();
						}else {
							String N_autor = JOptionPane.showInputDialog(null, "Introduce el nuevo autor","Autor",
									JOptionPane.QUESTION_MESSAGE);
							if(N_autor.isEmpty()){
								JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
								modificarMaterial();
							}else{
								String N_xpage = JOptionPane.showInputDialog(null, "Introduce el nuevo Numero de Paginas","Numero" +
												" de Paginas",
										JOptionPane.QUESTION_MESSAGE);
								if(N_xpage.isEmpty()){
									JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
									modificarMaterial();
								}else {
									String N_editorial = JOptionPane.showInputDialog(null, "Introduce la nueva editorial","Editorial",
											JOptionPane.QUESTION_MESSAGE);
									if(N_editorial.isEmpty()){
										JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
										modificarMaterial();
									}else {
										String N_ffPublicacion = JOptionPane.showInputDialog(null, "Introduce la nueva fecha de " +
														"publicacion","Fecha de Publicacion",
												JOptionPane.QUESTION_MESSAGE);
										if(N_ffPublicacion.isEmpty()){
											JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
											modificarMaterial();
										}else {
											String N_unidades = JOptionPane.showInputDialog(null, "Introduce las  unidades a registrar",
													"Unidades Disponibles",
													JOptionPane.QUESTION_MESSAGE);
											if(N_unidades.isEmpty()){
												JOptionPane.showMessageDialog(null,"NO PUEDEN HABER CAMPOS VACIOS","ERROR",JOptionPane.ERROR_MESSAGE);
												modificarMaterial();
											}else {
												material.getElementsByTagName("Titulo").item(0).setTextContent(N_titulo);
												material.getElementsByTagName("Autor").item(0).setTextContent(N_autor);
												material.getElementsByTagName("NumPage").item(0).setTextContent(N_xpage);
												material.getElementsByTagName("Editorial").item(0).setTextContent(N_editorial);
												material.getElementsByTagName("FechaPublicacion").item(0).setTextContent(N_ffPublicacion);
												material.getElementsByTagName("UnidadesDisp").item(0).setTextContent(N_unidades);

												DOMHelper.saveXMLContent(d, "ejercicio-2/src/mediateca/libros.xml");
											}
										}
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
				Document d = DOMHelper.getDocument("ejercicio-2/src/mediateca/libros.xml");
				NodeList nl = d.getElementsByTagName("libro");
				for (int i=0; i<nl.getLength();i++){
					Element material = (Element) nl.item(i);
					if(material.getElementsByTagName("CodigoID").item(0).getTextContent().equals(id)){
						material.getParentNode().removeChild(material);
					}
					DOMHelper.saveXMLContent(d,"ejercicio-2/src/mediateca/libros.xml");
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
	public void buscarMaterial()  {
		//Pedimos el valor a buscar
		String id = JOptionPane.showInputDialog(null, "Introduce el ID del Regitro a Buscar", "Buscar Material",
				JOptionPane.QUESTION_MESSAGE);
		if(id.isEmpty()){
			JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
			buscarMaterial();
		}else {
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
