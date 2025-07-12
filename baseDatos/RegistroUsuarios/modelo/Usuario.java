package baseDatos.RegistroUsuarios.modelo;

public class Usuario {
	private int id;
	private String usuario;
	private String contraseña;
	private String nombre;
	private String Correo;
	private String ultima_sesion;
	private int idTipo_usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getUltima_sesion() {
		return ultima_sesion;
	}
	public void setUltima_sesion(String ultima_sesion) {
		this.ultima_sesion = ultima_sesion;
	}
	public int getIdTipo_usuario() {
		return idTipo_usuario;
	}
	public void setIdTipo_usuario(int idTipo_usuario) {
		this.idTipo_usuario = idTipo_usuario;
	}
	
}
