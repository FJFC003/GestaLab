package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.prototipo.gestalab.dominio.entidades.ClienteC;


public interface IClienteCRepositorio {
	
	ClienteC guardar (ClienteC nuevaCliente);
	Optional<ClienteC> buscarPorId(int idClienteC);
	List<ClienteC> ListarTodos();
	Page<ClienteC> listarPaginado(int pagina, int tamanio);
	
	void eliminar (int idClienteC);

}
