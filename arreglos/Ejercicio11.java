package arreglos;
import java.util.Scanner;

/**
 * Leer 5 elementos numericos que se introduciran ordenados de forma creciente.
 * Estos se guardaran en una tabla de tamaño 10. Leer un Numero N
 * insertarlo en el lugar adecuado para que la tabla continue ordenada
 */
public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int array[]=new int[10];
		boolean creciente=true;
		int n,j=0,aux=0;
		do {
			for (int i = 0; i < 5; i++) {
				System.out.print(String.format("Ingresa el numero %d: ", (i+1)));
				array[i]=s.nextInt();
			}
			for (int i = 0; i < 4; i++) {
				if(array[i]<array[i+1])
					creciente=true;
				else {
					creciente=false;
					break;					
				}
			}
			if(!creciente)
				System.out.println("Error, el arreglo no esta ordenado.\n");
		}while(!creciente);
		System.out.print("Digite un numero: ");
		n=s.nextInt();
		while(array[j]<n&&j<5) {
			aux++;
			j++;
		}
		for(int i=4;i>=aux;i--)
			array[i+1]=array[i];
		array[aux]=n;
		Ejercicio04.printArray(array);
		s.close();
	}

}
