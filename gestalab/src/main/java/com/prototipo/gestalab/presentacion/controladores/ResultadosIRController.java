package com.prototipo.gestalab.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IResultadosIRUseCase;
import com.prototipo.gestalab.presentacion.dto.request.ResultadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.ResultadosIRResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IResultadosIRDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/resultados")
@RestController
public class ResultadosIRController {
	
	private final IResultadosIRUseCase resultadosIRUseCase;
	private final IResultadosIRDtoMapper mapper;
	
	public ResultadosIRController(IResultadosIRUseCase resultadosIRUseCase, IResultadosIRDtoMapper mapper) {
		super();
		this.resultadosIRUseCase = resultadosIRUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResultadosIRResponseDto guardar(@Valid @RequestBody ResultadosIRRequestDto requestResultados) {
		return mapper.toResponseDto(resultadosIRUseCase.guardar(mapper.toDomain(requestResultados)));
	}
	
	@GetMapping
	public List<ResultadosIRResponseDto> listarTodos(){
		return resultadosIRUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idResultados}")
	public ResponseEntity<Void> eliminar (@PathVariable int idResultados)
	{
		resultadosIRUseCase.eliminar(idResultados);
		return ResponseEntity.noContent().build();
	}

}
