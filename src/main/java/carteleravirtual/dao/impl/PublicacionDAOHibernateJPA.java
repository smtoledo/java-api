package carteleravirtual.dao.impl;

import org.springframework.stereotype.Repository;

import carteleravirtual.dao.PublicacionDAO;
import carteleravirtual.model.Publicacion;

@Repository
public class PublicacionDAOHibernateJPA<T> extends GenericDAOHibernateJPA<Publicacion> implements PublicacionDAO {

	public PublicacionDAOHibernateJPA() {
		super(Publicacion.class);
	}
	
}