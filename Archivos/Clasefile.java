package Archivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Clasefile {
    private File archivo;
    private Scanner s = new Scanner(System.in);

    public Clasefile() {
        // Inicializar con un archivo por defecto
        this.archivo = new File("CursoDJava/Archivos/prueba.txt");
    }

    public static void main(String[] args) {
        Clasefile file = new Clasefile();
        int menu = 0;
        do {
            System.out.println("\nMenu de archivos");
            System.out.println("1. Crear archivo");
            System.out.println("2. Crear carpeta");
            System.out.println("3. Escribir texto");
            System.out.println("4. Leer archivo");
            System.out.println("0. Salir");
            System.out.print("Ingresa una opción: ");
            menu = file.s.nextInt();
            file.s.nextLine();
            System.out.println();
            switch (menu) {
                case 1: file.crearArchivo(); break;
                case 2: file.creaCarpeta(); break;
                case 3: file.escribirTexto(); break;
                case 4: file.leerArchivo();break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (menu != 0);
        file.s.close();
    }

    private void creaCarpeta() {
        // Asignamos directamente a this.archivo
        this.archivo = new File("CursoDJava/Archivos/Ejercicio01");
        if (this.archivo.mkdirs()) {
            System.out.println("Directorio creado: " + this.archivo.getPath());
            // Ahora apuntamos el archivo al TXT dentro de esta carpeta
            this.archivo = new File(this.archivo, "prueba.txt");
        } else {
            System.out.println("Error al crear el directorio.");
        }
    }

    private void escribirTexto() {
        try {
            if (!this.archivo.exists()) {
                System.out.println("El archivo no existe. Creándolo...");
                if (this.archivo.createNewFile()) {
                    System.out.println("Archivo creado: " + this.archivo.getName());
                }
            }
            
            FileWriter escribir = new FileWriter(this.archivo, true);
            System.out.print("Ingrese texto: ");
            String cadena = "\r\n"+s.nextLine();
            escribir.write(cadena + "\n");
            escribir.close();
            System.out.println("Texto escrito correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }
    private void leerArchivo() {
    	String cadena;
    	try {
			FileReader leer=new FileReader(archivo);
			BufferedReader lectura=new BufferedReader(leer);
			
			do {
				
				cadena= lectura.readLine();
				if(cadena!=null)
					System.out.println(cadena);
			}while(cadena!=null);
			lectura.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void crearArchivo() {
        try {
            if (this.archivo.createNewFile()) {
                System.out.println("Archivo creado: " + this.archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}