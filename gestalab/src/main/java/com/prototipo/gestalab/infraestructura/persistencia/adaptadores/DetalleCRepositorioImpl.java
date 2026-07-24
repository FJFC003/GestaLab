package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.dominio.repositorio.IDetalleCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDetalleCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoNormServiCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoParametroCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICotizacionCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IDetalleCJpaRepositorio;

public class DetalleCRepositorioImpl implements IDetalleCRepositorio{
	
	private final IDetalleCJpaRepositorio jpaRepositorio;
	private final IDetalleCJpaMapper entityMapper;
	private final ICotizacionCJpaRepositorio cotizacionCJpaRepositorio;
	private final ICatalogoParametroCJpaRepositorio parametroCJpaRepositorio;
	private final ICatalogoNormServiCJpaRepositorio normServiCJpaRepositorio;

	public DetalleCRepositorioImpl(IDetalleCJpaRepositorio jpaRepositorio, IDetalleCJpaMapper entityMapper,
			ICotizacionCJpaRepositorio cotizacionCJpaRepositorio,
			ICatalogoParametroCJpaRepositorio parametroCJpaRepositorio,
			ICatalogoNormServiCJpaRepositorio normServiCJpaRepositorio) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.cotizacionCJpaRepositorio = cotizacionCJpaRepositorio;
		this.parametroCJpaRepositorio = parametroCJpaRepositorio;
		this.normServiCJpaRepositorio = normServiCJpaRepositorio;
	}

	@Override
	public DetalleC guardar(DetalleC nuevoDetalleC) {
		DetalleCEntity entity = entityMapper.toEntity(nuevoDetalleC);
		
		if (nuevoDetalleC.getFkCotizacion() != null && nuevoDetalleC.getFkCotizacion().getIdCotizacionC() > 0) {
			entity.setFkCotizacionCEntity(
					cotizacionCJpaRepositorio.findById(nuevoDetalleC.getFkCotizacion().getIdCotizacionC()).orElse(null));
		} else {
			entity.setFkCotizacionCEntity(null);
		}

		if (nuevoDetalleC.getFkParametro() != null && nuevoDetalleC.getFkParametro().getIdParametroC() > 0) {
			entity.setFkCatalogoParametroEntity(
					parametroCJpaRepositorio.findById(nuevoDetalleC.getFkParametro().getIdParametroC()).orElse(null));
		} else {
			entity.setFkCatalogoParametroEntity(null);
		}

		if (nuevoDetalleC.getFkNormaServicio() != null && nuevoDetalleC.getFkNormaServicio().getIdCatalogoNormServi() > 0) {
			entity.setFkCatalogoNormServiEntity(
					normServiCJpaRepositorio.findById(nuevoDetalleC.getFkNormaServicio().getIdCatalogoNormServi()).orElse(null));
		} else {
			entity.setFkCatalogoNormServiEntity(null);
		}
		
		DetalleCEntity guardar = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardar);
	}

	@Override
	public Optional<DetalleC> buscarPorId(int idDetalleC) {
		// TODO Auto-generated method stub
		return jpaRepositorio.findById(idDetalleC).map(entityMapper :: toDomain);
	}

	@Override
	public List<DetalleC> ListarTodos() {
		// TODO Auto-generated method stub
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDetalleC) {
		// TODO Auto-generated method stub
		jpaRepositorio.deleteById(idDetalleC);
	}

}
