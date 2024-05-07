package com.transportesayb.proyectomantenimiento.repuesto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transportesayb.proyectomantenimiento.repuesto.modelos.Repuesto;
import com.transportesayb.proyectomantenimiento.repuesto.repositorios.RepuestoRepositorio;

@Service
public class RepuestoServicioImpl implements IRepuestoServicio {
	
	@Autowired
	RepuestoRepositorio repuestorepositorio;

	@Override
	public List<Repuesto> obtenerTodo() {
		return repuestorepositorio.findAll();
	}

	/*@Override
	public Repuesto guardar(Repuesto repuesto) {
		return repuestorepositorio.save(repuesto);
	}*/


	@Override
	public Repuesto guardar(Repuesto repuesto) {
		// Verificar si el código o el nombre ya existen
		Repuesto existentePorCodigo = repuestorepositorio.findByCodigo(repuesto.getCodigo());
		Repuesto existentePorNombre = repuestorepositorio.findByNombre(repuesto.getNombre());

		// Si ya existe un repuesto con el mismo código o nombre, lanzar una excepción o manejarlo de acuerdo a tus necesidades
		if (existentePorCodigo != null) {
			// Código ya existe
			throw new RuntimeException("Ya existe un repuesto con el código especificado");
		}
		if (existentePorNombre != null) {
			// Nombre ya existe
			throw new RuntimeException("Ya existe un repuesto con el nombre especificado");
		}

		// Si no existe, guardar el nuevo repuesto
		return repuestorepositorio.save(repuesto);
	}

	/*@Override
	public void eliminarPorCodigo(String codigo) {
		repuestorepositorio.deleteByCodigo(codigo);
	}*/
	@Override
	public void eliminarPorCodigo(String codigo) {
		Repuesto repuesto = repuestorepositorio.findByCodigo(codigo);
		if (repuesto != null) {
			repuestorepositorio.delete(repuesto);
		} else {
			throw new RuntimeException("El repuesto con código " + codigo + " no existe");
		}
	}










	@Override
	public Repuesto obtenerPorId(long id) {
		return repuestorepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		repuestorepositorio.deleteById(id);
		
	}

}
