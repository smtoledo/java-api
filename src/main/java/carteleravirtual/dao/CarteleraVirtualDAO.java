package carteleravirtual.dao;

import java.util.List;

import carteleravirtual.model.CarteleraVirtual;
import carteleravirtual.model.Publicacion;

public interface CarteleraVirtualDAO extends GenericDAO<CarteleraVirtual,Integer> {
	
	public boolean agregarPublicacion(CarteleraVirtual cartelera, Publicacion publicacion);
	public List<CarteleraVirtual> recuperarCartelerasPorUsuario(Integer usuario);
	public List<CarteleraVirtual> recuperarCartelerasFavPorUsuario(Integer usuario);	
}
