package ciclos;
/**
 *Produto de los primeros numero impares  
 */
public class Ejercicio11 {

	public static void main(String[] args) {
		int suma=1;
		for (int i = 1; i < 20; i+=2) {
			suma*=i;
			System.out.println(i+" "+suma);
		}
		System.out.println(suma);

	}

}
