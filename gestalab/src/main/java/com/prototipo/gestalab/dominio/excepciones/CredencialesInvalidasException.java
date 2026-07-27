package com.prototipo.gestalab.dominio.excepciones;

public class CredencialesInvalidasException extends RuntimeException{
	
	public CredencialesInvalidasException(String mensaje) {
        super(mensaje);
    }

}
