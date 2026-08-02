package com.prototipo.gestalab.presentacion.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICondicionAmbientalIRUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEquiposUtilizadosIRUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformeResultadosIRUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IResultadosIRUseCase;
import com.prototipo.gestalab.dominio.entidades.CondicionAmbientalIR;
import com.prototipo.gestalab.dominio.entidades.EquiposUtilizadosIR;
import com.prototipo.gestalab.dominio.entidades.ResultadosIR;
import com.prototipo.gestalab.presentacion.dto.integrador.InformeCompletoIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.integrador.InformeCompletoIRResponseDto;
import com.prototipo.gestalab.presentacion.dto.request.CondicionAmbientalIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.request.EquiposUtilizadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.request.InformeResultadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.request.ResultadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformeResultadosIRResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ICondicionAmbientalIRDtoMapper;
import com.prototipo.gestalab.presentacion.mapeadores.IEquiposUtilizadosIRDtoMapper;
import com.prototipo.gestalab.presentacion.mapeadores.IInformeResultadosIRDtoMapper;
import com.prototipo.gestalab.presentacion.mapeadores.IResultadosIRDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/informe")
@RestController
public class InformeResultadosIRController {
	
	private final IInformeResultadosIRUseCase informeUseCase;
	private final IInformeResultadosIRDtoMapper mapper;
	private final IResultadosIRDtoMapper resultadosMapper;
	private final ICondicionAmbientalIRDtoMapper condicionesMapper;
	private final IEquiposUtilizadosIRDtoMapper equiposMapper;
	private final IResultadosIRUseCase resultadosUseCase;
	private final ICondicionAmbientalIRUseCase condicionesUseCase;
	private final IEquiposUtilizadosIRUseCase equiposUseCase;

	public InformeResultadosIRController(IInformeResultadosIRUseCase informeUseCase,
			IInformeResultadosIRDtoMapper mapper, IResultadosIRDtoMapper resultadosMapper,
			ICondicionAmbientalIRDtoMapper condicionesMapper, IEquiposUtilizadosIRDtoMapper equiposMapper,
			IResultadosIRUseCase resultadosUseCase, ICondicionAmbientalIRUseCase condicionesUseCase,
			IEquiposUtilizadosIRUseCase equiposUseCase) {
		super();
		this.informeUseCase = informeUseCase;
		this.mapper = mapper;
		this.resultadosMapper = resultadosMapper;
		this.condicionesMapper = condicionesMapper;
		this.equiposMapper = equiposMapper;
		this.resultadosUseCase = resultadosUseCase;
		this.condicionesUseCase = condicionesUseCase;
		this.equiposUseCase = equiposUseCase;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public InformeResultadosIRResponseDto guardar(@Valid @RequestBody InformeResultadosIRRequestDto request) {
		return mapper.toResponseDto(informeUseCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<InformeResultadosIRResponseDto> listarTodos(){
		return informeUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}

	@GetMapping("/{idInforme}")
	public InformeResultadosIRResponseDto buscarPorId(@PathVariable int idInforme) {
		return mapper.toResponseDto(informeUseCase.buscarPorId(idInforme));
	}

	@GetMapping("/orden/{idOT}")
	public ResponseEntity<InformeResultadosIRResponseDto> buscarPorOrden(@PathVariable int idOT) {
		var informe = informeUseCase.buscarPorOrden(idOT);
		if (informe == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(mapper.toResponseDto(informe));
	}

	@DeleteMapping("/{idInforme}")
	public ResponseEntity<Void> eliminar (@PathVariable int idInforme)
	{
		informeUseCase.eliminar(idInforme);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/completo")
	@ResponseStatus(HttpStatus.CREATED)
	public InformeResultadosIRResponseDto guardarCompleto(
			@Valid @RequestBody InformeCompletoIRRequestDto request) {

		List<ResultadosIR> resultados = new ArrayList<>();
		for (ResultadosIRRequestDto dto : request.getListaResultados()) {
			resultados.add(resultadosMapper.toDomain(dto));
		}

		List<CondicionAmbientalIR> condiciones = new ArrayList<>();
		for (CondicionAmbientalIRRequestDto dto : request.getListaCondiciones()) {
			condiciones.add(condicionesMapper.toDomain(dto));
		}

		List<EquiposUtilizadosIR> equipos = new ArrayList<>();
		for (EquiposUtilizadosIRRequestDto dto : request.getListaEquipos()) {
			equipos.add(equiposMapper.toDomain(dto));
		}

		return mapper.toResponseDto(informeUseCase.guardarInformeCompleto(
				mapper.toDomain(request.getInforme()), resultados, condiciones, equipos));
	}


	@GetMapping("/completo/{idOT}")
	public ResponseEntity<InformeCompletoIRResponseDto> buscarCompletoPorOrden(@PathVariable int idOT) {

		var informe = informeUseCase.buscarPorOrden(idOT);
		if (informe == null) {
			return ResponseEntity.noContent().build();
		}

		int idInforme = informe.getIdInforme();

		InformeCompletoIRResponseDto respuesta = new InformeCompletoIRResponseDto();
		respuesta.setInforme(mapper.toResponseDto(informe));
		respuesta.setListaResultados(resultadosUseCase.listarPorInforme(idInforme)
				.stream().map(resultadosMapper :: toResponseDto).toList());
		respuesta.setListaCondiciones(condicionesUseCase.listarPorInforme(idInforme)
				.stream().map(condicionesMapper :: toResponseDto).toList());
		respuesta.setListaEquipos(equiposUseCase.listarPorInforme(idInforme)
				.stream().map(equiposMapper :: toResponseDto).toList());

		return ResponseEntity.ok(respuesta);
	}

	// ================= FLUJO HACIA LA COORDINACION TECNICA =================

	@PutMapping("/enviar-coordinacion/{idInforme}")
	public InformeResultadosIRResponseDto enviarACoordinacion(@PathVariable int idInforme) {
		return mapper.toResponseDto(informeUseCase.enviarACoordinacion(idInforme));
	}

	@GetMapping("/enviados")
	public List<InformeResultadosIRResponseDto> listarEnviados(){
		return informeUseCase.listarEnviados().stream().map(mapper :: toResponseDto).toList();
	}

}