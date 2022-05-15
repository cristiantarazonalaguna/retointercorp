package com.intercorp.reto.app.service;

import com.intercorp.reto.app.Util.GenericUtil;
import com.intercorp.reto.app.models.Report;
import com.intercorp.reto.app.models.User;
import com.intercorp.reto.app.repository.UserRepository;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Observable<List<User>> listUsers() {
        Iterable<User> iterable = userRepository.findAll();
        List<User> users = new ArrayList<>();
        iterable.forEach(x->users.add(x));
        return  Observable.just(users);
    }



    @Override
    @Transactional
    public Observable<User> save(User user) {
        User user1 = GenericUtil.calcularFecheMuerte(user);
        return Observable.just(userRepository.save(user1));
    }


    @Override
    public Observable<Report> kpiColaboradores() {

        Iterable<User> iterable = userRepository.findAll();
        Report rep = GenericUtil.calculateReport(iterable);

        return Observable.just(rep);
    }
}
