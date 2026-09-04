package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import java.util.List;

import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;
import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;
import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;
import com.prototipo.gestalab.dominio.entidades.ResultadosIR;

public interface IInformeResultadosIRUseCase {
	
	InformeResultadosIR guardar(InformeResultadosIR nuevoInforme);
	InformeResultadosIR buscarPorId(int idInforme);
	List<InformeResultadosIR> ListarTodos();
	void eliminar(int idInforme);

	InformeResultadosIR buscarPorOrden(int idOT);

	InformeResultadosIR guardarInformeCompleto(InformeResultadosIR informe,
			List<ResultadosIR> resultados,
			List<CondicionAmbientalIR> condiciones,
			List<EquiposUtilizadosIR> equipos);


	InformeResultadosIR enviarACoordinacion(int idInforme);
	InformeResultadosIR devolverALaboratorio(int idInforme, String motivo);
	List<InformeResultadosIR> listarEnviados();

}
