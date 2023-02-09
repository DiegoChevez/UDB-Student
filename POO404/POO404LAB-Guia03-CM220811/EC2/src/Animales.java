import java.util.Scanner;

public class Animales {
	Scanner reader = new Scanner(System.in);
	public static  String nombre,comida;
	public static int edad;

	public Animales( String nombreAnimal,int edadAnimal, String comidaAnimal){
		Animales.nombre = nombreAnimal;
		Animales.edad = edadAnimal;
		Animales.comida = comidaAnimal;
	}

	public static class dog extends Animales{
		public String PelajeColor;
		public dog(String nombreAnimal,int edadAnimal, String comidaAnimal, String PelajeColor){
			super(nombreAnimal, edadAnimal, comidaAnimal);
			this.PelajeColor=PelajeColor;
		}

		public void mostrarDog(){
			System.out.println("\" Informacion Perro \"");
			System.out.println("Nombre: " + nombre );
			System.out.println("Edad: " + edad );
			System.out.println("Comida: " + comida );
			System.out.println("Color del Pelaje: " + PelajeColor );
		}

		public void registerDog(){
			System.out.println("\" Registrar Animales / Perro \"");
			System.out.println("Por favor ingrese la siguiente información de su perro");
			System.out.print("Nombre: ");
			nombre = reader.nextLine();
			System.out.print("Comida: ");
			comida = reader.nextLine();
			System.out.print("Edad: ");
			edad = reader.nextInt();
			System.out.print("Color de Pelaje ");
			PelajeColor = reader.nextLine();
			reader.nextLine();
		}
	}

	public static class cat extends Animales{
		public String OjosColor;
		public cat(String nombreAnimal,int edadAnimal, String comidaAnimal, String OjosColor){
			super(nombreAnimal, edadAnimal, comidaAnimal);
			this.OjosColor=OjosColor;
		}

		public void registerCat(){
			System.out.println("\" Registrar Animales / Gato \"");
			System.out.println("Por favor ingrese la siguiente información de su gato");
			System.out.print("Nombre: ");
			nombre = reader.nextLine();
			System.out.print("Comida: ");
			comida = reader.nextLine();
			System.out.print("Edad: ");
			edad = reader.nextInt();
			System.out.print("Color de Ojos ");
			OjosColor = reader.nextLine();
			reader.nextLine();
		}

		public void mostrarCat(){
			System.out.println("\" Informacion Gato \"");
			System.out.println("Nombre: " + nombre );
			System.out.println("Edad: " + edad );
			System.out.println("Comida: " + comida );
			System.out.println("Color de Ojos: " + OjosColor );
		}
	}

	public static class hamster extends Animales{
		public String PulgasCantidad;
		public hamster(String nombreAnimal,int edadAnimal, String comidaAnimal, String PulgasCantidad){
			super(nombreAnimal, edadAnimal, comidaAnimal);
			this.PulgasCantidad=PulgasCantidad;
		}

		public void registerHamster(){
			System.out.println("\" Registrar Animales / Hasmter \"");
			System.out.println("Por favor ingrese la siguiente información");
			System.out.print("Nombre: ");
			nombre = reader.nextLine();
			System.out.print("Comida: ");
			comida = reader.nextLine();
			System.out.print("Edad: ");
			edad = reader.nextInt();
			System.out.print("Cantidad de Pulgas ");
			PulgasCantidad = reader.nextLine();
			reader.nextLine();
		}

		public void mostrarHamster(){
			System.out.println("\" Informacion Hamster \"");
			System.out.println("Nombre: " + nombre );
			System.out.println("Edad: " + edad );
			System.out.println("Comida: " + comida );
			System.out.println("Cantidad de Pulgas: " + PulgasCantidad );
		}

	}

	public static class gallo extends Animales{
		public String PlumasColor;
		public gallo(String nombreAnimal,int edadAnimal, String comidaAnimal, String PlumasColor){
			super(nombreAnimal, edadAnimal, comidaAnimal);
			this.PlumasColor=PlumasColor;
		}
		public void registerGallo(){
			System.out.println("\" Registrar Animales / Gallo \"");
			System.out.println("Por favor ingrese la siguiente información");
			System.out.print("Nombre: ");
			nombre = reader.nextLine();
			System.out.print("Comida: ");
			comida = reader.nextLine();
			System.out.print("Edad: ");
			edad = reader.nextInt();
			System.out.print("Color de Plumas");
			PlumasColor = reader.nextLine();
			reader.nextLine();
		}

