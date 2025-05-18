/**
 * Leer un numero e indicar si es postivo o negativo. El proceso se repite hasta que se introduzca un 0
 */
package ciclos;
import java.util.Scanner;
public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int i=0;
		do {
			System.out.print("Ingresa un numero: ");
			i=s.nextInt();
			if((i<0))
				System.out.println("El numero es negativo");
			else if(i>0)
				System.out.println("El numero es positivo");
		}while(i<0||i>0);
		s.close();

	}

}
