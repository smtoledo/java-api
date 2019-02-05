package carteleravirtual.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import carteleravirtual.dao.UsuarioDAO;
import carteleravirtual.model.Usuario;

@Repository
public class UsuarioDAOHibernateJPA<T> extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {

	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}
	
	public Usuario autenticado(String username, String password) {
		Query consulta = this.getEntityManager().createQuery("select u from Usuario u"
				+ " where u.username = ?1 and u.password = ?2 ");
		consulta.setParameter(1, username);
		consulta.setParameter(2, password);
		
		try {
			return (Usuario) consulta.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public Usuario recuperar(String username) {
		Query consulta = this.getEntityManager()
				.createQuery("select u from Usuario u where	u.username=?1");
		consulta.setParameter(1, username);
		try {
			return (Usuario) consulta.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public Usuario recuperarPorId(int id) {
		Query consulta = this.getEntityManager()
				.createQuery("select u from Usuario u where	u.id=?1");
		consulta.setParameter(1, id);
		try {
			return (Usuario) consulta.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}