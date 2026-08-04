package com.prototipo.gestalab.presentacion.dto.response;

public class SolicitudRecuperacionResponseDto {
	
	private String correoEnmascarado;

	private int minutosValidez;

	public String getCorreoEnmascarado() {
		return correoEnmascarado;
	}

	public void setCorreoEnmascarado(String correoEnmascarado) {
		this.correoEnmascarado = correoEnmascarado;
	}

	public int getMinutosValidez() {
		return minutosValidez;
	}

	public void setMinutosValidez(int minutosValidez) {
		this.minutosValidez = minutosValidez;
	}

}
