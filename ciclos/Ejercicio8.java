/**
 * Pedir un numero N, y mostrar todos los numeros del 1 al N
 * 
 */
package ciclos;
import java.util.Scanner;
public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("Ingresa un numero: ");
		int n=s.nextInt();
		for(int i=1;i<=n;i++)
			System.out.println(i);
		s.close();

	}

}
