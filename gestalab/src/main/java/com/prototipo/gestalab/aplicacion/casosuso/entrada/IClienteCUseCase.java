package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.ClienteC;

public interface IClienteCUseCase {
	
	ClienteC guardar (ClienteC nuevaCliente);
	ClienteC buscarPorId(int idClienteC);
	List<ClienteC> ListarTodos();
	
	void eliminar (int idClienteC);

}
