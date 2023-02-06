package complementarios;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class TiendaDescuento {

	public static void main(String[] args) {
		
		String precioStr;
		double precio;
		double Operaciones;
		double total;

		   List<Integer> DuescuentosDisp = Arrays.asList(10, 5, 0);
	        Random aleatorio = new Random();
	        int TotalDesc = DuescuentosDisp.get(aleatorio.nextInt(DuescuentosDisp.size()));
            DecimalFormat df = new DecimalFormat("###.##");

            System.out.print(TotalDesc);
	        JOptionPane.showMessageDialog(null, "Descuento de la suerte");
	        precioStr = JOptionPane.showInputDialog("Introduzca el total a pagar y luego de a OK para saber si ha ganado descuento");
	        precio = Double.valueOf(precioStr);
	        JOptionPane.showMessageDialog(null,"Ha ingreso un monto a pagar de $" + df.format(precio) + " exitosamente");
	        
	        switch(TotalDesc) {
	        
	        case 10 :
	        	Operaciones = (TotalDesc * precio) / 100 ;
	        	total = precio - Operaciones;
		        JOptionPane.showMessageDialog(null,"Felicidades ha ganado un descuento del " + TotalDesc + "%\n"+"Su descuento sería de $" + df.format(Operaciones) + "\n Total a pagar: $"+df.format(total));
		        break;
		        
	        case 5 :
	        	
	        	Operaciones = (TotalDesc * precio) / 100 ;
	        	total = precio - Operaciones;
		        JOptionPane.showMessageDialog(null,"Felicidades ha ganado un descuento del " + TotalDesc + "%\n"+"Su descuento sería de $" + df.format(Operaciones) + "\n Total a pagar: $"+df.format(total));
		        break;
	        
		    default :
		        	
		        JOptionPane.showMessageDialog(null,"Lo sentimos, no ha ganado ningun descuento");
		      break;
		        
	        } 
	        
	      }

        }
