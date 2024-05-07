package com.transportesayb.proyectomantenimiento.repuesto.servicios;

import java.util.List;

import com.transportesayb.proyectomantenimiento.repuesto.modelos.Repuesto;

public interface IRepuestoServicio {

	public List<Repuesto> obtenerTodo();
	
	public Repuesto guardar(Repuesto repuesto);
	
	public Repuesto obtenerPorId(long id);
	
	public void eliminar(long id);

	void eliminarPorCodigo(String codigo); // Método para eliminar por código
}
