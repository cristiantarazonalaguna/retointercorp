package com.intercorp.reto.app.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;


@Getter
@Setter
public class Report {

    @Schema(
            description = "Promedio de las edades del usuario",
            example = "3")
    private Integer promedio;

    @Schema(
            description = "Desviacion standar de las edades de los usuario",
            example = "1,87")
    private Double desviacion;

}
