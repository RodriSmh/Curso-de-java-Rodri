package ciclos;

/**
 * Pedir 10 sueldos, mostrar la suma y mostrar cuantos son mayores a 1000
 */
import java.util.Scanner;
public class Ejercicio14 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int mayores=0,suma=0,num=0;
		for (int i = 0; i < 10; i++) {
			System.out.print("Ingresa el sueldo del empleado "+(i+1)+": ");
			num=s.nextInt();
			suma+=num;
			if(num>1000)
				mayores++;
		}
		System.out.println("La suma de los sueldos es: "+suma+"\n"+
						"la cantidad de empleados con un sueldo mayor a 1000 es: "+mayores);
		s.close();

	}

}
