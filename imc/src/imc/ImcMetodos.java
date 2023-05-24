package imc;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class ImcMetodos {
	
	ArrayList<String> nombres;
	ArrayList<String> telefono;
	ArrayList<Double> imc;
	ArrayList<String> conclusion;

	
	public ImcMetodos() {  //constructor y no retorna, es para inicializar variables
		
		nombres = new ArrayList<String>();
		telefono = new ArrayList<String>();
		imc = new ArrayList<Double>();
		conclusion  = new ArrayList<String>();
		
		String menu = menu();
		iniciar(menu);
	}
	
	public String menu() {
		String menu;
		
		 menu = "OPCIONES \n";
		 menu += "1.Registrar alguien más \n";
		 menu += "2.Buscar persona \n";
		 menu += "3.Imprimir lista \n";
		 menu += "4.Actualizar persona \n";
		 menu += "5.ELiminar persona \n";
		 menu += "6.Salir \n";
		 
		 return menu;
	}

	public void iniciar(String menu) {
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personas a registrar"));
			
		for (int j = 0; j < n; j++) {
			pedirDatos();
		}
		
		int cod;
		do {
			cod = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarCod(cod);
			
		} while (cod != 6);	
	}

	public void validarCod(int cod) {
		
		switch (cod) {
		case 1: pedirDatos();
			break;
			
		case 2: 
			if (!nombres.isEmpty()) {
				buscarPersona();
			} else {
				JOptionPane.showMessageDialog(null, "No hay datos por mostrar, ingrese almenos un registro");
			}
			break;
			
		case 3: 
			if (!nombres.isEmpty()) {
				imprimirLista();
			} else {
				JOptionPane.showMessageDialog(null, "No hay datos por mostrar, ingrese almenos un registro");
			}
			break;
			
		case 4:
			if (!nombres.isEmpty()) {
				actualizarPersona();
			} else {
				JOptionPane.showMessageDialog(null, "No hay datos por mostrar, ingrese almenos un registro");
			}
			break;
			
		case 5: 
			if (!nombres.isEmpty()) {
				eliminarPersona();
			} else {
				JOptionPane.showMessageDialog(null, "No hay datos por mostrar, ingrese almenos un registro");
			}
			break;
			
		case 6: 
			JOptionPane.showMessageDialog(null, "Gracias por usar el programa", "Cerrando", JOptionPane.INFORMATION_MESSAGE);
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "EL codigo no existe, ingrese nuevamente");
		}
	}


	public void pedirDatos() {
		double peso, talla;
		
			nombres.add(JOptionPane.showInputDialog("ingrese su nombre").toLowerCase());
			telefono.add(JOptionPane.showInputDialog("ingrese su telefono"));
			peso = validar("Ingrese su peso", 0);
			talla = validar("Ingrese su talla", 0);
			
			calcularImc(peso, talla);
	}


	public double validar(String mensaje, int limite) {
		double dato;
		
		do {
			dato = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
		} while(dato <= limite);
		
		return dato;
	}
	
	public void calcularImc(double peso, double talla) {
		double imc1;
		imc1 = peso / Math.pow(talla, 2);
		imc.add(imc1);
		
		resultado(imc1);
	}
	
	public void resultado(double imc1) {
		
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
	}
	
	public void imprimirLista() {
		String resultado;
			
		resultado = "LISTA COMPLETA: \n";
			
		for (int i = 0; i < nombres.size(); i++) {
			resultado += "Nombre: " + nombres.get(i)+ " | ";
			resultado += "tel: " + telefono.get(i)+ " | ";
			resultado += "resultado: " +conclusion.get(i) + " | ";
			resultado += "imc: " + imc.get(i) + " | ";
			resultado += "ubicado en posicion # " + i;
			resultado += "\n";
		}
			
			JOptionPane.showMessageDialog(null, resultado);		
	}
	
	
	public void buscarPersona() {
		String resultado, nombre;
		int veces = 0;
		
		nombre = JOptionPane.showInputDialog("Ingrese el nombre a buscar").toLowerCase();
		
		if (nombres.contains(nombre)) {
			
			resultado = "BUSQUEDA POR EL NOMBRE " + nombre + "\n\n";

			for (int i = 0; i < nombres.size(); i++) {
				
				if (nombres.get(i).equalsIgnoreCase(nombre)) {

					resultado += "posicion # " + i + " | ";
					resultado += "Nombre: " + nombres.get(i)+ " | ";
					resultado += "tel: " + telefono.get(i)+ " | ";
					resultado += "resultado: " +conclusion.get(i) + " | ";
					resultado += "imc: " + imc.get(i);
					resultado += "\n";
					
					veces++;
				}
			}
			JOptionPane.showMessageDialog(null, resultado + "se encontró el nombre " +nombre + " " +veces + " vez/veces");
			
		} else {
			JOptionPane.showMessageDialog(null, "No se encuentra la persona " +nombre);
		}
	}
	
	
	private void eliminarPersona() {
		
		ArrayList<Integer> posiciones = new ArrayList<Integer>();
		String resultado, nombre;
		int posicion;
		boolean valida = true;
		
		nombre = JOptionPane.showInputDialog("ingrese el nombre a eliminar del sistema").toLowerCase();
		
		if(nombres.contains(nombre)) {
				resultado = "ELIMINAR REGISTRO POR EL NOMBRE " + nombre +"\n";
				
			for (int i = 0; i < nombres.size(); i++) {
				
				if (nombres.get(i).equalsIgnoreCase(nombre)) {
					resultado += "ubicado en posicion # " + i + " | ";
					resultado += "Nombre: " + nombres.get(i)+ " | ";
					resultado += "tel: " + telefono.get(i)+ " | ";
					resultado += "resultado: " +conclusion.get(i) + " | ";
					resultado += "imc: " + imc.get(i);
					resultado += "\n";
					
					posiciones.add(i);
				}
			}
			
			do {
				posicion = Integer.parseInt(JOptionPane.showInputDialog(resultado + "de que posicion desea eliminar el registro?"));
				if (posiciones.contains(posicion)) {
					nombres.remove(posicion);
					telefono.remove(posicion);
					imc.remove(posicion);
					conclusion.remove(posicion);
					JOptionPane.showMessageDialog(null, "se eliminaron los datos de " + nombre + " de la posicion " +posicion);
					valida = false;
				}
			} while (valida == true);

		} else {
			JOptionPane.showMessageDialog(null, "No se encuentra la persona " +nombre+ " para eliminar");
		}
		
	}
	
	
	private void actualizarPersona() {
		ArrayList<Integer> posiciones = new ArrayList<Integer>();
		String resultado, nuevoNombre, nuevoTel, antesCambioN, antesCambioT;
		int posicion;
		int opcion;
		boolean valida = true;
		String nombre = JOptionPane.showInputDialog("ingrese el nombre de la persona a actualizar sus datos").toLowerCase();
		
		if(nombres.contains(nombre)) {
			
			resultado = "ACTUALIZAR DATOS POR EL NOMBRE " + nombre + "\n";
			
			for (int i = 0; i < nombres.size(); i++) {
				
				if (nombres.get(i).equalsIgnoreCase(nombre)) {
					 resultado += "ubicado en posicion # " + i + " | ";
					 resultado += "Nombre: " + nombres.get(i) + " | ";
					 resultado += "tel: " + telefono.get(i)+ " | ";
					 resultado += "resultado: " +conclusion.get(i) + " | ";
					 resultado += "imc: " + imc.get(i);
					 resultado += "\n";
					 
					 posiciones.add(i);
				}
			}
			
			do {
			posicion = Integer.parseInt(JOptionPane.showInputDialog(resultado + "De que posición desea actualizar los datos?"));
			
			if(posiciones.contains(posicion)) {
				do {
					opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese que quiere modificar \n" + "1-Nombre, 2-Tel, 3-Ambos"));
				
					switch (opcion) {
					case 1:
						nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
						antesCambioN = nombres.get(posicion);
						nombres.remove(posicion);
						nombres.add(posicion, nuevoNombre);
						JOptionPane.showMessageDialog(null, "se actualizó el nombre de " + antesCambioN + " a " + nombres.get(posicion));
						valida = false;
						break;
						
					case 2:
						nuevoTel = JOptionPane.showInputDialog("Ingrese el nuevo telefono");
						antesCambioT = telefono.get(posicion);
						telefono.set(posicion, nuevoTel);
						JOptionPane.showMessageDialog(null, "se actualizó del usuario " +nombres.get(posicion)+ " el telefono de " + antesCambioT + " a " + telefono.get(posicion));
						valida = false;
						break;
					case 3:
						nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
						nuevoTel = JOptionPane.showInputDialog("Ingrese el nuevo telefono");
						antesCambioN = nombres.get(posicion);
						antesCambioT = telefono.get(posicion);
						nombres.set(posicion, nuevoNombre);
						telefono.set(posicion, nuevoTel);
						JOptionPane.showMessageDialog(null, "se actualizó el nombre " +antesCambioN+ " a " + nombres.get(posicion) + " y telefono " + antesCambioT + " a " +  telefono.get(posicion));
						valida = false;
						break;
						
					default:JOptionPane.showMessageDialog(null, "opcion incorrecta");
						break;
					}
					
				} while (opcion <1 || opcion > 3);
				
			}
			} while (valida);
					
		} else {
			JOptionPane.showMessageDialog(null, "No se encuentra la persona " +nombre+ " en el sistema");
		}
	}
}
//

