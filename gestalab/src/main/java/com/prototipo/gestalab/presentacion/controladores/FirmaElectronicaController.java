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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IFirmaElectronicaUseCase;
import com.prototipo.gestalab.presentacion.dto.request.FirmaElectronicaRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.FirmaElectronicaResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IFirmaElectronicaDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/firmaelectronica")
@RestController
public class FirmaElectronicaController {
	
	private final IFirmaElectronicaUseCase firmaElectronicaUseCase;
	private final IFirmaElectronicaDtoMapper mapper;
	public FirmaElectronicaController(IFirmaElectronicaUseCase firmaElectronicaUseCase,
			IFirmaElectronicaDtoMapper mapper) {
		super();
		this.firmaElectronicaUseCase = firmaElectronicaUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FirmaElectronicaResponseDto guardar(@Valid @RequestBody FirmaElectronicaRequestDto requestFirma ) {
		return mapper.toResponseDto(firmaElectronicaUseCase.guardar(mapper.toDomain(requestFirma)));
	}
	
	@GetMapping
	public List<FirmaElectronicaResponseDto> listarTodos(){
		return firmaElectronicaUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idFirma}")
	public ResponseEntity<Void> eliminar (@PathVariable int idFirma)
	{
		firmaElectronicaUseCase.eliminar(idFirma);
		return ResponseEntity.noContent().build();
	}

}
