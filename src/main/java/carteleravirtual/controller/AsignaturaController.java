package carteleravirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carteleravirtual.service.CarteleraService;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

	@Autowired
	CarteleraService carteleraService;
    	
}
