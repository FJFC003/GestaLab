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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformacionAdicionalPLUseCase;
import com.prototipo.gestalab.presentacion.dto.request.InformacionAdicionalPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformacionAdicionalPLResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IInformacionAdicionalPLDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/informacion-adicional-pl")
@RestController
public class InformacionAdicionalPLController {
	
	private final IInformacionAdicionalPLUseCase informacionAdicionalPLUseCase;
	private final IInformacionAdicionalPLDtoMapper mapper;
	public InformacionAdicionalPLController(IInformacionAdicionalPLUseCase informacionAdicionalPLUseCase,
			IInformacionAdicionalPLDtoMapper mapper) {
		super();
		this.informacionAdicionalPLUseCase = informacionAdicionalPLUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public InformacionAdicionalPLResponseDto guardar(@Valid @RequestBody InformacionAdicionalPLRequestDto requestInfoAdi) {
		return mapper.toResponseDto(informacionAdicionalPLUseCase.guardar(mapper.toDomain(requestInfoAdi)));
	}
	
	@GetMapping
	public List<InformacionAdicionalPLResponseDto> listarTodos(){
		return informacionAdicionalPLUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idInformacion}")
	public ResponseEntity<Void> eliminar (@PathVariable int idInformacion)
	{
		informacionAdicionalPLUseCase.eliminar(idInformacion);
		return ResponseEntity.noContent().build();
	}

}
