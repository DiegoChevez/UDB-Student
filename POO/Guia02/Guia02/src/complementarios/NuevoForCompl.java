package complementarios;

import javax.swing.JOptionPane;

public class NuevoForCompl {

	public static void main(String[] args) {

		String leer;
		double sueldo, mayor=0,menor=10000;
		int i=1, contador=0;

		while (i <= 5) {
			leer = JOptionPane.showInputDialog("Ingrese el sueldo del empleado " + i);
			sueldo = Double.parseDouble(leer);
			while (sueldo < 0) {
				JOptionPane.showMessageDialog(null, "El sueldo no puede ser negativo. Por favor ingrese un valor válido.");
				leer = JOptionPane.showInputDialog("Ingrese el sueldo del empleado " + i);
				sueldo = Double.parseDouble(leer);
			}
			if (sueldo > 300) {
				contador = contador + 1;
			}
			if (sueldo > mayor) {
				mayor = sueldo;
			}
			if (sueldo < menor) {
				menor = sueldo;
			}
			i = i + 1;
		}





		JOptionPane.showMessageDialog(null, " El sueldo Mayor es de $: " + mayor +"\nEl sueldo Menor es de $: " + menor + "\n"+ contador + " Empleados tienen un sueldo mayor de $300");
		
		
		
	}

}
