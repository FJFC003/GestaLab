package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRolUseCase;
import com.prototipo.gestalab.dominio.entidades.Rol;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IRolRepositorio;

public class RolUseCaseImpl implements IRolUseCase{
	
	private final IRolRepositorio repositorio;

	public RolUseCaseImpl(IRolRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Rol guardar(Rol nuevoRol) {
		validarNombreUnico(nuevoRol);
		return repositorio.guardar(nuevoRol);
	}

	/**
	 * El nombre no puede repetirse. Se compara sin distinguir mayusculas ni
	 * espacios sobrantes, y se excluye el propio registro para que editar
	 * sin cambiar el nombre siga funcionando.
	 */
	private void validarNombreUnico(Rol candidato) {
		if (candidato.getNombre() == null || candidato.getNombre().isBlank()) {
			return;
		}
		String nombreLimpio = candidato.getNombre().trim();

		boolean repetido = repositorio.ListarTodos().stream()
				.filter(existente -> existente.getIdRol() != candidato.getIdRol())
				.anyMatch(existente -> existente.getNombre() != null
						&& existente.getNombre().trim().equalsIgnoreCase(nombreLimpio));

		if (repetido) {
			throw new IllegalStateException(
					"Ya existe un registro con el nombre \"" + nombreLimpio + "\". Use uno diferente.");
		}
	}

	@Override
	public Rol buscarPorId(int idRol) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idRol)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<Rol> ListarTodos() {
		// TODO Auto-generated method stub
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idRol) {
		// TODO Auto-generated method stub
		repositorio.eliminar(idRol);
	}

}
