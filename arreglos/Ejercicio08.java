package arreglos;
import java.util.Scanner;

/**
 * Declare una tabla de 10 elementos enteros
 * Leer mediante el teclado 8 numeros.
 * Despues se debe pedir un numero y una posicion, insertarlo en la posicion indicada
 * desplazar los que esten detras
 */
public class Ejercicio08 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int array[]=new int[10];
		int numero=0,posicion=0;
		Ejercicio04.fill(array,8);
		System.out.print("Ingresa un numero: ");
		numero=s.nextInt();
		System.out.println("Ingresa una posicion: ");
		posicion=s.nextInt()-1;
		
		for (int i = 7; i>=posicion; i--)
			array[i+1]=array[i];
		array[posicion]=numero;
		Ejercicio04.printArray(array);
		s.close();

	}

}
