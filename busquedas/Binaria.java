package busquedas;

import java.util.Scanner;

public class Binaria {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		int array[]= {1,3,5,7,9};
		
		System.out.print("Ingresa un dato a buscar: ");
		int dato=s.nextInt();
		
		if(binaria(array,dato)==-1)
			System.out.println("Dato no encontrado");
		else
			System.out.println("La posicion del dato es: "+((binaria(array,dato)+1)));

	}
	public static int binaria(int array[],int dato) {
		int sup=array.length,mitad,inf=0,i=0;
		boolean f=false;
		mitad=(sup+inf)/2;
		
		while(inf<sup&&i<array.length) {
			if(array[mitad]==dato) {
				f=true;
				break;
			}
			if(array[mitad]>dato) {
				sup=mitad;
				mitad=(sup+inf)/2;
			}
			if(array[mitad]<dato) {
				inf=mitad;
				mitad=(sup+inf)/2;
			}i++;
			
		}
		if(f==true)
			return mitad;
		else
			return -1;
	}

}
