package baseDatos.crud_mvc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionPersona {
	public static final String URL="jdbc:mysql://localhost:3306/escuela?autoReconnet=true&useSSL=false";
	public static final String usuario="root";
	public static final String contraseña="1234";
	
	public static Connection getConnection() {
		Connection conexion=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion= DriverManager.getConnection(URL,usuario,contraseña);
		}catch(Exception e) {
			System.err.println("Error"+e);			
		}
		return conexion;
	}
}
