package mediateca;
import javax.swing.JOptionPane;
import java.util.Objects;

public class Main {

	public static void main(String[] args) {

		Object[] op1 = {"Material Media",
				"Material Escrito",
				"Salir"};
		String menu1 = (String) JOptionPane.showInputDialog(null, "Bienvenido\n Escoja un tipo de material",
				"Mediateca", JOptionPane.INFORMATION_MESSAGE, null, op1, op1[0]);
		System.out.println(menu1);

		switch (menu1) {
			case "Material Media" -> {
				Object[] op2 = {"DVDs",
						"CDs",
						"Listar Materiales",
						"Regresar",
						"Salir"};
				String menu2 = (String) JOptionPane.showInputDialog(null, "Escoja un tipo multimedia",
						"Mediateca", JOptionPane.INFORMATION_MESSAGE, null, op2, op2[0]);
				System.out.println(menu2);
				if (Objects.equals(menu2, "Listar Materiales")) {
					System.out.println("Listas Materiales DVDs");
				} else if (Objects.equals(menu2, "Regresar")) {
					Main.main(null);
				} else if (Objects.equals(menu2, "Salir")) {
					System.exit(0);
				} else if(Objects.equals(menu2, "DVDs")){
					materialDVDs(menu2);
				}else {
					materialCDs(menu2);
				}
			}
			case "Material Escrito" -> {
				Object[] op3 = {"Libros",
						"Revistas",
						"Listar Materiales",
						"Regresar",
						"Salir"};
				String menu3 = (String) JOptionPane.showInputDialog(null, "Escoja un tipo multimedia",
						"Mediateca", JOptionPane.INFORMATION_MESSAGE, null, op3, op3[0]);
				System.out.println(menu3);
				if (Objects.equals(menu3, "Listar Materiales")) {
					System.out.println("Listas Materiales CDs");
				} else if (Objects.equals(menu3, "Regresar")) {
					Main.main(null);
				} else if (Objects.equals(menu3, "Salir")) {
					System.exit(0);
				} else if(Objects.equals(menu3, "Revistas")) {
					materialRevistas(menu3);
				}else {
					materialLibros(menu3);
				}
			}
			case "Salir" -> System.exit(0);
		}

	}

	public static void materialDVDs(String Menu){

		switch (Menu) {
			case "Agregar material" -> System.out.println("Agregar Materia a DVD");
			case "Modificar material" -> System.out.println("Modificar DVD");
			case "Listar Materiales" -> System.out.println("Listas Materiales DVDs");
			case "Regresar" -> Main.main(null);
			case "Salir" -> System.exit(0);
		}
	}

	public static void materialCDs(String Menu1){

		switch (Menu1) {
			case "Agregar material" -> System.out.println("Agregar CD");
			case "Modificar material" -> System.out.println("Modificar CD");
			case "Listar Materiales" -> System.out.println("Listas Materiales CD");
			case "Regresar" -> Main.main(null);
			case "Salir" -> System.exit(0);
		}
	}

	public static void materialLibros(String Menu1){

		switch (Menu1) {
			case "Agregar material" -> System.out.println("Agregar Libros");
			case "Modificar material" -> System.out.println("Modificar Libros");
			case "Listar Materiales" -> System.out.println("Listas Materiales Libros");
			case "Regresar" -> Main.main(null);
			case "Salir" -> System.exit(0);
		}
	}

	public static void materialRevistas(String Menu1){

		switch (Menu1) {
			case "Agregar material" -> System.out.println("Agregar Revistas");
			case "Modificar material" -> System.out.println("Modificar Revistas");
			case "Listar Materiales" -> System.out.println("Listas Materiales Revistas");
			case "Regresar" -> Main.main(null);
			case "Salir" -> System.exit(0);
		}
	}
}
