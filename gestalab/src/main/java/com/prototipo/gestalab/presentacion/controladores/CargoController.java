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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ICargoUseCase;
import com.prototipo.gestalab.presentacion.dto.request.CargoRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.CargoResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.ICargoDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/cargo")
@RestController
public class CargoController {
	
	private final ICargoUseCase cargoUseCase;
	private final ICargoDtoMapper mapper;
	public CargoController(ICargoUseCase cargoUseCase, ICargoDtoMapper mapper) {
		super();
		this.cargoUseCase = cargoUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CargoResponseDto guardar(@Valid @RequestBody CargoRequestDto requestCargo ) {
		return mapper.toResponseDto(cargoUseCase.guardar(mapper.ToDomain(requestCargo)));
	}
	
	@GetMapping
	public List<CargoResponseDto> listarTodos(){
		return cargoUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idCargo}")
	public ResponseEntity<Void> eliminar (@PathVariable int idCargo)
	{
		cargoUseCase.eliminar(idCargo);
		return ResponseEntity.noContent().build();
	}

}
