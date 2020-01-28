package carteleravirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carteleravirtual.dto.CarteleraDTO;
import carteleravirtual.service.CarteleraService;

@RestController
@RequestMapping("/carteleras")
public class CarteleraController {

	@Autowired
	CarteleraService carteleraService;

    @GetMapping
    @CrossOrigin(origins = "*")
    @ResponseBody
    public ResponseEntity<?> recuperarCarteleras(){
    	return carteleraService.recuperarCarteleras();
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> recuperarCartelerasPorId(@PathVariable("id") Long id) {
        return carteleraService.recuperarCarteleras(id);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
	@ResponseBody
	public ResponseEntity<?> crearCartelera(@RequestHeader("token") String token, 
			@RequestBody CarteleraDTO carteleraDTO){
		return carteleraService.crearCartelera(carteleraDTO, token);
    }
    	
}
