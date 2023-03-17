package Ejercicio1;
import java.util.*;
public class Estudiante {

	Scanner reader = new Scanner(System.in);

	//Variables para la Info de los Estudiantes
	public static String nombre, carnet, carrera, direccion, telefono, mail;
	public static int edad;

	//Variables para la Info de las Materias
	public static String Mm1,Mm2,Mm3,Mm4,Mm5;

	public  Estudiante (String Vnombre,String Vcarnet, String Vcarrera, String Vdireccion, String Vtelefono,
						String Vmail, int Vedad)
	{
		Estudiante.nombre = Vnombre;
		Estudiante.carnet = Vcarnet;
		Estudiante.carrera = Vcarrera;
		Estudiante.direccion = Vdireccion;
		Estudiante.telefono = Vtelefono;
		Estudiante.mail = Vmail;
		Estudiante.edad = Vedad;
	}

	public void materias(){
		System.out.println("\" Incripcion de Materias \"");
		System.out.println("Por favor ingrese la siguiente información");
		System.out.print("Materia 1: ");
		Mm1 = reader.nextLine();
		System.out.print("Materia 2: ");
		Mm2 = reader.nextLine();
		System.out.print("Materia 3: ");
		Mm3 = reader.nextLine();
		System.out.print("Materia 4: ");
		Mm4 = reader.nextLine();
		System.out.print("Materia 5: ");
		Mm5 = reader.nextLine();
	}


	public void registrar(){
		System.out.println("\" Informacion Estudiantil \"");
		System.out.println("Por favor ingrese la siguiente información");
		System.out.print("Nombre: ");
		nombre = reader.nextLine();
		System.out.print("Carnet: ");
		carnet = reader.nextLine();
		System.out.print("Carrera: ");
		carrera = reader.nextLine();
		System.out.print("direccion: ");
		direccion = reader.nextLine();
		System.out.print("telefono: ");
		telefono = reader.nextLine();
		System.out.print("mail: ");
		mail = reader.nextLine();
		System.out.print("edad: ");
		edad = reader.nextInt();
	}


	public void mostrar(){
		System.out.println("\" Informacion Estudiantil \"");
		System.out.println("Nombre: " + Estudiante.nombre );
		System.out.println("Carnet: " + Estudiante.carnet );
		System.out.println("Carrera: " + Estudiante.carrera );
		System.out.println("Direccion: " + Estudiante.direccion );
		System.out.println("Telefono: " + Estudiante.telefono );
		System.out.println("Email: " + Estudiante.mail );
		System.out.println("Edad: " + Estudiante.edad );
		System.out.println("------------------------------------");
		System.out.println("\" Informacion de Incripcion \"");
		System.out.println("Materia 1: " + Estudiante.Mm1 );
		System.out.println("Materia 2: " + Estudiante.Mm2 );
		System.out.println("Materia 3: " + Estudiante.Mm3 );
		System.out.println("Materia 4: " + Estudiante.Mm4 );
		System.out.println("Materia 5: " + Estudiante.Mm5 );
	}


}
