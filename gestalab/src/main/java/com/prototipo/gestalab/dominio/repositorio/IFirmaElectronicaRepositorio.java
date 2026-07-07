package com.prototipo.gestalab.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.prototipo.gestalab.dominio.entidades.FirmaElectronica;

public interface IFirmaElectronicaRepositorio {
	
	FirmaElectronica guardar(FirmaElectronica nuevaFirma);
	Optional<FirmaElectronica> buscarPorId(int idFirma);
	List<FirmaElectronica> ListarTodos();
	
	void eliminar(int idFirma);

}
