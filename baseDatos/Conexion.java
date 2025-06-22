package baseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public static final String URL="jdbc:mysql://localhost:3306/escuela?autoReconnet=true&useSSL=false";
	public static final String usuario="root";
	public static final String contraseña="1234";
	public static void main(String[] args) {
		Connection conexion= getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps=conexion.prepareStatement("Select * from persona");
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("id: "+rs.getString("idPersona"));
				System.out.println("Nombre: "+rs.getString("nombre"));
				System.out.println("Fecha nacimiento: "+String.valueOf(rs.getDate("fecha_nacimiento")));
				System.out.println();
			}
				conexion.close();
		}catch(Exception e) {System.err.println("Error"+e);}
	}
	public static Connection getConnection() {
		Connection conexion=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion= DriverManager.getConnection(URL,usuario,contraseña);
			System.out.println("Se establecio conexion");
		}catch(Exception e) {
			System.err.println("Error"+e);			
		}
		return conexion;
	}

}
