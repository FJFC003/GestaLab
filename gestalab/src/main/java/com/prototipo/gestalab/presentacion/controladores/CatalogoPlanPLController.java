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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoPlanPLUseCase;
import com.prototipo.gestalab.presentacion.dto.request.CatalogoPlanPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CatalogoPlanPLResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ICatalogoPlanPLDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/catalogoplan")
@RestController
public class CatalogoPlanPLController {

	private final ICatalogoPlanPLUseCase useCase;
	private final ICatalogoPlanPLDtoMapper mapper;

	public CatalogoPlanPLController(ICatalogoPlanPLUseCase useCase, ICatalogoPlanPLDtoMapper mapper) {
		super();
		this.useCase = useCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CatalogoPlanPLResponseDto guardar(@Valid @RequestBody CatalogoPlanPLRequestDto request) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<CatalogoPlanPLResponseDto> listarTodos() {
		return useCase.ListarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/portipo/{tipoLista}")
	public List<CatalogoPlanPLResponseDto> listarPorTipo(@PathVariable("tipoLista") String tipoLista) {
		return useCase.ListarPorTipo(tipoLista).stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{id}")
	public CatalogoPlanPLResponseDto buscarPorId(@PathVariable("id") int idCatalogoPlanPL) {
		return mapper.toResponseDto(useCase.buscarPorId(idCatalogoPlanPL));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") int idCatalogoPlanPL) {
		useCase.eliminar(idCatalogoPlanPL);
		return ResponseEntity.noContent().build();
	}

}
