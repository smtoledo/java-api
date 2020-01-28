package carteleravirtual.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import carteleravirtual.common.Perfil;
import carteleravirtual.common.TokenValidator;
import carteleravirtual.dao.CarteleraVirtualDAO;
import carteleravirtual.dao.UsuarioDAO;
import carteleravirtual.dto.CarteleraDTO;
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

	public ResponseEntity<?> crearCartelera(CarteleraDTO carteleraDto, String token) {
		Usuario usuario = usuarioDao.recuperarPorId(tokenValidator.parseIdUsuario(token));
		if (usuario != null && usuario.getPerfil().equals(Perfil.ADMINISTRADOR)) {
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
    
    public ResponseEntity<?> recuperarCarteleras(Long id){
		List<CarteleraDTO> carteleraDtos = carteleraDAO.recuperarTodos("titulo").stream()
				.map(cartelera -> modelmapper.map(cartelera, CarteleraDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(carteleraDtos.stream().filter(cartelera -> cartelera.getId() == id.intValue()).findFirst().orElse(null), HttpStatus.OK);
    }

	public ResponseEntity<?> recuperarTiposCartelera() {
		return null;
	}

}
