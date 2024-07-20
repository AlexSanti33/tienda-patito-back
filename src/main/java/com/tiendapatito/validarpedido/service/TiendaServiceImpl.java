package com.tiendapatito.validarpedido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapatito.validarpedido.entities.Tienda;
import com.tiendapatito.validarpedido.repository.TiendaRepository;

@Service
public class TiendaServiceImpl implements TiendaService{

	@Autowired
	private TiendaRepository tiendaRepository;
	
	@Override
	public Tienda save(Tienda tienda) {
		// TODO Auto-generated method stub
		return tiendaRepository.save(tienda);
	}

}
