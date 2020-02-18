package carteleravirtual.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import carteleravirtual.common.TokenValidator;
import carteleravirtual.dto.CarteleraDTO;

@Service
public class PublicacionService {
	
	@Autowired
	TokenValidator tokenValidator;
	@Autowired
	ModelMapper modelmapper;
	
	
	public ResponseEntity<?> crearCartelera(CarteleraDTO carteleraDto) {
		/**CarteleraVirtual cartelera = carteleraDAO.persistir(modelmapper.map(carteleraDto, CarteleraVirtual.class));
		return new ResponseEntity<>(modelmapper.map(cartelera, CarteleraDTO.class), HttpStatus.OK);*/
		return null;
	}


}
