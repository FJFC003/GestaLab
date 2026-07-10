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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IInformacionMatrizPLUseCase;
import com.prototipo.gestalab.presentacion.dto.request.InformacionMatrizPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformacionMatrizPLResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IInformacionMatrizPLDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/informacion-matriz-pl")
@RestController
public class InformacionMatrizPLController {
	
	private final IInformacionMatrizPLUseCase informacionMatrizPLUseCase;
	private final IInformacionMatrizPLDtoMapper mapper;
	public InformacionMatrizPLController(IInformacionMatrizPLUseCase informacionMatrizPLUseCase,
			IInformacionMatrizPLDtoMapper mapper) {
		super();
		this.informacionMatrizPLUseCase = informacionMatrizPLUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public InformacionMatrizPLResponseDto guardar(@Valid @RequestBody InformacionMatrizPLRequestDto requestMatriz) {
		return mapper.toResponseDto(informacionMatrizPLUseCase.guardar(mapper.toDomain(requestMatriz)));
	}
	
	@GetMapping
	public List<InformacionMatrizPLResponseDto> listarTodos(){
		return informacionMatrizPLUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idInfoMatriz}")
	public ResponseEntity<Void> eliminar (@PathVariable int idInfoMatriz)
	{
		informacionMatrizPLUseCase.eliminar(idInfoMatriz);
		return ResponseEntity.noContent().build();
	}

}
