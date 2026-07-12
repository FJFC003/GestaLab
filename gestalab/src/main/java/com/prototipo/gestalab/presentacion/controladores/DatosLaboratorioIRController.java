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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDatosLaboratorioIRUseCase;
import com.prototipo.gestalab.presentacion.dto.request.DatosLaboratorioIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DatosLaboratorioIRResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IDatosLaboratorioIRDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/datoslaboratorio")
@RestController
public class DatosLaboratorioIRController {
	
	private final IDatosLaboratorioIRUseCase laboratorioIRUseCase;
	private final IDatosLaboratorioIRDtoMapper mapper;
	
	public DatosLaboratorioIRController(IDatosLaboratorioIRUseCase laboratorioIRUseCase,
			IDatosLaboratorioIRDtoMapper mapper) {
		super();
		this.laboratorioIRUseCase = laboratorioIRUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DatosLaboratorioIRResponseDto guardar(@Valid @RequestBody DatosLaboratorioIRRequestDto requestDato) {
		return mapper.toResponseDto(laboratorioIRUseCase.guardar(mapper.toDomain(requestDato)));
	}
	
	@GetMapping
	public List<DatosLaboratorioIRResponseDto> listarTodos(){
		return laboratorioIRUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idDatos}")
	public ResponseEntity<Void> eliminar (@PathVariable int idDatos)
	{
		laboratorioIRUseCase.eliminar(idDatos);
		return ResponseEntity.noContent().build();
	}

}
