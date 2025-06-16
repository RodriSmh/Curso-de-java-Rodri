package arreglos;
import java.util.Scanner;

/**
 * Leer 10 numeros enteros, guardarlos en un arreglo. Mostrarlo en el orden
 * primero,ultimo,segundo,antepenultimo,tercero, etc.
 */
public class Ejercicio04 {

	public static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		int lista[]=new int[10];
		fill(lista);
		for (int i = 0; i < 5; i++) {
			System.out.print(lista[i]+" ");
			System.out.print(lista[9-i]+" ");
		}
		s.close();
	}
	public static void fill(int[] lista) {
		for (int i = 0; i < lista.length; i++) {
			System.out.print(String.format("Ingresa el numero %d: ", (i+1)));
			lista[i]=s.nextInt();
		}
	}
	public static int [] fill() {
		int[] lista=new int[10];
		for (int i = 0; i < lista.length; i++) {
			System.out.print(String.format("Ingresa el numero %d: ", (i+1)));
			lista[i]=s.nextInt();
		}
		return lista;
	}
	public static void fill(int[] lista,int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(String.format("Ingresa el numero %d: ", (i+1)));
			lista[i]=s.nextInt();
		}
	}
	public static void printArray(int[] a) {
		int k=0;
		for (int i : a) {
			System.out.print(String.format("Array[%d]: %d\n", (k+1),i));
			k++;
		}
	}
	public static void printArray(int[] a,int c) {
		int k=0;
		for (int i : a) {
			if(k<c) {
				System.out.print(String.format("Array[%d]: %d\n", (k+1),i));
				k++;
			}
		}
	}


}
