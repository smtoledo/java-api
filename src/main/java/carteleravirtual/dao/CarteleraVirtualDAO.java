package carteleravirtual.dao;

import carteleravirtual.model.CarteleraVirtual;
import carteleravirtual.model.Publicacion;

public interface CarteleraVirtualDAO extends GenericDAO<CarteleraVirtual,Integer> {
	
	public boolean agregarPublicacion(CarteleraVirtual cartelera, Publicacion publicacion);
	
}
