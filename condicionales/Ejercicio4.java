/**
 * 31 Ejercicio 4 hacer 20% de descuento si se hace una compra mayor a 300
 * **/
package condicionales;
import java.util.Scanner;
public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("Ingresa el monto de compra: ");
		float precioCompra=s.nextFloat(),descuento=0;
		if(precioCompra>=300)
			descuento = precioCompra*0.20f;
		System.out.println("El descuento es: "+ (descuento));
		System.out.println("El total a pagar es: "+ (precioCompra-descuento) );
		s.close();
	}
}
