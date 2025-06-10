/**
 * Pide un numero 0 a 1
 * mostrar la tabla de multiplicar
 * */

package ciclos;
import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int tabla=-1;
		
		while (tabla>10||tabla<0) {
		System.out.print("Ingresa una tabla de multiplicar: ");
				tabla =s.nextInt();
		}
		for (int i = 1; i <= 10; i++) {
			System.out.println(i+"X"+tabla+"= "+(i*tabla));
		}
		s.close();

	}

}
