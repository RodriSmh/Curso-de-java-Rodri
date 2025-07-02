package Archivos.ejercicio01;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Archivo {
	private File archivo;
	
	public void crearArchivo() {
		archivo= new File("CursoDJava/Archivos/ejercicio01/agendaContactos.txt");
		try {
			
			if(archivo.createNewFile()) {
				System.out.println("Se creo el archivo correctamente: "+archivo.getAbsolutePath());
			}
			if(archivo.exists())
				System.out.println("si existe");
		} catch (IOException e) {
			System.out.println("no se pudo crear bro");
			System.err.print(e.getMessage());
			e.printStackTrace();
		}
	}
	public void escribirTexto(Persona persona) {
		
		try {
			FileWriter escribir=new FileWriter(archivo, true);
			escribir.write(persona.getNombre()+"%"+persona.getCorreo()+"%"+persona.getTelefono()+"\r\n");
			escribir.close();
		} catch (IOException e) {
			System.out.println("no se pudo escribir bro");
			e.printStackTrace();
		}
	}

}
