package com.carniceria.api_rest.model.dto;


import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder

public class Empleadodto implements Serializable {

    private int id;
    private String nombre;
    private  String apellido;
    private int telefono;
    private String direccion;
    private String cargo;
    private String password;
}
