package arreglos;
import java.util.Scanner;

/**
 *  Leer dos series de 10 numeros, que estaran ordenados crecientemente.
 *  fusionar las dos tablas, de forma que sigan ordenadas
 */
public class Ejercicio14 {

	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		int  a[]=new int[10];
		int  b[]=new int[10];
		int  c[]=new int[20];
		System.out.println("Ingresa el primer arreglo");
		arrayCreciente(a);
		System.out.println("Ingresa el segundo arreglo");
		arrayCreciente(b);
		
		int i=0,j=0,k=0;
		while(i<10&&j<10) {
			if(a[i]<b[j]) {
				c[k]=a[i];
				i++;
			}else {
				c[k]=b[j];
				j++;
			}
			k++;
		}
		if(i==10) {
			while(j<10) {
				c[k]=b[j];
				j++;
				k++;
			}
		}else {
			while(i<10) {
				c[k]=a[i];
				i++;
				k++;
			}
		}
		System.out.println("El resultado del tercer arreglo:");
		Ejercicio04.printArray(c);
		
	}
	public static void arrayCreciente(int[]a) {
		boolean creciente=true;
		do {
			for (int i = 0; i < a.length; i++) {
				System.out.print(String.format("Ingresa el numero %d: ", (i+1)));
				a[i]=s.nextInt();
			}
			for (int i = 0; i < a.length-1; i++) {
				if(a[i]<a[i+1])
					creciente=true;
				else if(a[i]>a[i+1]||a[i]==a[i+1]) {
					creciente=false;
					System.out.println("El arreglo no esta ordenado");
					break;
				}
			}
		}while(creciente==false);
	}

}
