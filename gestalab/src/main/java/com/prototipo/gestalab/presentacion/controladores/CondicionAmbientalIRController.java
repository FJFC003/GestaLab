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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICondicionAmbientalIRUseCase;
import com.prototipo.gestalab.presentacion.dto.request.CondicionAmbientalIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CondicionAmbientalIRResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ICondicionAmbientalIRDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/condi")
@RestController
public class CondicionAmbientalIRController {
	
	private final ICondicionAmbientalIRUseCase ambientalIRUseCase;
	private final ICondicionAmbientalIRDtoMapper mapper;
	
	public CondicionAmbientalIRController(ICondicionAmbientalIRUseCase ambientalIRUseCase,
			ICondicionAmbientalIRDtoMapper mapper) {
		super();
		this.ambientalIRUseCase = ambientalIRUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CondicionAmbientalIRResponseDto guardar(@Valid @RequestBody CondicionAmbientalIRRequestDto requestAmbiental) {
		return mapper.toResponseDto(ambientalIRUseCase.guardar(mapper.toDomain(requestAmbiental)));
	}
	
	@GetMapping
	public List<CondicionAmbientalIRResponseDto> listarTodos(){
		return ambientalIRUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idCondi}")
	public ResponseEntity<Void> eliminar (@PathVariable int idCondi)
	{
		ambientalIRUseCase.eliminar(idCondi);
		return ResponseEntity.noContent().build();
	}

}
