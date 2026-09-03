package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.prototipo.gestalab.dominio.entidades.DatosLaboratorioIR;
import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;
import com.prototipo.gestalab.dominio.entidades.LmpC;
import com.prototipo.gestalab.presentacion.dto.request.InformeResultadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformeResultadosIRResponseDto;

@Mapper(componentModel = "spring", uses = { ILmpCDtoMapper.class })
public interface IInformeResultadosIRDtoMapper {
	
	@Mapping(target = "fkDatosLaboratorio", source = "fkDatosLaboratorio", qualifiedByName = "idADatosLaboratorio")
	@Mapping(target = "fkOrdenTrabajo.idOT", source = "fkOrdenTrabajo")
	// El id 0 significa "sin seleccionar": se guarda como null en vez de
	// apuntar a un LMP inexistente.
	@Mapping(target = "fkLmp", source = "fkLmp", qualifiedByName = "idALmp")
	InformeResultadosIR toDomain(InformeResultadosIRRequestDto dto);
	
	
	InformeResultadosIRResponseDto toResponseDto(InformeResultadosIR informeResultadosIRPojo);
	
	@Named("idALmp")
	default LmpC idALmp(int idLmp) {
		if (idLmp <= 0) {
			return null;
		}
		LmpC lmp = new LmpC();
		lmp.setIdLmpC(idLmp);
		return lmp;
	}

	@Named("idADatosLaboratorio")
	default DatosLaboratorioIR idADatosLaboratorio(int idDatos) {
		if (idDatos <= 0) {
			return null;
		}
		DatosLaboratorioIR datos = new DatosLaboratorioIR();
		datos.setIdDatos(idDatos);
		return datos;
	}

}
