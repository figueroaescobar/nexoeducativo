package com.nigmacode.apiREST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nigmacode.apiREST.entity.cargo;
import com.nigmacode.apiREST.service.CargoService;

//Indiciamos que es un controlador rest
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600) // SE COMUNICA CON FRONT END
@RestController
@RequestMapping("/apiCar") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/


public class CargoRestController {
	
	//Inyectamos el servicio para poder hacer uso de el
	@Autowired
	private CargoService CargoService;
	
	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
	http://127.0.0.1:8080/api/users*/
	@GetMapping("/Cargos")
	public List<cargo> findAll(){
		//retornara todos los usuarios
		return CargoService.findAll();
	}
	
	/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
	http://127.0.0.1:8080/api/users/1*/
	@GetMapping("/Cargos/{idCargo}")
	public cargo getCargo(@PathVariable int idCargo) {
		cargo Cargo = CargoService.findById(idCargo);
		
		if (Cargo == null) {
			throw new RuntimeException("User id no encontrado -" + idCargo);
		}
		//retornara al usuario con id pasado en la url
		return Cargo;
	}
	
	/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/apiCar/Cargos/  */
	@PostMapping("/Cargos")
	public cargo addCargo(@RequestBody cargo Cargo) {
        Cargo.setID_CARGO(0);
		
        
        try{
        	//Este metodo guardara al usuario enviado
            CargoService.save(Cargo);
        }catch (Exception e) {
        	e.printStackTrace();
        }
        
		return Cargo;
	}
	
	/*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
	http://127.0.0.1:8080/api/users/  */
	@PutMapping("/Cargos")
	public cargo updateCargo(@RequestBody cargo Cargo) {
		CargoService.save(Cargo);
		
		//este metodo actualizara al usuario enviado
		
		return Cargo;
	}
	
	/*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
	http://127.0.0.1:8080/api/users/1  */
	@DeleteMapping("Cargos/{idCargo}")
	public String deleteCargo(@PathVariable int idCargo) {
		cargo Cargo = CargoService.findById(idCargo);
		
		if(Cargo == null) {
			throw new RuntimeException("User id no encontrado -"+idCargo);
		}
		
		CargoService.deleteById(idCargo);
		
		//Esto método, recibira el id de un usuario por URL y se borrará de la bd.
		return "Deleted user id - "+ idCargo;
	}

}
