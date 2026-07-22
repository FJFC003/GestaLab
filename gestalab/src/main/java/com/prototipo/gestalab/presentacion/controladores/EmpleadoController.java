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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IEmpleadoUseCase;
import com.prototipo.gestalab.presentacion.dto.request.EmpleadoRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.EmpleadoResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IEmpleadoDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/empleado")
@RestController
public class EmpleadoController {
	
	private final IEmpleadoUseCase empleadoUseCase;
	private final IEmpleadoDtoMapper mapper;
	public EmpleadoController(IEmpleadoUseCase empleadoUseCase, IEmpleadoDtoMapper mapper) {
		super();
		this.empleadoUseCase = empleadoUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EmpleadoResponseDto guardar(@Valid @RequestBody EmpleadoRequestDto requestEmpleado ) {
		return mapper.toResponseDto(empleadoUseCase.guardar(mapper.toDomain(requestEmpleado)));
	}
	
	@GetMapping
	public List<EmpleadoResponseDto> listarTodos(){
		return empleadoUseCase.ListarTodo().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idEmpleado}")
	public ResponseEntity<Void> eliminar (@PathVariable int idEmpleado)
	{
		empleadoUseCase.eliminar(idEmpleado);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{idEmpleado}")
	public EmpleadoResponseDto buscarPorId(@PathVariable int idEmpleado) {
		return mapper.toResponseDto(empleadoUseCase.buscarPorId(idEmpleado));
	}

}
