package carteleravirtual.excepcion;

public class TokenInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
    public String getMessage() {
        return "El token no es valido";
    }
}
