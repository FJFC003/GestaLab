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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IOrdenTrabajoOTUseCase;
import com.prototipo.gestalab.presentacion.dto.request.OrdenTrabajoOTRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.OrdenTrabajoOTResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IOrdenTrabajoOTDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/ordentrabajo")
@RestController
public class OrdenTrabajo {
	
	private final IOrdenTrabajoOTUseCase ordenTrabajoOTUseCase;
	private final IOrdenTrabajoOTDtoMapper mapper;
	
	public OrdenTrabajo(IOrdenTrabajoOTUseCase ordenTrabajoOTUseCase, IOrdenTrabajoOTDtoMapper mapper) {
		super();
		this.ordenTrabajoOTUseCase = ordenTrabajoOTUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdenTrabajoOTResponseDto guardar(@Valid @RequestBody OrdenTrabajoOTRequestDto requestOT) {
		return mapper.toResponseDto(ordenTrabajoOTUseCase.guardar(mapper.toDomain(requestOT)));
	}
	
	@GetMapping
	public List<OrdenTrabajoOTResponseDto> listarTodos(){
		return ordenTrabajoOTUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idOT}")
	public ResponseEntity<Void> eliminar (@PathVariable int idOT)
	{
		ordenTrabajoOTUseCase.eliminar(idOT);
		return ResponseEntity.noContent().build();
	}

}
