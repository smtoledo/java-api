package carteleravirtual.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carteleravirtual.common.TokenValidator;
import carteleravirtual.dao.AsignaturaDAO;

@Service
public class AsignaturaService {

	@Autowired
	AsignaturaDAO asignaturaDAO;
	@Autowired
	TokenValidator tokenValidator;
	@Autowired
	ModelMapper modelmapper;

	
}
