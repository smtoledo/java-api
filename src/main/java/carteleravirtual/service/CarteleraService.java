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
import carteleravirtual.dao.PublicacionDAO;
import carteleravirtual.dao.UsuarioDAO;
import carteleravirtual.dto.CarteleraDTO;
import carteleravirtual.dto.PublicacionDTO;
import carteleravirtual.model.CarteleraVirtual;
import carteleravirtual.model.Publicacion;
import carteleravirtual.model.Usuario;

@Service
public class CarteleraService {

	@Autowired
	CarteleraVirtualDAO carteleraDAO;
	@Autowired
	TokenValidator tokenValidator;
	@Autowired
	UsuarioDAO usuarioDAO;
	@Autowired
	PublicacionDAO publicacionDAO;
	@Autowired
	ModelMapper modelmapper;
	
	
	public ResponseEntity<?> crearCartelera(CarteleraDTO carteleraDto) {
		CarteleraVirtual cartelera = carteleraDAO.persistir(modelmapper.map(carteleraDto, CarteleraVirtual.class));
		return new ResponseEntity<>(modelmapper.map(cartelera, CarteleraDTO.class), HttpStatus.OK);
	}
	
    public ResponseEntity<?> recuperarCarteleras(){
		List<CarteleraDTO> carteleraDtos = carteleraDAO.recuperarTodos("titulo").stream()
				.map(cartelera -> modelmapper.map(cartelera, CarteleraDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(carteleraDtos, HttpStatus.OK);
    }
    
    public ResponseEntity<?> recuperarCarteleras(Integer id){
		List<CarteleraDTO> carteleraDtos = carteleraDAO.recuperarTodos("titulo").stream()
				.map(cartelera -> modelmapper.map(cartelera, CarteleraDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(carteleraDtos.stream().filter(cartelera -> cartelera.getId() == id.intValue()).findFirst().orElse(null), HttpStatus.OK);
    }
    
    public ResponseEntity<?> agregarPublicacion(PublicacionDTO publicacionDTO, Integer id_cartelera, String username){
    	CarteleraVirtual cartelera = carteleraDAO.recuperarPorId(id_cartelera);
    	Usuario autor = usuarioDAO.recuperar(username);
    	if (cartelera != null && autor != null) {
    		Publicacion publi = modelmapper.map(publicacionDTO, Publicacion.class);
    		publi.setAutor(autor);
    		publi.setCartelera(cartelera);
    		try {
    			cartelera.addPublicacion(publi);
    			carteleraDAO.actualizar(cartelera);
    		}catch(Exception e) {
    			return new ResponseEntity<CarteleraDTO>(modelmapper.map(cartelera, CarteleraDTO.class), HttpStatus.NOT_MODIFIED);
    		}
    		return new ResponseEntity<CarteleraDTO>(modelmapper.map(cartelera, CarteleraDTO.class), HttpStatus.OK);
    	}else {
    		return new ResponseEntity<CarteleraDTO>(modelmapper.map(cartelera, CarteleraDTO.class), HttpStatus.NOT_MODIFIED);
    	}
    	
    }

	public Perfil[] recuperarTiposCartelera() {
		return Perfil.values();
	}

}
