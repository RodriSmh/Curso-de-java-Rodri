package baseDatos.crud_mvc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class ConsultasPersona extends ConexionPersona{
	PreparedStatement ps;
	ResultSet rs;
	public boolean Eliminar(ModeloPersona persona) {
		Connection conexion=getConnection();
		try {
			ps=conexion.prepareStatement("delete from persona where idpersona=?");
				
			
			ps.setInt(1, persona.getIdPersona());
			int resultado =ps.executeUpdate();
			
			if(resultado>0)
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}finally {
			try {
				conexion.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public boolean modificar(ModeloPersona persona) {
		Connection conexion=getConnection();
		try {
			ps=conexion.prepareStatement("update persona set clave=?,nombre=?,domicilio=?,celular=?,correo_electronico=?,fecha_nacimiento=?,genero=? where idpersona=?");
			ps.setString(1, persona.getClave());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getDomicilio());
			ps.setString(4, persona.getCelular());
			ps.setString(5, persona.getCorreo_electronico());
			ps.setDate(6, persona.getFecha_nacimiento());
			ps.setString(7, persona.getGenero());
			ps.setInt(8, persona.getIdPersona());
			int resultado =ps.executeUpdate();
			
			if(resultado>0)
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}finally {
			try {
				conexion.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public boolean insertar(ModeloPersona persona) {
		Connection conexion=getConnection();
		try {
			ps=conexion.prepareStatement("Insert into persona(clave,nombre,domicilio,celular,correo_electronico,fecha_nacimiento,genero) values(?,?,?,?,?,?,?)");
			ps.setString(1, persona.getClave());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getDomicilio());
			ps.setString(4, persona.getCelular());
			ps.setString(5, persona.getCorreo_electronico());
			ps.setDate(6, persona.getFecha_nacimiento());
			ps.setString(7, persona.getGenero());
			int resultado =ps.executeUpdate();
			
			if(resultado>0)
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}finally {
			try {
				conexion.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public boolean buscar(ModeloPersona persona) {
		Connection conexion=getConnection();
		try {
			ps=conexion.prepareStatement("select * from persona where clave=?");
			ps.setString(1, persona.getClave());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				persona.setIdPersona(rs.getInt("idPersona"));
				persona.setClave(rs.getString("clave"));
				persona.setNombre(rs.getString("nombre"));
				persona.setDomicilio(rs.getString("domicilio"));
				persona.setCelular(rs.getString("celular"));
				persona.setCorreo_electronico(rs.getString("correo_electronico"));
				persona.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
				persona.setGenero(rs.getString("genero"));
				return true;
			}
				
			else
				return false;
		} catch (Exception ex) {
			return false;
		}finally {
			try {
				conexion.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
