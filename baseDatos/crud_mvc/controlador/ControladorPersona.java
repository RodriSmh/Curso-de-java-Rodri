package baseDatos.crud_mvc.controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import baseDatos.crud_mvc.modelo.ConsultasPersona;
import baseDatos.crud_mvc.modelo.ModeloPersona;
import baseDatos.crud_mvc.vista.VistaPersona;
public class ControladorPersona implements ActionListener{
	private VistaPersona vista;
	private ModeloPersona persona;
	private ConsultasPersona modelo;
	
	public ControladorPersona(VistaPersona vista, ModeloPersona persona, ConsultasPersona modelo) {
		super();
		this.vista = vista;
		this.persona = persona;
		this.modelo = modelo;
		vista.btnInsertar.addActionListener(this);
		vista.btnLimpiar.addActionListener(this);
		vista.btnBuscar.addActionListener(this);
		vista.btnModificar.addActionListener(this);
		vista.btnEliminar.addActionListener(this);
	}
	public void iniciar() {
		vista.setTitle("CRUD mvc");
		vista.setLocationRelativeTo(null);
		vista.tbIdPersona.setVisible(false);
	}
	public void limpiarCajas() {
		vista.tbIdPersona.setText("");
		vista.tbClave.setText("");
		vista.tbBuscar.setText("");
		vista.tbIdPersona.setText("");
		vista.tbNombre.setText("");
		vista.tbDomicilio.setText("");
		vista.tbCelular.setText("");
		vista.tbCorreoElectronico.setText("");
		vista.tbFechaNacimiento.setText("");
		vista.cbGenero.setSelectedIndex(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vista.btnInsertar) {
			persona.setClave(vista.tbClave.getText());
			persona.setNombre(vista.tbNombre.getText());
			persona.setDomicilio(vista.tbDomicilio.getText());
			persona.setCelular(vista.tbCelular.getText());
			persona.setCorreo_electronico(vista.tbCorreoElectronico.getText());
			persona.setFecha_nacimiento(Date.valueOf(vista.tbFechaNacimiento.getText()));
			persona.setGenero(vista.cbGenero.getSelectedItem().toString());
			limpiarCajas();
			if(modelo.insertar(persona)) {
				JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al insertar registro");	
				limpiarCajas();
			}
		}else if(e.getSource()==vista.btnLimpiar)
			limpiarCajas();
		else if(e.getSource()==vista.btnBuscar) {
			persona.setClave(vista.tbBuscar.getText());
			if(modelo.buscar(persona)) {
				vista.tbClave.setText(persona.getClave());
				vista.tbIdPersona.setText(String.valueOf(persona.getIdPersona()));
				vista.tbNombre.setText(persona.getNombre());
				vista.tbDomicilio.setText(persona.getDomicilio());
				vista.tbCelular.setText(persona.getCelular());
				vista.tbCorreoElectronico.setText(persona.getCorreo_electronico());
				vista.tbFechaNacimiento.setText(persona.getFecha_nacimiento().toString());
				vista.cbGenero.setSelectedItem(persona.getGenero());
			}else {
				JOptionPane.showMessageDialog(null, "Error al buscar");
				vista.limpiarCajas();
			}
				
		}else if(e.getSource()==vista.btnModificar) {
			persona.setIdPersona(Integer.parseInt(vista.tbIdPersona.getText()));
			persona.setClave(vista.tbClave.getText());
			persona.setNombre(vista.tbNombre.getText());
			persona.setDomicilio(vista.tbDomicilio.getText());
			persona.setCelular(vista.tbCelular.getText());
			persona.setCorreo_electronico(vista.tbCorreoElectronico.getText());
			persona.setFecha_nacimiento(Date.valueOf(vista.tbFechaNacimiento.getText()));
			persona.setGenero(vista.cbGenero.getSelectedItem().toString());
			if(modelo.modificar(persona)) {
				JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
				limpiarCajas();
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al modificado registro");	
				limpiarCajas();
			}
		}else if(e.getSource()==vista.btnEliminar) {
			persona.setIdPersona(Integer.parseInt(vista.tbIdPersona.getText()));
			
			if(modelo.Eliminar(persona)) {
				JOptionPane.showMessageDialog(null, "Registro se ha eliminado correctamente");
				limpiarCajas();
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al eliminar registro");	
				limpiarCajas();
			}
		}
			
	}
}
