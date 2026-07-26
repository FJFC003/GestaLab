package com.prototipo.gestalab.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.prototipo.gestalab.dominio.entidades.NormaParametroLmpC;
import com.prototipo.gestalab.presentacion.dto.request.NormaParametroLmpCRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.NormaParametroLmpCResponseDto;

@Mapper(componentModel = "spring", uses = { ICatalogoNormServiCDtoMapper.class, ICatalogoParametroCDtoMapper.class,
		ILmpCDtoMapper.class })
public interface INormaParametroLmpCDtoMapper {
	
	@Mapping(target = "fkNorma.idCatalogoNormServi", source = "fkNorma")
	@Mapping(target = "fkParametro.idParametroC", source = "fkParametro")
	@Mapping(target = "fkLmp.idLmpC", source = "fkLmp")
	NormaParametroLmpC toDomain(NormaParametroLmpCRequestDto dto);
	NormaParametroLmpCResponseDto toResponseDto(NormaParametroLmpC pojo);

}
