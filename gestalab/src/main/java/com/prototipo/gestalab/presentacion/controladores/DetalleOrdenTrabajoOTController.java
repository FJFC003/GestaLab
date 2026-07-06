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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDetalleOrdenTrabajoOTUseCase;
import com.prototipo.gestalab.presentacion.dto.request.DetalleOrdenTrabajoOTRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DetalleOrdenTrabajoOTResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IDetalleOrdenTrabajoOTDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/detalleOrdenTrabajo")
@RestController
public class DetalleOrdenTrabajoOTController {

	private final IDetalleOrdenTrabajoOTUseCase detalleOrdenTrabajoOTUseCase;
	private final IDetalleOrdenTrabajoOTDtoMapper mapper;
	public DetalleOrdenTrabajoOTController(IDetalleOrdenTrabajoOTUseCase detalleOrdenTrabajoOTUseCase,
			IDetalleOrdenTrabajoOTDtoMapper mapper) {
		super();
		this.detalleOrdenTrabajoOTUseCase = detalleOrdenTrabajoOTUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DetalleOrdenTrabajoOTResponseDto guardar(@Valid @RequestBody DetalleOrdenTrabajoOTRequestDto requestDetalleOrdenTrabajoOT) {
		return mapper.toResponseDto(detalleOrdenTrabajoOTUseCase.guardar(mapper.ToDomain(requestDetalleOrdenTrabajoOT)));
	}
	
	@GetMapping
	public List<DetalleOrdenTrabajoOTResponseDto> listarTodos(){
		return detalleOrdenTrabajoOTUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idDetalleOrdenOT}")
	public ResponseEntity<Void> eliminar (@PathVariable int idDetalleOrdenOT)
	{
		detalleOrdenTrabajoOTUseCase.eliminar(idDetalleOrdenOT);
		return ResponseEntity.noContent().build();
	}
	
}
