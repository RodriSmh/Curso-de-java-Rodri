package Archivos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AñadirContenido extends ObjectOutputStream{

	public AñadirContenido(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void writeStreamHeader() throws IOException {
		reset();
	}
	
}
