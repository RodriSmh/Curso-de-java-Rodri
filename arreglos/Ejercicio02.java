package arreglos;

import java.util.Scanner;

/**
 * Leer 5 numeros, guardarlos en un arreglo y mostrarlos en el orden inverso
 */
public class Ejercicio02 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int[] numeros=new int[5];
		for (int i = 0; i < numeros.length; i++) {
			System.out.print((i+1)+".Ingresa un numero: ");
			numeros[i]=s.nextInt();
		}
		for (int i = numeros.length; 0 <i ; i--) {
			System.out.println(numeros[i-1]);
		}
		s.close();
	}

}
