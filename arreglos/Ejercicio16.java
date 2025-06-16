package arreglos;

import java.util.Scanner;

public class Ejercicio16 {

	/**
	 * Se quiere desarrollar una aplicacion que nos ayude a gestionar las notas de un centro educativo.
	 * Cada grupo esta compuesto por 5 alumnos.
	 * Se pide leer notas del primer,segundo y tercer trimestre de un grupo.
	 * Debe mostrar al final: la nota media del grupo de cada trimestre, la media del numero que se encuentra en la posicion N
	 */
	public static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		float primer[]=new float[5],segundo[]=new float[5],tercer[]=new float[5];
		
		System.out.println("Ingrese el primer trimestre");
		calculaParcial(primer,"primer");
		System.out.println("Ingrese el segundo trimestre");
		calculaParcial(segundo, "segundo");
		System.out.println("Ingrese el tercer trimestre");
		calculaParcial(tercer, "tercer");
		int posicion=0;
		do {
			System.out.println("Ingrese la posicion del alumno a buscar: ");
			posicion=s.nextInt()-1;
			if(posicion<0||posicion>4)
				System.out.println("Ingrese una posicion dentro del rango");
		}while(posicion<0||posicion>4);
		System.out.print(String.format("La media del primer parcial es: %.2f\n"
									+ "La media del segundo parcial es: %.2f\n"
									+ "La media del tercer parcial es: %.2f\n"
									+ "La media del alumno %d es: %.2f",promedioParcial(primer),promedioParcial(segundo)
									,promedioParcial(tercer),posicion+1,promedioAlumno(primer, segundo, tercer, posicion)));

	}
	public static void calculaParcial(float array[],String st){
		
		for (int i = 0; i < array.length; i++) {
			do {
				System.out.print(String.format("Ingresa la calificacion del %s parcial del alumno %d: ",st,(i+1)));
				array[i]=s.nextFloat();
			}while(array[i]<0||array[i]>10);
		}
	}
	public static float promedioParcial(float array[]) {
		float promedio=0;
		for (float f : array) {
			promedio+=f;
		}
		return promedio/array.length;
	}
	public static float promedioAlumno(float a[],float b[],float c[],int posicion) {
		float promedio=0;
		
		for (int i = 0; i < a.length; i++) {
			if(posicion==i) {
				promedio+=a[i];
				promedio+=b[i];
				promedio+=c[i];
				break;
			}
		}
		return promedio/3; 
	}

}
