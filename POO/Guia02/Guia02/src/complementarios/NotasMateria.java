package complementarios;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;


public class NotasMateria {

	public static void main(String[] args) {
		
		String nota1,nota2,nota3;
		double n1,n2,n3,prom;


		 JOptionPane.showMessageDialog(null,"¿Pase o no la materia?");
		 nota1 = JOptionPane.showInputDialog("Por favor, ingrese la primera nota ");
		 nota2 = JOptionPane.showInputDialog("Por favor, ingrese la segunda nota");
		 nota3 = JOptionPane.showInputDialog("Por favor, ingrese la tercera nota");
 		 n1 = Double.valueOf(nota1);
 		 n2 = Double.valueOf(nota2);
 		 n3 = Double.valueOf(nota3);
 		 prom = (n1 + n2 + n3) / 3;
 	     DecimalFormat promdef = new DecimalFormat("##.##");


		  if(n1 > 10 || n1 < 0){
			  JOptionPane.showMessageDialog(null,"Nota 1 es menor que 0 y/o mayor que 10");
		} else {
			  if(n2 > 10 || n2 < 0){
				  JOptionPane.showMessageDialog(null,"Nota 2 es menor que 0 y/o mayor que 10");
			  } else {
				  if(n3 > 10 || n3 < 0){
					  JOptionPane.showMessageDialog(null,"Nota 3 es menor que 0 y/o mayor que 10");
				  } else {
					  if(prom >= 7) {

						  JOptionPane.showMessageDialog(null,"\nNota 1: " + n1 + "\nNota 2: " + n2 + "\nNota 3: " + n3 + "\nPromedio: " + promdef.format(prom) + "\nFelicidades ha pasado exitosamente la materia ");


					  } else if (prom >= 6.50 && prom <= 6.99 ) {

						  JOptionPane.showMessageDialog(null,"\nNota 1: " + n1 + "\nNota 2: " + n2 + "\nNota 3: " + n3 + "\nPromedio: " +  promdef.format(prom) + "\nDebera cursar un examen de reposición para tener la posibilidad de pasar la materia ");

					  } else {

						  JOptionPane.showMessageDialog(null,"\nNota 1: " + n1 + "\nNota 2: " + n2 + "\nNota 3: " + n3 + "\nPromedio: " +  promdef.format(prom) + "\nReprobado");
					  }
				  }
			  }
		  }









	   }
     } 
