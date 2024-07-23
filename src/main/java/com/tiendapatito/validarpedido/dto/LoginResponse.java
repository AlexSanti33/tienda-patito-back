package com.tiendapatito.validarpedido.dto;

import com.tiendapatito.validarpedido.entities.Empleado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {

    private String token;

    private long expiresIn;
    
    private Empleado empleado;

}
