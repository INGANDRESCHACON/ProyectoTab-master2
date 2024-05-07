package com.transportesayb.proyectomantenimiento.repuesto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.transportesayb.proyectomantenimiento.repuesto.modelos.Repuesto;

@Repository
public interface RepuestoRepositorio extends JpaRepository<Repuesto, Long> {
    /*borra por codigo*/
    void deleteByCodigo(String codigo);
//metodo para validar si el nombre o el codigo ya existe
    Repuesto findByCodigo(String codigo);
    Repuesto findByNombre(String codigo);



}
