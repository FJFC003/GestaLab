package com.prototipo.gestalab.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRecuperacionAccesoUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.impl.RecuperacionAccesoUseCaseImpl;
import com.prototipo.gestalab.dominio.repositorio.IUsuarioRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IUsuariohasRolRepositorio;

@Configuration
public class ConfigRecuperacionAcceso {
	
	@Bean
	IRecuperacionAccesoUseCase recuperacionAccesoUseCase(
			IUsuarioRepositorio usuarioRepositorio,
			IUsuariohasRolRepositorio usuariohasRolRepositorio,
			PasswordEncoder passwordEncoder) {
		return new RecuperacionAccesoUseCaseImpl(
				usuarioRepositorio, usuariohasRolRepositorio, passwordEncoder);
	}

}
