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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IDetalleCUseCase;
import com.prototipo.gestalab.presentacion.dto.request.DetalleCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.DetalleCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IDetalleCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/detallecotizacion")
@RestController
public class DetalleCController {
	
	private final IDetalleCUseCase detalleCUseCase;
	private final IDetalleCDtoMapper mapper;
	public DetalleCController(IDetalleCUseCase detalleCUseCase, IDetalleCDtoMapper mapper) {
		super();
		this.detalleCUseCase = detalleCUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DetalleCResponseDto guardar(@Valid @RequestBody DetalleCRequestDto requestDetalle) {
		return mapper.toResponseDto(detalleCUseCase.guardar(mapper.toDomain(requestDetalle)));
	}
	
	@GetMapping
	public List<DetalleCResponseDto> listarTodos(){
		return detalleCUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@GetMapping("/{idDetalleC}")
	public DetalleCResponseDto buscarPorId(@PathVariable int idDetalleC) {
		return mapper.toResponseDto(detalleCUseCase.buscarPorId(idDetalleC));
	}
	
	@DeleteMapping("/{idDetalleC}")
	public ResponseEntity<Void> eliminar (@PathVariable int idDetalleC)
	{
		detalleCUseCase.eliminar(idDetalleC);
		return ResponseEntity.noContent().build();
	}

}
