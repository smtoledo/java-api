package carteleravirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import carteleravirtual.dto.UsuarioDTO;
import carteleravirtual.service.UsuarioService;

@RestController()
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;	

	@CrossOrigin(origins = "*")
    @PostMapping("/usuarios")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuario){
        return usuarioService.crearUsuario(usuario);
    }

	@CrossOrigin(origins = "*")
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> recuperarUsuario(@PathVariable("id") String idUsuario){
    	return usuarioService.recuperarUsuario(idUsuario);
    }
    
	@CrossOrigin(origins = "*")
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UsuarioDTO usuarioDTO, @PathVariable("id") String idUsuario){
    	return usuarioService.actualizarUsuario(usuarioDTO, idUsuario);    	
    }
    
}
