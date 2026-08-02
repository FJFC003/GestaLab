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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEquipoLaboratorioUseCase;
import com.prototipo.gestalab.presentacion.dto.request.EquipoLaboratorioRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.EquipoLaboratorioResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IEquipoLaboratorioDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/equipolaboratorio")
@RestController
public class EquipoLaboratorioController {

	private final IEquipoLaboratorioUseCase equipoLaboratorioUseCase;
	private final IEquipoLaboratorioDtoMapper mapper;

	public EquipoLaboratorioController(IEquipoLaboratorioUseCase equipoLaboratorioUseCase,
			IEquipoLaboratorioDtoMapper mapper) {
		super();
		this.equipoLaboratorioUseCase = equipoLaboratorioUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EquipoLaboratorioResponseDto guardar(@Valid @RequestBody EquipoLaboratorioRequestDto requestDto) {
		return mapper.toResponseDto(equipoLaboratorioUseCase.guardar(mapper.toDomain(requestDto)));
	}

	@GetMapping
	public List<EquipoLaboratorioResponseDto> listarTodos(){
		return equipoLaboratorioUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}

	@GetMapping("/activos")
	public List<EquipoLaboratorioResponseDto> listarActivos(){
		return equipoLaboratorioUseCase.listarActivos().stream().map(mapper :: toResponseDto).toList();
	}

	@GetMapping("/{idEquipoLab}")
	public EquipoLaboratorioResponseDto buscarPorId(@PathVariable int idEquipoLab){
		return mapper.toResponseDto(equipoLaboratorioUseCase.buscarPorId(idEquipoLab));
	}

	@DeleteMapping("/{idEquipoLab}")
	public ResponseEntity<Void> eliminar (@PathVariable int idEquipoLab)
	{
		equipoLaboratorioUseCase.eliminar(idEquipoLab);
		return ResponseEntity.noContent().build();
	}

}