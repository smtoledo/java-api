package carteleravirtual.utils;

public class Rol {

    public static final Rol ADMINISTRADOR = new Rol("ADMINISTRADOR");
    public static final Rol DOCENTE = new Rol("DOCENTE");
    public static final Rol ALUMNO = new Rol("ALUMNO");

    private String name;

    private Rol(String name) {
    	this.name = name;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Rol getAdministrador() {
		return ADMINISTRADOR;
	}

	public static Rol getDocente() {
		return DOCENTE;
	}

	public static Rol getAlumno() {
		return ALUMNO;
	}
}
