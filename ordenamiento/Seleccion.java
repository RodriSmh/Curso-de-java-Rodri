package ordenamiento;

import java.util.Scanner;

import arreglos.Ejercicio04;

public class Seleccion {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Ingresa el tamaño del arreglo: ");
		int array[]=new int[s.nextInt()];
		Ejercicio04.fill(array);
		seleccion(array);
		Ejercicio04.printArray(array);
		
	}
	public static void seleccion(int array[]) {
		int min,aux;
		for (int i = 0; i < array.length; i++) {
			min=i;
			for (int j =i+1; j < array.length; j++) {
				if(array[j]<array[min])
					min=j;
			}
			aux=array[i];
			array[i]=array[min];
			array[min]=aux;
		}
	}

}
