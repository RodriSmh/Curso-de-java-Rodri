package matrices;

/**
 * Crea y carga una matriz de tamaño n x m y decir si es simetrica o no
 */
public class Ejercicio01 {

	public static void main(String[] args) {
		boolean simetrica=true;
		int matriz[][]=Matriz.defineMatriz();
		Matriz.llenaMatriz(matriz);
		simetrica(matriz,simetrica);
		
	}
	public static void simetrica(int matriz[][],boolean simetrica) {
		if(matriz.length==matriz[0].length) {
			int i=0,j;
			while(i<matriz.length&&simetrica==true) {
				j=0;
				while(j<i&&simetrica==true) {
					if(matriz[i][j]!=matriz[j][i])
						simetrica=false;
					j++; 
				}
				i++;
			}
			if(simetrica==true)
				System.out.println("La matriz es simetrica");
			else
				System.out.println("la matriz no es simetrica");;
		}else
			System.out.println("la matriz no es simetrica");;
	}

}
