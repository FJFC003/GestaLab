package com.prototipo.gestalab.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.TokenRecuperacionEntity;

public interface ITokenRecuperacionJpaRepositorio extends JpaRepository<TokenRecuperacionEntity, Integer>{
	
	Optional<TokenRecuperacionEntity> findByHashToken(String hashToken);

	List<TokenRecuperacionEntity> findByFkUsuarioEntity_IdUsuarioAndUsadoFalse(int idUsuario);


}
