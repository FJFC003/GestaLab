package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.FirmaElectronicaEntity;

public interface IFirmaElectronicaRepositorio extends JpaRepository<FirmaElectronicaEntity, Integer> {

}
