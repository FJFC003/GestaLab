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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ITipoTomaFreHoraPLUseCase;
import com.prototipo.gestalab.presentacion.dto.request.TipoTomaFreHoraPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.TipoTomaFreHoraPLResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ITipoTomaFreHoraPLDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/tipo-toma-fre-hora-pl")
@RestController
public class TipoTomaFreHoraPLController {
	
	private final ITipoTomaFreHoraPLUseCase tipoTomaFreHoraPLUseCase;
	private final ITipoTomaFreHoraPLDtoMapper mapper;
	public TipoTomaFreHoraPLController(ITipoTomaFreHoraPLUseCase tipoTomaFreHoraPLUseCase,
			ITipoTomaFreHoraPLDtoMapper mapper) {
		super();
		this.tipoTomaFreHoraPLUseCase = tipoTomaFreHoraPLUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TipoTomaFreHoraPLResponseDto guardar(@Valid @RequestBody TipoTomaFreHoraPLRequestDto requestTipo) {
		return mapper.toResponseDto(tipoTomaFreHoraPLUseCase.guardar(mapper.toDomain(requestTipo)));
	}
	
	@GetMapping
	public List<TipoTomaFreHoraPLResponseDto> listarTodos(){
		return tipoTomaFreHoraPLUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idTipoFre}")
	public ResponseEntity<Void> eliminar (@PathVariable int idTipoFre)
	{
		tipoTomaFreHoraPLUseCase.eliminar(idTipoFre);
		return ResponseEntity.noContent().build();
	}

}
