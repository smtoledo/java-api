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
import carteleravirtual.dao.UsuarioDAO;
import carteleravirtual.dto.CarteleraDTO;
import carteleravirtual.dto.UsuarioDTO;
import carteleravirtual.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioDAO usuarioDao;	
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
    
    public ResponseEntity<?> actualizarUsuario(UsuarioDTO usuarioDTO, String idUsuario) {
			Usuario usuario = usuarioDao.recuperarPorId(Integer.parseInt(idUsuario));
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
