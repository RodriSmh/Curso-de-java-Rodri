package ordenamiento;

import java.util.Scanner;

import arreglos.Ejercicio04;

/**
 * Ordenamiento con metodo burbuja
 */
public class Burbuja {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int array[],nElementos;
		System.out.print("Ingresa el numero de elementos del arreglo: ");
		nElementos=s.nextInt();
		array=new int[nElementos];
		Ejercicio04.fill(array);
		burbuja(array);
		Ejercicio04.printArray(array);
		s.close();

	}
	public static void burbuja(int array[]) {
		int aux=0;
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length-1; j++) {
				if(array[j]>array[j+1]) {
					aux=array[j];
					array[j]=array[j+1];
					array[j+1]=aux;
				}
					
			}
		}
	}

}
