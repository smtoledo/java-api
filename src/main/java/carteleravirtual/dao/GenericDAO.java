package carteleravirtual.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID> {
	
	public T persistir(T entity);
	public T actualizar(T entity);
	public void borrar(T entity);
	public T recuperarPorId(ID id);
	public List<T> recuperarTodos(String columnOrder);
	public List<T> recuperarTodosDonde(String where, String columnOrder);
	public boolean existe(Serializable id);
}