package com.intercorp.reto.app.controllers;

import com.intercorp.reto.app.models.Report;
import com.intercorp.reto.app.models.User;
import com.intercorp.reto.app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
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
    public User altaColaborador(@RequestBody User user){

        return userService.save(user);
    }

    @GetMapping("/listColaboradores")
    @ApiOperation(
            value = "Lista todos los colaboradores",
            notes = "Devuelve todos los registros de colaboradores"

    )
    public List<User> listaColaboradores(){
        userService.listUsers().forEach(x->{
            System.out.println("userService.listUsers() = " + x.getLastName());
        });
        List<User> users = userService.listUsers();



        return users;
    }

    @GetMapping("/kpicolaboradores")
    @ApiOperation(value = "Lista el kpi de los clientes",
    notes = "Devuelve el listado de los clientes por KPi")
    public Report kpiColaboradores(){
        return userService.kpiColaboradores();
    }
}
