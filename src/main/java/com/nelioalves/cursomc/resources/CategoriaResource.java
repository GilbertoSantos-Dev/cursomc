package com.nelioalves.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
    @GetMapping
    public List<Categoria> listarTodos() {
        return service.listarTodos();
    }
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> BuscarPorId(@PathVariable Integer id)  {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}		
}
