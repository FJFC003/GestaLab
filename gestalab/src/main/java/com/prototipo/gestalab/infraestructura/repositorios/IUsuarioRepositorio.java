package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.UsuarioEntity;

public interface IUsuarioRepositorio extends JpaRepository<UsuarioEntity, Integer> {

}
