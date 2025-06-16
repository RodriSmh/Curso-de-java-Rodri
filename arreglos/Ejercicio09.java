package arreglos;
//import java.util.Scanner;

/**
 * Leer 10 numeros enteros
 * desplace una posicion hacia abajo
 * primero, se hace segundo, segundo, tercero, ultimo, primero
 */
public class Ejercicio09 {

	public static void main(String[] args) {
//		Scanner s=new Scanner(System.in);
		int array[]=new int[10];
		Ejercicio04.fill(array);
		int aux=array[9];
		for (int i = array.length-1; i >= 0; i--) {
			if(i==0) {
				array[i]=aux;
				break;
			}
			else
				array[i]=array[i-1];	
		}
		Ejercicio04.printArray(array);

	}

}
