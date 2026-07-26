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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ILmpCUseCase;
import com.prototipo.gestalab.presentacion.dto.request.LmpCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.LmpCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ILmpCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/lmp")
@RestController
public class LmpCController {
	
	private final ILmpCUseCase useCase;
	private final ILmpCDtoMapper mapper;
	public LmpCController(ILmpCUseCase useCase, ILmpCDtoMapper mapper) {
		super();
		this.useCase = useCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LmpCResponseDto guardar(@Valid @RequestBody LmpCRequestDto request) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<LmpCResponseDto> listarTodos() {
		return useCase.ListarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{id}")
	public LmpCResponseDto buscarPorId(@PathVariable("id") int idLmpC) {
		return mapper.toResponseDto(useCase.buscarPorId(idLmpC));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int idLmpC) {
		useCase.eliminar(idLmpC);
		return ResponseEntity.noContent().build();
	}

}
