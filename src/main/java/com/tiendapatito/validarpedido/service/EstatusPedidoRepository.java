package com.tiendapatito.validarpedido.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendapatito.validarpedido.entities.EstatusPedido;

public interface EstatusPedidoRepository extends JpaRepository<EstatusPedido, Long>{

}
