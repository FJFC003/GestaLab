package com.prototipo.gestalab.aplicacion.casosuso.entrada;

public interface IRecuperacionAccesoUseCase {
	
	/** Devuelve la pregunta configurada para ese correo, si procede. */
	String obtenerPregunta(String correo);

	/** Valida la respuesta y fija una contrasenia nueva. */
	void restablecerContrasenia(String correo, String respuesta, String nuevaContrasenia);

	/** Configura o cambia la pregunta y la respuesta de una cuenta. */
	void configurarPregunta(int idUsuario, String pregunta, String respuesta);

	/** Indica si la cuenta ya tiene pregunta y respuesta configuradas. */
	boolean tienePreguntaConfigurada(int idUsuario);

}
