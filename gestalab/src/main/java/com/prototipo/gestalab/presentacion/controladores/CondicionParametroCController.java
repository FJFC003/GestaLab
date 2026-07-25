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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICondicionParametroCUseCase;
import com.prototipo.gestalab.presentacion.dto.request.CondicionParametroCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CondicionParametroCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ICondicionParametroCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/condicionparametro")
@RestController
public class CondicionParametroCController {
	
	private final ICondicionParametroCUseCase useCase;
	private final ICondicionParametroCDtoMapper mapper;
	public CondicionParametroCController(ICondicionParametroCUseCase useCase, ICondicionParametroCDtoMapper mapper) {
		super();
		this.useCase = useCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CondicionParametroCResponseDto guardar(@Valid @RequestBody CondicionParametroCRequestDto request) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<CondicionParametroCResponseDto> listarTodos() {
		return useCase.ListarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idCondicionParametroC}")
	public CondicionParametroCResponseDto buscarPorId(@PathVariable int idCondicionParametroC) {
		return mapper.toResponseDto(useCase.buscarPorId(idCondicionParametroC));
	}

	@DeleteMapping("/{idCondicionParametroC}")
	public ResponseEntity<Void> eliminar(@PathVariable int idCondicionParametroC) {
		useCase.eliminar(idCondicionParametroC);
		return ResponseEntity.noContent().build();
	}

}
