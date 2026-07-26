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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.INormaParametroLmpCUseCase;
import com.prototipo.gestalab.presentacion.dto.request.NormaParametroLmpCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.NormaParametroLmpCResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.INormaParametroLmpCDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/normaparametrolmp")
@RestController
public class NormaParametroLmpCController {
	
	private final INormaParametroLmpCUseCase useCase;
	private final INormaParametroLmpCDtoMapper mapper;

	public NormaParametroLmpCController(INormaParametroLmpCUseCase useCase, INormaParametroLmpCDtoMapper mapper) {
		super();
		this.useCase = useCase;
		this.mapper = mapper;
	}
	
	// Asocia un par Parámetro-LMP existente a una Norma.
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public NormaParametroLmpCResponseDto guardar(@Valid @RequestBody NormaParametroLmpCRequestDto request) {
			return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
		}

		@GetMapping
		public List<NormaParametroLmpCResponseDto> listarTodos() {
			return useCase.ListarTodos().stream().map(mapper::toResponseDto).toList();
		}

		@GetMapping("/{id}")
		public NormaParametroLmpCResponseDto buscarPorId(@PathVariable("id") int idNormaParametroLmpC) {
			return mapper.toResponseDto(useCase.buscarPorId(idNormaParametroLmpC));
		}

		// Pares Parámetro-LMP asociados a una Norma específica (para "Lista de Normas").
		@GetMapping("/pornorma/{idNorma}")
		public List<NormaParametroLmpCResponseDto> buscarPorNorma(@PathVariable int idNorma) {
			return useCase.buscarPorNorma(idNorma).stream().map(mapper::toResponseDto).toList();
		}

		// Desasocia un par (no elimina el Parámetro ni el LMP de sus catálogos).
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable("id") int idNormaParametroLmpC) {
			useCase.eliminar(idNormaParametroLmpC);
			return ResponseEntity.noContent().build();
		}

}
