package com.tiendapatito.validarpedido.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "pedidoItem")
@Data
public class PedidoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="productoId",referencedColumnName = "hawaId")
	private Producto producto;
	private Integer cantidad;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name ="pedidoId",referencedColumnName = "id")
	private Pedido pedido;
	
}
