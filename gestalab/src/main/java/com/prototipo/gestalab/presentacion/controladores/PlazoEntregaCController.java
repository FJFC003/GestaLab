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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IPlazoEntregaCUseCase;
import com.prototipo.gestalab.presentacion.dto.request.PlazoEntregaCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.PlazoEntregaCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IPlazoEntregaCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/plazoentrega")
@RestController
public class PlazoEntregaCController {
	
	private final IPlazoEntregaCUseCase useCase;
	private final IPlazoEntregaCDtoMapper mapper;
	public PlazoEntregaCController(IPlazoEntregaCUseCase useCase, IPlazoEntregaCDtoMapper mapper) {
		super();
		this.useCase = useCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlazoEntregaCResponseDto guardar(@Valid @RequestBody PlazoEntregaCRequestDto request) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<PlazoEntregaCResponseDto> listarTodos() {
		return useCase.ListarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{id}")
	public PlazoEntregaCResponseDto buscarPorId(@PathVariable("id") int idPlazoEntregaC) {
		return mapper.toResponseDto(useCase.buscarPorId(idPlazoEntregaC));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int idPlazoEntregaC) {
		useCase.eliminar(idPlazoEntregaC);
		return ResponseEntity.noContent().build();
	}

}
