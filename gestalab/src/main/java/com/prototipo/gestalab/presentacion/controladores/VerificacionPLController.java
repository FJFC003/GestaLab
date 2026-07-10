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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IVerificacionPLUseCase;
import com.prototipo.gestalab.presentacion.dto.request.VerificacionPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.VerificacionPLResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IVerificacionPLDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/verificacion-pl")
@RestController
public class VerificacionPLController {
	
	private final IVerificacionPLUseCase verificacionPLUseCase;
	private final IVerificacionPLDtoMapper mapper;
	public VerificacionPLController(IVerificacionPLUseCase verificacionPLUseCase, IVerificacionPLDtoMapper mapper) {
		super();
		this.verificacionPLUseCase = verificacionPLUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VerificacionPLResponseDto guardar(@Valid @RequestBody VerificacionPLRequestDto requestVeri) {
		return mapper.toResponseDto(verificacionPLUseCase.guardar(mapper.toDomain(requestVeri)));
	}
	
	@GetMapping
	public List<VerificacionPLResponseDto> listarTodos(){
		return verificacionPLUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idVerificacion}")
	public ResponseEntity<Void> eliminar (@PathVariable int idVerificacion)
	{
		verificacionPLUseCase.eliminar(idVerificacion);
		return ResponseEntity.noContent().build();
	}

}
