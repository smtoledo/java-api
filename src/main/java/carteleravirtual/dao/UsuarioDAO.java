package carteleravirtual.dao;

import java.util.List;

import carteleravirtual.model.Usuario;


public interface UsuarioDAO extends GenericDAO<Usuario,Integer> {
	
	public Usuario recuperar(String username);
	public Usuario recuperarPorId(int id);
	public List<Usuario> recuperarPorCartelera(Integer id);

}
