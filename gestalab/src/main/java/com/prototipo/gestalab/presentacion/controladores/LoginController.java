package com.prototipo.gestalab.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.ILoginUseCase;
import com.prototipo.gestalab.aplicacion.casosuso.entrada.IUsuariohasRolUseCase;
import com.prototipo.gestalab.dominio.entidades.Usuario;
import com.prototipo.gestalab.dominio.entidades.UsuariohasRol;
import com.prototipo.gestalab.presentacion.dto.request.LoginRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.LoginResponseDto;

import jakarta.validation.Valid;

@RequestMapping("api/gestalab/login")
@RestController
public class LoginController {
	
	private static final String ROL_GERENTE = "Gerente General";

	private final ILoginUseCase loginUseCase;
	private final IUsuariohasRolUseCase usuariohasRolUseCase;
	public LoginController(ILoginUseCase loginUseCase, IUsuariohasRolUseCase usuariohasRolUseCase) {
		super();
		this.loginUseCase = loginUseCase;
		this.usuariohasRolUseCase = usuariohasRolUseCase;
	}
	
	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public LoginResponseDto login(@Valid @RequestBody LoginRequestDto request) {
		Usuario usuario = loginUseCase.autenticar(request.getCorreo(), request.getContrasenia());

		List<UsuariohasRol> asignaciones = usuariohasRolUseCase.ListarTodos();

		String rolEncontrado = asignaciones.stream()
				.filter(a -> a.getFkUsuario() != null && a.getFkUsuario().getIdUsuario() == usuario.getIdUsuario())
				.filter(a -> a.getFkRol() != null && a.getFkRol().getNombre() != null)
				.map(a -> a.getFkRol().getNombre())
				.filter(nombre -> nombre.equalsIgnoreCase(ROL_GERENTE))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(
						"Este usuario no tiene permisos de Gerente General"));

		LoginResponseDto response = new LoginResponseDto();
		response.setIdUsuario(usuario.getIdUsuario());
		response.setNombre(usuario.getNombre());
		response.setCorreo(usuario.getCorreo());
		response.setRol(rolEncontrado);
		return response;
	}
	
}
