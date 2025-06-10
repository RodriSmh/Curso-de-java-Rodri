package ciclos;

/**
 * pedir 10 numeros. mostrar la media de los numeros positivos, la media de numero negativos, y la cantidad de ceros
 */
import java.util.Scanner;
public class Ejercicio13 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int num=0,ceros=0,positivos=0,cPositivos=0,cNegativos=0,negativos=0;
		for (int i = 0; i < 10; i++) {
			System.out.print("Ingresa un numero: ");
			num=s.nextInt();
			if(num==0)
				ceros++;
			else if(num>0) {
				cPositivos++;
				positivos+=num;
			}
			else if (num<0) {
				cNegativos++;
				negativos+=num;
			}
		}
		System.out.print("La cantidad de ceros fue: "+ceros+"\n"+
						"La Media de numeros positivos es: "+(positivos/cPositivos)+"\n"+
						"La media de numeros negativos es; "+(negativos/cNegativos));
		s.close();

	}

}
