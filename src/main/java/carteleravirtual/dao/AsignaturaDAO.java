package carteleravirtual.dao;

import carteleravirtual.model.Asignatura;

public interface AsignaturaDAO extends GenericDAO<Asignatura,Integer> {
	
	public Asignatura recuperar(String codigo);
}
