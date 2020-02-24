package carteleravirtual.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import carteleravirtual.dao.GenericDAO;

@Transactional
public abstract class GenericDAOHibernateJPA<T, ID> implements GenericDAO<T, ID>{

    protected Class<T> persistentClass;

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager em){
        this.entityManager = em;
    }
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
	public GenericDAOHibernateJPA(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	public T persistir(T entity) {
        this.getEntityManager().persist(entity);
        return entity;
	}

    public T recuperarPorId(ID id) {
        return this.getEntityManager().find(this.persistentClass, id);
    }
	
	@Override
	public T actualizar(T entity) {
		return this.getEntityManager().merge(entity);
	}

	@Override
	public void borrar(T entity) {
        this.getEntityManager().remove(this.getEntityManager().contains(entity) ? entity : this.getEntityManager().merge(entity));
	}
	
	@Override
	public boolean existe(Serializable id) {
		Query consulta = this.getEntityManager().createQuery("select e from " +this.persistentClass.getSimpleName()+" e where id = :id");
		consulta.setParameter("id", id);
		try {
			return (consulta.getSingleResult() != null);
		} catch (NoResultException e) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> recuperarTodos(String columnOrder) {
		Query consulta = getEntityManager()
				.createQuery("select e from "+this.persistentClass.getSimpleName()+" e order by e."+columnOrder);
		return (List<T>) consulta.getResultList();
	}
	
	
}