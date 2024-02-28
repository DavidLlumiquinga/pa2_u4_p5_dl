package pa2_u4_p5_dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pa2_u4_p5_dl.repository.modelo.Persona;
import pa2_u4_p5_dl.service.IPersonaService;

//http://localhost:8085/personas/buscarTodos
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
	// /buscarPorCedula/17258961 -> la cedula siempre va ser variable  
	@GetMapping("/buscarPorCedula/{cedulaPersona}")
	public String buscarPorCedula(@PathVariable("cedulaPersona") String cedula,Model modelo) {
		Persona persona=this.iPersonaService.consultarPorCedula(cedula);
		modelo.addAttribute("persona",persona);
		return "vistaPersona";
	}
	//(Se utilizar en el actualizar)Cuando viaja el modelo en el request, tengo que declarar el objeto que viaja
	//PUT para actualizar
	@PutMapping("/actualizar/{cedulaPersona}")
	public String actualizar(@PathVariable("cedulaPersona") String cedula, Persona persona) {
		Persona perAux=this.iPersonaService.consultarPorCedula(cedula);
		perAux.setApellido(persona.getApellido());
		perAux.setNombre(persona.getNombre());
		perAux.setCedula(persona.getCedula());
		perAux.setGenero(persona.getGenero());
		this.iPersonaService.actualizar(perAux);
		return "redirect:/personas/buscarTodos";
	}
	
	//POST para guardar
	@PostMapping("/insertar")
	public String insertar(Persona persona) {
		this.iPersonaService.guardar(persona);
		return "redirect:/personas/buscarTodos";
	}
	
	@GetMapping("/nuevaPersona")
	public String mostrarNuevaPersona(Model modelo) {
		modelo.addAttribute("persona",new Persona());
		return "vistaNuevaPersona";
	}

	//DELETE para borrar
	@DeleteMapping("/borrar/{cedulaPersona}")
	public String borrar(@PathVariable("cedula") String cedula) {
		this.iPersonaService.borrarPorCedula(cedula);
		return "redirect:/personas/buscarTodos";
	}

}
