/**
 *Hacer unas modificaciones al ejercicio anterior suponiendo que no se introduce el precio por litro. solo exiten 3 produtos con precios: 
 *1- 0,6$/litro
 *2- 3$/litro
 *3- 1,25$/litro
 */

package ciclos;

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String codigo;
		int litros,mayor600=0;
		float importeFactura=0,importeFacturaTotal=0,litrosArticulo1=0;
		for (int i = 0; i < 5; i++) {
			System.out.println("\n\tProducto "+(i+1)+"\n");
			System.out.print("Ingresa el codigo del producto "+(i+1)+": "); codigo=s.next();
			System.out.print("Ingresa la cantidad de litros: "+(i+1)+": "); litros=s.nextInt();
			//System.out.print("Ingresa el precio del producto "+(i+1)+": "); precioLitros=s.nextFloat();
			if(codigo.equals("1"))			
				importeFactura= litros * 0.6f;
			if(codigo.equals("2"))			
				importeFactura= litros * 3f;
			if(codigo.equals("3"))			
				importeFactura= litros * 1.25f;

			importeFacturaTotal+=importeFactura;
			if(codigo.equals("1"))
				litrosArticulo1+=litros;
			if(importeFactura>=600)
				mayor600++;
			System.out.println("Importe de factura "+(i+1)+": "+importeFactura);
		}
		System.out.print("\n\tResumen de ventas \n"
				+ "Facturacion total: "+importeFacturaTotal
				+ "\nNumero de facturas mayores a 600: "+mayor600+"\n"
				+ "Cantidad de litros del articulo 1: "+litrosArticulo1);
		s.close();

	}

}
