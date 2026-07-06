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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDesviosOrdenOTUseCase;
import com.prototipo.gestalab.presentacion.dto.request.DesviosOrdenOTRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DesviosOrdenOTResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IDesviosOrdenOTDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/desviosdeorden")
@RestController
public class DesviosOrdenOTController {
	
	private final IDesviosOrdenOTUseCase desviosOrdenOTUseCase;
	private final IDesviosOrdenOTDtoMapper mapper;
	public DesviosOrdenOTController(IDesviosOrdenOTUseCase desviosOrdenOTUseCase, IDesviosOrdenOTDtoMapper mapper) {
		super();
		this.desviosOrdenOTUseCase = desviosOrdenOTUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DesviosOrdenOTResponseDto guardar(@Valid @RequestBody DesviosOrdenOTRequestDto requestDesviosOrdenOT) {
		return mapper.toResponseDto(desviosOrdenOTUseCase.guardar(mapper.ToDomain(requestDesviosOrdenOT)));
	}
	
	@GetMapping
	public List<DesviosOrdenOTResponseDto> listarTodos(){
		return desviosOrdenOTUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idDesviosOrdenOT}")
	public ResponseEntity<Void> eliminar (@PathVariable int ididDesviosOrdenOT)
	{
		desviosOrdenOTUseCase.eliminar(ididDesviosOrdenOT);
		return ResponseEntity.noContent().build();
	}
	

}
