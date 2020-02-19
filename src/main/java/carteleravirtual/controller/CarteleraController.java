package carteleravirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carteleravirtual.common.Perfil;
import carteleravirtual.dto.CarteleraDTO;
import carteleravirtual.dto.PublicacionDTO;
import carteleravirtual.dto.UsuarioDTO;
import carteleravirtual.service.CarteleraService;
import carteleravirtual.service.PublicacionService;

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
    
    @GetMapping("/tipos_cartelera")
    @ResponseBody
    public Perfil[] recuperarTiposCartelera(){
    	return carteleraService.recuperarTiposCartelera();
    }
    
    @GetMapping("/carteleras/{id}")
    public ResponseEntity<?> recuperarCartelerasPorId(@PathVariable("id") Long id) {
        return carteleraService.recuperarCarteleras(id);
    }

    @PostMapping("/carteleras")
	@ResponseBody
	public ResponseEntity<?> crearCartelera(@RequestBody CarteleraDTO carteleraDTO){
		return carteleraService.crearCartelera(carteleraDTO);
    }
    /** ********************** SUSCRIPTORES/INTERESADOS *****************/
    
    @GetMapping("/carteleras/{id}/interesados")
    @ResponseBody
    public ResponseEntity<?> recuperarInteresados(@PathVariable("id") Long id){
    	return null; //carteleraService.recuperarCarteleras();
    }
    
    @PostMapping("/carteleras/{id_cartelera}/interesados")
    public ResponseEntity<?> suscribirInteresado(@RequestBody UsuarioDTO userDTO,
    		@PathVariable("id_cartelera") Long id_cartelera) {
        return null; //to do
    }
    
    /** ********************** PUBLICACIONES *****************/
    
    @PostMapping("/carteleras/{id_cartelera}/publicaciones")
    public ResponseEntity<?> subirPublicacion(@RequestBody PublicacionDTO publicacionDTO,
    		@PathVariable("id_cartelera") Long id_cartelera) {
        return null; //to do
    }
     
    @GetMapping("/carteleras/{id_cartelera}/publicaciones")
    public ResponseEntity<?> recuperarPublicaciones(@PathVariable("id_cartelera") Long id_cartelera) {
        return null; //to do
    }
    
    @GetMapping("/carteleras/{id_cartelera}/publicaciones/{id_publicacion}")
    public ResponseEntity<?> recuperarPublicacion(@PathVariable("id_cartelera") Long id_cartelera,
    		@PathVariable("id_publicacion") Long id_publicacion) {
        return null; //to do
    }
    	
}
