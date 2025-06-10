/**
 * Dadas 6 notas, escribir la cantidad de alumnos aprobados, codicionados (=4) y suspensos 
 */
package ciclos;

import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		float notas=0;
		int cAprovados=0,cCondicionado=0,cSuspensos=0;
		for (int i = 1; i <=6; i++) {
			do {
				System.out.print("\n\tAlumno "+i+":\n"
						+ "Ingresa la calificacion del alumno "+i+": ");
				notas=s.nextFloat();
				
			}while(notas<0||notas>10);
			if(notas==4)
				cCondicionado++;
			if(notas>4)
				cAprovados++;
			if(notas<4)
				cSuspensos++;
		}
		System.out.print("Cantidad de aprovados: "+cAprovados+"\n"
				+ "Cantidad de Condicionados: "+cCondicionado+"\n"
						+ "Cantidad de suspensos: "+cSuspensos);
		s.close();
	}

}
