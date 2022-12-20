package carteleravirtual.dto;

public class UsuarioDTO {

	private int id;
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private String email;
	private int dni;
	private String perfil;
	private int cuentaActiva;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public int getCuentaActiva() {
		return cuentaActiva;
	}
	public void setCuentaActiva(int cuentaActiva) {
		this.cuentaActiva = cuentaActiva;
	}
}
