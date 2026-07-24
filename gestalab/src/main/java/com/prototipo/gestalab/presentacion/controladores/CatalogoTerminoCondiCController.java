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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICatalogoTerminoCondiCUseCase;
import com.prototipo.gestalab.presentacion.dto.request.CatalogoTerminoCondiCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CatalogoTerminoCondiCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ICatalogoTerminoCondiCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/catalogoterminos")
@RestController
public class CatalogoTerminoCondiCController {
	
	private final ICatalogoTerminoCondiCUseCase catalogoTerminoCondiCUseCase;
	private final ICatalogoTerminoCondiCDtoMapper mapper;
	public CatalogoTerminoCondiCController(ICatalogoTerminoCondiCUseCase catalogoTerminoCondiCUseCase,
			ICatalogoTerminoCondiCDtoMapper mapper) {
		super();
		this.catalogoTerminoCondiCUseCase = catalogoTerminoCondiCUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CatalogoTerminoCondiCResponseDto guardar(@Valid @RequestBody CatalogoTerminoCondiCRequestDto requestTermino) {
		return mapper.toResponseDto(catalogoTerminoCondiCUseCase.guardar(mapper.toDomain(requestTermino)));
	}
	
	@GetMapping
	public List<CatalogoTerminoCondiCResponseDto> listarTodos(){
		return catalogoTerminoCondiCUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@GetMapping("/{idTerminoC}")
	public CatalogoTerminoCondiCResponseDto buscarPorId(@PathVariable int idTerminoC) {
		return mapper.toResponseDto(catalogoTerminoCondiCUseCase.buscarPorId(idTerminoC));
	}
	
	@DeleteMapping("/{idTerminoC}")
	public ResponseEntity<Void> eliminar (@PathVariable int idTerminoC)
	{
		catalogoTerminoCondiCUseCase.eliminar(idTerminoC);
		return ResponseEntity.noContent().build();
	}

}