		public void mostrarGallo(){
			System.out.println("\" Informacion Gato \"");
			System.out.println("Nombre: " + nombre );
			System.out.println("Edad: " + edad );
			System.out.println("Comida: " + comida );
			System.out.println("Color de las Plumas: " + PlumasColor );
		}
	}


	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);


		cat gato = new cat("", 0, "", "");
		dog perro = new dog("", 0, "", "");
		hamster raton = new hamster("", 0, "", "");
		gallo pollo = new gallo("", 0, "", "");

		int menu,opt1;

		do{
			System.out.println("					Menu");
			System.out.println("------------------------------------------------");
			System.out.println("|	1. Ingresar Animal				           |");
			System.out.println("|	2. Ver Animales							   |");
			System.out.println("|	0. Salir								   |");
			System.out.println("------------------------------------------------");
			System.out.print("Ingresa tu opcion...\n");
			menu = reader.nextInt();

			switch (menu) {
				case 1 -> {
					System.out.println("Registrar Animales");
					System.out.println("------------------------------------------------");
					System.out.println("|	1. Gato										|");
					System.out.println("|	2. Perro									|");
					System.out.println("|	3. Hamster									|");
					System.out.println("|	4. Pollo									|");
					System.out.println("|	0. Regresar									|");
					System.out.println("------------------------------------------------");
					System.out.print("Ingresa tu opcion...\n");
					opt1 = reader.nextInt();
					switch (opt1) {
						case 1 -> {
							gato.registerCat();
							System.out.println("------------------------------------------------");
							System.out.println("| [1]Continuar [0]Salir	   					  |");
							menu = reader.nextInt();
						}
						case 2 -> {
							perro.registerDog();
							System.out.println("------------------------------------------------");
							System.out.println("| [1]Continuar [0]Salir	   					  |");
							menu = reader.nextInt();
						}
						case 3 -> {
							raton.registerHamster();
							System.out.println("------------------------------------------------");
							System.out.println("| [1]Continuar [0]Salir	   					  |");
							menu = reader.nextInt();
						}
						case 4 -> {
							pollo.registerGallo();
							System.out.println("------------------------------------------------");
							System.out.println("| [1]Continuar [0]Salir	   					  |");
							menu = reader.nextInt();
						}
						default -> menu = 0;
					}
				}
				case 2 -> {
					System.out.println("Informacion Animales");
					System.out.println("------------------------------------------------");
					System.out.println("|	1. Gato										|");
					System.out.println("|	2. Perro									|");
					System.out.println("|	3. Hamster									|");
					System.out.println("|	4. Pollo									|");
					System.out.println("|	0. Regresar									|");
					System.out.println("------------------------------------------------");
					System.out.print("Ingresa tu opcion...\n");
					opt1 = reader.nextInt();
					switch (opt1) {
						case 1 -> {
							gato.mostrarCat();
							System.out.println("------------------------------------------------");
							System.out.println("| [1]Continuar [0]Salir	   					  |");
							menu = reader.nextInt();
						}
						case 2 -> {
							perro.mostrarDog();
							System.out.println("------------------------------------------------");
							System.out.println("| [1]Continuar [0]Salir	   					  |");
							menu = reader.nextInt();
						}
						case 3 -> {
							raton.mostrarHamster();
							System.out.println("------------------------------------------------");
							System.out.println("| [1]Continuar [0]Salir	   					  |");
							menu = reader.nextInt();
						}
						case 4 -> {
							pollo.mostrarGallo();
							System.out.println("------------------------------------------------");
							System.out.println("| [1]Continuar [0]Salir	   					  |");
							menu = reader.nextInt();
						}
						default -> menu = 0;
					}
				}
				default -> System.exit(0);
			}



		}while(menu >=1);


	}

}
