package arreglos;

import java.util.Scanner;

/**
 * Leer 10 numeros enteros y desplace N posiciones en el arreglo
 */
public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int array[]=new int[10];
		int nPosicion=0;
		Ejercicio04.fill(array);
		System.out.print("Ingrese el numero de posicion a desplazar: ");
		nPosicion=s.nextInt();
		int aux;
		
		for (int i = 1; i <= nPosicion; i++) {
			aux=array[array.length-1];
			for (int j = array.length-2; j >=0; j--) {
				array[j+1]=array[j];		
			}
			array[0]=aux;
							
		}
		Ejercicio04.printArray(array);
		s.close();
	}
	

}
