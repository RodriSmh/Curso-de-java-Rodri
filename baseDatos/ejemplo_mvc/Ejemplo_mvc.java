package baseDatos.ejemplo_mvc;

import baseDatos.ejemplo_mvc.controlador.Controlador;
import baseDatos.ejemplo_mvc.modelo.Modelo;
import baseDatos.ejemplo_mvc.vista.Vista;

public class Ejemplo_mvc{
	public static void main(String[] args) {
		Vista vista=new Vista();
		Modelo modelo=new Modelo();
		Controlador controlador=new Controlador(vista,modelo);
		controlador.iniciar();
	}
}