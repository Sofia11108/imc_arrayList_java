package imc;

import java.util.ArrayList;

import javax.swing.JOptionPane;
//import java.text.DecimalFormat;


public class Imc {

	public static void main(String[] args) {
		
//		DecimalFormat df = new DecimalFormat("#.00");
		
		ArrayList<String> nombres = new ArrayList<String>();
		ArrayList<String> telefono = new ArrayList<String>();
		ArrayList<Double> imc = new ArrayList<Double>();
		ArrayList<String> conclusion = new ArrayList<String>();
		double peso, talla, imc1;
		String resultado;
		int i = 0;
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de pacientes"));
		
		do {
		nombres.add(JOptionPane.showInputDialog("ingrese su nombre"));

		telefono.add(JOptionPane.showInputDialog("ingrese su telefono"));
		
			do {
				peso = Double.parseDouble(JOptionPane.showInputDialog("ingrese su peso"));
			}while(peso <= 0);
			
			do {
				talla = Double.parseDouble(JOptionPane.showInputDialog("ingrese su talla"));
			}while(talla <= 0);
			
			imc1 = peso/(Math.pow(talla, 2));
			imc.add(imc1);
			
			if(imc1 < 18) {
				conclusion.add("Anorexia");
				
			} else if (imc1 >= 18 && imc1 < 20) {
				conclusion.add("Delgadez");
				
			} else if (imc1 >= 20 && imc1 < 27) {
				conclusion.add("Normalidad");
				
			} else if (imc1 >= 27 && imc1 < 30) {
				conclusion.add("Obesidad(1)");
				
			} else if (imc1 >= 30 && imc1 < 35) {
				conclusion.add("Obesidad(2)");
				
			} else if (imc1 >= 35 && imc1 < 40) {
				conclusion.add("Obesidad(3)");
				
			} else if (imc1 >= 40) {
				conclusion.add("Obesidad mórbida");
			}
		
		i++;
		} while(i < n);
		
		System.out.println(nombres);
		System.out.println(telefono);
		System.out.println(imc);
		System.out.println(conclusion);
		System.out.println();
		
		
		for (int j = 0; j < nombres.size(); j++) {
			resultado = "Nombre: " + nombres.get(j)+ "\n";
			resultado += "tel: " + telefono.get(j)+ "\n";
			resultado += "imc: " + imc.get(j) + "\n";
			resultado += "resultado: " +conclusion.get(j);
			
			System.out.println(resultado);
			System.out.println();
		}
	}

}
