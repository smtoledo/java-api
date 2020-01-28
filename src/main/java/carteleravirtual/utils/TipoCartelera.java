package carteleravirtual.utils;

public class TipoCartelera {

    public static final TipoCartelera EDUCATIVA = new TipoCartelera("EDUCATIVA");
    public static final TipoCartelera LABORAL = new TipoCartelera("LABORAL");

    private String name;

    private TipoCartelera(String name) {
    	this.name = name;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static TipoCartelera getEducativa() {
		return EDUCATIVA;
	}

	public static TipoCartelera getLaboral() {
		return LABORAL;
	}
	
}
