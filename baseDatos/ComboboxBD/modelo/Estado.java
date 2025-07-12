package baseDatos.ComboboxBD.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Estado {
	private int idEstado;
	private String nombreEstado;
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	@Override
	public String toString() {
		return this.nombreEstado;
	}
	public Vector<Estado> mostrarEstado(Integer idPais){
		PreparedStatement ps=null;
		ResultSet rs=null;
		Vector<Estado> vectorEstado =new Vector<Estado> ();
		Estado Estado=null;
		try {
			Conexion con=new Conexion();
			Connection conexion=con.getConnection();
			
			ps=conexion.prepareStatement("select * from Estados where idPais="+idPais);
			rs=ps.executeQuery();
			
			Estado=new Estado();
			Estado.setIdEstado(0);
			Estado.setNombreEstado("Seleccione Estado");
			vectorEstado.add(Estado);
			
			while(rs.next()) {
				Estado=new Estado();
				Estado.setIdEstado(rs.getInt("idEstado"));
				Estado.setNombreEstado(rs.getString("nombreEstado"));
				vectorEstado.add(Estado);
			}
			rs.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return vectorEstado;
	}
}
