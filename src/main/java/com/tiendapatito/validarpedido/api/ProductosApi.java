package com.tiendapatito.validarpedido.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendapatito.validarpedido.entities.Producto;
import com.tiendapatito.validarpedido.service.ProductoService;

@RestController
@RequestMapping(path = "productos")
public class ProductosApi {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("{hawa}")
	private ResponseEntity<Producto>getId(@PathVariable Long hawa){
		
		return ResponseEntity.ok(productoService.findByIdProducto(hawa));
	}
}
