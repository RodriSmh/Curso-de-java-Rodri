/**
 * 29 Ejercicio 2 comprobar si un numero es mayor a otro o si son iguales
 */
package condicionales;
import java.util.Scanner;
public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("Ingresa un numero: ");
		int num1= s.nextInt();
		System.out.print("Ingresa un numero: ");
		int num2= s.nextInt();
		
		if(num1>num2) 
			System.out.println("El numero mayor es "+ num1);
		else if (num1==num2)
			System.out.println("los numeros son iguales");
		else
			System.out.println("El numero mayor es "+ num2);
		s.close();
	}

}
