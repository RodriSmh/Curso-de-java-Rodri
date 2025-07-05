package baseDatos.ejemplo_mvc.controlador;

import baseDatos.ejemplo_mvc.modelo.Modelo;
import baseDatos.ejemplo_mvc.vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
	private Vista vista;
	private Modelo modelo;
	public Controlador(Vista vista, Modelo modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		vista.btnSumar.addActionListener(this);
		
		
	}
	public void iniciar() {
		vista.setTitle("MVC sumar");
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		modelo.setNumero1(Integer.parseInt(vista.tbNumero1.getText()));
		modelo.setNumero2(Integer.parseInt(vista.tbNumero2.getText()));
		modelo.sumar();
		
		vista.tbResultado.setText(String.valueOf(modelo.getResultado()));
	}
	
}
