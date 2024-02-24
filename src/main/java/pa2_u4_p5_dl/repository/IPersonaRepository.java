package pa2_u4_p5_dl.repository;

import java.util.List;

import pa2_u4_p5_dl.repository.modelo.Persona;

public interface IPersonaRepository {

	public void insertar(Persona persona);
	public void actualizar(Persona persona);
	public Persona consultarPorCedula(String cedula);
	public void eliminarPorCedula(String cedula);
	public List<Persona> consultarTodo();
}
