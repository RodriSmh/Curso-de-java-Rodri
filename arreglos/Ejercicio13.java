package arreglos;

/**
 * Leer 10 numeros
 * guardar en otra tabla los pares de la primera,
 * despues los impares.
 */
public class Ejercicio13 {

	public static void main(String[] args) {
		int array[]=new int[10];
		int par[]=new int[10];
		int impar[]=new int[10];
		Ejercicio04.fill(array);
		int cPar=0,cImpar=0;
		for (int i = 0; i < 10; i++) {
			if(array[i]%2==0) {
				par[cPar]=array[i];
				cPar++;
			}
		}
		for (int i = 0; i < 10; i++) {
			if(array[i]%2==1) {
				impar[cImpar]=array[i];
				cImpar++;
			}
		}
		
		
		Ejercicio04.printArray(par,cPar);
		Ejercicio04.printArray(impar,cImpar);
	}

}
