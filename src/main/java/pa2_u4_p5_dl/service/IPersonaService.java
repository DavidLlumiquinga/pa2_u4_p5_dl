package pa2_u4_p5_dl.service;

import java.util.List;

import pa2_u4_p5_dl.repository.modelo.Persona;

public interface IPersonaService {

	public void guardar(Persona persona);
	public void actualizar(Persona persona);
	public Persona consultarPorCedula(String cedula);
	public void borrarPorCedula(String cedula);
	public List<Persona> consultarTodo();
}
