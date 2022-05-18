package com.intercorp.reto.app.service;

import com.intercorp.reto.app.Util.GenericUtil;
import com.intercorp.reto.app.mapper.UserMapper;
import com.intercorp.reto.app.entity.UserEntity;
import com.intercorp.reto.app.models.Report;
import com.intercorp.reto.app.models.User;
import com.intercorp.reto.app.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  UserMapper userMapper;

    @Override
    public Single<List<User>> listUsers() {
        Iterable<UserEntity> iterable = userRepository.findAll();
        List<User> users = new ArrayList<>();
        iterable.forEach(x->users.add(userMapper.toModel(x)));
        return  Single.just(users);
    }



    @Override
    @Transactional
    public Single<User> save(User user) {
        User user1 = GenericUtil.calcularFecheMuerte(user);

        return Single.just(userMapper.toModel(userRepository.save(userMapper.toEntity(user1))));
    }


    @Override
    public Single<Report> kpiColaboradores() {

        Iterable<UserEntity> iterable = userRepository.findAll();

        Report rep = GenericUtil.calculateReport(iterable,userMapper);

        return Single.just(rep);
    }
}
