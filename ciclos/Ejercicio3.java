/**
 * Leer un numero e indicar si es par o impar. El proceso se repite hasta que se introduzca un 0
 */
package ciclos;
import java.util.Scanner;
public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int i=0;
		do {
			System.out.print("Ingresa un numero: ");
			i=s.nextInt();
			if((i%2==0))
				System.out.println("El numero es Par");
			else if(i%2!=0)
				System.out.println("El numero es Impar");
		}while(i!=0);
		s.close();

	}

}
