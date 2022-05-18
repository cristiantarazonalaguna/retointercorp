package com.intercorp.reto.app.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(
            description = "Id del cliente" ,
            example = "1")
    private Long id;

    @Schema(
            description = "Nombre del cliente" ,
            example = "Juan")
    private String name;


    @Column(name = "last_name")
    @Schema(
            description = "Apellido del cliente",
            example = "Perez")
    private String lastName;

    @Schema(
            description = "Edad del cliente" ,
            example = "20")
    private int age;

    @Column(name = "date_born")
    @Schema(
            description = "Fecha de nacimiento del cliente del cliente" ,
            example = "1994-09-12")
    private Date dateBorn;

    @Column(name = "fechamuerte")
    @Schema(
            description = "fecha de muerte del cliente" ,
            example = "2029-09-01")
    @Temporal(TemporalType.DATE)
    private Date dateDie;
}
