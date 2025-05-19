/**
 * calcular la media de una serie de numeros, parar hasta indicar con 0
 * 
 */
package ciclos;
import java.util.Scanner;
public class Ejercicio07 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int i=0,c=0;
		float suma=0f;
		do {
			System.out.print("Ingresa un numero: ");
			i=s.nextInt();
			suma+=i;
			if(i!=0)
				c++;
		}while(i!=0);
		System.out.println("La cantidad total de la suma fue: "+ suma/c);
		s.close();
	}

}
