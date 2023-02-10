package guia3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Angie {
    public static HashMap<Integer, Double> cuentas = new HashMap<>();

    public static void main(String[] args) {
        leerArchivo();
        int opcion = 0;
        int numCuenta = Integer.parseInt(JOptionPane.showInputDialog("¿número de cuenta?"));
        int numCuenta2 =0;
        if (cuentas.containsKey(numCuenta)) {
            while (opcion != 5) {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Menú:\n1. Consultar saldo\n2. Retirar dinero\n3. Depositar dinero\n4. Transferir dinero\n5. Salir"));
                switch (opcion) {
                    case 1:
                        consultarSaldo(numCuenta);
                        break;
                    case 2:
                        retirarDinero(numCuenta);
                        break;
                    case 3:
                        depositarDinero(numCuenta); 
                        break;
                    case 4:
                        transferirDinero(numCuenta2, numCuenta);
                        break;
                    case 5:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cuenta inválida");
        }

        escribirArchivo();
    }

    private static void leerArchivo() {


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

    private static void escribirArchivo() {

        try (FileWriter fw = new FileWriter("cuentas.txt")) {
            for (Integer numCuenta : cuentas.keySet()) {
                fw.write(numCuenta + "," + cuentas.get(numCuenta) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void consultarSaldo(int numCuenta) {

            JOptionPane.showMessageDialog(null, "Su saldo es: $" + cuentas.get(numCuenta));
    }

    private static void retirarDinero(int numCuenta) {
            double retiro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a retirar:"));
                cuentas.put(numCuenta, cuentas.get(numCuenta) - retiro);
                JOptionPane.showMessageDialog(null, "Retiro realizado con éxito. Su nuevo saldo es: $" + cuentas.get(numCuenta));
    }

    private static void depositarDinero(int numCuenta) {

            double deposito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a depositar:"));
            cuentas.put(numCuenta, cuentas.get(numCuenta) + deposito);
            JOptionPane.showMessageDialog(null, "Deposito realizado con éxito. Su nuevo saldo es: $" + cuentas.get(numCuenta));

    }


    private static void transferirDinero(int numCuenta2, int numCuenta) {

            numCuenta2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cuenta a la que transferira:"));
            double transferencia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a depositar:"));
            cuentas.put(numCuenta2, cuentas.get(numCuenta2) + transferencia);
            cuentas.put(numCuenta, cuentas.get(numCuenta) - transferencia);
            JOptionPane.showMessageDialog(null, "Transferencia realizada con éxito. Su nuevo saldo es: $" + cuentas.get(numCuenta));

    }
}