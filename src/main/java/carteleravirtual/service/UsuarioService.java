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
import carteleravirtual.dto.UsuarioDTO;
import carteleravirtual.model.CarteleraVirtual;
import carteleravirtual.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioDAO usuarioDao;	
	@Autowired
	CarteleraVirtualDAO carteleraDAO;
	@Autowired
	TokenValidator tokenValidator;
	@Autowired
	ModelMapper modelmapper;
	
	
	public ResponseEntity<?> crearUsuario(UsuarioDTO userDTO) {
        try {
        	Usuario usuario = usuarioDao.persistir(toEntity(userDTO));   	
            return new ResponseEntity<>(modelmapper.map(usuario, UsuarioDTO.class), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	    
    public ResponseEntity<?> recuperarUsuario(String idUsuario) {
    		Usuario result = usuarioDao.recuperarPorId(Integer.parseInt(idUsuario));
    		if (result != null) {
				return new ResponseEntity<>(toDTO(result), HttpStatus.OK);
    		} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
    }
    
    public ResponseEntity<?> recuperarUsuarios(){
		List<UsuarioDTO> userDTOs = usuarioDao.recuperarTodos("username").stream()
				.map(user -> modelmapper.map(user, UsuarioDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }
    
    public ResponseEntity<?> actualizarUsuario(UsuarioDTO usuarioDTO) {
			Usuario usuario = usuarioDao.recuperarPorId(usuarioDTO.getId());
			if (usuario != null) {    			
				usuario.setNombre(usuarioDTO.getNombre());
				usuario.setApellido(usuarioDTO.getApellido());
				usuario.setEmail(usuarioDTO.getEmail());
				usuario.setDni(usuarioDTO.getDni());						
				usuarioDao.actualizar(usuario);
				return new ResponseEntity<>(HttpStatus.OK);
    		} else {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}

	}
	
	public ResponseEntity<?> suscribe(Integer id_cartelera, String username){
    	CarteleraVirtual cartelera = carteleraDAO.recuperarPorId(id_cartelera);
		Usuario usuario = usuarioDao.recuperar(username);
		
    	if (cartelera != null && usuario != null) {
    		try {
				usuario.addPreferidas(cartelera);
				usuarioDao.actualizar(usuario);				
    		}catch(Exception e) {
    			return new ResponseEntity<UsuarioDTO>(modelmapper.map(usuario, UsuarioDTO.class), HttpStatus.NOT_MODIFIED);
    		}
    		return new ResponseEntity<UsuarioDTO>(modelmapper.map(usuario, UsuarioDTO.class), HttpStatus.OK);
    	}else {
    		return new ResponseEntity<UsuarioDTO>(modelmapper.map(usuario, UsuarioDTO.class), HttpStatus.NOT_MODIFIED);
    	}
	}
	
		
	public ResponseEntity<?> unsuscribe(Integer id_cartelera, String username){
    	CarteleraVirtual cartelera = carteleraDAO.recuperarPorId(id_cartelera);
		Usuario usuario = usuarioDao.recuperar(username);
		
    	if (cartelera != null && usuario != null) {
    		try {
				usuario.removePreferidas(cartelera);
				usuarioDao.actualizar(usuario);				
    		}catch(Exception e) {
    			return new ResponseEntity<UsuarioDTO>(modelmapper.map(usuario, UsuarioDTO.class), HttpStatus.NOT_MODIFIED);
    		}
    		return new ResponseEntity<UsuarioDTO>(modelmapper.map(usuario, UsuarioDTO.class), HttpStatus.OK);
    	}else {
    		return new ResponseEntity<UsuarioDTO>(modelmapper.map(usuario, UsuarioDTO.class), HttpStatus.NOT_MODIFIED);
    	}
	}
	    
    private UsuarioDTO toDTO(Usuario u) {
    	UsuarioDTO uDTO = modelmapper.map(u, UsuarioDTO.class);
    	uDTO.setPerfil(u.getPerfil().getNombre());
		return uDTO;
    }
    
    private Usuario toEntity(UsuarioDTO dto) {
    	Usuario u = modelmapper.map(dto, Usuario.class);
    	//u.setPerfil(Perfil.fromNombre(dto.getPerfil()));
    	return u;
    }

}
