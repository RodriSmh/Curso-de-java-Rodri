package matrices;

/**
 * Crear y cargar una matriz tamaño NxM, mostrando la suma de cada fila y cada columna
 */
public class Ejercicio05 {

	public static void main(String[] args) {
		int matriz[][]=Matriz.defineMatriz();
		Matriz.llenaMatriz(matriz);
		int sFila=0,sColumna=0;
		Matriz.imprimeMatriz(matriz);
		for (int i = 0; i < matriz.length; i++) {
			sFila=0;
			for (int j = 0; j < matriz[0].length; j++) {
				sFila+=matriz[i][j];
			}
			System.out.println(String.format("La suma de la fila %d es: %d",(i+1),sFila));
		}
		for (int j = 0; j < matriz[0].length; j++) {
			sColumna=0;
			for (int i = 0; i < matriz.length;i++) {
				sColumna+=matriz[i][j];
			}
			System.out.println(String.format("La suma de la columna %d es: %d",(j+1),sColumna));
		}

	}

}
