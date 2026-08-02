package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.prototipo.gestalab.dominio.entidades.DatosLaboratorioIR;
import com.prototipo.gestalab.dominio.entidades.InformeResultadosIR;
import com.prototipo.gestalab.presentacion.dto.request.InformeResultadosIRRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.InformeResultadosIRResponseDto;

@Mapper(componentModel = "spring")
public interface IInformeResultadosIRDtoMapper {
	
	@Mapping(target = "fkDatosLaboratorio", source = "fkDatosLaboratorio", qualifiedByName = "idADatosLaboratorio")
	@Mapping(target = "fkOrdenTrabajo.idOT", source = "fkOrdenTrabajo")
	InformeResultadosIR toDomain(InformeResultadosIRRequestDto dto);
	
	
	InformeResultadosIRResponseDto toResponseDto(InformeResultadosIR informeResultadosIRPojo);
	
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
