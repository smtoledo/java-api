package carteleravirtual.dao.impl;

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
	
}