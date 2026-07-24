package com.prototipo.gestalab.aplicacion.casosuso.entrada;

import com.prototipo.gestalab.dominio.entidades.Usuario;

public interface ILoginUseCase {

	Usuario autenticar(String correo, String contrasenia);

	
}
