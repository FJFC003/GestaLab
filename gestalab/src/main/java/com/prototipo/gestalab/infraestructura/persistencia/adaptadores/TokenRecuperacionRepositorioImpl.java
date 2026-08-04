package com.prototipo.gestalab.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.TokenRecuperacion;
import com.prototipo.gestalab.dominio.repositorio.ITokenRecuperacionRepositorio;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.TokenRecuperacionEntity;
import com.prototipo.gestalab.infraestructura.persistencia.mapeadores.ITokenRecuperacionJpaMapper;
import com.prototipo.gestalab.infraestructura.repositorios.ITokenRecuperacionJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IUsuarioJpaRepositorio;

public class TokenRecuperacionRepositorioImpl implements ITokenRecuperacionRepositorio {

	private final ITokenRecuperacionJpaRepositorio jpaRepositorio;
	private final ITokenRecuperacionJpaMapper entityMapper;
	private final IUsuarioJpaRepositorio usuarioJpaRepositorio;

	public TokenRecuperacionRepositorioImpl(ITokenRecuperacionJpaRepositorio jpaRepositorio,
			ITokenRecuperacionJpaMapper entityMapper,
			IUsuarioJpaRepositorio usuarioJpaRepositorio) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.usuarioJpaRepositorio = usuarioJpaRepositorio;
	}

	@Override
	public TokenRecuperacion guardar(TokenRecuperacion token) {
		TokenRecuperacionEntity entity = entityMapper.toEntity(token);

		// La FK se resuelve contra Hibernate, no con una entidad "suelta"
		// construida por el mapeador: es el mismo patron que EmpleadoRepositorioImpl
		// y evita el TransientPropertyValueException.
		if (token.getFkUsuario() != null && token.getFkUsuario().getIdUsuario() > 0) {
			entity.setFkUsuarioEntity(
					usuarioJpaRepositorio.findById(token.getFkUsuario().getIdUsuario()).orElse(null));
		} else {
			entity.setFkUsuarioEntity(null);
		}

		return entityMapper.toDomain(jpaRepositorio.save(entity));
	}

	@Override
	public Optional<TokenRecuperacion> buscarPorHash(String hashToken) {
		return jpaRepositorio.findByHashToken(hashToken).map(entityMapper::toDomain);
	}

	@Override
	public List<TokenRecuperacion> buscarSinUsarPorUsuario(int idUsuario) {
		return jpaRepositorio.findByFkUsuarioEntity_IdUsuarioAndUsadoFalse(idUsuario)
				.stream().map(entityMapper::toDomain).toList();
	}

}