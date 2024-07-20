package com.tiendapatito.validarpedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendapatito.validarpedido.entities.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Long>{

}
