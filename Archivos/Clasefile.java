package Archivos;
import java.io.File;

public class Clasefile {

	public static void main(String[] args) {
		File archivo=new File("CursoDJava/Archivos/archivo.txt");
		
		if(archivo.exists())
			System.out.println("El archivo existe");
		else
			System.out.println("El archivo no existe");
	}

}
