package com.intercorp.reto.app.controllers;

import com.intercorp.reto.app.models.Report;
import com.intercorp.reto.app.models.User;
import com.intercorp.reto.app.service.UserService;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Api(tags = {"API de usuarios"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/altacolaborador")
    @ApiOperation(
            value = "Da de alta a un colaborador",
            notes = "Devuelve el usuarios registardo"
    )
    public Single<User> altaColaborador(@RequestBody User user){

        return userService.save(user);
    }

    @GetMapping("/listaColaboradores")
    @CrossOrigin(origins = "*")
    @ApiOperation(
            value = "Lista todos los colaboradores",
            notes = "Devuelve todos los registros de colaboradores"

    )
    public Single<List<User>> listaColaboradores(){

        return userService.listUsers();
    }

    @GetMapping("/kpicolaboradores")
    @ApiOperation(value = "Lista el kpi de los clientes",
    notes = "Devuelve el listado de los clientes por KPi")
    public Single<Report> kpiColaboradores(){
        return userService.kpiColaboradores();
    }
}
