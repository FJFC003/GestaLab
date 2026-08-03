package com.prototipo.gestalab.aplicacion.casosuso.impl;

import java.util.List;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEquipoLaboratorioUseCase;
import com.prototipo.gestalab.dominio.entidades.EquipoLaboratorio;
import com.prototipo.gestalab.dominio.excepciones.RecursoNoEncontradoException;
import com.prototipo.gestalab.dominio.repositorio.IEquipoLaboratorioRepositorio;

public class EquipoLaboratorioUseCaseImpl implements IEquipoLaboratorioUseCase{
	
	private final IEquipoLaboratorioRepositorio repositorio;

	public EquipoLaboratorioUseCaseImpl(IEquipoLaboratorioRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public EquipoLaboratorio guardar(EquipoLaboratorio nuevoEquipoLaboratorio) {
		validarCodigoInternoUnico(nuevoEquipoLaboratorio);
		return repositorio.guardar(nuevoEquipoLaboratorio);
	}

	/**
	 * El codigo interno identifica al equipo dentro del laboratorio, asi que no
	 * puede repetirse. El nombre, la marca, el modelo y la serie si pueden: es
	 * normal tener dos equipos iguales comprados en lotes distintos.
	 */
	private void validarCodigoInternoUnico(EquipoLaboratorio candidato) {
		if (candidato.getCodigoInterno() == null || candidato.getCodigoInterno().isBlank()) {
			return;
		}
		String codigoLimpio = candidato.getCodigoInterno().trim();

		boolean repetido = repositorio.ListarTodos().stream()
				.filter(existente -> existente.getIdEquipoLab() != candidato.getIdEquipoLab())
				.anyMatch(existente -> existente.getCodigoInterno() != null
						&& existente.getCodigoInterno().trim().equalsIgnoreCase(codigoLimpio));

		if (repetido) {
			throw new IllegalStateException(
					"Ya existe un equipo con el codigo interno \"" + codigoLimpio + "\". Use uno diferente.");
		}
	}

	@Override
	public EquipoLaboratorio buscarPorId(int idEquipoLab) {
		return repositorio.buscarPorId(idEquipoLab)
				.orElseThrow(() -> new RecursoNoEncontradoException("Equipo de laboratorio no encontrado"));
	}

	@Override
	public List<EquipoLaboratorio> ListarTodos() {
		return repositorio.ListarTodos();
	}

	
	@Override
	public List<EquipoLaboratorio> listarActivos() {
		return repositorio.ListarTodos().stream()
				.filter(EquipoLaboratorio::isEstadoEquipoLab)
				.toList();
	}

	@Override
	public void eliminar(int idEquipoLab) {
		repositorio.eliminar(idEquipoLab);
	}


}
