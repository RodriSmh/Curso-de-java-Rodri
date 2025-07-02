package Archivos.ejercicio02;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AñadirBinario extends ObjectOutputStream{
	
	public AñadirBinario (OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}
	public AñadirBinario () throws IOException, SecurityException{
		
	}
	@Override
	public void writeStreamHeader() throws IOException {
		File archivo = new File("CursoDJava/Archivos/ejercicio02/RegistroAtletas.bin");
		if(archivo.length()==0)
			super.writeStreamHeader();
		else
			reset();
	}

}
