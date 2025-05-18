/**
 * Contador de numeros, terminar hasta teclear un numero negativo
 */
package ciclos;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int i=0,c=0;
		do {
			System.out.print("Ingresa un numero: ");
			i=s.nextInt();
			if(i>0)
				c++;
		}while(i>0);
		System.out.println("La cantidad de numeros positivos fue: "+ c);
		s.close();

	}

}
