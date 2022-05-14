package com.intercorp.reto.app.Util;

import com.intercorp.reto.app.models.Report;
import com.intercorp.reto.app.models.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class GenericUtil {
    public static User calcularFecheMuerte(User user){
        Random random = new Random();

        Calendar maybeDate = Calendar.getInstance();
        maybeDate.setTime(user.getDateBorn());
        maybeDate.add(Calendar.DAY_OF_YEAR, random.nextInt(30));
        maybeDate.add(Calendar.MONTH, random.nextInt(12));
        maybeDate.add(Calendar.YEAR, random.nextInt(50));

        user.setDateDie(maybeDate.getTime());

        return user;
    }


    public static Report calculateReport(Iterable<User> iterable){

        Integer promedio;
        Double desviacion;

        Report report = new Report();
        List<User> users = new ArrayList<>();
        iterable.forEach(x->users.add(x));


        promedio = calcularPromedio(users);

        desviacion = calcularDesviacion(users,promedio);

        report.setPromedio(promedio);
        report.setDesviacion(desviacion);

        return report;
    }

    private static Integer calcularPromedio(List<User> users){
        int count=0;
        Integer promedio;
        Integer acumulado=0;
        for (User user: users){
            count++;
            acumulado = acumulado + user.getAge();

        }

        promedio = acumulado/count;

        return promedio;
    }

    private static Double calcularDesviacion(List<User> users, Integer promedio){
        int count=0;
        Double distancia =0.0;
        Double desviacion;
        for (User user: users){
            count++;
            distancia = distancia +Math.pow(Math.abs(user.getAge()-promedio),2);

        }
        desviacion = Math.sqrt(distancia/count);

        return desviacion;
    }
}
