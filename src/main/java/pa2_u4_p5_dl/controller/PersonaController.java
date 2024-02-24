package pa2_u4_p5_dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pa2_u4_p5_dl.repository.modelo.Persona;
import pa2_u4_p5_dl.service.IPersonaService;

//http://localhost:8085/personas/buscar
@Controller
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService iPersonaService;
	
	//Diferentes tipos de request
	//verbos o metodos HTTP
	
	@GetMapping("/buscarTodos")
	public String buscarTodos(Model modelo) {
		List<Persona> lista=this.iPersonaService.consultarTodo();
		modelo.addAttribute("personas",lista);
		return "vistaListaPersonas";
	}

	//PATH
	//GET para buscar 
	@GetMapping("/buscar")
	public String buscarPorCedula(String cedula) {
		
		return "";
	}
	
	//PUT para actualizar
	@PutMapping("/actualizar")
	public String actualizar() {
		return "";
	}

	//DELETE para borrar
	@DeleteMapping("/borrar")
	public String borrar() {
		return "";
	}
	//POST para guardar
	@PostMapping("/guardar")
	public String guardar() {
		return "";
	}
	
}
