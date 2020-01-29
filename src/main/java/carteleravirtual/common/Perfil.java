package carteleravirtual.common;

public enum Perfil {
    ADMINISTRADOR("Administrador"), DOCENTE("Docente"), ALUMNO("Alumno"), PUBLICADOR("Publicador");
    
    private String nombre;
	
    private Perfil(String nombre){
    	this.nombre = nombre;
    }
    	
	public String getNombre() {
		return nombre;
	}

	public static Perfil fromNombre(String nombre) {
		switch(nombre) {
			case "Administrador":
				return Perfil.ADMINISTRADOR;
			case "Docente":
				return Perfil.DOCENTE;
			case "Alumno":
				return Perfil.ALUMNO;
			default:
				throw new IllegalArgumentException("Nombre de perfil: "+nombre+" no soportado.");
		}
	}

	@Override
	public String toString() { 
		return nombre; 
	}
}
