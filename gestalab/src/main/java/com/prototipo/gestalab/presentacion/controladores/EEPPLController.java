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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEEPPLUseCase;
import com.prototipo.gestalab.presentacion.dto.request.EEPPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.EEPPLResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IEEPPLDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/eeppl")
@RestController
public class EEPPLController {
	
	private final IEEPPLUseCase eepplUseCase;
	private final IEEPPLDtoMapper mapper;
	public EEPPLController(IEEPPLUseCase eepplUseCase, IEEPPLDtoMapper mapper) {
		super();
		this.eepplUseCase = eepplUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EEPPLResponseDto guardar(@Valid @RequestBody EEPPLRequestDto requestEep) {
		return mapper.toResponseDto(eepplUseCase.guardar(mapper.toDomain(requestEep)));
	}
	
	@GetMapping
	public List<EEPPLResponseDto> listarTodos(){
		return eepplUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idEEP}")
	public ResponseEntity<Void> eliminar (@PathVariable int idEEP)
	{
		eepplUseCase.eliminar(idEEP);
		return ResponseEntity.noContent().build();
	}

}
