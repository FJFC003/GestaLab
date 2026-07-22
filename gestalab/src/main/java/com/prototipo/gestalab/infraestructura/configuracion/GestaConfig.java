package com.prototipo.gestalab.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IAreaUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICargoUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoNormServiCUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoParametroUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoTerminoCondiCUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IClienteCUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICondicionAmbientalIRUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICotizacionCUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDatosLaboratorioIRUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDesviosOrdenOTUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDetalleCUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDetalleOrdenTrabajoOTUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEEPPLUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEquiposUtilizadosIRUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IFirmaElectronicaUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformacionAdicionalPLUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformacionMatrizPLUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformeResultadosIRUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IOrdenTrabajoOTUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IParametroAnalizarPLUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IPlanMuestreoPLUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IProcedimientoMuePLUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRecursosCronoPLUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IResultadosIRUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRolUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.ITipoTomaFreHoraPLUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IUsuariohasRolUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IVerificacionPLUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.impl.AreaUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.CargoUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.CatalogoNormServiCUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.CatalogoParametroUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.CatalogoTerminoCondiCUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.ClienteCUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.CondicionAmbientalIRUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.CotizacionCUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.DatosLaboratorioIRUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.DesviosOrdenOTUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.DetalleCUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.DetalleOrdenTrabajoOTImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.EEPPLUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.EmpleadoUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.EquiposUtilizadosIRUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.FirmaElectronicaUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.InformacionAdicionalPLUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.InformacionMatrizPLUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.InformeResultadosIRUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.OrdenTrabajoOTUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.ParametroAnalizarPLUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.PlanMuestreoPLUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.ProcedimientoMuePLUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.RecursosCronoPLUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.ResultadosIRUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.RolUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.TipoTomaFreHoraPLUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.UsuarioUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.UsuariohasRolUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.VerificacionPLUseCaseImpl;
import com.prototipo.gestalab.dominio.repositorio.IAreaRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ICargoRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoNormServiCRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoParametroCRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ICatalogoTerminoCondiCRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IClienteCRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ICondicionAmbientalIRRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ICotizacionCRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IDatosLaboratorioIRRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IDesviosOrdenOTRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IDetalleCRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IDetalleOrdenTrabajoOTRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IEEPPLRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IEmpleadoRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IEquiposUtilizadosIRRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IFirmaElectronicaRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IInformacionAdicionalPLRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IInformacionMatrizPLRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IInformeResultadosIRRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IOrdenTrabajoOTRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IParametroAnalizarPLRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IPlanMuestreoPLRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IProcedimientoMuePLRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IRecursosCronoPLRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IResultadosIRRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IRolRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ITipoTomaFreHoraPLRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IUsuarioRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IUsuariohasRolRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IVerificacionPLRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.AreaRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.CargoRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.CatalogoNormServiCRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.CatalogoParametroCRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.CatalogoTerminoCondiCRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.ClienteCRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.CondicionAmbientalIRRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.CotizacionCRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.DatosLaboratorioIRRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.DesviosOrdenOTRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.DetalleCRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.DetalleOrdenTrabajoOTRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.EEPPLRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.EmpleadoRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.EquiposUtilizadosIRRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.FirmaElectronicaRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.InformacionAdicionalPLRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.InformacionMatrizPLRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.InformeResultadosIRRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.OrdenTrabajoOTRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.ParametroAnalizarPLRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.PlanMuestreoPLRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.ProcedimientoMuePLRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.RecursosCronoPLRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.ResultadosIRRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.RolRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.TipoTomaFreHoraPLRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.UsuariohasRolRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.VerificacionPLRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IAreaJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICargoJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICatalogoNormServiCJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICatalogoParametrosCJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICatalogoTerminosCondiCJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IClienteCJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICondicionAmbientalIRJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICotizacionCJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDatosLaboratorioIRJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDesviosOrdenOTJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDetalleCJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDetalleOrdenTrabajoOTJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IEEPPLJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IEmpleadoJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IEquiposUtilizadosIRJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IFirmaElectronicaJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IInformacionAdicionalPLJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IInformacionMatrizPLJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IInformeResultadosIRJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IOrdenTrabajoOTJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IParametroAnalizarPLJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IPlanMuestreoPLJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IProcedimientoMuePLJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IRecursosCronoPLJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IResultadosIRJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ITipoTomaFreHoraPLJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IUsuariohasRolJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IVerificacionPLJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IAreaJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICargoJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoNormServiCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoParametroCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICatalogoTerminoCondiCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IClienteCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICondicionAmbientalIRJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICotizacionCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IDatosLaboratorioIRJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IDesviosOrdenOTJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IDetalleCJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IDetalleOrdenTrabajoOTJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IEEPPLJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IEmpleadoJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IEquiposUtilizadosIRJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IFirmaElectronicaJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IInformacionAdicionalPLJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IInformacionMatrizPLJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IInformeResultadosIRJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IOrdenTrabajoOTJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IParametroAnalizarPLJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IPlanMuestreoPLJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IProcedimientoMuePLJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IRecursosCronoPLJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IResultadosIRJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IRolJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ITipoTomaFreHoraPLJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IUsuarioJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IUsuariohasRolJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IVerificacionPLJpaRepositorio;

