package org.example;
import java.util.*;
import  org.example.Calculadora;
public class App 
{

    public static void main(String[] args) {

        Calculadora operaciones = new Calculadora();

        int a;
        int b;
        boolean validacion = false;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Escoja una opcion");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("Opción: ");
            int opcion = sc.nextInt();
                sc.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Introduzca el primer número");
                    a = sc.nextInt();
                    System.out.println("Introduzca el segundo número");
                    b = sc.nextInt();
                    System.out.println(Calculadora.suma(a,b));
                    break;

                case 2:
                    System.out.println("Introduzca el primer número");
                    a = sc.nextInt();
                    System.out.println("Introduzca el segundo número");
                    b = sc.nextInt();
                    System.out.println(Calculadora.resta(a,b));
                    break;

                case 3:
                    System.out.println("Introduzca el primer número");
                    a = sc.nextInt();
                    System.out.println("Introduzca el segundo número");
                    b = sc.nextInt();
                    System.out.println(Calculadora.multiplicacion(a,b));
                    break;

                case 4:
                    System.out.println("Introduzca el primer número");
                    a = sc.nextInt();
                    System.out.println("Introduzca el segundo número");
                    b = sc.nextInt();
                    System.out.println(Calculadora.division(a,b));
                    break;

                default:
                    System.out.println("Introduzca una opcion valida!!");
                    break;

            }


        }while(validacion);

    }

}
