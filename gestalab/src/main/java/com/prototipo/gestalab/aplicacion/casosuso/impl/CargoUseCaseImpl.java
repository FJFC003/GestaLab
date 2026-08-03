package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICargoUseCase;
import com.prototipo.gestalab.dominio.entidades.Cargo;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.ICargoRepositorio;

public class CargoUseCaseImpl implements ICargoUseCase{
	
	private final ICargoRepositorio repositorio;

	public CargoUseCaseImpl(ICargoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Cargo guardar(Cargo nuevoCargo) {
		validarNombreUnico(nuevoCargo);
		return repositorio.guardar(nuevoCargo);
	}

	/**
	 * El nombre no puede repetirse. Se compara sin distinguir mayusculas ni
	 * espacios sobrantes, y se excluye el propio registro para que editar
	 * sin cambiar el nombre siga funcionando.
	 */
	private void validarNombreUnico(Cargo candidato) {
		if (candidato.getNombre() == null || candidato.getNombre().isBlank()) {
			return;
		}
		String nombreLimpio = candidato.getNombre().trim();

		boolean repetido = repositorio.ListarTodos().stream()
				.filter(existente -> existente.getIdCargo() != candidato.getIdCargo())
				.anyMatch(existente -> existente.getNombre() != null
						&& existente.getNombre().trim().equalsIgnoreCase(nombreLimpio));

		if (repetido) {
			throw new IllegalStateException(
					"Ya existe un registro con el nombre \"" + nombreLimpio + "\". Use uno diferente.");
		}
	}

	@Override
	public Cargo buscarPorId(int idCargo) {
		return repositorio
				.buscarPorId(idCargo)
				.orElseThrow(() -> new RecursoNoEncontradoException("Información no encontrada"));
	}

	@Override
	public List<Cargo> ListarTodos() {
		return repositorio.ListarTodos();
	}

	@Override
	public void eliminar(int idCargo) {
		repositorio.eliminar(idCargo);
	}


}
