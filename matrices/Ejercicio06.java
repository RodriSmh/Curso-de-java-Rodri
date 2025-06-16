package matrices;

/**
 * Utilizando dos matrices de tamaño 5x9 y 9x5, cargar la primera y transponerla en al segunda
 */
public class Ejercicio06 {

	public static void main(String[] args) {
		int matriz [][]=new int[5][9];
		int transpuesta[][]=new int[9][5];
		Matriz.llenaMatriz(matriz);
		Matriz.imprimeMatriz(matriz);
		int aux=0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				
				transpuesta[j][i]=matriz[i][j];
			}
		}
		Matriz.imprimeMatriz(transpuesta);

	}

}
