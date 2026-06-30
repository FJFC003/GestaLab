package com.prototipo.gestalab;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.AreaEntity;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.CargoEntity;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.EmpleadoEntity;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.FirmaElectronicaEntity;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.RolEntity;
import com.prototipo.gestalab.infraestructura.persistencia.jpa.UsuarioEntity;
import com.prototipo.gestalab.infraestructura.repositorios.IAreaJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.ICargoJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IEmpleadoJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IFirmaElectronicaJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IRolJpaRepositorio;
import com.prototipo.gestalab.infraestructura.repositorios.IUsuarioJpaRepositorio;

@SpringBootTest
class GestalabApplicationTests {
	
	@Autowired
	IEmpleadoJpaRepositorio repoEmpleado;
	
	@Autowired
	IAreaJpaRepositorio repoArea;
	
	@Autowired
	ICargoJpaRepositorio repoCargo;
	
	@Autowired
	IFirmaElectronicaJpaRepositorio repoFirma;
	
	@Autowired
	IRolJpaRepositorio repoRol;
	
	@Autowired
	IUsuarioJpaRepositorio repoUsuario;
	

	@Test
	void contextLoads() {
		
		EmpleadoEntity nuevo = new EmpleadoEntity();
		nuevo.setNombre("Frank");
		nuevo.setApellido("Flores");
		nuevo.setCorreo("e1729156727@uisrael.edu.ec");
		nuevo.setDireccion("San Bartolo");
		nuevo.setCi("1729156727");
		nuevo.setFechaIngreso(new Date());
		nuevo.setFechaSalida(new Date());
		nuevo.setEstadoEmpleado(true);
		repoEmpleado.save(nuevo);
		System.out.println(nuevo.getNombre() + " " + nuevo.getApellido() + " " + nuevo.getCorreo() + " " + nuevo.getDireccion() + " " + nuevo.getFechaIngreso() + " " + nuevo.getFechaSalida());
		
		
		AreaEntity nuevoA = new AreaEntity();
		nuevoA.setNombre("Area Tecnica");
		nuevoA.setDescripcion("Tecnico se encargas de ir a campo a tomar muestras");
		nuevoA.setEstadoArea(true);
		repoArea.save(nuevoA);
		
		
		CargoEntity nuevoC = new CargoEntity();
		nuevoC.setNombre("Asistent Tecnico");
		nuevoC.setDescripcion("Encargado de brindar apoyo al tecnico con la toma de muestras");
		nuevoC.setEstadoCargo(true);
		repoCargo.save(nuevoC);
		
		
		FirmaElectronicaEntity nuevoF = new FirmaElectronicaEntity();
		nuevoF.setFormatoFirma("PDF");
		nuevoF.setFechaSubida(new Date());
		nuevoF.setFechaExpiracion(new Date());
		repoFirma.save(nuevoF);
		
		
		RolEntity nuevoR = new RolEntity();
		nuevoR.setNombre("Coordinacion");
		nuevoR.setDescripcion("Coordina Equipos de trabajos");
		nuevoR.setEstadoRol(true);
		repoRol.save(nuevoR);
		
		
		UsuarioEntity nuevoU = new UsuarioEntity();
		nuevoU.setNombre("Fj2003");
		nuevoU.setContrasenia("123456");
		nuevoU.setCorreo("e1729156727@uisrael.edu.ec");
		nuevoU.setFechaCreacion(new Date());
		nuevoU.setEstadoUsuario(true);
		repoUsuario.save(nuevoU);
		
		
		
		
	}

}
