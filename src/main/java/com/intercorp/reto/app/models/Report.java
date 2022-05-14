package com.intercorp.reto.app.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@ApiModel("Model Report")
public class Report {

    @ApiModelProperty(
            value = "Promedio de las edades del usuario",
            example = "3",
            position = 1)
    private Integer promedio;

    @ApiModelProperty(
            value = "Desviacion standar de las edades de los usuario",
            example = "1,87",
            position = 3)
    private Double desviacion;
}
