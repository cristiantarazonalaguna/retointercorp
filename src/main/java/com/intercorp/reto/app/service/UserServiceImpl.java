package com.intercorp.reto.app.service;

import com.intercorp.reto.app.Util.GenericUtil;
import com.intercorp.reto.app.models.Report;
import com.intercorp.reto.app.models.User;
import com.intercorp.reto.app.repository.UserRepository;
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
    public List<User> listUsers() {
        Iterable<User> iterable = userRepository.findAll();
        List<User> users = new ArrayList<>();
        iterable.forEach(x->users.add(x));
        return  users;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public User save(User user) {
        User user1 = GenericUtil.calcularFecheMuerte(user);
        return userRepository.save(user1);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
      userRepository.deleteById(id);
    }

    @Override
    public Report kpiColaboradores() {

        Iterable<User> iterable = userRepository.findAll();
        Report rep = GenericUtil.calculateReport(iterable);

        return rep;
    }
}
