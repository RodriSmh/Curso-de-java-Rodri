package arreglos;

import java.util.Scanner;

/**
 * Leer por teclado una serie de 10 numeros enteros
 * debe indicar si los numeros estan ordenados de forma creciente
 * decreciente, si estan desordenados o todos son iguales
 */
public class Ejercicio07 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int array[]=new int[5];
		Ejercicio04.fill(array);
		boolean creciente=false,decreciente=false;
		
		for (int i = 0; i < (array.length)-1; i++) {
			if(array[i]<array[i+1])
				creciente=true;
			if(array[i]>array[i+1])
				decreciente=true;
		}
		if(creciente==true&&decreciente==false)
			System.out.println("El arreglo esta ordenado en forma creciente");
		else if(creciente==false&&decreciente==true)
			System.out.println("El arreglo esta ordenado en forma decreciente");
		else if(creciente==true&&decreciente==true)
			System.out.println("El arreglo esta desordenado");
		else
			System.out.println("El arreglo es igual en todos sus valores");

		s.close();

	}

}