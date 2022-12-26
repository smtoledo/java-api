package carteleravirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carteleravirtual.dto.CarteleraDTO;
import carteleravirtual.dto.ComentarioDTO;
import carteleravirtual.dto.PublicacionDTO;
import carteleravirtual.service.CarteleraService;
import carteleravirtual.service.PublicacionService;
import carteleravirtual.service.TokenService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarteleraController {

	@Autowired
	CarteleraService carteleraService;
	@Autowired
	PublicacionService publicacionService;

	/** ******************* CARTELERAS SIN SESION ************ */
	
    @GetMapping("/carteleras_publicas")
    @ResponseBody
    public ResponseEntity<?> recuperarCarteleras(){
    	return carteleraService.recuperarCarteleras();
    }
    
  	/** ******************* CARTELERAS CON SESION ************ */

    @GetMapping("/carteleras_usuario")
    @ResponseBody
    public ResponseEntity<?> recuperarCartelerasPorUsuario(@RequestHeader (name="Authorization") String token){
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)
            return carteleraService.recuperarCartelerasPorUsuario(username);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }
    
    @GetMapping("/carteleras_fav_usuario")
    @ResponseBody
    public ResponseEntity<?> recuperarCartelerasFavPorUsuario(@RequestHeader (name="Authorization") String token){
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)
            return carteleraService.recuperarCartelerasFavPorUsuario(username);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
            
    }

    @GetMapping("/carteleras/{id}")
    public ResponseEntity<?> recuperarCartelerasPorId(@RequestHeader (name="Authorization") String token, 
        @PathVariable("id") Integer id) {
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)
            return carteleraService.recuperarCarteleras(id);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }

    // @GetMapping("/tipos_cartelera")
    // @ResponseBody
    // public ResponseEntity<?> recuperarTiposCartelera(@RequestHeader (name="Authorization") String token){
    //     String username = TokenService.getUsernameFromToken(token);
    //     if (username != null)
    //         return carteleraService.recuperarTiposCartelera();
    //     else
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    // }    

    @PostMapping("/carteleras")
	@ResponseBody
	public ResponseEntity<?> crearCartelera(@RequestBody CarteleraDTO carteleraDTO,
			@RequestHeader (name="Authorization") String token){
    	String username = TokenService.getUsernameFromToken(token);
        if (username != null)
            return carteleraService.crearCartelera(carteleraDTO, username);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }
        
    /** ********************** PUBLICACIONES *****************/
    
    @PostMapping("/carteleras/{id_cartelera}/publicaciones")
    public ResponseEntity<?> subirPublicacion(@RequestBody PublicacionDTO publicacionDTO,
    		@PathVariable("id_cartelera") Integer id_cartelera, 
    		@RequestHeader (name="Authorization") String token) {
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)
            return carteleraService.agregarPublicacion(publicacionDTO, id_cartelera, username);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }
     
    @GetMapping("/carteleras/{id_cartelera}/publicaciones")
    public ResponseEntity<?> recuperarPublicaciones(@PathVariable("id_cartelera") Integer id_cartelera, 
        @RequestHeader (name="Authorization") String token) {
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)
            return carteleraService.recuperarPublicaciones(id_cartelera);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }
    
    @GetMapping("/carteleras/{id_cartelera}/publicaciones/{id_publicacion}")
    public ResponseEntity<?> recuperarPublicacion(@PathVariable("id_cartelera") Integer id_cartelera,
            @PathVariable("id_publicacion") Integer id_publicacion, 
            @RequestHeader (name="Authorization") String token) {
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)        
            return carteleraService.recuperarPublicacion(id_cartelera, id_publicacion);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }
    
    /** ********************** COMENTARIOS *****************/
    
    @PostMapping("/carteleras/{id_cartelera}/publicaciones/{id_publicacion}/comentarios")
    public ResponseEntity<?> postComentario(@RequestBody ComentarioDTO comentarioDTO,
    		@PathVariable("id_cartelera") Integer id_cartelera,
    		@PathVariable("id_publicacion") Integer id_publicacion,
    		@RequestHeader (name="Authorization") String token) {
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)        
            return publicacionService.agregarComentario(comentarioDTO, id_cartelera, id_publicacion, username);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }
    
    @GetMapping("/carteleras/{id_cartelera}/publicaciones/{id_publicacion}/comentarios")
    public ResponseEntity<?> getComentarios(@PathVariable("id_cartelera") Integer id_cartelera,
            @PathVariable("id_publicacion") Integer id_publicacion, 
            @RequestHeader (name="Authorization") String token){
        String username = TokenService.getUsernameFromToken(token);
        if (username != null)        
            return publicacionService.recuperarComentarios(id_publicacion);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("acceso no autorizado");
    }
            	
}
