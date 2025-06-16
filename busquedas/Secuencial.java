package busquedas;

import java.util.Scanner;

public class Secuencial {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
		//System.out.print("Ingresa el tamaño del arreglo: ");
		int array[]= {4,1,5,2,3};
		
		
		System.out.print("Ingresa un dato a buscar: ");
		int dato=s.nextInt();
		
		if(secuencial(array, dato)==-1)
			System.out.println("Dato no encontrado");
		else
			System.out.println("La posicion es: "+(secuencial(array, dato)+1));
	}
	public static int secuencial(int array[],int dato) {
		int i=0;
		boolean flag=false;
		while(i<array.length&&flag==false) {
			if(array[i]==dato) {
				flag=true;
				break;
			}
			i++;
		}
		if(flag==true) {
			return i;			
		}else
		return -1;
	}

}
