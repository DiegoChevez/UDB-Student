package mediateca;

import mediateca.materialEscrito.libros;
import mediateca.materialEscrito.revista;
import mediateca.materialVisual.cds;
import mediateca.materialVisual.dvds;

import javax.swing.*;
import java.util.Objects;


public class Main {

	public static void main(String[] args ) {


		Object[] op1 = {"Material Media",
						"Material Escrito",
						"Salir"};

		String menu1 = (String) JOptionPane.showInputDialog(null, "\t! BIENVENIDO ¡\n\nSeleccione un Area..",
				"Mediateca", JOptionPane.INFORMATION_MESSAGE, null, op1, op1[0]);

		switch (menu1) {
			case "Material Media" -> {
				Object[] op2 = {"DVDs",
								"CDs",
								"Regresar",
								"Salir"};

				String menu2 = (String) JOptionPane.showInputDialog(null, "Escoja un tipo multimedia",
						"Mediateca", JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);

				if (Objects.equals(menu2, "DVDs")){
					materialDVDs();
				} else if (Objects.equals(menu2, "CDs")) {
					materialCDs();
				} else if (Objects.equals(menu2, "Regresar")) {
					Main.main(null);
				}else{
					System.exit(0);
				}
			}
			case "Material Escrito" -> {

				Object[] op3 = {"Libros",
								"Revistas",
								"Regresar",
								"Salir"};

				String menu3 = (String) JOptionPane.showInputDialog(null, "Escoja un tipo multimedia",
						"Mediateca", JOptionPane.INFORMATION_MESSAGE, null, op3, op3[0]);

				if (Objects.equals(menu3, "Libros")){
					materialLibros();
				} else if (Objects.equals(menu3, "Revistas")) {
					materialRevistas();
				} else if (Objects.equals(menu3, "Regresar")) {
					Main.main(null);
				}else{
					System.exit(0);
				}
			}
			case "Salir" -> System.exit(0);
		}

	}

	public static void materialDVDs() {

		Object[] opDVD = {"Agregar material",
				"Modificar material",
				"Listar Materiales",
				"Buscar Material",
				"Borrar Materiales",
				"Regresar",
				"Salir"};

		String menu1 = (String) JOptionPane.showInputDialog(null, "Escoja un tipo multimedia",
				"Mediateca", JOptionPane.INFORMATION_MESSAGE, null, opDVD, opDVD[0]);

		switch (menu1) {
			case "Agregar material" -> {

				dvds dvd = new dvds("","","","","");
				dvd.agregarMaterial();

			}
			case "Modificar material" -> {

				dvds dvd = new dvds("","","","","");
				dvd.modificarMaterial();

			}
			case "Listar Materiales" -> {

				dvds dvd = new dvds("","","","","");
				dvd.listarMaterial();

			}
			case "Borrar Materiales" -> {

				dvds dvd = new dvds("","","","","");
				dvd.borrarMaterial();

			}
			case "Buscar Material" -> {

				dvds dvd = new dvds("","","","","");
				dvd.buscarMaterial();

			}
			case "Regresar" -> Main.main(null);
			case "Salir" -> System.exit(0);
		}
	}

	public static void materialCDs() {

		Object[] opCD = {"Agregar material",
						"Modificar material",
						"Listar Materiales",
						"Buscar Material",
						"Borrar Materiales",
						"Regresar",
						"Salir"};

		String menu1 = (String) JOptionPane.showInputDialog(null, "Escoja un tipo multimedia",
				"Mediateca", JOptionPane.INFORMATION_MESSAGE, null, opCD, opCD[0]);

		switch (menu1) {
			case "Agregar material" -> {

				cds cd = new cds("","","","","","", "");
				cd.agregarMaterial();

			}
			case "Modificar material" -> {

				cds cd = new cds("","","","","","", "");
				cd.modificarMaterial();

			}
			case "Listar Materiales" -> {

				cds cd = new cds("","","","","","", "");
				cd.listarMaterial();

			}
			case "Borrar Materiales" -> {

				cds cd = new cds("","","","","","", "");
				cd.borrarMaterial();

			}
			case "Buscar Material" -> {

				cds cd = new cds("","","","","","", "");
				cd.buscarMaterial();

			}
			case "Regresar" -> Main.main(null);
			case "Salir" -> System.exit(0);
		}
	}

	public static void materialLibros() {
		Object[] opLB = {"Agregar material",
						"Modificar material",
						"Listar Materiales",
						"Buscar Material",
						"Borrar Materiales",
						"Regresar",
						"Salir"};

		String menu1 = (String) JOptionPane.showInputDialog(null, "Escoja un tipo multimedia",
				"Mediateca", JOptionPane.INFORMATION_MESSAGE, null, opLB, opLB[0]);

		switch (menu1) {
			case "Agregar material" -> {

				libros libros = new libros("","","","","","", "","");
				libros.agregarMaterial();

			}
			case "Modificar material" -> {

				libros libros = new libros("", "", "", "", "", "", "", "");
				libros.modificarMaterial();

			}
			case "Listar Materiales" -> {

				libros libros = new libros("", "", "", "", "", "", "", "");
				libros.listarMaterial();

			}
			case "Borrar Materiales" -> {

				libros libros = new libros("", "", "", "", "", "", "", "");
				libros.borrarMaterial();

			}
			case "Buscar Material" -> {

				libros libros = new libros("", "", "", "", "", "", "", "");
				libros.buscarMaterial();

			}
			case "Regresar" -> Main.main(null);
			case "Salir" -> System.exit(0);
		}
	}

	public static void materialRevistas() {

		Object[] opREV = {"Agregar material",
				"Modificar material",
				"Listar Materiales",
				"Buscar Material",
				"Borrar Materiales",
				"Regresar",
				"Salir"};

		String menu1 = (String) JOptionPane.showInputDialog(null, "Escoja un tipo multimedia",
				"Mediateca", JOptionPane.INFORMATION_MESSAGE, null, opREV, opREV[0]);

		switch (menu1) {
			case "Agregar material" -> {

				revista revistas = new revista("","","","","","");
				revistas.agregarMaterial();

			}
			case "Modificar material" -> {

				revista revistas = new revista("","","","","","");
				revistas.modificarMaterial();

			}
			case "Listar Materiales" -> {

				revista revistas = new revista("","","","","","");
				revistas.listarMaterial();

			}
			case "Borrar Materiales" -> {

				revista revistas = new revista("","","","","","");
				revistas.borrarMaterial();

			}
			case "Buscar Material" -> {

				revista revistas = new revista("","","","","","");
				revistas.buscarMaterial();

			}
			case "Regresar" -> Main.main(null);
			case "Salir" -> System.exit(0);
		}


	}
}
