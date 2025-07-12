package baseDatos.RegistroUsuarios.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class SQLUsuario {
	
	public boolean iniciarSesion(Usuario usuario) {
		Conexion con= new Conexion();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Connection conexion=con.getConnection();
			ps=conexion.prepareStatement("select id,nombreUsuario,contraseña,nombre,idTipo_usuario from usuario where nombreUsuario=?");
			ps.setString(1, usuario.getUsuario());
			
			rs=ps.executeQuery();
			if(rs.next()) {
				if(usuario.getContraseña().equals(rs.getString("contraseña"))) {
					ps=conexion.prepareStatement("update usuario set ultima_sesion=? where id=?");
					ps.setString(1, usuario.getUltima_sesion());
					ps.setInt(2, rs.getInt("id"));
					ps.executeUpdate();
					
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setIdTipo_usuario(rs.getInt("idTipo_usuario"));
					return true;
					
				}
				else {
					conexion.close();
					return false;
					
				}
			}
			return false;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}
	public boolean comprobarEmail(String email) {
	    if (email == null || email.isEmpty()) {
	        return false;
	    }
	    
	    // Patrón de validación para emails
	    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	    
	    // Compilar el patrón
	    Pattern pattern = Pattern.compile(regex);
	    
	    // Crear el matcher
	    Matcher matcher = pattern.matcher(email);
	    
	    // Verificar si coincide
	    return matcher.matches();
	}
	public boolean registrar(Usuario usuario) {
		Conexion con= new Conexion();
		PreparedStatement ps=null;
		
		try {
			Connection conexion=con.getConnection();
			ps=conexion.prepareStatement("insert into usuario (nombreUsuario,contraseña,nombre,correo,idTipo_usuario) values (?,?,?,?,?)");
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getContraseña());
			ps.setString(3, usuario.getNombre());
			ps.setString(4, usuario.getCorreo());
			ps.setInt(5, usuario.getIdTipo_usuario());
			ps.executeUpdate();
			conexion.close();
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}
	public int verificarUsuario(String usuario) {
		Conexion con= new Conexion();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Connection conexion=con.getConnection();
			ps=conexion.prepareStatement("select count(id) from usuario where nombreUsuario=?");
			ps.setString(1, usuario);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			conexion.close();
			return 1;
		} catch (Exception e) {
			System.err.println(e);
			return 1;
		}
	}
	
}
