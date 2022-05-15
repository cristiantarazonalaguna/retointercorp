package com.intercorp.reto.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@ApiModel("Model User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(
            value = "Id del cliente" ,
            position = 1,
            example = "1")
    private Long id;

    @ApiModelProperty(
            value = "Nombre del cliente" ,
            position = 2,
            example = "Juan")
    private String name;


    @Column(name = "last_name")
    @ApiModelProperty(
            value = "Apellido del cliente" ,
            position = 3,
            example = "Perez")
    private String lastName;

    @ApiModelProperty(
            value = "Edad del cliente" ,
            position = 4,
            example = "20")
    private int age;

    @Column(name = "date_born")
    @ApiModelProperty(
            value = "Fecha de nacimiento del cliente del cliente" ,
            position = 5,
            example = "1994-09-12")
    private Date dateBorn;

    @Column(name = "fechamuerte")
    @ApiModelProperty(
            value = "fecha de muerte del cliente" ,
            position = 4,
            example = "2029-09-01")
    @Temporal(TemporalType.DATE)
    private Date dateDie;
}
