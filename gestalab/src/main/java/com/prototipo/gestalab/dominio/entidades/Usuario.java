package com.prototipo.gestalab.dominio.entidades;

import java.util.Date;

public class Usuario {
	
	private int idUsuario;
	private String nombre;
	private String correo;
	private String contrasenia;
	private Date fechaCreacion;
	private boolean estadoUsuario;

	/** Pregunta elegida por el usuario para recuperar el acceso. Texto visible. */
	private String preguntaSeguridad;

	/** Respuesta a la pregunta, guardada con BCrypt igual que la contrasenia. */
	private String respuestaSeguridad;

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public boolean isEstadoUsuario() {
		return estadoUsuario;
	}
	public void setEstadoUsuario(boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	public String getPreguntaSeguridad() {
		return preguntaSeguridad;
	}
	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}
	public String getRespuestaSeguridad() {
		return respuestaSeguridad;
	}
	public void setRespuestaSeguridad(String respuestaSeguridad) {
		this.respuestaSeguridad = respuestaSeguridad;
	}	
	
}
