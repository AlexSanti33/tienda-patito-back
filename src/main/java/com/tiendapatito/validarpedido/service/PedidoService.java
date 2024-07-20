package com.tiendapatito.validarpedido.service;

import java.util.List;

import com.tiendapatito.validarpedido.entities.Pedido;

public interface PedidoService {

	Pedido save(Pedido pedido);
	
	List<Pedido>findAll();

	Pedido updateStatus(Long id,Pedido pedido);
	
}