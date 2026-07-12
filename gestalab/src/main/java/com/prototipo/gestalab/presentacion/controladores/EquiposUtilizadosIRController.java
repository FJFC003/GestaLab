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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEquiposUtilizadosIRUseCase;
import com.prototipo.gestalab.presentacion.dto.request.EquiposUtilizadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.EquiposUtilizadosIRResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IEquiposUtilizadosIRDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/equipos")
@RestController
public class EquiposUtilizadosIRController {
	
	private final IEquiposUtilizadosIRUseCase equiposUtilizadosIRUseCase;
	private final IEquiposUtilizadosIRDtoMapper mapper;
	
	public EquiposUtilizadosIRController(IEquiposUtilizadosIRUseCase equiposUtilizadosIRUseCase,
			IEquiposUtilizadosIRDtoMapper mapper) {
		super();
		this.equiposUtilizadosIRUseCase = equiposUtilizadosIRUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EquiposUtilizadosIRResponseDto guardar(@Valid @RequestBody EquiposUtilizadosIRRequestDto requestEquipo) {
		return mapper.toResponseDto(equiposUtilizadosIRUseCase.guardar(mapper.toDomain(requestEquipo)));
	}
	
	@GetMapping
	public List<EquiposUtilizadosIRResponseDto> listarTodos(){
		return equiposUtilizadosIRUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idEquipos}")
	public ResponseEntity<Void> eliminar (@PathVariable int idEquipos)
	{
		equiposUtilizadosIRUseCase.eliminar(idEquipos);
		return ResponseEntity.noContent().build();
	}

}
