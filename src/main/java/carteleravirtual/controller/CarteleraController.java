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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carteleravirtual.common.Perfil;
import carteleravirtual.dto.CarteleraDTO;
import carteleravirtual.dto.ComentarioDTO;
import carteleravirtual.dto.PublicacionDTO;
import carteleravirtual.dto.UsuarioDTO;
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

	/** ******************* CARTELERAS ************ */
	
    @GetMapping("/carteleras_publicas")
    @ResponseBody
    public ResponseEntity<?> recuperarCarteleras(){
    	return carteleraService.recuperarCarteleras();
    }
    
    @GetMapping("/carteleras_usuario")
    @ResponseBody
    public ResponseEntity<?> recuperarCartelerasPorUsuario(@RequestHeader (name="Authorization") String token){
        String username = TokenService.getUsernameFromToken(token);
    	return carteleraService.recuperarCartelerasPorUsuario(username);
    }
    
    @GetMapping("/carteleras_fav_usuario")
    @ResponseBody
    public ResponseEntity<?> recuperarCartelerasFavPorUsuario(@RequestHeader (name="Authorization") String token){
        String username = TokenService.getUsernameFromToken(token);
    	return carteleraService.recuperarCartelerasFavPorUsuario(username);
    }

    @GetMapping("/tipos_cartelera")
    @ResponseBody
    public Perfil[] recuperarTiposCartelera(){
    	return carteleraService.recuperarTiposCartelera();
    }
    
    @GetMapping("/carteleras/{id}")
    public ResponseEntity<?> recuperarCartelerasPorId(@PathVariable("id") Integer id) {
        return carteleraService.recuperarCarteleras(id);
    }

    @PostMapping("/carteleras")
	@ResponseBody
	public ResponseEntity<?> crearCartelera(@RequestBody CarteleraDTO carteleraDTO,
			@RequestHeader (name="Authorization") String token){
    	String username = TokenService.getUsernameFromToken(token);
		return carteleraService.crearCartelera(carteleraDTO, username);
    }
    /** ********************** SUSCRIPTORES/INTERESADOS *****************/
    
    @GetMapping("/carteleras/{id}/interesados")
    @ResponseBody
    public ResponseEntity<?> recuperarInteresados(@PathVariable("id") Integer id){
    	return null; //carteleraService.recuperarCarteleras();
    }
    
    @PostMapping("/carteleras/{id}/interesados")
    public ResponseEntity<?> suscribirInteresado(@RequestBody UsuarioDTO userDTO,
    		@PathVariable("id") Long id) {
        return null; //to do
    }
    
    /** ********************** PUBLICACIONES *****************/
    
    @PostMapping("/carteleras/{id_cartelera}/publicaciones")
    public ResponseEntity<?> subirPublicacion(@RequestBody PublicacionDTO publicacionDTO,
    		@PathVariable("id_cartelera") Integer id_cartelera, 
    		@RequestHeader (name="Authorization") String token) {
    	String username = TokenService.getUsernameFromToken(token);
        return carteleraService.agregarPublicacion(publicacionDTO, id_cartelera, username);
    }
     
    @GetMapping("/carteleras/{id_cartelera}/publicaciones")
    public ResponseEntity<?> recuperarPublicaciones(@PathVariable("id_cartelera") Integer id_cartelera) {
        return carteleraService.recuperarPublicaciones(id_cartelera);
    }
    
    @GetMapping("/carteleras/{id_cartelera}/publicaciones/{id_publicacion}")
    public ResponseEntity<?> recuperarPublicacion(@PathVariable("id_cartelera") Integer id_cartelera,
    		@PathVariable("id_publicacion") Integer id_publicacion) {
        return carteleraService.recuperarPublicacion(id_cartelera, id_publicacion);
    }
    
    /** ********************** COMENTARIOS *****************/
    
    @PostMapping("/carteleras/{id_cartelera}/publicaciones/{id_publicacion}/comentarios")
    public ResponseEntity<?> postComentario(@RequestBody ComentarioDTO comentarioDTO,
    		@PathVariable("id_cartelera") Integer id_cartelera,
    		@PathVariable("id_publicacion") Integer id_publicacion,
    		@RequestHeader (name="Authorization") String token) {
    	String username = TokenService.getUsernameFromToken(token);
        return publicacionService.agregarComentario(comentarioDTO, id_cartelera, id_publicacion, username);
    }
    
    @GetMapping("/carteleras/{id_cartelera}/publicaciones/{id_publicacion}/comentarios")
    public ResponseEntity<?> getComentarios(@PathVariable("id_cartelera") Integer id_cartelera,
    		@PathVariable("id_publicacion") Integer id_publicacion){
        return publicacionService.recuperarComentarios(id_publicacion);
    }
    
    @PutMapping("/carteleras/{id_cartelera}/publicaciones/{id_publicacion}/comentarios")
    public ResponseEntity<?> updateComentario(@RequestBody ComentarioDTO comentarioDTO,
    		@PathVariable("id_cartelera") Integer id_cartelera,
    		@PathVariable("id_publicacion") Integer id_publicacion,
    		@RequestHeader (name="Authorization") String token) {
    	String username = TokenService.getUsernameFromToken(token);
        return null;//publicacionService.agregarComentario(comentarioDTO, id_cartelera, id_publicacion, username);
    }
    
    /** ********************** SUSCRIPTOS *****************/
    
    @PutMapping("/carteleras/{id_cartelera}/suscribe")
    public ResponseEntity<?> suscribe(@PathVariable("id_cartelera") Integer id_cartelera, 
    		@RequestHeader (name="Authorization") String token) {
    	String username = TokenService.getUsernameFromToken(token);
        return carteleraService.suscribe(id_cartelera, username);
    }
    
    @PutMapping("/carteleras/{id_cartelera}/unsuscribe")
    public ResponseEntity<?> unsuscribe(@PathVariable("id_cartelera") Integer id_cartelera, 
    		@RequestHeader (name="Authorization") String token) {
    	String username = TokenService.getUsernameFromToken(token);
        return carteleraService.unsuscribe(id_cartelera, username);
    }
    	
}
