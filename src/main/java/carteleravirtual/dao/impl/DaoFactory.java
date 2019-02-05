package carteleravirtual.dao.impl;

import carteleravirtual.dao.AsignaturaDAO;
import carteleravirtual.dao.CarteleraVirtualDAO;
import carteleravirtual.dao.ComentarioDAO;
import carteleravirtual.dao.PublicacionDAO;
import carteleravirtual.dao.UsuarioDAO;

@SuppressWarnings("rawtypes")
public class DaoFactory {

	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOHibernateJPA();
	}
	
	public static PublicacionDAO getPublicacionDAO() {
		return new PublicacionDAOHibernateJPA();
	}
	
	public static ComentarioDAO getComentarioDAO() {
		return new ComentarioDAOHibernateJPA();
	}	
	
	public static AsignaturaDAO getAsignaturaDAO() {
		return new AsignaturaDAOHibernateJPA();
	}

	public static CarteleraVirtualDAO getCarteleraVirtualDAO() {
		return new CarteleraVirtualDAOHibernateJPA();
	}
}