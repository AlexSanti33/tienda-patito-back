package com.tiendapatito.validarpedido.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="pedidos")
@Data
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<PedidoItem>items;

	
	@ManyToOne()
	@JoinColumn(name="empleadoId",referencedColumnName = "id")
	private Empleado empleado;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="clienteId",referencedColumnName = "id")
	private Cliente cliente;

	@ManyToOne()
	@JoinColumn(name="estatusId",referencedColumnName = "id")
	private EstatusPedido estatusPedido; 
	
	private LocalDateTime fechaEvento;
	
	private LocalDateTime updateDate;
	
	private String ip;
	
}
