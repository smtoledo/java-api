package carteleravirtual.dao.impl;

import org.springframework.stereotype.Repository;

import carteleravirtual.dao.CarteleraVirtualDAO;
import carteleravirtual.model.CarteleraVirtual;

@Repository
public class CarteleraVirtualDAOHibernateJPA<T> extends GenericDAOHibernateJPA<CarteleraVirtual> implements CarteleraVirtualDAO {

	public CarteleraVirtualDAOHibernateJPA() {
		super(CarteleraVirtual.class);
	}
	
}