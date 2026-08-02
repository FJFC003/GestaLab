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
		return repositorio.guardar(nuevoEquipoLaboratorio);
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
