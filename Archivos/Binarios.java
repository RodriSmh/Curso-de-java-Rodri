package Archivos;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Binarios {

	private ObjectInputStream lectura;
	private void escribirBinario() {
		try {
			FileOutputStream archivo=new FileOutputStream("CursoDJava/Archivos/personas.bin");
			ObjectOutputStream escritura=new ObjectOutputStream(archivo);
			
			Persona persona1=new Persona("Qetzalli", 28);
			Persona persona2=new Persona("Rodrigo",28);
			
			escritura.writeObject(persona1);
			escritura.writeObject(persona2);
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void añadirBinario() {
		try {
			FileOutputStream archivo=new FileOutputStream("CursoDJava/Archivos/personas.bin",true);
			AñadirContenido escritura=new AñadirContenido(archivo);
			
			Persona persona1=new Persona("Victor", 28);
			Persona persona2=new Persona("Yoel",28);
			
			escritura.writeObject(persona1);
			escritura.writeObject(persona2);
			escritura.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void leerBinario() {
	    Persona persona;
	    try {
	        FileInputStream archivo = new FileInputStream("CursoDJava/Archivos/personas.bin");
	        lectura = new ObjectInputStream(archivo);
	        
	        while (true) {
	            try {
	                persona = (Persona) lectura.readObject();
	                System.out.println(persona.toString()); // Imprime los datos
	            } catch (EOFException e) {
	                break; // Sale del bucle al final del archivo
	            }
	        }
	        
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (lectura != null) {
	                lectura.close(); // Cierra el flujo
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public static void main(String[] args) {
		Binarios archivo=new Binarios();
		archivo.escribirBinario();
		archivo.añadirBinario();
		archivo.leerBinario();
		

	}

}
