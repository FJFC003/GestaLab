package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.CotizacionC;
import com.prototipo.gestalab.dominio.repositorio.ICotizacionCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CotizacionCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICotizacionCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoNormServiCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IClienteCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICotizacionCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IDetalleCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IEmpleadoJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ILmpCJpaRepositorio;

public class CotizacionCRepositorioImpl implements ICotizacionCRepositorio{
	
	private final ICotizacionCJpaRepositorio jpaRepositorio;
	private final ICotizacionCJpaMapper entityMapper;
	private final IClienteCJpaRepositorio clienteCJpaRepositorio;
	private final IEmpleadoJpaRepositorio empleadoJpaRepositorio;
	private final IDetalleCJpaRepositorio detalleCJpaRepositorio;
	private final ICatalogoNormServiCJpaRepositorio normaCJpaRepositorio;
	private final ILmpCJpaRepositorio lmpCJpaRepositorio;

	public CotizacionCRepositorioImpl(ICotizacionCJpaRepositorio jpaRepositorio, ICotizacionCJpaMapper entityMapper,
			IClienteCJpaRepositorio clienteCJpaRepositorio, IEmpleadoJpaRepositorio empleadoJpaRepositorio,
			IDetalleCJpaRepositorio detalleCJpaRepositorio, ICatalogoNormServiCJpaRepositorio normaCJpaRepositorio,
			ILmpCJpaRepositorio lmpCJpaRepositorio) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.clienteCJpaRepositorio = clienteCJpaRepositorio;
		this.empleadoJpaRepositorio = empleadoJpaRepositorio;
		this.detalleCJpaRepositorio = detalleCJpaRepositorio;
		this.normaCJpaRepositorio = normaCJpaRepositorio;
		this.lmpCJpaRepositorio = lmpCJpaRepositorio;
	}

	@Override
	public CotizacionC guardar(CotizacionC nuevoCotizacionC) {
		CotizacionCEntity entity = entityMapper.toEntity(nuevoCotizacionC);
		
		if (nuevoCotizacionC.getFkCliente() != null && nuevoCotizacionC.getFkCliente().getIdClienteC() > 0) {
			entity.setFkClienteCEntity(
					clienteCJpaRepositorio.findById(nuevoCotizacionC.getFkCliente().getIdClienteC()).orElse(null));
		} else {
			entity.setFkClienteCEntity(null);
		}

		if (nuevoCotizacionC.getFkEmpleado() != null && nuevoCotizacionC.getFkEmpleado().getIdEmpleado() > 0) {
			entity.setFkEmpleadoEntity(
					empleadoJpaRepositorio.findById(nuevoCotizacionC.getFkEmpleado().getIdEmpleado()).orElse(null));
		} else {
			entity.setFkEmpleadoEntity(null);
		}

		if (nuevoCotizacionC.getFkNormaServicio() != null && nuevoCotizacionC.getFkNormaServicio().getIdCatalogoNormServi() > 0) {
			entity.setFkCatalogoNormServiEntity(
					normaCJpaRepositorio.findById(nuevoCotizacionC.getFkNormaServicio().getIdCatalogoNormServi()).orElse(null));
		} else {
			entity.setFkCatalogoNormServiEntity(null);
		}

		if (nuevoCotizacionC.getFkLmp() != null && nuevoCotizacionC.getFkLmp().getIdLmpC() > 0) {
			entity.setFkLmpEntity(
					lmpCJpaRepositorio.findById(nuevoCotizacionC.getFkLmp().getIdLmpC()).orElse(null));
		} else {
			entity.setFkLmpEntity(null);
		}
		
		CotizacionCEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<CotizacionC> buscarPorId(int idCotizacionC) {
		return jpaRepositorio.findById(idCotizacionC).map(entityMapper :: toDomain);
	}

	@Override
	public List<CotizacionC> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCotizacionC) {
		detalleCJpaRepositorio.deleteAll(detalleCJpaRepositorio.findByFkCotizacionCEntity_IdCotizacionC(idCotizacionC));
		jpaRepositorio.deleteById(idCotizacionC);
	}
}
