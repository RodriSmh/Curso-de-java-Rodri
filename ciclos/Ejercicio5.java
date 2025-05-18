/**
 * Realizar un juego para adivinar un numero. Generar un numero de 1 - 100 , ir indicando si el numero es mayor o menor
 * 
 */
package ciclos;
import java.util.Scanner;
import java.util.Random;
public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Random r=new Random();
		int i=0,a=r.nextInt(100),c=0;
		do {
			System.out.print("Ingresa un numero: ");
			i=s.nextInt();
			if(i>a)
				System.out.println("Ingresaste un numero mayor");
			else if (i<a)
				System.out.println("Ingresaste un numero menor");
			c++;
		}while(i!=a);
		System.out.println("La cantidad de intentos fue: "+ c);
		s.close();
	}

}
