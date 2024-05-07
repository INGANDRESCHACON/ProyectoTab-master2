package com.transportesayb.proyectomantenimiento.repuesto.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transportesayb.proyectomantenimiento.repuesto.modelos.Repuesto;
import com.transportesayb.proyectomantenimiento.repuesto.servicios.RepuestoServicioImpl;

@RestController
@RequestMapping("/api/v1")
public class RepuestoControlador {
	
	@Autowired
	RepuestoServicioImpl repuestoservicio;


	@GetMapping("/repuesto")
	public List<Repuesto> obtenerRepuesto(){
		return repuestoservicio.obtenerTodo();
	}
	
	
	@PostMapping("/repuesto/guardar")
	public ResponseEntity<Repuesto> guardarRepuesto(@RequestBody Repuesto repuesto){
		Repuesto nuevo_repuesto = repuestoservicio.guardar(repuesto);
		return new ResponseEntity<>(nuevo_repuesto, HttpStatus.CREATED);
	}
	
	@GetMapping("/repuesto/{id}")
	public ResponseEntity<Repuesto> obtenerRepuestoId(@PathVariable long id){
		Repuesto repuestoPorId = repuestoservicio.obtenerPorId(id);
		return ResponseEntity.ok(repuestoPorId);
	}
	
	@PutMapping("/repuesto/{id}")
	public ResponseEntity<Repuesto> actualizarRepuesto(@PathVariable long id, @RequestBody Repuesto repuesto){
		Repuesto repuestoPorId = repuestoservicio.obtenerPorId(id);
		repuestoPorId.setCodigo(repuesto.getCodigo());
		repuestoPorId.setNombre(repuesto.getNombre());
		repuestoPorId.setMarca(repuesto.getMarca());
		repuestoPorId.setReferencia(repuesto.getReferencia());
		
		Repuesto repuesto_actualizado = repuestoservicio.guardar(repuestoPorId);
		return new ResponseEntity<>(repuesto_actualizado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/repuesto/{id}")
	public ResponseEntity<HashMap<String,Boolean>> eliminarRepuesto(@PathVariable long id){
		this.repuestoservicio.eliminar(id);
		
		HashMap<String, Boolean> estadoRepuestoEliminado = new HashMap<>();
		estadoRepuestoEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoRepuestoEliminado);
	}

	@DeleteMapping("/repuesto/codigo/{codigo}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarRepuestoPorCodigo(@PathVariable String codigo) {
		this.repuestoservicio.eliminarPorCodigo(codigo);
		HashMap<String, Boolean> estadoRepuestoEliminado = new HashMap<>();
		estadoRepuestoEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoRepuestoEliminado);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
