package com.tiendapatito.validarpedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendapatito.validarpedido.entities.Inventario;
import com.tiendapatito.validarpedido.entities.Producto;

public interface InventarioRepository extends JpaRepository<Inventario, Long>{

	Inventario findByProducto(Producto producto);
}
