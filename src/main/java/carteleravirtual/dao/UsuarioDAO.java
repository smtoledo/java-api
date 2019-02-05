package carteleravirtual.dao;

import carteleravirtual.model.Usuario;


public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public Usuario recuperar(String username);
	public Usuario recuperarPorId(int id);
	
}
