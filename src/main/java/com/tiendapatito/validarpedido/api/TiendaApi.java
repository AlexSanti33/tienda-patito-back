package com.tiendapatito.validarpedido.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendapatito.validarpedido.entities.Tienda;
import com.tiendapatito.validarpedido.service.TiendaService;

@RestController
@RequestMapping(path="tienda")
public class TiendaApi {

	@Autowired
	private TiendaService tiendaService;
	
	@PostMapping()
	private ResponseEntity<Tienda>save(@RequestBody Tienda tienda){
		
		return ResponseEntity.created(URI.create(this.tiendaService.save(tienda).getNombre())).build();
	}
}
