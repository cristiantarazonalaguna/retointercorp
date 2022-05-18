package com.intercorp.reto.app.controllers;

import com.intercorp.reto.app.models.Report;
import com.intercorp.reto.app.models.User;
import com.intercorp.reto.app.service.UserService;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Tag(name = "API de usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/altacolaborador")
    @Operation(summary = "Dar de alta colaborador")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Consulta exitosa",
            content ={@Content(mediaType = "application/json",
            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400", description = "Error en la consulta",content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado",
            content = @Content)})
    public Single<User> altaColaborador(
            @RequestBody User user){

        return userService.save(user);
    }

    @GetMapping("/listaColaboradores")
    @Operation(summary = "Lista colaboradores")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Consulta exitosa",
                    content ={@Content(mediaType = "application/json",
                            array = @ArraySchema(schema =@Schema(implementation = User.class)))}),
            @ApiResponse(responseCode = "400", description = "Error en la consulta",content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado",
                    content = @Content)})
    @CrossOrigin(origins = "*")
    public Single<List<User>> listaColaboradores(){

        return userService.listUsers();
    }

    @GetMapping("/kpicolaboradores")
    @Operation(summary = "Devuelve el kpi")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Consulta exitosa",
                    content ={@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Report.class))}),
            @ApiResponse(responseCode = "400", description = "Error en la consulta",content = @Content),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado",
                    content = @Content)})
    public Single<Report> kpiColaboradores(){
        return userService.kpiColaboradores();
    }
}
