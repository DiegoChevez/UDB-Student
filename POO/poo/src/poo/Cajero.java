package poo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import java.util.Scanner;

public class Cajero {


    public static void main(String[] args) {
    	


    	FuncionesCajero funciones = new FuncionesCajero();

        
        Scanner reader = new Scanner(System.in);

        int opcion = 0;
        int numCuenta2 =0;
        boolean validacion = false;


    	
   	 do {
   		 
   		 try {
   		  	validacion = false;
   		  
   	        int numCuenta = Integer.parseInt(JOptionPane.showInputDialog("¿número de cuenta?"));
   	        
   	        do {
   	        	
   	   	     try {

   	             funciones.leerArchivo();
   	            	 
   	            	if (FuncionesCajero.cuentas.containsKey(numCuenta)) {
   	   	 	        	
   	   	 	        	do {
   	   	     		
   	   	     	            while (opcion != 5) {
   	   	     	            	
   	   	     	                opcion = Integer.parseInt(JOptionPane.showInputDialog("Menú:\n1. Consultar saldo\n2. Retirar dinero\n3. Depositar dinero\n4. Transferir dinero\n5. Salir"));
   	   	     	               
   	   	     	                switch (opcion) {
   	   	     	                
   	   	     	                    case 1:
   	   	     	                        funciones.consultarSaldo(numCuenta);
   	   	     	                        break;
   	   	     	                        
   	   	     	                    case 2:
   	   	     	                        funciones.retirarDinero(numCuenta);
   	   	     	                        break;
   	   	     	                        
   	   	     	                    case 3:
   	   	     	                        funciones.depositarDinero(numCuenta); 
   	   	     	                        break;
   	   	     	                        
   	   	     	                    case 4:
   	   	     	                        funciones.transferirDinero(numCuenta2, numCuenta);
   	   	     	                        break;
   	   	     	                        
   	   	     	                    case 5:
   	   	     	                        break;
   	   	     	                        
   	   	     	                    default:
   	   	     	                        JOptionPane.showMessageDialog(null, "Opción inválida");
   	   	     	                        break;
   	   	     	                }
   	   	     	                
   	   	     	            }
   	   	     	            
   	   	     	        funciones.escribirArchivo();
   	   	     			
   	   	     		
   	   	     	
   	   	     	}while(opcion !=4);
   	   	     		
   	   	 	        } else {
   	   	 	        	
   	   	 	            JOptionPane.showMessageDialog(null, "Cuenta inválida");
   	   	 	            
   	   	 	        	   }

   	   	     }catch(NumberFormatException e) {
   	 			
   	 			JOptionPane.showMessageDialog(null, "Opción no valida, intente de nuevo!", "Error", JOptionPane.ERROR_MESSAGE);
   	 			validacion = true;
   	 		}
   	   	        
   	        }while(validacion);
   	             
   		 }catch(NumberFormatException e) {
   			JOptionPane.showMessageDialog(null, "Opción no valida, intente de nuevo!", "Error", JOptionPane.ERROR_MESSAGE);
  			validacion = true;
   		 }
   
      }while(validacion);

        
    }
        
}
