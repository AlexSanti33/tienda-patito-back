package com.tiendapatito.validarpedido.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="inventarios")
@Data
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "existencia_actual")
	private Integer existenciaActual;
	
	@ManyToOne
	@JoinColumn(name="camionetaId",referencedColumnName = "id")
	private Camioneta camioneta;
	
	private LocalDate insertDate;
	
	private LocalDate updateDate;
	
	private LocalDate ultimaFechaEntrada;
	
	@ManyToOne
	@JoinColumn(name="tiendaId",referencedColumnName = "id")
	private Tienda tienda;	
	
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name="productoId",referencedColumnName = "hawaId")
	private Producto producto;
	
}
