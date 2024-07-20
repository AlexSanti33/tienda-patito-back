/**
 * 
 */
package com.tiendapatito.validarpedido.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "camionetas")
public class Camioneta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelo;
	private String marca;
	private String color;
	private Integer caballosFuerza;
	private String numeroPersonasAbordo;
	private Double capacidadCarga;
	private LocalDate anio;
	
}
