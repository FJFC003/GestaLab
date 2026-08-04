package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.TokenRecuperacion;

public interface ITokenRecuperacionRepositorio {
	
	TokenRecuperacion guardar(TokenRecuperacion token);

	/** Busca por la huella del token. Es la consulta que resuelve el enlace. */
	Optional<TokenRecuperacion> buscarPorHash(String hashToken);

	/** Tokens todavia sin usar de un usuario, para invalidarlos al emitir uno nuevo. */
	List<TokenRecuperacion> buscarSinUsarPorUsuario(int idUsuario);


}
