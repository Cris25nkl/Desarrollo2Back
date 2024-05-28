package com.carniceria.api_rest.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table (name = "empleado")
@Entity
public class Empleado implements Serializable {
    @Id
    @Column(name = "ID_empleado")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private  String apellido;
    private int telefono;
    private String direccion;
    private String cargo;
    private String password;
}
