package com.prototipo.gestalab.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Empleado")
public class EmpleadoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;
	@Column(length = 80)
	private String nombre;
	private String apellido;
	private String ci;
	private String correo;
	private String direccion;
	private Date fechaIngreso;
	private Date fechaSalida;
	private boolean estadoEmpleado;
	
	@ManyToOne
	@JoinColumn(name = "fk_Area")
	private AreaEntity fkAreaAntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_Cargo")
	private CargoEntity fkCargoEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_FirmaElectronica")
	private FirmaElectronicaEntity fkFirmaElectronicaEntity;
	
	@ManyToOne
	@JoinColumn(name = "fk_Usuario")
	private UsuarioEntity fkUsuarioEntity;

}
