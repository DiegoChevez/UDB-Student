package ejemplos;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Animales {
	Scanner reader= new Scanner(System.in);

	
	public String nombre;
	public int edad;
	public String alimentacion;
	
	public Animales(String nombre, int edad, String alimentacion) {

		this.nombre = nombre;
		this.edad = edad;
		this.alimentacion = alimentacion;
		
	}
	
	public static class Perro extends Animales	{

		public String color_pelaje;
		
		public Perro(String nombre, int edad, String alimentacion, String color_pelaje) {
			super(nombre, edad, alimentacion);
			this.color_pelaje = color_pelaje;

		}
		
		
		public void mostrarDatosPerro() {
			
		System.out.println("Datos Perro\n");	
		System.out.println("Nombre: "+nombre+"\nEdad: "+edad+"\nAlimentacion: "+alimentacion+"\nColor de pelaje: "+color_pelaje);
			
		}
		
		public void ingresarDatosPerro() {
			
			System.out.println("Ingrese los datos de su mascota");
			System.out.println("Nombre: ");
			nombre = reader.nextLine();
			System.out.println("Edad: ");
			edad = reader.nextInt();
			reader.nextLine();
			System.out.println("Ingrese la alimentación de su mascota: ");
			alimentacion = reader.nextLine();
			System.out.println("Ingrese el color de pelo de su mascota: ");
			color_pelaje = reader.nextLine();
			
		}
		
		
	  }

	
	public static class Gallo extends Animales{
		
		public String color_plumas;

		public Gallo(String nombre, int edad, String alimentacion, String color_plumas) {
			super(nombre, edad, alimentacion);
		this.color_plumas = color_plumas;
		
		}	
		
		
		public void mostrarDatosGallo() {
			
			System.out.println("Datos Gallo\n");	
			System.out.println("Nombre: "+nombre+"\nEdad: "+edad+"\nAlimentacion: "+alimentacion+"\nColor de pelaje: "+color_plumas);
				
			}
		
	public void ingresarDatosGallo() {
			
			System.out.println("Ingrese los datos de su mascota");
			System.out.println("Nombre: ");
			nombre = reader.nextLine();
			System.out.println("Edad: ");
			edad = reader.nextInt();
			reader.nextLine();
			System.out.println("Ingrese la alimentación de su mascota: ");
			alimentacion = reader.nextLine();
			System.out.println("Ingrese el color de plumas de su mascota: ");
			color_plumas = reader.nextLine();
			
		}
		
	}
	
	
	public static class Gato extends Animales{

		public String color_ojos;
		
		public Gato(String nombre, int edad, String alimentacion, String color_ojos) {
			super(nombre, edad, alimentacion);
			
		this.color_ojos = color_ojos;
			
		}
		
		public void mostrarDatosGato() {
			
			System.out.println("Datos Gato\n");	
			System.out.println("Nombre: "+nombre+"\nEdad: "+edad+"\nAlimentacion: "+alimentacion+"\nColor de pelaje: "+color_ojos);
				
			}
		
		public void ingresarDatosGato() {
			
			System.out.println("Ingrese los datos de su mascota");
			System.out.println("Nombre: ");
			nombre = reader.nextLine();
			System.out.println("Edad: ");
			edad = reader.nextInt();
			reader.nextLine();
			System.out.println("Ingrese la alimentación de su mascota: ");
			alimentacion = reader.nextLine();
			System.out.println("Ingrese el color de ojos de su mascota: ");
			color_ojos = reader.nextLine();
			
		}
		
		
	
	}	
		
			
	public static class Hamster extends Animales{
		
		public String cantidad_pulgas;
		
		public Hamster(String nombre, int edad, String alimentacion, String cantidad_pulgas) {
			super (nombre, edad, alimentacion);
			
			this.cantidad_pulgas = cantidad_pulgas;
						
			
		}
		
		public void mostrarDatosHamster() {
			
			System.out.println("Datos Hamster\n");	
			System.out.println("Nombre: "+nombre+"\nEdad: "+edad+"\nAlimentacion: "+alimentacion+"\nColor de pelaje: "+cantidad_pulgas);
				
			}
		
		public void ingresarDatosHamster() {
			
			System.out.println("Ingrese los datos de su mascota");
			System.out.println("Nombre: ");
			nombre = reader.nextLine();
			System.out.println("Edad: ");
			edad = reader.nextInt();
			reader.nextLine();
			System.out.println("Ingrese la alimentación de su mascota: ");
			alimentacion = reader.nextLine();
			System.out.println("Ingrese la cantidad de pulgas de su mascota: ");
			cantidad_pulgas = reader.nextLine();
			
		}
		
		
			
	}
	

	@SuppressWarnings("unused")
	
	public static void main (String[]args) {
		
		Perro perro = new Perro("Rocky", 4, "Croquetas", "Negro");
		Gallo gallo = new Gallo("Chela", 9, "Maicillo", "Blancas");
		Hamster hamster = new Hamster("Chagui", 7, "Lechuga", "Cafe");
		Gato gato = new Gato("Hanyi", 10, "Whiskas", "Negro");

		Scanner reader= new Scanner(System.in);

		int opcion;
		int opcion2;

		boolean validacion = false;
		
		do {
			try {
				validacion = true;
				do {
					
					System.out.println("---------------Menu-------------------");
					System.out.println("1. Perro ");
					System.out.println("2. Gallo ");
					System.out.println("3. Gato ");
					System.out.println("4. Hamster");
					System.out.println("0. Salir");
					System.out.println("----------------------------------------");
					
					opcion = reader.nextInt();
					
					
					switch(opcion) {
					
					case 1: 
						
						do {
							System.out.println("---------------Menu-------------------");
							System.out.println("1. Registrar datos perro ");
							System.out.println("2. Mostrar datos perro ");
							System.out.println("0. Regresar ");
							System.out.println("---------------------------------------");
							opcion2 = reader.nextInt();

							switch (opcion2) {
							
							case 1: 
								
								perro.ingresarDatosPerro();
								System.out.println("Registro exitoso!");
								break;
							case 2: 
								
								perro.mostrarDatosPerro();
								break;
							case 0: 
								break;	
							default:
								System.out.println("Opción no valida!");
											
							}
							
							
						}while(opcion2 != 0);
						break;
					
					case 2:
						
						do {
							System.out.println("---------------Menu-------------------");
							System.out.println("1. Registrar datos gallo ");
							System.out.println("2. Mostrar datos gallo ");
							System.out.println("0. Regresar ");
							System.out.println("---------------------------------------");
							opcion2 = reader.nextInt();

							switch (opcion2) {
							
							case 1: 
								
								gallo.ingresarDatosGallo();
								System.out.println("Registro exitoso!");
								break;
							case 2: 
								
								gallo.mostrarDatosGallo();
								break;
							case 0: 
								break;	
							default:
								System.out.println("Opción no valida!");
											
							}
							
							
						}while(opcion2 != 0);
						break;			
					case 3:
						
						do {
							System.out.println("---------------Menu-------------------");
							System.out.println("1. Registrar datos gato ");
							System.out.println("2. Mostrar datos gato ");
							System.out.println("0. Regresar ");
							System.out.println("---------------------------------------");
							opcion2 = reader.nextInt();

							switch (opcion2) {
							
							case 1: 
								
								gato.ingresarDatosGato();
								System.out.println("Registro exitoso!");
								break;
							case 2: 
								
								gato.mostrarDatosGato();
								break;
							case 0: 
								break;	
							default:
								System.out.println("Opción no valida!");
											
							}
							
							
						}while(opcion2 != 0);
						break;
						
					case 4: 	
						
						do {
							System.out.println("---------------Menu-------------------");
							System.out.println("1. Registrar datos hamster ");
							System.out.println("2. Mostrar datos hamster ");
							System.out.println("0. Regresar ");
							System.out.println("---------------------------------------");
							opcion2 = reader.nextInt();

							switch (opcion2) {
							
							case 1: 
								
								hamster.ingresarDatosHamster();
								System.out.println("Registro exitoso!");
								break;
							case 2: 
								
								hamster.mostrarDatosHamster();
								break;
							case 0: 
								break;	
							default:
								System.out.println("Opción no valida!");
											
							}
							
							
						}while(opcion2 != 0);
						
			
						
						break;
						
					case 0: 
						System.out.println("Fin del programa!");
						System.exit(0);
						break;
						
		
					default: 	
						System.out.println("Opción invalida!");
						break;
						
					}
					
						
				}while(opcion != 0);
				
				
				
				
			}catch(InputMismatchException e) {
				System.out.println("No se admiten letras");
				reader.nextLine();
				
			}
			
		}while(validacion);

	 }		 	
   }
