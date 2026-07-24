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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICotizacionCUseCase;
import com.prototipo.gestalab.presentacion.dto.request.CotizacionCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CotizacionCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ICotizacionCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/cotizacion")
@RestController
public class CotizacionCController {
	
	private final ICotizacionCUseCase cotizacionCUseCase;
	private final ICotizacionCDtoMapper mapper;
	public CotizacionCController(ICotizacionCUseCase cotizacionCUseCase, ICotizacionCDtoMapper mapper) {
		super();
		this.cotizacionCUseCase = cotizacionCUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CotizacionCResponseDto guardar(@Valid @RequestBody CotizacionCRequestDto requestCotizacion) {
		return mapper.toResponseDto(cotizacionCUseCase.guardar(mapper.toDomain(requestCotizacion)));
	}
	
	@GetMapping
	public List<CotizacionCResponseDto> listarTodos(){
		return cotizacionCUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@GetMapping("/{idCotizacionC}")
	public CotizacionCResponseDto buscarPorId(@PathVariable int idCotizacionC) {
		return mapper.toResponseDto(cotizacionCUseCase.buscarPorId(idCotizacionC));
	}
	
	@DeleteMapping("/{idCotizacionC}")
	public ResponseEntity<Void> eliminar (@PathVariable int idCotizacionC)
	{
		cotizacionCUseCase.eliminar(idCotizacionC);
		return ResponseEntity.noContent().build();
	}

}
