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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDescripcionServicioCUseCase;
import com.prototipo.gestalab.presentacion.dto.request.DescripcionServicioCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DescripcionServicioCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IDescripcionServicioCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/descripcionservicio")
@RestController
public class DescripcionServicioCController {
	
	private final IDescripcionServicioCUseCase useCase;
	private final IDescripcionServicioCDtoMapper mapper;
	public DescripcionServicioCController(IDescripcionServicioCUseCase useCase, IDescripcionServicioCDtoMapper mapper) {
		super();
		this.useCase = useCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DescripcionServicioCResponseDto guardar(@Valid @RequestBody DescripcionServicioCRequestDto request) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<DescripcionServicioCResponseDto> listarTodos() {
		return useCase.ListarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{id}")
	public DescripcionServicioCResponseDto buscarPorId(@PathVariable("id") int idDescripcionServicioC) {
		return mapper.toResponseDto(useCase.buscarPorId(idDescripcionServicioC));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int idDescripcionServicioC) {
		useCase.eliminar(idDescripcionServicioC);
		return ResponseEntity.noContent().build();
	}

}
