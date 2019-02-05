package carteleravirtual.dao.impl;

import org.springframework.stereotype.Repository;

import carteleravirtual.dao.ComentarioDAO;
import carteleravirtual.model.Comentario;

@Repository
public class ComentarioDAOHibernateJPA<T> extends GenericDAOHibernateJPA<Comentario> implements ComentarioDAO {

	public ComentarioDAOHibernateJPA() {
		super(Comentario.class);
	}
	
}