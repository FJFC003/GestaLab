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

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.prototipo.gestalab.presentacion.dto.request.UsuarioRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.UsuarioResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IUsuarioDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/usuario")
@RestController
public class UsuarioController {
	
	private final IUsuarioUseCase usuarioUseCase;
	private final IUsuarioDtoMapper mapper;
	public UsuarioController(IUsuarioUseCase usuarioUseCase, IUsuarioDtoMapper mapper) {
		super();
		this.usuarioUseCase = usuarioUseCase;
		this.mapper = mapper;
	} 
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDto guardar(@Valid @RequestBody UsuarioRequestDto requestUsuario ) {
		return mapper.toResponseDto(usuarioUseCase.guardar(mapper.toDomain(requestUsuario)));
	}
	
	@GetMapping
	public List<UsuarioResponseDto> listarTodos(){
		return usuarioUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Void> eliminar (@PathVariable int idUsuario)
	{
		usuarioUseCase.eliminar(idUsuario);
		return ResponseEntity.noContent().build();
	}

}
