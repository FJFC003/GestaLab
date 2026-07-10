package com.prototipo.gestalab.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IAreaUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICargoUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDesviosOrdenOTUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IFirmaElectronicaUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IOrdenTrabajoOTUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRolUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IUsuariohasRolUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.impl.AreaUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.CargoUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.DesviosOrdenOTUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.EmpleadoUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.FirmaElectronicaUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.OrdenTrabajoOTUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.RolUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.UsuarioUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.UsuariohasRolUseCaseImpl;
import com.prototipo.gestalab.dominio.repositorio.IAreaRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ICargoRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IDesviosOrdenOTRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IEmpleadoRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IFirmaElectronicaRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IOrdenTrabajoOTRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IRolRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IUsuarioRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IUsuariohasRolRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.AreaRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.CargoRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.DesviosOrdenOTRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.EmpleadoRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.FirmaElectronicaRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.OrdenTrabajoOTRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.RolRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.UsuariohasRolRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IAreaJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICargoJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IDesviosOrdenOTJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IEmpleadoJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IFirmaElectronicaJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IOrdenTrabajoOTJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IUsuariohasRolJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IAreaJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICargoJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IDesviosOrdenOTJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IEmpleadoJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IFirmaElectronicaJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IOrdenTrabajoOTJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IRolJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IUsuarioJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IUsuariohasRolJpaRepositorio;

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
	IEmpleadoRepositorio empleadoRepositorio(IEmpleadoJpaRepositorio jpaRepositorio, IEmpleadoJpaMapper mapper) {
		return new EmpleadoRepositorioImpl(jpaRepositorio, mapper);
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
	IUsuariohasRolRepositorio usuariohasRolRepositorio(IUsuariohasRolJpaRepositorio jpaRepositorio, IUsuariohasRolJpaMapper mapper) {
		return new UsuariohasRolRepositorioImpl(jpaRepositorio, mapper);
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

}
