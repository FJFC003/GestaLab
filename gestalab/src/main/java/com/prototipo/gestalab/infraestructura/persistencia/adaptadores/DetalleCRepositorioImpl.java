package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.DetalleC;
import com.prototipo.gestalab.dominio.entidades.DetalleParametroC;
import com.prototipo.gestalab.dominio.repositorio.IDetalleCRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.DetalleParametroCEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDetalleCJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoParametroCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICotizacionCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IDescripcionServicioCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IDetalleCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ILmpCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IPlazoEntregaCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ITipoTomaMuestraCJpaRepositorio;

public class DetalleCRepositorioImpl implements IDetalleCRepositorio {

	private final IDetalleCJpaRepositorio jpaRepositorio;
	private final IDetalleCJpaMapper entityMapper;
	private final ICotizacionCJpaRepositorio cotizacionCJpaRepositorio;
	private final ICatalogoParametroCJpaRepositorio parametroCJpaRepositorio;
	private final ILmpCJpaRepositorio lmpCJpaRepositorio;
	private final IDescripcionServicioCJpaRepositorio descripcionServicioCJpaRepositorio;
	private final IPlazoEntregaCJpaRepositorio plazoEntregaCJpaRepositorio;
	private final ITipoTomaMuestraCJpaRepositorio tipoTomaMuestraCJpaRepositorio;

	public DetalleCRepositorioImpl(IDetalleCJpaRepositorio jpaRepositorio, IDetalleCJpaMapper entityMapper,
			ICotizacionCJpaRepositorio cotizacionCJpaRepositorio,
			ICatalogoParametroCJpaRepositorio parametroCJpaRepositorio,
			ILmpCJpaRepositorio lmpCJpaRepositorio,
			IDescripcionServicioCJpaRepositorio descripcionServicioCJpaRepositorio,
			IPlazoEntregaCJpaRepositorio plazoEntregaCJpaRepositorio,
			ITipoTomaMuestraCJpaRepositorio tipoTomaMuestraCJpaRepositorio) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.cotizacionCJpaRepositorio = cotizacionCJpaRepositorio;
		this.parametroCJpaRepositorio = parametroCJpaRepositorio;
		this.lmpCJpaRepositorio = lmpCJpaRepositorio;
		this.descripcionServicioCJpaRepositorio = descripcionServicioCJpaRepositorio;
		this.plazoEntregaCJpaRepositorio = plazoEntregaCJpaRepositorio;
		this.tipoTomaMuestraCJpaRepositorio = tipoTomaMuestraCJpaRepositorio;
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

		if (nuevoDetalleC.getFkDescripcionServicio() != null
				&& nuevoDetalleC.getFkDescripcionServicio().getIdDescripcionServicioC() > 0) {
			entity.setFkDescripcionServicioEntity(descripcionServicioCJpaRepositorio
					.findById(nuevoDetalleC.getFkDescripcionServicio().getIdDescripcionServicioC()).orElse(null));
		} else {
			entity.setFkDescripcionServicioEntity(null);
		}

		if (nuevoDetalleC.getFkPlazoEntrega() != null && nuevoDetalleC.getFkPlazoEntrega().getIdPlazoEntregaC() > 0) {
			entity.setFkPlazoEntregaEntity(
					plazoEntregaCJpaRepositorio.findById(nuevoDetalleC.getFkPlazoEntrega().getIdPlazoEntregaC())
							.orElse(null));
		} else {
			entity.setFkPlazoEntregaEntity(null);
		}

		if (nuevoDetalleC.getFkTipoTomaMuestra() != null
				&& nuevoDetalleC.getFkTipoTomaMuestra().getIdTipoTomaMuestraC() > 0) {
			entity.setFkTipoTomaMuestraEntity(tipoTomaMuestraCJpaRepositorio
					.findById(nuevoDetalleC.getFkTipoTomaMuestra().getIdTipoTomaMuestraC()).orElse(null));
		} else {
			entity.setFkTipoTomaMuestraEntity(null);
		}

		// Al actualizar hay que partir de la lista de hijos que ya existe en la
		// base. Si se asignara una lista nueva sobre una entidad recien creada
		// por el mapeador, Hibernate no tendria como saber cuales borrar.
		DetalleCEntity destino = entity;
		if (nuevoDetalleC.getIdDetalleC() > 0) {
			DetalleCEntity existente = jpaRepositorio.findById(nuevoDetalleC.getIdDetalleC()).orElse(null);
			if (existente != null) {
				existente.setCantidadPuntosDetalleC(entity.getCantidadPuntosDetalleC());
				existente.setPrecioUnitarioDetalleC(entity.getPrecioUnitarioDetalleC());
				existente.setPrecioTotalDetalleC(entity.getPrecioTotalDetalleC());
				existente.setCondicionDetalleC(entity.getCondicionDetalleC());
				existente.setFrecuenciaDetalleC(entity.getFrecuenciaDetalleC());
				existente.setFkCotizacionCEntity(entity.getFkCotizacionCEntity());
				existente.setFkDescripcionServicioEntity(entity.getFkDescripcionServicioEntity());
				existente.setFkPlazoEntregaEntity(entity.getFkPlazoEntregaEntity());
				existente.setFkTipoTomaMuestraEntity(entity.getFkTipoTomaMuestraEntity());
				destino = existente;
			}
		}

		aplicarParametros(destino, nuevoDetalleC.getListaParametros());

		DetalleCEntity guardado = jpaRepositorio.save(destino);
		return entityMapper.toDomain(guardado);
	}

	/**
	 * Reemplaza los ensayos del grupo de servicio. Se vacia la coleccion en vez
	 * de sustituirla para que orphanRemoval borre los que ya no vienen.
	 */
	private void aplicarParametros(DetalleCEntity destino, List<DetalleParametroC> parametros) {
		destino.getListaParametros().clear();

		if (parametros == null) {
			return;
		}

		for (DetalleParametroC parametro : parametros) {
			if (parametro == null || parametro.getFkParametro() == null
					|| parametro.getFkParametro().getIdParametroC() <= 0) {
				continue;
			}

			DetalleParametroCEntity hijo = new DetalleParametroCEntity();
			hijo.setFkDetalleCEntity(destino);
			hijo.setFkCatalogoParametroEntity(
					parametroCJpaRepositorio.findById(parametro.getFkParametro().getIdParametroC()).orElse(null));

			if (parametro.getFkLmp() != null && parametro.getFkLmp().getIdLmpC() > 0) {
				hijo.setFkLmpEntity(lmpCJpaRepositorio.findById(parametro.getFkLmp().getIdLmpC()).orElse(null));
			}

			destino.getListaParametros().add(hijo);
		}
	}

	@Override
	public Optional<DetalleC> buscarPorId(int idDetalleC) {
		return jpaRepositorio.findById(idDetalleC).map(entityMapper::toDomain);
	}

	@Override
	public List<DetalleC> ListarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDetalleC) {
		jpaRepositorio.deleteById(idDetalleC);
	}

	@Override
	public List<DetalleC> buscarPorCotizacion(int idCotizacionC) {
		return jpaRepositorio.findByFkCotizacionCEntity_IdCotizacionC(idCotizacionC)
				.stream()
				.map(entityMapper::toDomain)
				.toList();
	}

}
