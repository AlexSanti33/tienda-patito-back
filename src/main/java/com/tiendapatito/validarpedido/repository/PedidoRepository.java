package com.tiendapatito.validarpedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendapatito.validarpedido.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
