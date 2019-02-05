package carteleravirtual.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import carteleravirtual.dao.AsignaturaDAO;
import carteleravirtual.model.Asignatura;

@Repository
public class AsignaturaDAOHibernateJPA<T> extends GenericDAOHibernateJPA<Asignatura> implements AsignaturaDAO {

	public AsignaturaDAOHibernateJPA() {
		super(Asignatura.class);
	}
	
	@Override
	public Asignatura recuperar(String codigo) {
		Query consulta = this.getEntityManager()
				.createQuery("select a from Asignatura a where a.codigo=?1");
		consulta.setParameter(1,codigo);
		Asignatura resultado = (Asignatura) consulta.getSingleResult();
		return resultado;
	}

}