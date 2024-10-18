package com.tiendapatito.validarpedido.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapatito.validarpedido.entities.Pedido;
import com.tiendapatito.validarpedido.repository.InventarioRepository;
import com.tiendapatito.validarpedido.repository.PedidoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private InventarioRepository inventarioRepository;
	
	@Override
	public Pedido save(Pedido pedido) {
		log.info("Guardando pedido");
		pedido.getItems().stream().forEach(item-> {
			item.setPedido(pedido);
			if(item.getCantidad() > item.getProducto().getInventario().getExistenciaActual()) {
				throw new IllegalArgumentException("Existencia menor a cantidad de pedido");
			}
		});
		pedido.setFechaEvento(LocalDateTime.now());
		var pedidoCreado = pedidoRepository.save(pedido);
		if(Objects.nonNull(pedidoCreado)) {
			actualizarInventario(pedidoCreado);
		}
		
		return pedidoCreado;
		
	}

	@Override
	public List<Pedido> findAll() {
		log.info("Consultando lista de pedidos");
		return pedidoRepository.findAll();
	
	}
	
	private void actualizarInventario(Pedido pedido) {
		log.info("Actualizando stock de productos");
		var inventariosActualizados = pedido.getItems().stream().map(x->{
			var inventario = inventarioRepository.findByProducto(x.getProducto());
			inventario.setExistenciaActual(inventario.getExistenciaActual()-x.getCantidad());
			return inventario;
		}).collect(Collectors.toList());
		
		if( Objects.nonNull(inventariosActualizados)&& !inventariosActualizados.isEmpty())
			inventarioRepository.saveAll(inventariosActualizados);
	}

	@Override
	public Pedido updateStatus(Long id,Pedido pedido) throws NoSuchElementException  {

		log.info("Cancelando pedido");
		Pedido pedidoDb=	pedidoRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No se encontro el pedido"));
		
		LocalDateTime now = LocalDateTime.now().minusSeconds(30);
		
		if(pedidoDb.getFechaEvento().isAfter(now)) {
			pedidoDb.setEstatusPedido(pedido.getEstatusPedido());
			pedidoDb.setUpdateDate(LocalDateTime.now());
			pedidoRepository.save(pedidoDb);
		}else {
			log.error("No se pudo cancelar el pedido");
			throw new NoSuchElementException("Ya pasaron mas de 10 min");
		}
		
		return pedidoDb;
	}

}
