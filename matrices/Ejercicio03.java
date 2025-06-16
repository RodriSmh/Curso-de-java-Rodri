package matrices;

/**
 * hallar la matriz transpuesta
 */
public class Ejercicio03 {

	public static void main(String[] args) {
		int matriz[][]=new int [3][3];
		int aux=0;
		Matriz.llenaMatriz(matriz);
		System.out.println("Matriz original");
		Matriz.imprimeMatriz(matriz);
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j <i; j++) {
				
				aux=matriz[i][j];
				matriz[i][j]=matriz[j][i];
				matriz[j][i]=aux;
			}
		}
		System.out.println("Matriz transpuesta");
		Matriz.imprimeMatriz(matriz);
	}

}
