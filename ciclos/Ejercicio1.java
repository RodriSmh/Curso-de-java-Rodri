/**
 * Leer un numero y mostrar su cuadrado, repetir el proceso hasta que se ingrese un numero negativo
 */

package ciclos;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int i=1;
		Scanner s=new Scanner(System.in);
		do{
			System.out.print("Ingresa un numero: ");
			i=s.nextInt();
		}while (i>=0);
		
		s.close();
	}

}
