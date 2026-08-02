package com.prototipo.gestalab.presentacion.dto.integrador;

import java.util.ArrayList;
import java.util.List;

import com.prototipo.gestalab.presentacion.dto.response.CondicionAmbientalIRResponseDto;
import com.prototipo.gestalab.presentacion.dto.response.EquiposUtilizadosIRResponseDto;
import com.prototipo.gestalab.presentacion.dto.response.InformeResultadosIRResponseDto;
import com.prototipo.gestalab.presentacion.dto.response.ResultadosIRResponseDto;

import lombok.Data;

@Data
public class InformeCompletoIRResponseDto {
	
	private InformeResultadosIRResponseDto informe;

	private List<ResultadosIRResponseDto> listaResultados = new ArrayList<>();

	private List<CondicionAmbientalIRResponseDto> listaCondiciones = new ArrayList<>();

	private List<EquiposUtilizadosIRResponseDto> listaEquipos = new ArrayList<>();

}
