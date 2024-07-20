package com.tiendapatito.validarpedido.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="productos")
@Data
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hawaId;
	
	@OneToOne(mappedBy = "producto")
	private Inventario inventario;
	
	private BigDecimal precioLista;
	private BigDecimal descuento;
	private String descripcion;
	
}
