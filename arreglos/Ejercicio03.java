package arreglos;
import java.util.Scanner;
public class Ejercicio03 {
	/**
	 * Leer 5 numeros por teclado,
	 * almacenarlos en un arreglo
	 * realizar la media de los numeros positivos
	 * la media de los numeros negativos
	 * contar los ceros
	 */
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int []num=new int[5];
		int positivos=0,cPositivos=0;
		int negativos=0,cNegativos=0;
		int cCeros=0;
		for (int i = 0; i < num.length; i++) {
			System.out.print("Ingrese el numero "+(i+1)+": ");
			num[i]=s.nextInt();
			if(num[i]>0) {
				positivos+=num[i];
				cPositivos++;
			}
			else if (num[i]<0) {
				negativos+=num[i];
				cNegativos++;
			}
			else
				cCeros++;
		}
		System.out.print(String.format("La media de %d numeros positivos es:%.2f \n"
				+ "La media de %d numeros negativos es:%.2f \n"
				+ "La cantidad de ceros es:%d ",cPositivos,media(positivos,cPositivos),cNegativos,media(negativos, cNegativos),cCeros));
		s.close();
	}
	public static float media(float numero,int contador) {
		return numero/contador;
	}

}
