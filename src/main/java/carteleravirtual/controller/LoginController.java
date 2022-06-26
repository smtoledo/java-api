package carteleravirtual.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import carteleravirtual.dao.UsuarioDAO;
import carteleravirtual.model.CarteleraVirtual;
import carteleravirtual.model.Credentials;
import carteleravirtual.model.UsernaneAndPassword;
import carteleravirtual.model.Usuario;
import carteleravirtual.service.TokenService;

@RestController
public class LoginController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private TokenService tokenServices;

    private final int EXPIRATION_IN_SEC = 86400;
	
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/auth")
    public ResponseEntity<?> authenticate(@RequestBody UsernaneAndPassword userpass) {
    	Usuario u = usuarioDAO.recuperar(userpass.getUsername());    	
        if(u != null && u.getPassword().equals(userpass.getPassword())) {        	
            String token = tokenServices.generateToken(userpass.getUsername(), EXPIRATION_IN_SEC);
            return ResponseEntity.ok(new Credentials(token, EXPIRATION_IN_SEC, u.getUsername(), u.getPerfil(), 
                u.getPreferidasIds(), u.getCartelerasIds()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
        }
    }

}
