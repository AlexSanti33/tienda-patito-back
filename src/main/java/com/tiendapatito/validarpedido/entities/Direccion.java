package com.tiendapatito.validarpedido.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "direcciones")
@Data
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String calle;
	private String colonia;
	private String entidadFederativa;
	private String numeroInterior;
	private String numeroExterior;

}
