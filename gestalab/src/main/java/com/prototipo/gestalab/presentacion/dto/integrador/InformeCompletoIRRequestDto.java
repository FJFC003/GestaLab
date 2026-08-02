package com.prototipo.gestalab.presentacion.dto.integrador;

import java.util.ArrayList;
import java.util.List;

import com.prototipo.gestalab.presentacion.dto.request.CondicionAmbientalIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.request.EquiposUtilizadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.request.InformeResultadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.request.ResultadosIRRequestDto;

import lombok.Data;

@Data
public class InformeCompletoIRRequestDto {
	
	private InformeResultadosIRRequestDto informe = new InformeResultadosIRRequestDto();

	private List<ResultadosIRRequestDto> listaResultados = new ArrayList<>();

	private List<CondicionAmbientalIRRequestDto> listaCondiciones = new ArrayList<>();

	private List<EquiposUtilizadosIRRequestDto> listaEquipos = new ArrayList<>();

}
