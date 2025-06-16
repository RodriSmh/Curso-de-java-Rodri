package ordenamiento;
import java.util.Scanner;

import arreglos.Ejercicio04;

public class Insercion {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Ingresa el tamaño del arreglo: ");
		int array[]=new int[s.nextInt()];
		Ejercicio04.fill(array);
		insercion(array);
		Ejercicio04.printArray(array);

	}
	public static void insercion(int array[]) {
		int pos,aux;
		for (int i = 0; i < array.length; i++) {
			pos=i;
			aux=array[i];
			while(pos>0&&(array[pos-1])>aux) {
				array[pos]=array[pos-1];
				pos--;
			}
			array[pos]=aux;
		}
	}

}
