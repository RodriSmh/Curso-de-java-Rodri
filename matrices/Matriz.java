package matrices;

import java.util.Scanner;

public class Matriz {
	static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
//		int matriz[][]= {{1,2,3},{4,5,6},{7,8,9}};
		int matriz[][]=defineMatriz();
		matriz=llenaMatriz(matriz);
		imprimeMatriz(matriz);
	}
	public static int[][] defineMatriz() {
		int nFilas,nColumnas;
		System.out.print("Ingresa el numero de filas: ");
		nFilas=s.nextInt();
		System.out.print("Ingresa el numero de columnas: ");
		nColumnas=s.nextInt();
		int matriz[][]=new int[nFilas][nColumnas];
		return matriz;
	}
	public static int[][] llenaMatriz(int matriz[][]) {
		
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(String.format("Matriz[%d]\n",i+1));
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(String.format("Matriz[%d][%d]= ",i+1,j+1));
				matriz[i][j]=s.nextInt();
			}
			System.out.println();
		}
		
		
		return matriz;
	}
	public static void imprimeMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j]+" - ");
			}
			System.out.println();
		}
	}

}
