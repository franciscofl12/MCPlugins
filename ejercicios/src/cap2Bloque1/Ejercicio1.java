package cap2Bloque1;

import javax.swing.JOptionPane;

public class Ejercicio1{

	/**
	 * 
	 * @param args
	 */
	
	public static void main(String args[]) {
		calculo(); // Llamamos a nuestro método para hacer el calculo
	}

	public static void calculo() {
		String var = JOptionPane.showInputDialog("Introduzca un numero: "); // Obtenemos valor para los calculos necesarios
		int num1 = Integer.parseInt(var);
		String var2 = JOptionPane.showInputDialog("Introduzca otro numero: "); // Obtenemos valor para los calculos necesarios
		int num2 = Integer.parseInt(var2);
		if (num1!=num2) {
			if (num1>num2) {
				System.out.println("El numero mayor es: "+ num1);
			}
			else {
				System.out.println("El numero mayor es: "+ num2);
			}
		}
		else {
			System.out.println("Los numeros introducidos son iguales.");
		}
	}
}
	

