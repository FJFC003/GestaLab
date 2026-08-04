package com.prototipo.gestalab.aplicacion.casosuso.salida;

public interface INotificadorRecuperacion {
	
	void enviarEnlaceRecuperacion(String correoDestino, String nombreUsuario,
			String enlace, int minutosValidez);

}
