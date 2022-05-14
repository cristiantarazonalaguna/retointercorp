package com.intercorp.reto.app.service;

import com.intercorp.reto.app.models.Report;
import com.intercorp.reto.app.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    public List<User> listUsers();
    public User getUserById(Long id);

    public User save(User user);
    public User update(User user);
    public void deleteUserById(Long id);

    public Report kpiColaboradores();
}
