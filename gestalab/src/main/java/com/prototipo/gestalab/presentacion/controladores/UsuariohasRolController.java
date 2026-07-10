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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IUsuariohasRolUseCase;
import com.prototipo.gestalab.presentacion.dto.request.UsuariohasRolRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.UsuariohasRolResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IUsuariohasRolDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/UsuariohasRol")
@RestController
public class UsuariohasRolController {
	
	private final IUsuariohasRolUseCase usuariohasRolUseCase;
	private final IUsuariohasRolDtoMapper mapper;
	
	public UsuariohasRolController(IUsuariohasRolUseCase usuariohasRolUseCase, IUsuariohasRolDtoMapper mapper) {
		super();
		this.usuariohasRolUseCase = usuariohasRolUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuariohasRolResponseDto guardar(@Valid @RequestBody UsuariohasRolRequestDto requestUsuarioRol ) {
		return mapper.toResponseDto(usuariohasRolUseCase.guardar(mapper.toDomain(requestUsuarioRol)));
	}
	
	@GetMapping
	public List<UsuariohasRolResponseDto> listarTodos(){
		return usuariohasRolUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idUsuarioRol}")
	public ResponseEntity<Void> eliminar (@PathVariable int idUsuarioRol)
	{
		usuariohasRolUseCase.eliminar(idUsuarioRol);
		return ResponseEntity.noContent().build();
	}

}
