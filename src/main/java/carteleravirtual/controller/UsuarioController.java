package carteleravirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carteleravirtual.dto.UsuarioDTO;
import carteleravirtual.service.UsuarioService;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;	

    @PostMapping("/usuarios")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuario){
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/usuarios")
    @ResponseBody
    public ResponseEntity<?> recuperarUsuarios(){
    	return usuarioService.recuperarUsuarios();
    }
    
    @GetMapping("/usuarios/{id}") //ok
    public ResponseEntity<?> recuperarUsuario(@PathVariable("id") String idUsuario){
    	return usuarioService.recuperarUsuario(idUsuario);
    }
    
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UsuarioDTO usuarioDTO, @PathVariable("id") String idUsuario){
    	return usuarioService.actualizarUsuario(usuarioDTO, idUsuario);    	
    }
    
}