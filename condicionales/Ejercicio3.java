/**
 * 30 Ejercicio 3 determinar si una letra es mayuscula o minuscula 
 */
package condicionales;
import java.util.Scanner;
public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("Ingresa una letra: ");
		char letra=s.next().charAt(0);
		if(Character.isUpperCase(letra))
			System.out.println("La letra es mayuscula");
		else if (Character.isLowerCase(letra))
			System.out.println("La letra es minuscula");
		else 
			System.out.println("El caracter ingresado no es una letra");
		s.close();
	}

}
