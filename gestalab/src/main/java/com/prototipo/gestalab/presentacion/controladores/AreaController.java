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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IAreaUseCase;
import com.prototipo.gestalab.presentacion.dto.request.AreaRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.AreaResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IAreaDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/area")
@RestController
public class AreaController {
	
	private final IAreaUseCase areaUseCase;
	private final IAreaDtoMapper mapper;

	public AreaController(IAreaUseCase areaUseCase, IAreaDtoMapper mapper) {
		this.areaUseCase = areaUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AreaResponseDto guardar(@Valid @RequestBody AreaRequestDto requestArea) {
		return mapper.toResponseDto(areaUseCase.guardar(mapper.toDomain(requestArea)));
	}
	
	@GetMapping
	public List<AreaResponseDto> listarTodos(){
		return areaUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idArea}")
	public ResponseEntity<Void> eliminar (@PathVariable int idArea)
	{
		areaUseCase.eliminar(idArea);
		return ResponseEntity.noContent().build();
	}
	
	
	
	

}
