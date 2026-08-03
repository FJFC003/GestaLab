package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IAreaUseCase;
import com.prototipo.gestalab.dominio.entidades.Area;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IAreaRepositorio;


public class AreaUseCaseImpl implements IAreaUseCase{
	
	private final IAreaRepositorio repositorio;
	
	public AreaUseCaseImpl(IAreaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Area guardar(Area nuevaArea) {
		validarDatosObligatorios(nuevaArea);
		validarNombreUnico(nuevaArea);
		return repositorio.guardar(nuevaArea);
	}

	/**
	 * Nombre y descripcion son obligatorios. Se valida aqui, en el caso de uso,
	 * para que el mensaje llegue a la interfaz como un aviso legible y no como
	 * el mapa de errores de la validacion automatica.
	 */
	private void validarDatosObligatorios(Area candidato) {
		if (candidato.getNombre() == null || candidato.getNombre().isBlank()) {
			throw new IllegalStateException("El nombre no puede quedar vacío.");
		}
		if (candidato.getDescripcion() == null || candidato.getDescripcion().isBlank()) {
			throw new IllegalStateException("El apartado de descripción no puede quedar vacío.");
		}
	}

	/**
	 * El nombre no puede repetirse. Se compara sin distinguir mayusculas ni
	 * espacios sobrantes, y se excluye el propio registro para que editar
	 * sin cambiar el nombre siga funcionando.
	 */
	private void validarNombreUnico(Area candidato) {
		if (candidato.getNombre() == null || candidato.getNombre().isBlank()) {
			return;
		}
		String nombreLimpio = candidato.getNombre().trim();

		boolean repetido = repositorio.ListarTodos().stream()
				.filter(existente -> existente.getIdArea() != candidato.getIdArea())
				.anyMatch(existente -> existente.getNombre() != null
						&& existente.getNombre().trim().equalsIgnoreCase(nombreLimpio));

		if (repetido) {
			throw new IllegalStateException(
					"Ya existe un registro con el nombre \"" + nombreLimpio + "\". Use uno diferente.");
		}
	}

	@Override
	public Area buscarPorId(int idArea) {
		return repositorio
				.buscarPorId(idArea)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<Area> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idArea) {
		repositorio.eliminar(idArea);
	}


}
