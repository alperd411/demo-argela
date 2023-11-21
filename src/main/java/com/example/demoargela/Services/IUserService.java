package com.example.demoargela.Services;

import com.example.demoargela.Models.User;
import com.example.demoargela.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface IUserService {

    User SaveUser(User user);

    List<User> ListUsers();
    void DeleteUserById(Long id);
    Optional<User> FindById(Long id);
    Optional<List<User>> findAllByDobBetween(Date start,Date end);

}
