package com.prototipo.gestalab.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.gestalab.infraestructura.persistencia.jpa.UsuariohasRolEntity;

public interface IUsuariohasRolJpaRepositorio extends JpaRepository<UsuariohasRolEntity, Integer>{

}
