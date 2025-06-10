package arreglos;

import java.util.Scanner;

/**
 * Leer 5 numeros, guardarlos en un arreglo y mostrarlos en el mismo orden introducido
 */
public class Ejercicio01 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int[] numeros=new int[5];
		for (int i = 0; i < numeros.length; i++) {
			System.out.print((i+1)+".Ingresa un numero: ");
			numeros[i]=s.nextInt();
		}
		for (int i : numeros) {
			System.out.println(i);
		}
		s.close();
	}

}
