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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IRecursosCronoPLUseCase;
import com.prototipo.gestalab.presentacion.dto.request.RecursosCronoPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.RecursosCronoPLResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IRecursosCronoPLDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/recursos-crono-pl")
@RestController
public class RecursosCronoPLController {
	
	private final IRecursosCronoPLUseCase recursosCronoPLUseCase;
	private final IRecursosCronoPLDtoMapper mapper;
	public RecursosCronoPLController(IRecursosCronoPLUseCase recursosCronoPLUseCase, IRecursosCronoPLDtoMapper mapper) {
		super();
		this.recursosCronoPLUseCase = recursosCronoPLUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RecursosCronoPLResponseDto guardar(@Valid @RequestBody RecursosCronoPLRequestDto requestCrono) {
		return mapper.toResponseDto(recursosCronoPLUseCase.guardar(mapper.toDomain(requestCrono)));
	}
	
	@GetMapping
	public List<RecursosCronoPLResponseDto> listarTodos(){
		return recursosCronoPLUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idRecursos}")
	public ResponseEntity<Void> eliminar (@PathVariable int idRecursos)
	{
		recursosCronoPLUseCase.eliminar(idRecursos);
		return ResponseEntity.noContent().build();
	}

}
