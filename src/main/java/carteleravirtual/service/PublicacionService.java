package carteleravirtual.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import carteleravirtual.common.TokenValidator;
import carteleravirtual.dao.PublicacionDAO;
import carteleravirtual.dao.UsuarioDAO;
import carteleravirtual.dto.CarteleraDTO;
import carteleravirtual.dto.ComentarioDTO;
import carteleravirtual.dto.PublicacionDTO;
import carteleravirtual.model.CarteleraVirtual;
import carteleravirtual.model.Comentario;
import carteleravirtual.model.Publicacion;
import carteleravirtual.model.Usuario;

@Service
public class PublicacionService {
	
	@Autowired
	TokenValidator tokenValidator;
	@Autowired
	UsuarioDAO usuarioDAO;
	@Autowired
	PublicacionDAO publicacionDAO;
	@Autowired
	ModelMapper modelmapper;
	
	
    public ResponseEntity<?> agregarComentario(ComentarioDTO comentarioDTO, Integer id_cartelera, 
    		Integer id_publicacion, String username){
    	Publicacion publicacion = publicacionDAO.recuperarPorId(id_publicacion);
    	Usuario autor = usuarioDAO.recuperar(username);
    	
    	if (publicacion != null && autor != null) {
    		Comentario comment = modelmapper.map(comentarioDTO, Comentario.class);
    		comment.setAutor(autor);
    		comment.setPublicacion(publicacion);
    		try {
    			publicacion.addComentario(comment);
    			publicacionDAO.actualizar(publicacion);
    		}catch(Exception e) {
    			return new ResponseEntity<PublicacionDTO>(modelmapper.map(publicacion, PublicacionDTO.class), HttpStatus.NOT_MODIFIED);
    		}
    		return new ResponseEntity<PublicacionDTO>(modelmapper.map(publicacion, PublicacionDTO.class), HttpStatus.OK);
    	}else {
    		return new ResponseEntity<PublicacionDTO>(modelmapper.map(publicacion, PublicacionDTO.class), HttpStatus.NOT_MODIFIED);
    	}
    	
    }
    
    public ResponseEntity<?> recuperarComentarios(Integer id_publicacion){
    	Publicacion publicacion = publicacionDAO.recuperarPorId(id_publicacion);
    	List<ComentarioDTO> listDtos = publicacion.getComentarios().stream()
				.map(comment -> modelmapper.map(comment, ComentarioDTO.class)).collect(Collectors.toList());
    	return new ResponseEntity<>(listDtos, HttpStatus.OK);
    }


}
