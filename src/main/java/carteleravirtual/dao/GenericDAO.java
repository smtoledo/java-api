package carteleravirtual.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {
	
	public T persistir(T entity);
	public T actualizar(T entity);
	public void borrar(T entity);	
	public List<T> recuperarTodos(String columnOrder);
	public boolean existe(Serializable id);
}