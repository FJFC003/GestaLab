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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IProcedimientoMuePLUseCase;
import com.prototipo.gestalab.presentacion.dto.request.ProcedimientoMuePLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.ProcedimientoMuePLResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IProcedimientoMuePLDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/procedimiento-mue-pl")
@RestController
public class ProcedimientoMuePLController {
	
	private final IProcedimientoMuePLUseCase procedimientoMuePLUseCase;
	private final IProcedimientoMuePLDtoMapper mapper;
	public ProcedimientoMuePLController(IProcedimientoMuePLUseCase procedimientoMuePLUseCase,
			IProcedimientoMuePLDtoMapper mapper) {
		super();
		this.procedimientoMuePLUseCase = procedimientoMuePLUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProcedimientoMuePLResponseDto guardar(@Valid @RequestBody ProcedimientoMuePLRequestDto requestProce) {
		return mapper.toResponseDto(procedimientoMuePLUseCase.guardar(mapper.toDomain(requestProce)));
	}
	
	@GetMapping
	public List<ProcedimientoMuePLResponseDto> listarTodos(){
		return procedimientoMuePLUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idProcedimiento}")
	public ResponseEntity<Void> eliminar (@PathVariable int idProcedimiento)
	{
		procedimientoMuePLUseCase.eliminar(idProcedimiento);
		return ResponseEntity.noContent().build();
	}

}
