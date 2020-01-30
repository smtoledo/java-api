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
import carteleravirtual.service.CarteleraService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarteleraController {

	@Autowired
	CarteleraService carteleraService;

    @GetMapping("/carteleras")
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
    	
}
