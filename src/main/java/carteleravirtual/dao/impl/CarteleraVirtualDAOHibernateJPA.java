package carteleravirtual.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import carteleravirtual.dao.CarteleraVirtualDAO;
import carteleravirtual.model.CarteleraVirtual;
import carteleravirtual.model.Publicacion;

@Repository
public class CarteleraVirtualDAOHibernateJPA<T> extends GenericDAOHibernateJPA<CarteleraVirtual, Integer> implements CarteleraVirtualDAO {

	public CarteleraVirtualDAOHibernateJPA() {
		super(CarteleraVirtual.class);
	}

	@Override
	public boolean agregarPublicacion(CarteleraVirtual cartelera, Publicacion publicacion) {
		cartelera.addPublicacion(publicacion);
		CarteleraVirtual cv = this.actualizar(cartelera);
		if (cv != null) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CarteleraVirtual> recuperarCartelerasPorUsuario(Integer usuario) {
		Query consulta = getEntityManager()
				/*.createQuery("SELECT cv FROM CarteleraVirtual cv INNER JOIN cv.interesados u "+
					" WHERE u.id not in (" + usuario + ") order by cv.titulo");*/
				.createQuery("SELECT cv FROM CarteleraVirtual cv "+
					" WHERE " + usuario + " NOT MEMBER OF cv.interesados order by cv.titulo");	
		return (List<CarteleraVirtual>) consulta.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CarteleraVirtual> recuperarCartelerasFavPorUsuario(Integer usuario) {
		Query consulta = getEntityManager()
				/*.createQuery("SELECT cv FROM CarteleraVirtual cv INNER JOIN cv.interesados u "+
					" WHERE u.id in (" + usuario + ") order by cv.titulo");*/
				.createQuery("SELECT cv FROM CarteleraVirtual cv "+
					" WHERE " + usuario + " MEMBER OF cv.interesados order by cv.titulo");	
		return (List<CarteleraVirtual>) consulta.getResultList();
	}

}