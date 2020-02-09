package carteleravirtual.common;

public enum TipoCartelera {
	EDUCATIVA("Educativa"),
	LABORAL("Laboral");
	
    private String nombre;
	
    private TipoCartelera(String nombre){
    	this.nombre = nombre;
    }
    	
	public String getNombre() {
		return nombre;
	}

	public static TipoCartelera fromNombre(String nombre) {
		switch(nombre) {
			case "Educativa":
				return TipoCartelera.EDUCATIVA;
			case "Laboral":
				return TipoCartelera.LABORAL;
			default:
				throw new IllegalArgumentException("Nombre: "+nombre+" no soportado.");
		}
	}

	@Override
	public String toString() { 
		return nombre; 
	}

}
