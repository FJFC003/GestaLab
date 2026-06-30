package com.prototipo.gestalab.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IAreaUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICargoUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.impl.AreaUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.impl.CargoUseCaseImpl;
import com.prototipo.gestalab.dominio.repositorio.IAreaRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ICargoRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.AreaRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.CargoRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.IAreaJpaMapper;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ICargoJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.IAreaJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICargoJpaRepositorio;

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

}
