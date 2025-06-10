/**
 *Pedir 10 numeros, y mostrar al final si se ha introducido alguno negativo. 
 */
package ciclos;

import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int numero=0,f=0;
		
		for (int i = 0; i < 10; i++) {
			System.out.print("Introduce el numero "+(i+1)+": ");
			numero=s.nextInt();
			if(numero<0)
				f=1;
		}
		switch (f) {
		case 1:
			System.out.println("Se introdujo algun negativo ");
			break;
		case 0:
			System.out.println("No se introdujo algun negativo");
			break;
		}
		s.close();

	}

}
