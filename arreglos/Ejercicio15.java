package arreglos;

import java.util.Scanner;

/**
 * Leer 10 enteros ordenados crecientemente.
 * Leer N y buscarlo en la tabla. se debe mostrar la posicion en la que se encuentra.
 * Si no esta indicarlo con un mensaje
 */
public class Ejercicio15 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int array[]=new int[10];
		int n=0;
		Ejercicio14.arrayCreciente(array);
		System.out.print("Ingrese N para buscarlo en la tabla: ");
		n=s.nextInt();
		for (int i = 0; i < array.length; i++) {
			if(n==array[i]) {
				System.out.print("Posicion encontrada: "+(i+1));
				break;
			}	
			else if(i==9)
				System.out.print("Numero no encontrado");
		}
		s.close();
	}

}
