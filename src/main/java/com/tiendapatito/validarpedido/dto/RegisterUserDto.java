package com.tiendapatito.validarpedido.dto;

import com.tiendapatito.validarpedido.entities.Empleado;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;
    
    private String password;
    
    private String fullName;
    
    private Empleado empleado;
    
}
