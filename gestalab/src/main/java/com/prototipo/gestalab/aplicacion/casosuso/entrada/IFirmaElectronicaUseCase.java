package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.FirmaElectronica;

public interface IFirmaElectronicaUseCase {
	
	FirmaElectronica guardar(FirmaElectronica nuevaFirma);
	FirmaElectronica buscarPorId(int idFirma);
	List<FirmaElectronica> ListarTodos();
	
	void eliminar(int idFirma);

}
