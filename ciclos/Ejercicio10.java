package ciclos;
/**
 *  Mostrar la suma de 10 numeros 
 */
import java.util.Scanner;
public class Ejercicio10 {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int suma=0;
		for (int i = 0; i < 10; i++) {
			System.out.print("Ingresa un numero "+(i+1)+" a sumar: ");
			suma+=s.nextInt();
		}
		System.out.println("La suma total es: "+suma );
		s.close();
	}

}
