package arreglos;

import java.util.Scanner;

/**
 * Leer por teclado una tabla de 10 elementos numericos enteros y una posicion
 * eliminar el elemento situado en la posicion dada sin dejar huecos
 */
public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int array[]=Ejercicio04.fill();
		int posicion;
		System.out.print("Ingrese la posicion a eliminar: ");
		posicion=s.nextInt()-1;
		for (int i = posicion; i < array.length; i++) {
			if(array[i]==array[array.length-1])
				array[i]=0;
			else if(array[i]!=array[array.length-1])
				array[i]=array[i+1];
		}
		printArray(array);
		s.close();
	}
	public static void printArray(int[] a) {
		int k=0;
		for (int i : a) {
			if(i!=0)
			System.out.print(String.format("Array[%d]: %d\n", (k+1),i));
			k++;
		}
	}
}
