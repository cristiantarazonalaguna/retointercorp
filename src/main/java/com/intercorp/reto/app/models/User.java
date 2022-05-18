package com.intercorp.reto.app.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class User {
    private Long id;

    @Schema(
            description = "Nombre del cliente" ,
            example = "Juan")
    private String name;


    @Column(name = "last_name")
    @Schema(
            description = "Apellido del cliente" ,
            example = "Perez")
    private String lastName;

    @Schema(
            description = "Edad del cliente" ,
            example = "20")
    private int age;

    @Schema(
            description = "Fecha de nacimiento del cliente del cliente" ,
            example = "1994-09-12")
    private Date dateBorn;

    @Schema(
            description = "fecha de muerte del cliente" ,
            example = "2029-09-01")
    private Date dateDie;

}
