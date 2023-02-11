package poo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.*;

public class FuncionesCajero {

    public static HashMap<Integer, Double> cuentas = new HashMap<>();
    
	protected void leerArchivo() {


        try (FileReader lectura = new FileReader("cuentas.txt")) {
            BufferedReader lecturabufer = new BufferedReader(lectura);
            String linea;
            while ((linea = lecturabufer.readLine()) != null) {
                String[] cuenta = linea.split(",");
                int numCuenta = Integer.parseInt(cuenta[0]);

                double saldo = Double.parseDouble(cuenta[1]);
                cuentas.put(numCuenta, saldo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	protected void escribirArchivo() {

        try (FileWriter fw = new FileWriter("cuentas.txt")) {
            for (Integer numCuenta : cuentas.keySet()) {
                fw.write(numCuenta + "," + cuentas.get(numCuenta) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	protected void consultarSaldo(int numCuenta) {

            JOptionPane.showMessageDialog(null, "Su saldo es: $" + cuentas.get(numCuenta));
    }

	protected void retirarDinero(int numCuenta) {
            double retiro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a retirar:"));
                cuentas.put(numCuenta, cuentas.get(numCuenta) - retiro);
                JOptionPane.showMessageDialog(null, "Retiro realizado con éxito. Su nuevo saldo es: $" + cuentas.get(numCuenta));
    }

	protected void depositarDinero(int numCuenta) {

            double deposito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a depositar:"));
            cuentas.put(numCuenta, cuentas.get(numCuenta) + deposito);
            JOptionPane.showMessageDialog(null, "Deposito realizado con éxito. Su nuevo saldo es: $" + cuentas.get(numCuenta));

    }

	protected void transferirDinero(int numCuenta2, int numCuenta) {

            numCuenta2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cuenta a la que transferira:"));
            double transferencia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a depositar:"));
            cuentas.put(numCuenta2, cuentas.get(numCuenta2) + transferencia);
            cuentas.put(numCuenta, cuentas.get(numCuenta) - transferencia);
            JOptionPane.showMessageDialog(null, "Transferencia realizada con éxito. Su nuevo saldo es: $" + cuentas.get(numCuenta));

    }
	
	
}
