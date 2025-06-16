package matrices;

/**
 * Crear y cargar dos matrices de tamaño 3x3, sumarlas y mostrar su suma
 */
public class Ejercicio02 {

	public static void main(String[] args) {
		int matriz1[][]=new int [3][3];
		int matriz2[][]=new int [3][3];
		int suma[][]=new int[3][3];
		Matriz.llenaMatriz(matriz1);
		Matriz.llenaMatriz(matriz2);
		for (int i = 0; i < suma.length; i++) {
			for (int j = 0; j < suma.length; j++) {
				suma[i][j]+=matriz1[i][j]+matriz2[i][j];
			}
		}
		System.out.println("La suma de las dos matrices es: ");
		Matriz.imprimeMatriz(suma);

	}

}
