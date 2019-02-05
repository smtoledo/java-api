package carteleravirtual.dao;

import carteleravirtual.model.Asignatura;

public interface AsignaturaDAO extends GenericDAO<Asignatura> {
	
	public Asignatura recuperar(String codigo);
}
