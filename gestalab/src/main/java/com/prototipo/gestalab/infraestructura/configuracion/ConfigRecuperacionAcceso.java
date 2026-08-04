package com.prototipo.gestalab.infraestructura.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRecuperacionAccesoUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.impl.RecuperacionAccesoUseCaseImpl;
import com.prototipo.gestalab.aplicacion.casosuso.salida.INotificadorRecuperacion;
import com.prototipo.gestalab.dominio.repositorio.IEmpleadoRepositorio;
import com.prototipo.gestalab.dominio.repositorio.ITokenRecuperacionRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IUsuarioRepositorio;
import com.prototipo.gestalab.dominio.repositorio.IUsuariohasRolRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.adaptadores.TokenRecuperacionRepositorioImpl;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ITokenRecuperacionJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ITokenRecuperacionJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IUsuarioJpaRepositorio;


@Configuration
public class ConfigRecuperacionAcceso {

	@Bean
	ITokenRecuperacionRepositorio tokenRecuperacionRepositorio(
			ITokenRecuperacionJpaRepositorio jpaRepositorio,
			ITokenRecuperacionJpaMapper mapper,
			IUsuarioJpaRepositorio usuarioJpaRepositorio) {
		return new TokenRecuperacionRepositorioImpl(jpaRepositorio, mapper, usuarioJpaRepositorio);
	}

	@Bean
	IRecuperacionAccesoUseCase recuperacionAccesoUseCase(
			IUsuarioRepositorio usuarioRepositorio,
			IUsuariohasRolRepositorio usuariohasRolRepositorio,
			IEmpleadoRepositorio empleadoRepositorio,
			ITokenRecuperacionRepositorio tokenRepositorio,
			INotificadorRecuperacion notificador,
			PasswordEncoder passwordEncoder,
			@Value("${gestalab.cliente.base-url:http://localhost:8081}") String baseUrlCliente,
			@Value("${gestalab.recuperacion.minutos-validez:30}") int minutosValidez) {

		return new RecuperacionAccesoUseCaseImpl(usuarioRepositorio, usuariohasRolRepositorio,
				empleadoRepositorio, tokenRepositorio, notificador, passwordEncoder,
				baseUrlCliente, minutosValidez);
	}

}