package matrices;

/**
 * Crear una matriz "marco" de tamaño 5x5: todos sus elementos deben ser 0 salvo los bordes que
 * deben de ser 1
 */
public class Ejercicio07 {

	public static void main(String[] args) {
		int matriz[][]=new int[5][5];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if(i==0||i==4||j==0||j==4)
					matriz[i][j]=1;
			}
		}
		Matriz.imprimeMatriz(matriz);

	}

}
