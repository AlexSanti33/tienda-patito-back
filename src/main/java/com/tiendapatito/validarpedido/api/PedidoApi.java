package com.tiendapatito.validarpedido.api;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendapatito.validarpedido.entities.Pedido;
import com.tiendapatito.validarpedido.service.PedidoService;

@RestController
@RequestMapping(path="pedido")
public class PedidoApi {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping()
	private ResponseEntity<List<Pedido>> findAll(){
		
		return ResponseEntity.ok(pedidoService.findAll());
	}
	
	@PostMapping()
	private ResponseEntity<Pedido>save(@RequestBody Pedido pedido){
		
		return ResponseEntity.ok(pedidoService.save(pedido));
	}
	
	@PostMapping("/cancelar")
	private ResponseEntity<?> updateEstatus(@RequestBody Pedido pedido){
		
		var pedidoActualizado = pedidoService.updateStatus(pedido.getId(),pedido);
		
		if(Objects.isNull(pedidoActualizado)) {
			return ResponseEntity.badRequest().body("Error al cancelar pedido");
		}
		
		return ResponseEntity.ok(pedido);
		
		
	}
	
}