@Configuration
public class GestaConfig {
	
	@Bean
	IAreaRepositorio areaRepositorio(IAreaJpaRepositorio jpaRepositorio, IAreaJpaMapper mapper ) {
		return new AreaRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IAreaUseCase areaUseCase(IAreaRepositorio repo) {
		return new AreaUseCaseImpl(repo);
	}
	
	@Bean
	ICargoRepositorio cargoRepositorio(ICargoJpaRepositorio jpaRepositorio, ICargoJpaMapper mapper) {
		return new CargoRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ICargoUseCase cargoUseCase(ICargoRepositorio repo) {
		return new CargoUseCaseImpl(repo);
	}
	
	@Bean
	IFirmaElectronicaRepositorio firmaElectronicaRepositorio(IFirmaElectronicaJpaRepositorio jpaRepositorio, IFirmaElectronicaJpaMapper mapper) {
		return new FirmaElectronicaRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IFirmaElectronicaUseCase firmaElectronicaUseCase(IFirmaElectronicaRepositorio repo) {
		return new FirmaElectronicaUseCaseImpl(repo);
	}
	
	@Bean
	IEmpleadoRepositorio empleadoRepositorio(IEmpleadoJpaRepositorio jpaRepositorio, IEmpleadoJpaMapper mapper,
			IAreaJpaRepositorio areaJpaRepositorio, ICargoJpaRepositorio cargoJpaRepositorio,
			IFirmaElectronicaJpaRepositorio firmaJpaRepositorio, IUsuarioJpaRepositorio usuarioJpaRepositorio) {
		return new EmpleadoRepositorioImpl(jpaRepositorio, mapper, areaJpaRepositorio, cargoJpaRepositorio,
				firmaJpaRepositorio, usuarioJpaRepositorio);
	}
	
	@Bean
	IEmpleadoUseCase empleadoUseCase(IEmpleadoRepositorio repo) {
		return new EmpleadoUseCaseImpl(repo);
	}
	
	@Bean
	IUsuarioRepositorio usuarioRepositorio(IUsuarioJpaRepositorio jpaRepositorio, IUsuarioJpaMapper mapper) {
		return new UsuarioRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio repo) {
		return new UsuarioUseCaseImpl(repo);
	}
	
	@Bean
	IRolRepositorio rolRepositorio(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper mapper) {
		return new RolRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IRolUseCase rolUseCase(IRolRepositorio repo) {
		return new RolUseCaseImpl(repo);
	}
	
	@Bean
	IUsuariohasRolRepositorio usuariohasRolRepositorio(IUsuariohasRolJpaRepositorio jpaRepositorio,
			IUsuariohasRolJpaMapper mapper, IUsuarioJpaRepositorio usuarioJpaRepositorio,
			IRolJpaRepositorio rolJpaRepositorio) {
		return new UsuariohasRolRepositorioImpl(jpaRepositorio, mapper, usuarioJpaRepositorio, rolJpaRepositorio);
	}
	
	@Bean
	IUsuariohasRolUseCase usuariohasRolUseCase(IUsuariohasRolRepositorio repo) {
		return new UsuariohasRolUseCaseImpl(repo);
	}
	
	@Bean
	IDesviosOrdenOTRepositorio desviosOrdenRepositorio(IDesviosOrdenOTJpaRepositorio jpaRepositorio, IDesviosOrdenOTJpaMapper mapper) {
		return new DesviosOrdenOTRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IDesviosOrdenOTUseCase desviosOrdenOTUseCase(IDesviosOrdenOTRepositorio repo) {
		return new DesviosOrdenOTUseCaseImpl(repo);
	}
	
	@Bean
	IOrdenTrabajoOTRepositorio ordenTrabajoOTRepositorio(IOrdenTrabajoOTJpaRepositorio jpaRepositorio, IOrdenTrabajoOTJpaMapper mapper) {
		return new OrdenTrabajoOTRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IOrdenTrabajoOTUseCase ordenTrabajoOTUseCase(IOrdenTrabajoOTRepositorio repo) {
		return new OrdenTrabajoOTUseCaseImpl(repo);
	}
	
	@Bean
	IDetalleOrdenTrabajoOTRepositorio detalleOrdenTrabajoOTRepositorio(IDetalleOrdenTrabajoOTJpaRepositorio jpaRepositorio, IDetalleOrdenTrabajoOTJpaMapper mapper) {
		return new DetalleOrdenTrabajoOTRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IDetalleOrdenTrabajoOTUseCase detalleOrdenTrabajoOTUseCase(IDetalleOrdenTrabajoOTRepositorio repo) {
		return new DetalleOrdenTrabajoOTImpl(repo);
	}
	
	@Bean
	ICatalogoNormServiCRepositorio catalogoNormServiCRepositorio(ICatalogoNormServiCJpaRepositorio jpaRepositorio, ICatalogoNormServiCJpaMapper mapper) {
		return new CatalogoNormServiCRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ICatalogoNormServiCUseCase catalogoNormServiCUseCase(ICatalogoNormServiCRepositorio repo) {
		return new CatalogoNormServiCUseCaseImpl(repo);
	}
	
	@Bean
	ICatalogoParametroCRepositorio catalogoParametroCRepositorio(ICatalogoParametroCJpaRepositorio jpaRepositorio, ICatalogoParametrosCJpaMapper mapper) {
		return new CatalogoParametroCRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ICatalogoParametroUseCase catalogoParametroUseCase(ICatalogoParametroCRepositorio repo) {
		return new CatalogoParametroUseCaseImpl(repo);
	}
	
	@Bean
	IClienteCRepositorio clienteCRepositorio(IClienteCJpaRepositorio jpaRepositorio, IClienteCJpaMapper mapper) {
		return new ClienteCRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IClienteCUseCase clienteCUseCase(IClienteCRepositorio repo) {
		return new ClienteCUseCaseImpl(repo);
	}

	@Bean
	ICotizacionCRepositorio cotizacionCRepositorio(ICotizacionCJpaRepositorio jpaRepositorio, ICotizacionCJpaMapper mapper) {
		return new CotizacionCRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ICotizacionCUseCase cotizacionCUseCase(ICotizacionCRepositorio repo) {
		return new CotizacionCUseCaseImpl(repo);
	}

	@Bean
	IDetalleCRepositorio detalleCRepositorio(IDetalleCJpaRepositorio jpaRepositorio, IDetalleCJpaMapper mapper) {
		return new DetalleCRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IDetalleCUseCase detalleCUseCase(IDetalleCRepositorio repo) {
		return new DetalleCUseCaseImpl(repo);
	}

	@Bean
	ICatalogoTerminoCondiCRepositorio catalogoTerminoCondiCRepositorio(ICatalogoTerminoCondiCJpaRepositorio jpaRepositorio, ICatalogoTerminosCondiCJpaMapper mapper) {
		return new CatalogoTerminoCondiCRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ICatalogoTerminoCondiCUseCase catalogoTerminoCondiCUseCase(ICatalogoTerminoCondiCRepositorio repo) {
		return new CatalogoTerminoCondiCUseCaseImpl(repo);
	}
	
	
	@Bean
	IEEPPLRepositorio eepplRepositorio(IEEPPLJpaRepositorio jpaRepositorio, IEEPPLJpaMapper mapper) {
		return new EEPPLRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IEEPPLUseCase eepplUseCase(IEEPPLRepositorio repositorio) {
		return new EEPPLUseCaseImpl(repositorio);
	}

		@Bean
	IInformacionAdicionalPLRepositorio informacionAdicionalPLRepositorio(IInformacionAdicionalPLJpaRepositorio jpaRepositorio, IInformacionAdicionalPLJpaMapper mapper) {
			return new InformacionAdicionalPLRepositorioImpl(jpaRepositorio, mapper);
	}

		@Bean
	IInformacionAdicionalPLUseCase informacionAdicionalPLUseCase(IInformacionAdicionalPLRepositorio repo) {
			return new InformacionAdicionalPLUseCaseImpl(repo);
		}

		@Bean
	IInformacionMatrizPLRepositorio informacionMatrizPLRepositorio(IInformacionMatrizPLJpaRepositorio jpaRepositorio, IInformacionMatrizPLJpaMapper mapper) {
			return new InformacionMatrizPLRepositorioImpl(jpaRepositorio, mapper);
		}

		@Bean
	IInformacionMatrizPLUseCase informacionMatrizPLUseCase(IInformacionMatrizPLRepositorio repo) {
			return new InformacionMatrizPLUseCaseImpl(repo);
		}

		@Bean
	IParametroAnalizarPLRepositorio parametroAnalizarPLRepositorio(IParametroAnalizarPLJpaRepositorio jpaRepositorio, IParametroAnalizarPLJpaMapper mapper) {
			return new ParametroAnalizarPLRepositorioImpl(jpaRepositorio, mapper);
		}

		@Bean
	IParametroAnalizarPLUseCase parametroAnalizarPLUseCase(IParametroAnalizarPLRepositorio repo) {
			return new ParametroAnalizarPLUseCaseImpl(repo);
		}

		@Bean
	IPlanMuestreoPLRepositorio planMuestreoPLRepositorio(IPlanMuestreoPLJpaRepositorio jpaRepositorio, IPlanMuestreoPLJpaMapper mapper) {
			return new PlanMuestreoPLRepositorioImpl(jpaRepositorio, mapper);
		}

		@Bean
	IPlanMuestreoPLUseCase planMuestreoPLUseCase(IPlanMuestreoPLRepositorio repo) {
			return new PlanMuestreoPLUseCaseImpl(repo);
		}

		@Bean
	IProcedimientoMuePLRepositorio procedimientoMuePLRepositorio(IProcedimientoMuePLJpaRepositorio jpaRepositorio, IProcedimientoMuePLJpaMapper mapper) {
			return new ProcedimientoMuePLRepositorioImpl(jpaRepositorio, mapper);
		}

		@Bean
	IProcedimientoMuePLUseCase procedimientoMuePLUseCase(IProcedimientoMuePLRepositorio repo) {
			return new ProcedimientoMuePLUseCaseImpl(repo);
		}

		@Bean
	IRecursosCronoPLRepositorio recursosCronoPLRepositorio(IRecursosCronoPLJpaRepositorio jpaRepositorio, IRecursosCronoPLJpaMapper mapper) {
			return new RecursosCronoPLRepositorioImpl(jpaRepositorio, mapper);
		}

		@Bean
	IRecursosCronoPLUseCase recursosCronoPLUseCase(IRecursosCronoPLRepositorio repo) {
			return new RecursosCronoPLUseCaseImpl(repo);
		}

		@Bean
	ITipoTomaFreHoraPLRepositorio tipoTomaFreHoraPLRepositorio(ITipoTomaFreHoraPLJpaRepositorio jpaRepositorio, ITipoTomaFreHoraPLJpaMapper mapper) {
			return new TipoTomaFreHoraPLRepositorioImpl(jpaRepositorio, mapper);
		}

		@Bean
	ITipoTomaFreHoraPLUseCase tipoTomaFreHoraPLUseCase(ITipoTomaFreHoraPLRepositorio repo) {
			return new TipoTomaFreHoraPLUseCaseImpl(repo);
		}

		@Bean
	IVerificacionPLRepositorio verificacionPLRepositorio(IVerificacionPLJpaRepositorio jpaRepositorio, IVerificacionPLJpaMapper mapper) {
			return new VerificacionPLRepositorioImpl(jpaRepositorio, mapper);
		}

		@Bean
	IVerificacionPLUseCase verificacionPLUseCase(IVerificacionPLRepositorio repo) {
			return new VerificacionPLUseCaseImpl(repo);
		}

		@Bean
	ICondicionAmbientalIRRepositorio condicionAmbientalIRRepositorio(ICondicionAmbientalIRJpaRepositorio jpaRepositorio, ICondicionAmbientalIRJpaMapper mapper) {
			return new CondicionAmbientalIRRepositorioImpl(jpaRepositorio, mapper);
		}
		
		@Bean
	ICondicionAmbientalIRUseCase condicionAmbientalIRUseCase(ICondicionAmbientalIRRepositorio repo) {
			return new CondicionAmbientalIRUseCaseImpl(repo);
		}

		@Bean
	IDatosLaboratorioIRRepositorio datosLaboratorioIRRepositorio(IDatosLaboratorioIRJpaRepositorio jpaRepositorio, IDatosLaboratorioIRJpaMapper mapper) {
			return new DatosLaboratorioIRRepositorioImpl(jpaRepositorio, mapper);
		}
		
		@Bean
	IDatosLaboratorioIRUseCase datosLaboratorioIRUseCase(IDatosLaboratorioIRRepositorio repo) {
			return new DatosLaboratorioIRUseCaseImpl(repo);
		}

		// 3. EquiposUtilizadosIR
		@Bean
	IEquiposUtilizadosIRRepositorio equiposUtilizadosIRRepositorio(IEquiposUtilizadosIRJpaRepositorio jpaRepositorio, IEquiposUtilizadosIRJpaMapper mapper) {
			return new EquiposUtilizadosIRRepositorioImpl(jpaRepositorio, mapper);
		}
		
		@Bean
	IEquiposUtilizadosIRUseCase equiposUtilizadosIRUseCase(IEquiposUtilizadosIRRepositorio repo) {
			return new EquiposUtilizadosIRUseCaseImpl(repo);
		}

		@Bean
	IResultadosIRRepositorio resultadosIRRepositorio(IResultadosIRJpaRepositorio jpaRepositorio, IResultadosIRJpaMapper mapper) {
			return new ResultadosIRRepositorioImpl(jpaRepositorio, mapper);
		}
		
		@Bean
	IResultadosIRUseCase resultadosIRUseCase(IResultadosIRRepositorio repo) {
			return new ResultadosIRUseCaseImpl(repo);
		}

		@Bean
	IInformeResultadosIRRepositorio informeResultadosIRRepositorio(IInformeResultadosIRJpaRepositorio jpaRepositorio, IInformeResultadosIRJpaMapper mapper) {
			return new InformeResultadosIRRepositorioImpl(jpaRepositorio, mapper);
		}
		
		@Bean
	IInformeResultadosIRUseCase informeResultadosIRUseCase(IInformeResultadosIRRepositorio repo) {
			return new InformeResultadosIRUseCaseImpl(repo);
		}

}
