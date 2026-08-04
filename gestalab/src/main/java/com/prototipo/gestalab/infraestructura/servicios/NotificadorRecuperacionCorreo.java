package com.prototipo.gestalab.infraestructura.servicios;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.prototipo.gestalab.aplicacion.casosuso.salida.INotificadorRecuperacion;

@Service
public class NotificadorRecuperacionCorreo implements INotificadorRecuperacion {

	private final JavaMailSender mailSender;

	@Value("${gestalab.correo.remitente:}")
	private String remitente;

	public NotificadorRecuperacionCorreo(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	@Override
	public void enviarEnlaceRecuperacion(String correoDestino, String nombreUsuario,
			String enlace, int minutosValidez) {

		if (remitente == null || remitente.isBlank()) {
			throw new IllegalStateException(
					"El correo de envio no esta configurado. Defina las variables de entorno "
					+ "GESTALAB_MAIL_USER y GESTALAB_MAIL_PASS.");
		}

		SimpleMailMessage mensaje = new SimpleMailMessage();
		mensaje.setFrom(remitente);
		mensaje.setTo(correoDestino);
		mensaje.setSubject("GestaLab - Restablecer su contrasena");
		mensaje.setText(
				"Hola " + nombreUsuario + ":\n\n"
				+ "Se solicito restablecer la contrasena de su cuenta en GestaLab.\n\n"
				+ "Abra este enlace para crear una contrasena nueva:\n\n"
				+ enlace + "\n\n"
				+ "El enlace caduca en " + minutosValidez + " minutos y sirve una sola vez.\n\n"
				+ "Si usted no pidio este cambio, ignore este mensaje: su contrasena\n"
				+ "actual sigue siendo valida y nadie puede usar este enlace sin\n"
				+ "acceso a este buzon.\n\n"
				+ "Laboratorios GestaLab\n"
				+ "Mensaje automatico, no responda a esta direccion.");

		mailSender.send(mensaje);
	}

}