/**
 * Pedir 5 calificaciones de alumnos y decir al final si hay algun suspenso.
 */
package ciclos;

import java.util.Scanner;

public class Ejercicio22 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int calificacion=0;
		boolean reprobado=false;
		for (int i = 0; i <5;i++) {
			System.out.print("Ingrese la calificacion 1: ");
			calificacion=s.nextInt();
			if(calificacion<6)
				reprobado=true;
		}
		if(reprobado==true)
			System.out.println("Hay alumnos reprobados");
		if(reprobado==false)
			System.out.println("No hay alumnos reprobados");
		
		s.close();
	}

}
