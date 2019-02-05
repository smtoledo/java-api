package carteleravirtual.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import carteleravirtual.common.TokenValidator;
import carteleravirtual.dao.CarteleraVirtualDAO;
import carteleravirtual.dao.UsuarioDAO;
import carteleravirtual.dto.CarteleraDTO;
import carteleravirtual.excepcion.TokenInvalidoException;
import carteleravirtual.model.CarteleraVirtual;
import carteleravirtual.model.Usuario;

@Service
public class CarteleraService {

	@Autowired
	CarteleraVirtualDAO carteleraDAO;
	@Autowired
	TokenValidator tokenValidator;
	@Autowired
	UsuarioDAO usuarioDao;
	@Autowired
	ModelMapper modelmapper;

	public ResponseEntity<?> crearCartelera(CarteleraDTO carteleraDto) {
		Usuario usuario = null; //usuarioDao.recuperarPorId(tokenValidator.parseIdUsuario(token));
		if (usuario != null && usuario.getPerfil().equals("ADMINISTRADOR")) {
			CarteleraVirtual cartelera = carteleraDAO.persistir(modelmapper.map(carteleraDto, CarteleraVirtual.class));
			return new ResponseEntity<>(modelmapper.map(cartelera, CarteleraDTO.class),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); 
		}
	}
	
    public ResponseEntity<?> recuperarCarteleras(){
		List<CarteleraDTO> carteleraDtos = carteleraDAO.recuperarTodos("titulo").stream()
				.map(cartelera -> modelmapper.map(cartelera, CarteleraDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(carteleraDtos, HttpStatus.OK);
    }

}
