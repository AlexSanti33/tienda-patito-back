package com.tiendapatito.validarpedido.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="empleados")
@Data
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	private String numeroEmpleado;
	private char sexo;
	@JsonIgnore
	@OneToOne(mappedBy ="empleado")
	private User user;
	
}
