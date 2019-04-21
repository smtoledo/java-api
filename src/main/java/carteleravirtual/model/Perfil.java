package carteleravirtual.model;

public class Perfil
{
    private Perfil(){}
    
    public static final Perfil ADMINISTRADOR = new Perfil();
    public static final Perfil DOCENTE = new Perfil();
    public static final Perfil ALUMNO = new Perfil();
    public static final Perfil PUBLICADOR = new Perfil();
}