package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import org.springframework.data.domain.Page;

import com.prototipo.gestalab.dominio.entidades.ClienteC;

public interface IClienteCUseCase {
	
	ClienteC guardar (ClienteC nuevaCliente);
	ClienteC buscarPorId(int idClienteC);
	List<ClienteC> ListarTodos();
	Page<ClienteC> listarPaginado(int pagina, int tamanio);
	
	void eliminar (int idClienteC);

}
