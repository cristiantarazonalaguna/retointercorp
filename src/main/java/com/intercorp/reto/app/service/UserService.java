package com.intercorp.reto.app.service;

import com.intercorp.reto.app.models.Report;
import com.intercorp.reto.app.models.User;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    public Single<List<User>> listUsers();

    public Single<User> save(User user);

    public Single<Report> kpiColaboradores();
}
