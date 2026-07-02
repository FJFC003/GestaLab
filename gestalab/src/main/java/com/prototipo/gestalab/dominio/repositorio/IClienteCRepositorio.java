package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.ClienteC;


public interface IClienteCRepositorio {
	
	ClienteC guardar (ClienteC nuevaCliente);
	Optional<ClienteC> buscarPorId(int idClienteC);
	List<ClienteC> ListarTodos();
	
	void eliminar (int idClienteC);

}
