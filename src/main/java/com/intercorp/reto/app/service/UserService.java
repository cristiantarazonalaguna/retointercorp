package com.intercorp.reto.app.service;

import com.intercorp.reto.app.models.Report;
import com.intercorp.reto.app.models.User;
import io.reactivex.Observable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    public Observable<List<User>> listUsers();

    public Observable<User> save(User user);

    public Observable<Report> kpiColaboradores();
}
