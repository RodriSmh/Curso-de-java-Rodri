package ciclos;

/**
 * Dada las estaturas y edades de 5 alumnos, 
 * calcular la media de estaturas,
 * contar la cantidad de alumnos con 18 años
 * cantidad de alumnos mayores de 1.75 m 
 */
import java.util.Scanner;
public class Ejercicio15 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		double estaturas=0,estatura=0;
		int nEstaturasMayores=0,edades=0,edad;
		for (int i = 0; i < 5; i++) {
			System.out.print("Ingresa la altura del alumno "+(i+1)+": ");
			estatura=s.nextDouble();
			if(estatura>1.75)
				nEstaturasMayores++;
			estaturas+=estatura;
			System.out.print("Ingresa la edad del alumno "+(i+1)+": ");
			edad=s.nextInt();
			if(edad>18)
				edades++;
		}
		System.out.println("La estatura media del grupo es: "+(estaturas/5)+
							"\nLa cantidad de alumnos mayores de 18 son: "+(edades)+
							"\nLa cantidad de alumnos con estatura mayor a 1.75 son: "+nEstaturasMayores);
		s.close();
	}
}
