package baseDatos.ComboboxBD.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Ciudad {
	private int idCiudad;
	private String nombreCiudad;
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	@Override
	public String toString() {
		return this.nombreCiudad;
	}
	public Vector<Ciudad> mostrarCiudad(Integer idEstado){
		PreparedStatement ps=null;
		ResultSet rs=null;
		Vector<Ciudad> vectorCiudad =new Vector<Ciudad> ();
		Ciudad Ciudad=null;
		try {
			Conexion con=new Conexion();
			Connection conexion=con.getConnection();
			
			ps=conexion.prepareStatement("select * from ciudades where idEstado="+idEstado);
			rs=ps.executeQuery();
			
			Ciudad=new Ciudad();
			Ciudad.setIdCiudad(0);
			Ciudad.setNombreCiudad("Seleccione ciudad");
			vectorCiudad.add(Ciudad);
			
			while(rs.next()) {
				Ciudad=new Ciudad();
				Ciudad.setIdCiudad(rs.getInt("idCiudad"));
				Ciudad.setNombreCiudad(rs.getString("nombreCiudad"));
				vectorCiudad.add(Ciudad);
			}
			rs.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return vectorCiudad;
	}
	

}
