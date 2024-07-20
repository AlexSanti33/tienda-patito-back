package com.tiendapatito.validarpedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendapatito.validarpedido.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	
}
