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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoNormServiCUseCase;
import com.prototipo.gestalab.presentacion.dto.request.CatalogoNormServiCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CatalogoNormServiCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ICatalogoNormServiCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/catanormser")
@RestController
public class CatalogoNormServiCController {
	
	private final ICatalogoNormServiCUseCase catalogoNormServiCUseCase;
	private final ICatalogoNormServiCDtoMapper mapper;
	public CatalogoNormServiCController(ICatalogoNormServiCUseCase catalogoNormServiCUseCase,
			ICatalogoNormServiCDtoMapper mapper) {
		super();
		this.catalogoNormServiCUseCase = catalogoNormServiCUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CatalogoNormServiCResponseDto guardar(@Valid @RequestBody CatalogoNormServiCRequestDto requestNorma) {
		return mapper.toResponseDto(catalogoNormServiCUseCase.guardar(mapper.toDomain(requestNorma)));
	}
	
	@GetMapping
	public List<CatalogoNormServiCResponseDto> listarTodos(){
		return catalogoNormServiCUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@GetMapping("/{idCatalogoNormServi}")
	public CatalogoNormServiCResponseDto buscarPorId(@PathVariable int idCatalogoNormServi) {
		return mapper.toResponseDto(catalogoNormServiCUseCase.buscarPorId(idCatalogoNormServi));
	}
	
	@DeleteMapping("/{idCatalogoNormServi}")
	public ResponseEntity<Void> eliminar (@PathVariable int idCatalogoNormServi)
	{
		catalogoNormServiCUseCase.eliminar(idCatalogoNormServi);
		return ResponseEntity.noContent().build();
	}

}
