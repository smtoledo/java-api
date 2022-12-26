package carteleravirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carteleravirtual.dto.UsuarioDTO;
import carteleravirtual.service.TokenService;
import carteleravirtual.service.UsuarioService;

@RestController()
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;	

    @PostMapping("/usuarios")
    public ResponseEntity<?> crearUsuario(@RequestHeader (name="Authorization") String token,
        @RequestBody UsuarioDTO usuario){
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)
            return usuarioService.crearUsuario(usuario);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }

    @GetMapping("/usuarios")
    @ResponseBody
    public ResponseEntity<?> recuperarUsuarios(@RequestHeader (name="Authorization") String token){
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)
            return usuarioService.recuperarUsuarios();
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }
    
    @GetMapping("/suscriptores/{cartelera_id}")
    @ResponseBody
    public ResponseEntity<?> recuperarUsuariosSuscriptos(@RequestHeader (name="Authorization") String token,
        @PathVariable("cartelera_id") Integer cartelera_id){
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)  
            return usuarioService.recuperarUsuariosSuscriptos(cartelera_id);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> recuperarUsuario(@RequestHeader (name="Authorization") String token, 
        @PathVariable("id") String idUsuario){
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)    
            return usuarioService.recuperarUsuario(idUsuario);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }
    
    @PutMapping("/usuarios")
    public ResponseEntity<?> updateUser(@RequestHeader (name="Authorization") String token, 
        @RequestBody UsuarioDTO usuario){
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)                
            return usuarioService.actualizarUsuario(usuario);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }

    /** baja alta de cuenta */
    @PutMapping("/usuarios/updateCuenta/{id_usuario}/{value}")
    public ResponseEntity<?> updateCuenta(@RequestHeader (name="Authorization") String token, 
        @PathVariable("id_usuario") Integer id_usuario, @PathVariable("value") Integer value) {
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)
            return usuarioService.updateCuenta(id_usuario, value);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }

    /** ********************************************  */

    @PutMapping("/usuarios/suscribe/{id_cartelera}/{username}")
    public ResponseEntity<?> suscribe(@RequestHeader (name="Authorization") String token, 
        @PathVariable("id_cartelera") Integer id_cartelera, @PathVariable("username") String username) {
        String username_token = TokenService.getUsernameFromToken(token);
        if (username_token != null)    
            return usuarioService.suscribe(id_cartelera, username);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");

    }
    
    @PutMapping("/usuarios/unsuscribe/{id_cartelera}/{username}")
    public ResponseEntity<?> unsuscribe(@RequestHeader (name="Authorization") String token, 
        @PathVariable("id_cartelera") Integer id_cartelera, @PathVariable("username") String username) {
        String username_token = TokenService.getUsernameFromToken(token);
        if (username_token != null)    
            return usuarioService.unsuscribe(id_cartelera, username);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }

}