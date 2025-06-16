package arreglos;

import java.util.Scanner;

/**
 * Leer los datos correspondientes a dos tablas de 12 elementos numericos
 * mezclarlos de una tercera de la forma 
 */
public class Ejercicio06 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a[],b[],c[];
		a=new int[6];
		b=new int[6];
		c=new int[12];
		Ejercicio04.fill(a);
		Ejercicio04.fill(b);
		int j=0,i=0;
		while(i<6) {
			for (int k = 0; k < 3; k++) {
				c[j]=a[i+k];
				j++;
			}
			for (int k = 0; k < 3; k++) {
				c[j]=b[i+k];
				j++;
			}
			i+=3;
		}
		for (int it : c) {
			System.out.println(it);
		}
		s.close();
	}

}
