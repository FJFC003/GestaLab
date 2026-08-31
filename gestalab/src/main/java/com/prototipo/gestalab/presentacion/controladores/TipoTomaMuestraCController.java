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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ITipoTomaMuestraCUseCase;
import com.prototipo.gestalab.presentacion.dto.request.TipoTomaMuestraCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.TipoTomaMuestraCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ITipoTomaMuestraCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/tipotomamuestra")
@RestController
public class TipoTomaMuestraCController {

	private final ITipoTomaMuestraCUseCase useCase;
	private final ITipoTomaMuestraCDtoMapper mapper;

	public TipoTomaMuestraCController(ITipoTomaMuestraCUseCase useCase, ITipoTomaMuestraCDtoMapper mapper) {
		super();
		this.useCase = useCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TipoTomaMuestraCResponseDto guardar(@Valid @RequestBody TipoTomaMuestraCRequestDto request) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<TipoTomaMuestraCResponseDto> listarTodos() {
		return useCase.ListarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{id}")
	public TipoTomaMuestraCResponseDto buscarPorId(@PathVariable("id") int idTipoTomaMuestraC) {
		return mapper.toResponseDto(useCase.buscarPorId(idTipoTomaMuestraC));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int idTipoTomaMuestraC) {
		useCase.eliminar(idTipoTomaMuestraC);
		return ResponseEntity.noContent().build();
	}

}
