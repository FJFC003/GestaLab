package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.UsuarioEntity;

public interface IUsuarioJpaRepositorio extends JpaRepository<UsuarioEntity, Integer> {
	
	Optional<UsuarioEntity> findByCorreo(String correo);

}
