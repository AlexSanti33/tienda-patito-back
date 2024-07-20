package com.tiendapatito.validarpedido.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapatito.validarpedido.entities.Inventario;
import com.tiendapatito.validarpedido.entities.Producto;
import com.tiendapatito.validarpedido.repository.InventarioRepository;
import com.tiendapatito.validarpedido.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	
	@Autowired
	private ProductoRepository productoRepository;	
	
	@Autowired
	private InventarioRepository inventarioRepository;
	
	@Override
	public Producto findByIdProducto(Long hawaId) {
		Producto producto =productoRepository.findById(hawaId).orElseThrow(()->new NoSuchElementException("Codigo Incorrecto"));
		Inventario inventario = inventarioRepository.findByProducto(producto);
		producto.setInventario(inventario);
		return producto;
	}

}
