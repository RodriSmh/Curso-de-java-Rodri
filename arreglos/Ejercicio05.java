package arreglos;

import java.util.Scanner;

/**
 * Mezclar 2 arreglos de la forma 1° de A, 1°de B, etc
 */
public class Ejercicio05 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a[],b[],c[];
		a=new int[10];
		b=new int[10];
		c=new int[20];
		
		Ejercicio04.fill(a);
		Ejercicio04.fill(b);
		int j=0;
		for (int i = 0; i < 10; i++) {
			c[j]=a[i];
			j++;
			c[j]=b[i];
			j++;
		}
		
//		int j=0,k=0;
//		for (int i = 0; i < c.length; i++) {
//			if(i%2==0) {
//				c[i]=a[j];
//				j++;
//			}else if(i%2==1) {
//				c[i]=b[k];
//				k++;
//			}
//		}
		for (int i : c) {
			System.out.println(i);
		}
		s.close();

	}

}
