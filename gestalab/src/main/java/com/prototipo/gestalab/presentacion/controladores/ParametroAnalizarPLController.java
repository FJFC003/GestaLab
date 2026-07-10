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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IParametroAnalizarPLUseCase;
import com.prototipo.gestalab.presentacion.dto.request.ParametroAnalizarPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.ParametroAnalizarPLResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IParametroAnalizarPLDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/parametro-analizar-pl")
@RestController
public class ParametroAnalizarPLController {
	
	private final IParametroAnalizarPLUseCase parametroAnalizarPLUseCase;
	private final IParametroAnalizarPLDtoMapper mapper;
	public ParametroAnalizarPLController(IParametroAnalizarPLUseCase parametroAnalizarPLUseCase,
			IParametroAnalizarPLDtoMapper mapper) {
		super();
		this.parametroAnalizarPLUseCase = parametroAnalizarPLUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ParametroAnalizarPLResponseDto guardar(@Valid @RequestBody ParametroAnalizarPLRequestDto requestAnalizar) {
		return mapper.toResponseDto(parametroAnalizarPLUseCase.guardar(mapper.toDomain(requestAnalizar)));
	}
	
	@GetMapping
	public List<ParametroAnalizarPLResponseDto> listarTodos(){
		return parametroAnalizarPLUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idParametroPL}")
	public ResponseEntity<Void> eliminar (@PathVariable int idParametroPL)
	{
		parametroAnalizarPLUseCase.eliminar(idParametroPL);
		return ResponseEntity.noContent().build();
	}

}
