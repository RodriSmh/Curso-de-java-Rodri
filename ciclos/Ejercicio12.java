package ciclos;

/**
 * Calcular el numero factorial de un numero dado
 */
import java.util.Scanner;
public class Ejercicio12 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("Ingresa un numero n: ");
		int n=s.nextInt(),factorial=1;
		for (int i = 1; i <=n; i++) {
			factorial*=i;
		}
		System.out.println("Factorial "+factorial);
		s.close();
	}

}
