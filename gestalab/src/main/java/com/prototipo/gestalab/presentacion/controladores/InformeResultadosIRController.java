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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformeResultadosIRUseCase;
import com.prototipo.gestalab.presentacion.dto.request.InformeResultadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformeResultadosIRResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IInformeResultadosIRDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/informe")
@RestController
public class InformeResultadosIRController {
	
	private final IInformeResultadosIRUseCase resultadosIRUseCase;
	private final IInformeResultadosIRDtoMapper mapper;
	
	public InformeResultadosIRController(IInformeResultadosIRUseCase resultadosIRUseCase,
			IInformeResultadosIRDtoMapper mapper) {
		super();
		this.resultadosIRUseCase = resultadosIRUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public InformeResultadosIRResponseDto guardar(@Valid @RequestBody InformeResultadosIRRequestDto requestInforme) {
		return mapper.toResponseDto(resultadosIRUseCase.guardar(mapper.toDomain(requestInforme)));
	}
	
	@GetMapping
	public List<InformeResultadosIRResponseDto> listarTodos(){
		return resultadosIRUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idInforme}")
	public ResponseEntity<Void> eliminar (@PathVariable int idInforme)
	{
		resultadosIRUseCase.eliminar(idInforme);
		return ResponseEntity.noContent().build();
	}

}
