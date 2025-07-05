package baseDatos.crud_mvc;

import baseDatos.crud_mvc.controlador.ControladorPersona;
import baseDatos.crud_mvc.modelo.ConsultasPersona;
import baseDatos.crud_mvc.modelo.ModeloPersona;
import baseDatos.crud_mvc.vista.VistaPersona;

public class CRUD_MVC {

	public static void main(String[] args) {
		VistaPersona vista=new VistaPersona();
		ModeloPersona persona=new ModeloPersona();
		ConsultasPersona modelo=new ConsultasPersona();
		ControladorPersona controlador=new ControladorPersona(vista, persona, modelo);
		controlador.iniciar();
		vista.setVisible(true);
	}

}
