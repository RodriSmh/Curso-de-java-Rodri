/**
 * Pedir un numero N, introducir N sueldos, y mostrar el sueldo maximo 
 */
package ciclos;

import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=0;
		float sueldo=0,maximo=0;
		
		while(n<=0){
			System.out.print("Ingresa la cantidad de sueldos: "); 
			n=s.nextInt();
		}
				
		for (int i = 0; i < n; i++) {
			System.out.print("Ingresa el sueldo "+(i+1)+": ");
			sueldo=s.nextFloat();
			if(sueldo>maximo)
				maximo=sueldo;
		}	
		System.out.println("El sueldo maximo es: "+maximo);
		
		s.close();
		
	}

}
