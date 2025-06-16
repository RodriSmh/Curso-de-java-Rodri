package matrices;

public class Ejercicio04 {

	public static void main(String[] args) {
		int matriz[][]=new int[7][7];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if(i==j)
					matriz[i][j]=1;
				else
					matriz[i][j]=0;
			}
		}
		Matriz.imprimeMatriz(matriz);

	}

}
