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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoParametroUseCase;
import com.prototipo.gestalab.presentacion.dto.request.CatalogoParametroCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CatalogoParametroCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ICatalogoParametroCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/cataparametro")
@RestController
public class CatalogoParametroCController {
	
	private final ICatalogoParametroUseCase catalogoParametroUseCase;
	private final ICatalogoParametroCDtoMapper mapper;
	public CatalogoParametroCController(ICatalogoParametroUseCase catalogoParametroUseCase,
			ICatalogoParametroCDtoMapper mapper) {
		super();
		this.catalogoParametroUseCase = catalogoParametroUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CatalogoParametroCResponseDto guardar(@Valid @RequestBody CatalogoParametroCRequestDto requestParametro) {
		return mapper.toResponseDto(catalogoParametroUseCase.guardar(mapper.toDomain(requestParametro)));
	}
	
	@GetMapping
	public List<CatalogoParametroCResponseDto> listarTodos(){
		return catalogoParametroUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@GetMapping("/{idParametroC}")
	public CatalogoParametroCResponseDto buscarPorId(@PathVariable int idParametroC) {
		return mapper.toResponseDto(catalogoParametroUseCase.buscarPorId(idParametroC));
	}
	
	@DeleteMapping("/{idParametroC}")
	public ResponseEntity<Void> eliminar (@PathVariable int idParametroC)
	{
		catalogoParametroUseCase.eliminar(idParametroC);
		return ResponseEntity.noContent().build();
	}
}
