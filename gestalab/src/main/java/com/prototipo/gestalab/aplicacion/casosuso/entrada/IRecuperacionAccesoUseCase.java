package com.prototipo.gestalab.aplicacion.casosuso.entrada;

public interface IRecuperacionAccesoUseCase {
	
	String solicitarEnlace(String correoLaboral);

	/** Comprueba que el enlace siga siendo valido. Lanza excepcion si no. */
	void validarToken(String token);

	/** Fija la contrasena nueva y quema el token. */
	void restablecerConToken(String token, String nuevaContrasenia);


}
