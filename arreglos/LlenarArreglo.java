package arreglos;

import java.util.Scanner;

public class LlenarArreglo {

	public static void main(String[] args) {
		int nElementos=0;
		Scanner s=new Scanner(System.in);
		System.out.print("Ingrese la cantidad de caracteres deseadas: ");
		nElementos=s.nextInt();
		char [] letras=new char[nElementos];
		System.out.println("Digite los elementos del arreglo");
		for (int i = 0; i < nElementos; i++) {
			System.out.print((i+1)+" Ingrese un caracter: ");
			letras[i]=s.next().charAt(0);
		}
		
		for (int i = 0; i < letras.length; i++) {
			System.out.print(letras[i]+" ");
		}
		s.close();

	}

}
