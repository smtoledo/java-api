package carteleravirtual.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import carteleravirtual.common.TokenValidator;
import carteleravirtual.dao.UsuarioDAO;
import carteleravirtual.dto.UsuarioDTO;
import carteleravirtual.excepcion.TokenInvalidoException;
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
        	Usuario usuario = usuarioDao.persistir(modelmapper.map(userDTO, Usuario.class));   	
            return new ResponseEntity<>(modelmapper.map(usuario, UsuarioDTO.class), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	    
    public ResponseEntity<?> recuperarUsuario(String idUsuario) {
    		Usuario result = usuarioDao.recuperarPorId(Integer.parseInt(idUsuario));
    		if (result != null) {
				return new ResponseEntity<>(modelmapper.map(result, UsuarioDTO.class), HttpStatus.OK);
    		} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
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

}
