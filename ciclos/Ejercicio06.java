/**
 * Pedir numeros hasta que se indique 0, mostrar la suma
 * 
 */
package ciclos;
import java.util.Scanner;
public class Ejercicio06 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int i=0,suma=0;
		do {
			System.out.print("Ingresa un numero: ");
			i=s.nextInt();
			suma+=i;
		}while(i!=0);
		System.out.println("La cantidad total de la suma fue: "+ suma);
		s.close();

	}
}